package io.github.drbreen.appsalvager.sample

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import io.github.drbreen.appsalvager.AppSalvager

fun createSalvageModeView(activity: Activity, cause: Throwable?): View {
    val root = LayoutInflater.from(activity).inflate(R.layout.salvage_activity_layout, null)

    root.findViewById<TextView>(R.id.cause).text = "$cause"

    root.findViewById<Button>(R.id.fixContentProvider).setOnClickListener {
        activity.setContentProviderBroken(false)
        AppSalvager.onProblemFixed()
    }

    root.findViewById<Button>(R.id.fixApplication).setOnClickListener {
        activity.setApplicationBroken(false)
        AppSalvager.onProblemFixed()
    }

    root.findViewById<Button>(R.id.throwAnotherCrash).setOnClickListener {
        throw RuntimeException("Oops! Another crash!")
    }

    return root
}