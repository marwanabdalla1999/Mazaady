package com.example.mazaadyTask.sharedViews

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun showSnackBar(view: View, massage: String?, retry: () -> Unit) {

        Snackbar.make(
            view, massage?:"Error", Snackbar.LENGTH_INDEFINITE
        ).setAction(
            "Retry"
        ) {
            retry()
        }.show()


}