package org.jetbrains.kotlin.course.old.school.functions

import org.jetbrains.kotlin.course.old.school.photo.Accessory
import org.jetbrains.kotlin.course.old.school.photo.Color
import org.jetbrains.kotlin.course.old.school.photo.PhotoCharacter
import org.springframework.stereotype.Service
import kotlin.reflect.typeOf

@Service
class GameFunctionsService {
    fun getAllPossibleColors(): List<String> = Color.entries.map { it.toString().lowercase() }

    private fun String.toColor(): Color = Color.valueOf(this.lowercase().let { color ->
        color.replaceFirstChar { it.titlecase() }
    })

    private fun Iterable<String>.toPhotoCharacters(): List<PhotoCharacter> = this.map {
        PhotoCharacter.valueOf(it.lowercase().let { name ->
            name.replaceFirstChar { character -> character.titlecase() }
        })
    }

    fun Iterable<String>.findPhoto(colorStr: String): PhotoCharacter? = with(colorStr.toColor()) {
        this@findPhoto.toPhotoCharacters().find {
            it.backgroundColor == this
        }
    }

    fun Iterable<String>.groupPhotosByColor(): List<PhotoCharacter> = toPhotoCharacters().groupBy {
        it.backgroundColor }.map {
            it.value
        }
        .flatten()

    fun Iterable<String>.groupPhotosByHairAndHat(): List<PhotoCharacter> = this.toPhotoCharacters().groupBy {
        it.hairType
    }.map { it.value }.map { it.groupBy { people -> people.accessories?.contains(Accessory.Hat) ?: false } }.map { it.values.flatten() }.flatten()
}
