package com.rxf113.cameraalbumtest


infix fun String.beginsWith(prefix: String) = startsWith(prefix)

infix fun <T> Collection<T>.has(element: T) = contains(element)

infix fun <A, B> A.with(that: B): Pair<A, B> = Pair(this, that)

fun main() {
    if ("ABC" beginsWith "A") {
        println(true)
    }

    val list = listOf(1, 2, 3, 4, 5)
    if (list has 5) {
        println(true)
    }

    val map = mapOf("k1" with 1, "k2" with 2, "k3" with 3)
    for (entry in map) {
        println(entry.key + " " + entry.value)
    }
}