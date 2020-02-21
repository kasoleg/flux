package com.example.flux

interface Component<T> {
	fun render(state: T)
}