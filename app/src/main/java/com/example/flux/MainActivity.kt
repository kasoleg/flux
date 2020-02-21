package com.example.flux

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.button.ButtonComponent
import com.example.button.ButtonState
import com.example.button.ButtonStore

class MainActivity : AppCompatActivity() {
	private val mButtonStore = ButtonStore(ButtonState("Click"))

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val container = findViewById<LinearLayout>(R.id.container)
		val dispatcher = Dispatcher()
		val button = ButtonComponent(container, dispatcher)
		mButtonStore.subscribe(button)
		dispatcher.subscribe(mButtonStore)
	}

	override fun onStart() {
		super.onStart()
		//mButtonStore.subscribe()
	}

	override fun onStop() {
		mButtonStore.unsubscribeAll()
		super.onStop()
	}
}
