package Application;
//Imports javafx
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class Main extends Application {
 
    public void start(Stage stage)
    {
//SET TITLE OF STAGE
        stage.setTitle("Penird MOD 5");
        
//CREATE AXIS FOR DATA STORAGE
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
//NAME Y AXIS
        yAxis.setLabel("Time(Nanoseconds)");
        
//name X axis
        xAxis.setLabel("Requested Fibonacci Numbers");
        
//Initialize the line chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        
//Set title for line chart
        lineChart.setTitle("Fibonacci Function Testing");
        
//Initialize Recursive series of data
        XYChart.Series seriesR = new XYChart.Series();
        
//Name Recursive series of data
        seriesR.setName("Recursive Performance");
//Initialize Iterative series of data
        XYChart.Series seriesL = new XYChart.Series();
//Name Iterative series of data
        seriesL.setName("Iterative Performance");
//Run test and catalog results for Recursive and Iterative methods
//three long variables store the start, stop and elapsed time in nanoseconds - to time the function.
        long start;
        long end;
        long elapsed;
//for loop goes from 0 requested values to 25000 requested values, incrementing by 5000
        for (int x = 0; x<25000; x += 5000)
        {
 //starts and tests Recursion to fulfill 'x' number of calculations
        	start = System.nanoTime();
        	Fibonacci.fibRecursive(0,0,0,0,x);
        	end = System.nanoTime();
        	elapsed = end-start;
//saves results from recursive test to line graph
        	seriesR.getData().add(new XYChart.Data(x, elapsed));
//starts and tests Iterative calculations for 'x' number of values
        	start = System.nanoTime();
        	Fibonacci.fibIterative(0,0,0,0,x);
        	end = System.nanoTime();
        	elapsed = end - start;
//saves results to Line Graph
        	seriesL.getData().add(new XYChart.Data(x, elapsed));
        }

       
 //Initialize Scene to display chart
        Scene scene  = new Scene(lineChart,1000,500);
//Add series data to Line Chart to display on Scene.
        lineChart.getData().addAll(seriesR, seriesL);
//Sets Scene to window
        stage.setScene(scene);
//Shows Stage containing all set above
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}