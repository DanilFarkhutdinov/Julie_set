package drawing

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import math.Complex
import math.Decart
import math.Screen
import math.polinom
import window.Window
import kotlin.math.sqrt
import kotlin.random.Random
import kotlinx.coroutines.*

fun color_list(maxiter: Int): List<Color>{
    var colors = mutableListOf<Color>()
    var clr = Color(Random.nextInt(0, 255), Random.nextInt(0, 255), Random.nextInt(0, 255))
    for (i in 0..maxiter){
        while (clr in colors){
            clr = Color(Random.nextInt(0, 255), Random.nextInt(0, 255), Random.nextInt(0, 255))
        }
        colors += clr
    }
    return colors
}

fun draw_Julie_set(scope : DrawScope, window: Window) = runBlocking{

    val c = Complex(-1f, 0f)
    var R = (1 + sqrt(1 + 4 * c.abs())) / 2
    val maxIter = 100
    var colorList = color_list(maxIter)


    async { coroutine(0, scope.size.width.toInt() * 1 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), 0, scope.size.height.toInt() * 1 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope, window, R, maxIter, c, colorList) }


    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope, window, R, maxIter, c, colorList) }

    async { coroutine(0, scope.size.width.toInt() * 1 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 1 / 16, scope.size.width.toInt() * 2 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 2 / 16, scope.size.width.toInt() * 3 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 3 / 16, scope.size.width.toInt() * 4 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 4 / 16, scope.size.width.toInt() * 5 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 5 / 16, scope.size.width.toInt() * 6 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 6 / 16, scope.size.width.toInt() * 7 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 7 / 16, scope.size.width.toInt() * 8 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 8 / 16, scope.size.width.toInt() * 9 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 9 / 16, scope.size.width.toInt() * 10 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 10 / 16, scope.size.width.toInt() * 11 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 11 / 16, scope.size.width.toInt() * 12 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 12 / 16, scope.size.width.toInt() * 13 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 13 / 16, scope.size.width.toInt() * 14 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 14 / 16, scope.size.width.toInt() * 15 / 16, scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
    async { coroutine(scope.size.width.toInt() * 15 / 16, scope.size.width.toInt(), scope.size.height.toInt() * 15 / 16, scope.size.height.toInt(), scope, window, R, maxIter, c, colorList) }
}


fun coroutine( s_x: Int, e_x: Int, s_y: Int, e_y: Int, scope: DrawScope, window: Window, R: Float, maxIter: Int, c: Complex, colorList: List<Color>) = runBlocking {
    for (i in s_x .. e_x) {
        for (j in s_y .. e_y){
            var point = Screen(i.toFloat(), j.toFloat()).ScrToDec(window)
            var z = Complex(
                point.x.toFloat(),
                point.y.toFloat()
            )
            var iteration = 0
            while (z.abs() < R && iteration < maxIter) {
                iteration += 1
                z = polinom(z, c)
            }
            scope.drawCircle(colorList[iteration], 1f, Offset(i.toFloat(), j.toFloat()))
        }
    }
}






//    launch{
//        for (i in 0 .. scope.size.width.toInt() / 2) {
//            for (j in 0..scope.size.height.toInt() / 2){
//                var point = Screen(i.toFloat(), j.toFloat()).ScrToDec(window)
//                var z = Complex(
//                    point.x.toFloat(),
//                    point.y.toFloat()
//                )
//                var iteration = 0
//                while (z.abs() < R && iteration < maxIter) {
//                    iteration += 1
//                    z = polinom(z, c)
//                }
//                scope.drawCircle(colorList[iteration], 1f, Offset(i.toFloat(), j.toFloat()))
//            }
//        }
//    }

//    launch {
//        for (i in scope.size.width.toInt() / 2 .. scope.size.width.toInt()) {
//            for (j in 0 .. scope.size.height.toInt() / 2){
//                var point = Screen(i.toFloat(), j.toFloat()).ScrToDec(window)
//                var z = Complex(
//                    point.x.toFloat(),
//                    point.y.toFloat()
//                )
//                var iteration = 0
//                while (z.abs() < R && iteration < maxIter) {
//                    iteration += 1
//                    z = polinom(z, c)
//                }
//                scope.drawCircle(colorList[iteration], 1f, Offset(i.toFloat(), j.toFloat()))
//            }
//        }
//    }

//    launch {
//        for (i in 0 .. scope.size.width.toInt() / 2) {
//            for (j in scope.size.height.toInt() / 2 .. scope.size.height.toInt()){
//                var point = Screen(i.toFloat(), j.toFloat()).ScrToDec(window)
//                var z = Complex(
//                    point.x.toFloat(),
//                    point.y.toFloat()
//                )
//                var iteration = 0
//                while (z.abs() < R && iteration < maxIter) {
//                    iteration += 1
//                    z = polinom(z, c)
//                }
//                scope.drawCircle(colorList[iteration], 1f, Offset(i.toFloat(), j.toFloat()))
//            }
//        }
//    }

//    launch {
//        for (i in scope.size.width.toInt() / 2 .. scope.size.width.toInt()) {
//            for (j in scope.size.height.toInt() / 2 .. scope.size.height.toInt()){
//                var point = Screen(i.toFloat(), j.toFloat()).ScrToDec(window)
//                var z = Complex(
//                    point.x.toFloat(),
//                    point.y.toFloat()
//                )
//                var iteration = 0
//                while (z.abs() < R && iteration < maxIter) {
//                    iteration += 1
//                    z = polinom(z, c)
//                }
//                scope.drawCircle(colorList[iteration], 1f, Offset(i.toFloat(), j.toFloat()))
//            }
//        }
//    }


//    for (i in 0 .. scope.size.width.toInt() - 1) {
//        for (j in 0..scope.size.height.toInt() - 1){
//            var point = Screen(i.toFloat(), j.toFloat()).ScrToDec(window)
//            var z = Complex(
//                point.x.toFloat(),
//                point.y.toFloat()
//            )
//            var iteration = 0
//            while (z.abs() < R && iteration < maxIter) {
//                iteration += 1
//                z = polinom(z, c)
//            }
//            scope.drawCircle(colorList[iteration], 1f, Offset(i.toFloat(), j.toFloat()))
//        }
//    }