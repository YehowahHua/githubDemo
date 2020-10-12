package com.yehowah.githubdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        Log.i(TAG, "分支提交代码: ")
    }
}