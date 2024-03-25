package org.jetbrains.kotlin.course.tamagotchi.game

import org.jetbrains.kotlin.course.tamagotchi.models.Command
import org.jetbrains.kotlin.course.tamagotchi.models.Mode
import org.springframework.stereotype.Service
import java.net.CookieManager

@Service
class GameService {
    companion object {
        private const val MAX_CAPACITY = 16
    }
    val commands : ArrayDeque<Command> = ArrayDeque()

    fun addCommand(command: Command): Boolean = if (commands.size < MAX_CAPACITY) commands.add(command) else false

    fun getCommand(mode: Mode): Command? = if(mode.name == "Queue") commands.removeFirstOrNull() else commands.removeLastOrNull()
}
