package com.yehowah.githubdemo.common.ext

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Preference<T>(val context: Context, val name: String, val default: T):ReadWriteProperty<Any?,T>{
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("default",Context.MODE_PRIVATE)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name,value)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name,default)
    }


    @SuppressLint("CommitPrefEdits")
    private fun putPreference(name: String, value: T) {
        with(prefs.edit()){
            when(value){
                is Long -> putLong(name,value)
                is String -> putString(name,value)
                is Int -> putInt(name,value)
                is Boolean -> putBoolean(name,value)
                is Float -> putFloat(name, value)
                else -> throw IllegalArgumentException("this type of data cannot be saved")
            }
        }.apply()
    }


    private fun findPreference(name: String, default: T): T {
        return with(prefs){
            when(default){
                is Long -> getLong(name,default)
                is String -> getString(name,default)
                is Int -> getInt(name,default)
                is Boolean -> getBoolean(name,default)
                else -> throw IllegalArgumentException("this type of data cannot be get")
            } as T
        }
    }

}