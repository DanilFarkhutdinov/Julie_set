import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.AwaitPointerEventScope
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

import drawing.draw_Julie_set
import kotlinx.coroutines.coroutineScope
import window.*




@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App(){

    var window by remember { mutableStateOf(Window(0f, 0f)) }
    var scroll by remember { mutableStateOf(false) }

    Canvas(modifier = Modifier.fillMaxSize()
        .onPointerEvent(PointerEventType.Scroll) {
            window.w = this.size.width.toFloat()
            window.h = this.size.height.toFloat()
            var pos = it.changes.first().position
            if (this.currentEvent.changes[0].scrollDelta.y == -1.0f){
                window.resize(pos)
                //window.zoom(pos)
                scroll = true
            }
            else{
                if (this.currentEvent.changes[0].scrollDelta.y == 1.0f){
                    window.resize2(pos)
                    //window.zoom2(pos)
                    scroll = true
                }
            }
        },
        onDraw = {
            window.w = this.size.width
            window.h = this.size.height
            draw_Julie_set(this, window)
            scroll = false
            println(scroll)
        }
    )
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}