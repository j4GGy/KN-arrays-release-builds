package com.example.arrays

class ArraysConstructor {
    private val memberArray: IntArray

    constructor(int1: Int, int2: Int) {
        memberArray = IntArray(2)
        set(int1, int2)
    }

    fun log() {
        println("Array (constructor init):")
        println("Size: ${memberArray.size}")
        println("Contents: ${memberArray.contentToString()}")
    }

    fun set(int1: Int, int2: Int) {
        memberArray[0] = int1
        memberArray[1] = int2
    }
}

class ArraysDefault {
    private val memberArray = IntArray(2)

    constructor(int1: Int, int2: Int) {
        set(int1, int2)
    }

    fun log() {
        println("Array (default value init):")
        println("Size: ${memberArray.size}")
        println("Contents: ${memberArray.contentToString()}")
    }

    fun set(int1: Int, int2: Int) {
        memberArray[0] = int1
        memberArray[1] = int2
    }
}