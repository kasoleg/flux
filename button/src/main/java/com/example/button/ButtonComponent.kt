package com.example.button

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import com.example.flux.Component
import com.example.flux.Dispatcher

class ButtonComponent(
	container: ViewGroup,
	private val mDispatcher: Dispatcher
) : Component<ButtonState> {
	private val root = LayoutInflater
		.from(container.context)
		.inflate(
			R.layout.button_layout,
			container,
			true
		)

	private val button by lazy {
		root.findViewById<Button>(R.id.button)
			.apply {
				setOnClickListener {
					mDispatcher.dispatch(ButtonClickedAction())
				}
			}
	}

	override fun render(state: ButtonState) {
		button.text = state.text
	}

}