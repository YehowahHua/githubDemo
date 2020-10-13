package com.yehowah.githubdemo.settings

import com.yehowah.githubdemo.AppContext
import com.yehowah.githubdemo.common.ext.Preference

object Settings {
    var email : String by Preference(AppContext,"email","")
    var password : String by Preference(AppContext,"password","")
}