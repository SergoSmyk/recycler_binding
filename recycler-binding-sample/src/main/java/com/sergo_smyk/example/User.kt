package com.sergo_smyk.example

import android.graphics.drawable.Drawable

data class User(
    val imageDrawable: Int,
    val userFullName: String
) {
    companion object {
        val listOfUsers = listOf<User>(
            User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            ),
            User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            ),
            User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            ),
            User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            ),
            User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            ),
            User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            ),User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            ),
            User (
                imageDrawable = android.R.drawable.ic_menu_report_image,
                userFullName = "Test Test"
            )
        )
    }
}