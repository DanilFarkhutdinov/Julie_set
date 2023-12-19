package window

import androidx.compose.ui.geometry.Offset
import math.Decart
import math.Screen

class Window(
    var w: Float, var h: Float,
//    var xMin: Double = -2.5, var xMax: Double = 1.0,
//    var yMin: Double = -1.0, var yMax: Double = 1.0
    var xMin: Double = -1.5, var xMax: Double = 1.5,
    var yMin: Double = -1.0, var yMax: Double = 1.0
) {

    fun scrToDec(sxMin: Double, sxMax: Double,
                 syMin: Double, syMax: Double){
        var oldWindow = this
        this.xMin = Screen(sxMin.toFloat(), 0f).ScrToDec(oldWindow).x
        this.xMax = Screen(sxMax.toFloat(), 0f).ScrToDec(oldWindow).x
        this.yMin = Screen(0f, syMin.toFloat()).ScrToDec(oldWindow).y
        this.yMax = Screen(0f, syMax.toFloat()).ScrToDec(oldWindow).y
    }


    fun resize(pos: Offset, k: Double = 0.9) {//изменение параметров окна//перевод координат выбранной точки в центр
        var sxMin = pos.x - this.w * k / 2
        var sxMax = pos.x + this.w * k / 2
        var syMin = pos.y + this.h * k / 2
        var syMax = pos.y - this.h * k / 2
        scrToDec(sxMin, sxMax, syMin, syMax)
    }

    fun resize2(pos: Offset, k: Double = 1.1) {//изменение параметров окна//перевод координат выбранной точки в центр
        var sxMin = pos.x - this.w * k / 2
        var sxMax = pos.x + this.w * k / 2
        var syMin = pos.y + this.h * k / 2
        var syMax = pos.y - this.h * k / 2
        scrToDec(sxMin, sxMax, syMin, syMax)
    }

    fun zoom(pos: Offset, k: Double = 0.9) {//второй способ приближения
        var sxMin = pos.x - this.w * k / 2
        var sxMax = pos.x + this.w * k / 2
        if (pos.x - this.w * k / 2 < 0) {
            sxMin = 0.0
            sxMax -= pos.x - this.w * k / 2
        }
        if (pos.x + this.w * k / 2 > this.w) {
            sxMin -= pos.x + this.w * k / 2 - this.w
            sxMax = this.w.toDouble()
        }
        var syMin = pos.y + this.h * k / 2
        var syMax = pos.y - this.h * k / 2
        if (pos.y - this.h * k / 2 < 0) {
            syMin = 0.0
            syMax = pos.y - this.h * k
        }
        if (pos.y + this.h * k / 2 > this.h) {
            syMin = this.h.toDouble()
            syMax = pos.y + this.h * k / 2 - this.h
        }

        scrToDec(sxMin, sxMax, syMin, syMax)
    }
}