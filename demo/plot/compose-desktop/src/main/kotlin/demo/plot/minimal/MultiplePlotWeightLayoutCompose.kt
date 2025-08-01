/*
 * Copyright (c) 2023 JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package demo.plot.minimal

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.letsPlot.skia.compose.PlotPanel
import plotSpec.BarPlotSpec
import plotSpec.DensitySpec

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Multiple Plot Weight Layout (Compose Desktop)") {
        MaterialTheme {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                PlotPanel(
                    figure = BarPlotSpec().createFigure(),
                    modifier = Modifier.fillMaxHeight().weight(1f)
                ) { computationMessages ->
                    computationMessages.forEach { println("[DEMO APP MESSAGE] $it") }
                }

                PlotPanel(
                    figure = DensitySpec().createFigure(),
                    modifier = Modifier.fillMaxHeight().weight(1f)
                ) { computationMessages ->
                    computationMessages.forEach { println("[DEMO APP MESSAGE] $it") }
                }
            }
        }
    }
}

