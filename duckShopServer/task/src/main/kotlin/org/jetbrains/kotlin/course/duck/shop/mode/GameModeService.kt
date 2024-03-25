package org.jetbrains.kotlin.course.duck.shop.mode

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.jetbrains.kotlin.course.duck.shop.duck.getDescription
import org.jetbrains.kotlin.course.duck.shop.utils.MAX_NUMBER_OF_DUCKS
import org.springframework.stereotype.Service

@Service
class GameModeService {
    fun generateListOfDucks(): List<Duck> = Duck.entries.shuffled().take(MAX_NUMBER_OF_DUCKS).toList()

    fun generateSetOfDucks(): Set<Duck> = Duck.entries.shuffled().take(MAX_NUMBER_OF_DUCKS).toSet()

    fun generateMapOfDucks(): Map<Duck, String> = Duck.entries.shuffled().take(MAX_NUMBER_OF_DUCKS).associateWith { it -> it.getDescription() }

}
