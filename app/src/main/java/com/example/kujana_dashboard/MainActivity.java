package com.example.kujana_dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.gauge.pointers.Bar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AnyChartView PieChartView;
    AnyChartView BarChartView;
    String[] months = {"Jan", "Fab", "Mar", "Apr", "May"};
    int[] participants = {500,300,250,800,600};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        PieChartView = findViewById(R.id.Bar_chart_view);
        BarChartView = findViewById(R.id.Bar_chart_view);

        //setupPaiChart();
        setupBarChart();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),
                                UserProfile.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.tracking:
                        startActivity(new Intent(getApplicationContext(),
                                GoogleMap.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
    }




    public void setupPaiChart(){

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < months.length; i++){
            dataEntries.add(new ValueDataEntry(months[i], participants[i]));
        }

        pie.data(dataEntries);
        PieChartView.setChart(pie);
    }

      public void setupBarChart(){

        Cartesian bar = AnyChart.column();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < months.length; i++){
            dataEntries.add(new ValueDataEntry(months[i], participants[i]));
        }

        bar.data(dataEntries);
        BarChartView.setChart(bar);
    }



}
