package org.jetbrains.kotlin.course.duck.shop.functions.action

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.springframework.stereotype.Service

@Service
class GameActionFunctionsService {

    fun List<Duck>.shuffleDucks(): List<Duck> = this.shuffled()

    fun List<Duck>.sortDucks(): List<Duck> = this.sortedByDescending{ it.accessories.sumOf { item -> item.price }  * if(it.hasKotlinAttribute) 100 else 1 }

    fun Collection<Duck>.deleteDucksWithoutKotlinStuff(): Collection<Duck> = this.filter { it.hasKotlinAttribute }

    fun Map<Duck, String>.deleteDucksWithoutKotlinStuff(): Map<Duck, String> = this.filter { it.key.hasKotlinAttribute }

    fun Collection<Duck>.divideDucksIntoKotlinAndNonKotlin(): Pair<Collection<Duck>, Collection<Duck>> = this.partition { it.hasKotlinAttribute }
}
