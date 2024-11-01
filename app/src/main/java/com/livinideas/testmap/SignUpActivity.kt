/*
package com.livinideas.testmap

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.fuel.json.FuelJson
import com.github.kittinunf.fuel.json.responseJson
import org.json.JSONObject
import com.github.kittinunf.result.Result
import java.io.FileOutputStream

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        // EditText要素の取得
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

        // ボタン要素の取得
        val signUpButton: Button = findViewById(R.id.signUpButton)

        // ボタンが押された時の処理
        signUpButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // ユーザー名とパスワードが空ではないか確認
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ユーザー名とパスワードを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val url = "http://192.168.179.234:8080/score"
            val header = mapOf("token" to "")

            // POSTリクエストを実行
            performPostRequest(url, header, "{\"user_name\":\"$username\", \"password\":\"$password\"}") { data ->
                pickTokenData(data)
            }
        }
    }

    // POSTリクエストを実行する関数
    private fun performPostRequest(url: String, header: Map<String, String>, jsonBody: String, onResponse: (JSONObject) -> Unit) {
        Fuel.post(url)
            .header(header)
            .jsonBody(jsonBody)
            .responseJson { _, _, result ->
                handleJsonResponse(result, onResponse)
            }
    }

    // JSONレスポンスを処理する共通関数
    private fun handleJsonResponse(result: Result<FuelJson, FuelError>, callback: (JSONObject) -> Unit) {
        when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                Log.e(TAG, "リクエスト失敗: ${ex.message}")
                runOnUiThread {
                    Toast.makeText(this, "リクエストに失敗しました", Toast.LENGTH_SHORT).show()
                }
            }
            is Result.Success -> {
                val data = result.get().obj()
                runOnUiThread {
                    callback(data)
                }
            }
        }
    }

    // トークンを処理する関数
    private fun pickTokenData(data: JSONObject) {
        val token = data.getString("token")
        Log.d("Tokenstringpower", "受信したトークン: $token")

        // トークンをファイルに保存
        saveTokenToFile(token)
    }

    // トークンをファイルに保存する関数
    private fun saveTokenToFile(token: String) {
        try {
            val outputStream: FileOutputStream = openFileOutput("token.txt", Context.MODE_PRIVATE)
            outputStream.write(token.toByteArray())
            outputStream.close()
            Log.d("Tokenstringpower", "トークンをファイルに保存しました: $token")

            // MainActivityへ遷移
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } catch (e: Exception) {
            Log.e("Tokenstringpower", "ファイル保存エラー: ${e.message}")
            Toast.makeText(this, "トークンの保存に失敗しました", Toast.LENGTH_SHORT).show()
        }
    }
}

 */



package com.livinideas.testmap

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.fuel.json.FuelJson
import com.github.kittinunf.fuel.json.responseJson
import org.json.JSONObject
import com.github.kittinunf.result.Result
import java.io.FileOutputStream

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        // EditText要素の取得
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)

        // ボタン要素の取得
        val signUpButton: Button = findViewById(R.id.signUpButton)

        // ボタンが押された時の処理
        signUpButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = "kousensai"

            // ユーザー名とパスワードが空ではないか確認
            if (username.isEmpty()) {
                Toast.makeText(this, "ユーザー名を入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val url = "ここにローカルネットワークIP"
            val header = mapOf("token" to "")

            // POSTリクエストを実行
            performPostRequest(url, header, "{\"user_name\":\"$username\", \"password\":\"$password\"}") { data ->
                pickTokenData(data)

            }
        }
    }

    // POSTリクエストを実行する関数
    private fun performPostRequest(url: String, header: Map<String, String>, jsonBody: String, onResponse: (JSONObject) -> Unit) {
        Fuel.post(url)
            .header(header)
            .jsonBody(jsonBody)
            .responseJson { _, _, result ->
                handleJsonResponse(result, onResponse)
            }
    }

    // JSONレスポンスを処理する共通関数
    private fun handleJsonResponse(result: Result<FuelJson, FuelError>, callback: (JSONObject) -> Unit) {
        when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                Log.e(TAG, "リクエスト失敗: ${ex.message}")
                runOnUiThread {
                    Toast.makeText(this, "リクエストに失敗しました", Toast.LENGTH_SHORT).show()
                }
            }
            is Result.Success -> {
                val data = result.get().obj()

                // 受け取ったJSONデータをログに出力
                Log.d(TAG, "受け取ったJSONデータ: $data")

                runOnUiThread {
                    callback(data)
                }
            }
        }
    }

    // トークンを処理する関数
    private fun pickTokenData(data: JSONObject) {
        val token = data.getString("token")
        Log.d("Tokenstringpower", "受信したトークン: $token")

        // トークンをファイルに保存
        saveTokenToFile(token)
    }

    // トークンをファイルに保存する関数
    private fun saveTokenToFile(token: String) {
        try {
            val outputStream: FileOutputStream = openFileOutput("token.txt", Context.MODE_PRIVATE)
            outputStream.write(token.toByteArray())
            outputStream.close()
            Log.d("Tokenstringpower", "トークンをファイルに保存しました: $token")

            // MainActivityへ遷移
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } catch (e: Exception) {
            Log.e("Tokenstringpower", "ファイル保存エラー: ${e.message}")
            Toast.makeText(this, "トークンの保存に失敗しました", Toast.LENGTH_SHORT).show()
        }
    }
}
