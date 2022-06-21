package com.example.fizzbuzz
import kotlin.collections.listOf
import kotlin.collections.reversed
import kotlin.collections.joinToString
import kotlin.system.exitProcess

fun main() {
    // Ambiguities
    // should the requirement for Fezz to be in front on the first thing beginning with B apply if the output has been reversed by 17
    // Bong instruction says to only print bong but Fezz says to also print Fezz if bong is present which to listen to?
    // It's not clearly stated that Fizz should still apply if Fezz is printed
    val DEFAULT_LIMIT = 1000;

    print("Enter the maximum number: ")
    var limit = DEFAULT_LIMIT;
    try {
        limit = Integer.valueOf(readLine())
    } catch (e: Exception) {
        print("Invalid integer")
        exitProcess(1)
    }

    if (limit < 0) {
        print("Limit must > 0")
        exitProcess(1)
    }

    for (i in 1..limit) {
        var outputWords: List<String> = listOf<String>()

        if (i % 3 == 0) outputWords += "Fizz"
        if (i % 13 == 0) outputWords += "Fezz"
        if (i % 5 == 0) outputWords += "Buzz"
        if (i % 11 == 0) outputWords = outputWords.filter { it == "Fezz"} + "Bong"
        if (i % 7 == 0) outputWords = outputWords.filter { it == "Fizz" || it == "Buzz"} + "Bang"
        if (i % 17 == 0) outputWords = outputWords.reversed()

        var output = i.toString()
        if (outputWords.size > 0) output = outputWords.joinToString("")

        println(output)
    }
}