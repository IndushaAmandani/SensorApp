package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtX;
    EditText txtY;
    EditText txtZ;
    SensorManager sensor;
    List sensorList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtX = this.findViewById(R.id.txtX);
        txtY = this.findViewById(R.id.txtY);
        txtZ = this.findViewById(R.id.txtZ);

            sensor =(SensorManager)getSystemService(SENSOR_SERVICE);
            sensorList = sensor.getSensorList(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sen = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent change) {
                float[] value = change.values;
                txtX.setText(Double.toString(Math.round(value[0])));
                txtY.setText(Double.toString( Math.round(value[1])));
                txtZ.setText(Double.toString(Math.round(value[2])));

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {}};

        sensor.registerListener(sen,(Sensor) sensorList.get(0),SensorManager.SENSOR_DELAY_NORMAL);

    }

}