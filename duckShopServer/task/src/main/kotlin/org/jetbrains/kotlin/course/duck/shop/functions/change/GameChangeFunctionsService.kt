package org.jetbrains.kotlin.course.duck.shop.functions.change

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.jetbrains.kotlin.course.duck.shop.duck.generateRandomDuck
import org.jetbrains.kotlin.course.duck.shop.duck.getDescription
import org.springframework.stereotype.Service

@Service
class GameChangeFunctionsService  {
    fun MutableList<Duck>.addRandomDuck(): Duck = generateRandomDuck().also {
        this.add(it)
    }

    fun MutableSet<Duck>.addRandomDuck(): Duck = Duck.entries.filter { it !in this }.random().also { add(it) }

    fun MutableMap<Duck, String>.addRandomDuck(): Pair<Duck, String> = Duck.entries.filter { it !in keys }.random().let { it to it.getDescription() }.also { plus(it) }

    fun List<Duck>.removeRandomDuck(): List<Duck> = toMutableList().apply {
        removeAt(indices.random())
    }

    fun Set<Duck>.removeRandomDuck(): Set<Duck> = toMutableSet().apply {
        remove(random())
    }

    fun Map<Duck, String>.removeRandomDuck(): Map<Duck, String> = toMutableMap().apply{
        remove(keys.random())
    }
}
