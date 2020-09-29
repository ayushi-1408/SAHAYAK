package com.example.sahayak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    AnyChartView anyChartView;
    String[] result = {"Depressed","Not Depressed"};
    int[] des = {1,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Instructions();
            }
        });

        anyChartView = findViewById(R.id.any_chart_view);
        setupPieChart();
    }
    public void setupPieChart(){

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for(int i =0;i < result.length;i++){
            dataEntries.add(new ValueDataEntry(result[i], des[i]));
        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);
    }
    public void Instructions() {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
    }
}
