/*
 * Copyright (c) 2012, ScalaFX Ensemble Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.ensemble.example.charts

import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.collections.ObservableBuffer.observableBuffer2ObservableList
import scalafx.ensemble.commons.EnsembleExample
import scalafx.geometry.Insets
import scalafx.scene.chart.BarChart
import scalafx.scene.chart.CategoryAxis
import scalafx.scene.chart.NumberAxis
import scalafx.scene.chart.XYChart
import scalafx.scene.control.Label
import scalafx.scene.layout.VBox
import scalafx.scene.text.Font

class EnsembleAdvancedBarChart extends EnsembleExample {
  def getContent = {
    new VBox {
      vgrow = scalafx.scene.layout.Priority.ALWAYS
      hgrow = scalafx.scene.layout.Priority.ALWAYS
      spacing = 10
      margin = Insets(50, 0, 0, 50)
      content = List(
        new Label {
          text = "Ensemble Advanced Bar Chart"
          font = new Font("Verdana", 20)
        },
        createBarChart)
    }
  }

  val createBarChart = {
    val years = new Array[String](3)
    years(0) = "2007"
    years(1) = "2008"
    years(2) = "2009"

    val xAxis = new CategoryAxis()
    xAxis.setLabel("Year")
    xAxis.setCategories(ObservableBuffer[String](years.toSeq))

    val yAxis = new NumberAxis()
    yAxis.setTickLabelFormatter(NumberAxis.DefaultFormatter(yAxis, "$", null))
    yAxis.setLabel("Price")

    // add starting data
    val series1 = new XYChart.Series[String, Number]()
    series1.setName("Data Series 1")
    // create sample data
    series1.getData().add(XYChart.Data[String, Number](years(0), 567))
    series1.getData().add(XYChart.Data[String, Number](years(1), 1292))
    series1.getData().add(XYChart.Data[String, Number](years(2), 2180))

    val series2 = new XYChart.Series[String, Number]()
    series2.setName("Data Series 2")
    // create sample data
    series2.getData().add(XYChart.Data[String, Number](years(0), 956))
    series2.getData().add(XYChart.Data[String, Number](years(1), 1665))
    series2.getData().add(XYChart.Data[String, Number](years(2), 2450))

    val series3 = new XYChart.Series[String, Number]()
    series3.setName("Data Series 3")
    // create sample data
    series3.getData().add(XYChart.Data[String, Number](years(0), 800))
    series3.getData().add(XYChart.Data[String, Number](years(1), 1000))
    series3.getData().add(XYChart.Data[String, Number](years(2), 2800))
    
    val series4 = new XYChart.Series[String, Number]()
    series4.setName("Data Series 4")
    // create sample data
    series4.getData().add(XYChart.Data[String, Number](years(0), 786))
    series4.getData().add(XYChart.Data[String, Number](years(1), 2100))
    series4.getData().add(XYChart.Data[String, Number](years(2), 450))

    // setup chart
    val bc = BarChart[String, Number](xAxis, yAxis)
    bc.barGap = 5
    bc.categoryGap = 12
    bc.setTitle("Advanced Bar Chart")
    bc.getData().add(series1)
    bc.getData().add(series2)
    bc.getData().add(series3)
    bc.getData().add(series4)
    bc
  }
}