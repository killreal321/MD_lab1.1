package com.example.io8325.md_lab11;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;
import java.util.List;
import im.dacer.androidcharts.PieHelper;
import im.dacer.androidcharts.PieView;


public class Lab2Fragment extends Fragment {

    private GraphView graph;
    private PieView pieView;

    public Lab2Fragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        pieView = requireActivity().findViewById(R.id.pie_view);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch switchDiagram = requireActivity()
                .findViewById(R.id.switch_diagram);
        switchDiagram.setChecked(false);
        graph = getActivity().findViewById(R.id.graph);
        switchDiagram.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                graph.setVisibility(View.INVISIBLE);
                pieView.setVisibility(View.VISIBLE);
            }else{
                pieView.setVisibility(View.INVISIBLE);
                graph.setVisibility(View.VISIBLE);
            }
        });

        double a = 0.01;
        double b = 3;
        List<DataPoint> dataPoints = new ArrayList<>();

        for(double i = a; i <= b; i+=0.01){
            dataPoints.add(new DataPoint(i, Math.pow(i, 3)));
        }
        DataPoint[] stateData = new DataPoint[dataPoints.size()];
        dataPoints.toArray(stateData);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(stateData);
        graph.addSeries(series);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setMaxX(3);
        graph.getViewport().setMinX(-3);
        graph.getViewport().setMaxY(3);
        graph.getViewport().setMinY(-3);
        graph.getViewport().setScalable(false);
        graph.getViewport().setScalableY(false);
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<>();
        pieHelperArrayList.add(new PieHelper(15, Color.YELLOW));
        pieHelperArrayList.add(new PieHelper(25, Color.rgb(150, 75, 0)));
        pieHelperArrayList.add(new PieHelper(45, Color.GRAY));
        pieHelperArrayList.add(new PieHelper(10, Color.RED));
        pieHelperArrayList.add(new PieHelper(5, Color.rgb(128, 0, 128)));
        pieView.setDate(pieHelperArrayList);
    }
}
