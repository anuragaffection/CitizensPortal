package com.example.citizensportal;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class OverSpeedWarning extends AppCompatActivity {

    TextView prevAcceleration, currentAcceleration, acceleration;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    private double accelerationPreviousValue;
    private double accelerationCurrentValue;
    private SensorEventListener sensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            accelerationCurrentValue = Math.sqrt( x * x + y * y + z * z);

            accelerationPreviousValue = accelerationCurrentValue;

            double changeInAcceleration = Math.abs(accelerationCurrentValue - accelerationPreviousValue);

            prevAcceleration.setText("Previous Acceleration = " + accelerationPreviousValue);
            currentAcceleration.setText("current Acceleration = " + accelerationCurrentValue);
            acceleration.setText("Acceleration = " + changeInAcceleration);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_speed_warning);

        prevAcceleration = findViewById(R.id.txtPrevAcceleration);
        currentAcceleration = findViewById(R.id.txtCurrentAcceleration);
        acceleration = findViewById(R.id.txtAcceleration);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }


    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }


}