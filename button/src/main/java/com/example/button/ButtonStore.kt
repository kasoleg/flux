package com.example.button

import com.example.flux.Action
import com.example.flux.Component
import com.example.flux.Store

class ButtonStore(
	private var mState: ButtonState
) : Store<ButtonState> {
	private val views = mutableListOf<Component<ButtonState>>()

	override fun reduce(action: Action) {
		mState = when (action) {
			is ButtonTextAction -> ButtonState(action.text)
			else -> mState
		}
		views.forEach {
			it.render(mState)
		}
	}

	override fun subscribe(component: Component<ButtonState>) {
		component.render(mState)
		views.add(component)
	}

	override fun unsubscribe(component: Component<ButtonState>) {
		views.remove(component)
	}

	override fun unsubscribeAll() {
		views.clear()
	}
}