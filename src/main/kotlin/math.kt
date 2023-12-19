package math

import kotlin.math.sqrt
import window.*

class Complex(var Re: Float = 0f, var Im: Float = 0f){

    fun abs(): Float{
        return sqrt(this.Re * this.Re + this.Im * this.Im)
    }

}

operator fun Complex.plus(number: Complex): Complex{
    var c = Complex()
    c.Re = this.Re + number.Re
    c.Im = this.Im + number.Im
    return c
}

operator fun Complex.times(number: Complex): Complex{
    var c = Complex()
    c.Re = this.Re * number.Re - this.Im * number.Im
    c.Im = this.Re * number.Im + this.Im * number.Re
    return c
}

fun polinom(z: Complex, c: Complex): Complex {
    return z * z + c
}

class Decart(var x: Double = 0.0, var y: Double = 0.0) {
    fun DecToScr(w: Window): Screen {
        var s_x = (this.x - w.xMin) * (w.w / (w.xMax - w.xMin))
        var s_y = (w.yMax - this.y) * (w.h / (w.yMax - w.yMin))
        var s = Screen(s_x.toFloat(), s_y.toFloat())
        return s
    }
}

class Screen(var x: Float = 0f, var y: Float = 0f) {
    fun ScrToDec(w: Window): Decart {
        var d_x = this.x * (w.xMax - w.xMin) / w.w + w.xMin
        var d_y = w.yMax - this.y * (w.yMax - w.yMin) / w.h
        var d = Decart(d_x, d_y)
        return d
    }
}