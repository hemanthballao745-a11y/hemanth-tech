package com.example.data.remote

import android.util.Log
import com.example.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class GeminiService {

    companion object {
        private const val TAG = "GeminiService"
        private const val MODEL_NAME = "gemini-2.5-flash"
        private const val BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models/$MODEL_NAME:generateContent"
    }

    suspend fun generateDmgtExplanation(
        prompt: String,
        contextTopic: String? = null,
        language: String = "English"
    ): Result<String> = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Exception) {
            ""
        }

        if (apiKey.isNullOrBlank()) {
            return@withContext Result.failure(IllegalStateException("API_KEY_MISSING"))
        }

        try {
            val systemInstruction = """
                You are the DMGT AI Study Assistant, an expert tutor in Discrete Mathematics and Graph Theory (R23 syllabus).
                Follow these strict pedagogical rules:
                1. Answer clearly, systematically, and NEVER skip any mathematical or logical steps.
                2. Explicitly explain each algebraic, logical, or graph-theoretic step and justify why it was used.
                3. Keep all mathematical formulas, set notation, logical symbols (¬, ∧, ∨, →, ↔, ∀, ∃), and graph notations invariant and exact.
                4. If the requested language is $language (not English), translate the explanatory text into $language, but keep all mathematical variables, formulas, and notations in standard international notation.
                5. Provide an easy intuition, a formal step-by-step derivation, and point out common exam pitfalls.
            """.trimIndent()

            val fullPrompt = buildString {
                if (!contextTopic.isNullOrBlank()) {
                    append("Topic: $contextTopic\n\n")
                }
                append("Language requested: $language\n\n")
                append("Question / Doubt:\n$prompt")
            }

            val requestJson = JSONObject().apply {
                val contentsArray = JSONArray().apply {
                    val contentObj = JSONObject().apply {
                        val partsArray = JSONArray().apply {
                            put(JSONObject().apply {
                                put("text", "$systemInstruction\n\n$fullPrompt")
                            })
                        }
                        put("parts", partsArray)
                    }
                    put(contentObj)
                }
                put("contents", contentsArray)

                val genConfig = JSONObject().apply {
                    put("temperature", 0.3)
                    put("maxOutputTokens", 1500)
                }
                put("generationConfig", genConfig)
            }

            val endpoint = "$BASE_URL?key=$apiKey"
            val url = URL(endpoint)
            val connection = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "POST"
                setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                doOutput = true
                connectTimeout = 15000
                readTimeout = 20000
            }

            OutputStreamWriter(connection.outputStream, "UTF-8").use { writer ->
                writer.write(requestJson.toString())
                writer.flush()
            }

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val responseText = connection.inputStream.bufferedReader().use(BufferedReader::readText)
                val jsonResponse = JSONObject(responseText)
                val candidates = jsonResponse.optJSONArray("candidates")
                if (candidates != null && candidates.length() > 0) {
                    val firstCandidate = candidates.getJSONObject(0)
                    val content = firstCandidate.optJSONObject("content")
                    val parts = content?.optJSONArray("parts")
                    if (parts != null && parts.length() > 0) {
                        val text = parts.getJSONObject(0).optString("text", "")
                        return@withContext Result.success(text)
                    }
                }
                Result.failure(Exception("Empty candidate in response"))
            } else {
                val errorStream = connection.errorStream?.bufferedReader()?.use(BufferedReader::readText) ?: "No error body"
                Log.e(TAG, "Gemini API HTTP $responseCode: $errorStream")
                Result.failure(Exception("HTTP $responseCode: $errorStream"))
            }
        } catch (e: Exception) {
            Log.e(TAG, "Gemini call failed", e)
            Result.failure(e)
        }
    }
}
