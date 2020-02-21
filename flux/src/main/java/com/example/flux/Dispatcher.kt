package com.example.flux

class Dispatcher {
	private val mStores = mutableListOf<Store<out State>>()

	fun dispatch(action: Action) {
		mStores.forEach {
			it.reduce(action)
		}
	}

	fun subscribe(store: Store<out State>) {
		mStores.add(store)
	}

	fun unsubscribe(store: Store<out State>) {
		mStores.remove(store)
	}
}