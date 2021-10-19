package com.ascom.prisoners.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref {
    private fun SharedPref() {}

    companion object {
        val URL: String = "URL"
        private var mSharedPref: SharedPreferences? = null

        @Synchronized
        fun init(context: Context) {
            if (mSharedPref == null) mSharedPref =
                context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
        }

        fun read(key: String, defValue: String?): String? {
            return mSharedPref!!.getString(key, defValue)
        }

        fun getSharedPreferences(): SharedPreferences? {
            return mSharedPref
        }

        fun write(key: String, value: String?) {
            val prefsEditor = mSharedPref!!.edit()
            prefsEditor.putString(key, value)
            prefsEditor.apply()
        }

        fun read(key: String, defValue: Boolean): Boolean {
            return mSharedPref!!.getBoolean(key, defValue)
        }

        fun write(key: String, value: Boolean) {
            val prefsEditor: SharedPreferences.Editor = mSharedPref!!.edit()
            prefsEditor.putBoolean(key, value)
            prefsEditor.apply()
        }

        fun write(key: String, value: Long) {
            val prefsEditor: SharedPreferences.Editor = mSharedPref!!.edit()
            prefsEditor.putLong(key, value)
            prefsEditor.apply()
        }

        fun read(key: String, defValue: Long): Long {
            return mSharedPref!!.getLong(key, defValue)
        }

        fun read(key: String, defValue: Int): Int {
            return mSharedPref!!.getInt(key, defValue)
        }

        fun write(key: String, value: Int?) {
            val prefsEditor: SharedPreferences.Editor = mSharedPref!!.edit()
            prefsEditor.putInt(key, value!!).apply()
        }
    }
}