package com.example.flux

interface Store<T> {
	fun reduce(action: Action);
	fun subscribe(component: Component<T>)
	fun unsubscribe(component: Component<T>)
	fun unsubscribeAll()
}