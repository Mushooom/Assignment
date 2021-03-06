/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

//new commit

/**
 * Activity for entering a word.
 */

class NewWordActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        val editWordView = findViewById<EditText>(R.id.edit_word)
        val editWordView4 = findViewById<EditText>(R.id.edit_word4)
        val editPhoneView = findViewById<EditText>(R.id.editTextPhone)
        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text) || TextUtils.isEmpty(editWordView4.text) || TextUtils.isEmpty(editPhoneView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                val word4 = editWordView4.text.toString()
                val phone = editPhoneView.text.toString()
                var theWord:ArrayList<String> = arrayListOf(word, word4, phone)


                replyIntent.putExtra(EXTRA_REPLY, theWord)//,EXTRA_REPLY4, word4 )
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
        const val EXTRA_REPLY4 = "com.example.android.wordlistsql.REPLY"
    }
}
