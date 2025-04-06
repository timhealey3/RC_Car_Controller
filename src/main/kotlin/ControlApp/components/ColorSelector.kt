package ControlApp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import data_classes.InputStatus

@Composable
fun ColorSelector(direction: InputStatus, selected: Boolean): Color {
    var color: Color = Color.LightGray
    if (selected) {
        color = when (direction) {
            InputStatus.LEFT -> Color.Blue
            InputStatus.RIGHT -> Color.Blue
            InputStatus.FORWARD -> Color.Blue
            InputStatus.BACKWARD -> Color.Blue
            InputStatus.STRAIGHTEN -> Color.Blue
            InputStatus.OFF -> Color.Red
            InputStatus.AUTO -> Color.Red
            InputStatus.MANUAL -> Color.Red
            InputStatus.TRAINING -> Color.Red
            InputStatus.NONE -> Color.Red
        }
    }
    return color
}