package com.example.fit;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;

public class StepCounter implements SensorEventListener {
    private boolean running;
    private int previousSteps;
    private int totalSteps;
    private Context context;
    private SensorManager sensorManager;
    private Sensor stepCounterSensor;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void getSensorManager() {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    public void useStepSensor() {
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (stepCounterSensor == null){
            stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);}

        if (stepCounterSensor == null) {
            Toast.makeText(context,
                    "Required step counter sensor is not present on this device.",
                    Toast.LENGTH_SHORT).show();
        }
        sensorManager.registerListener(this, stepCounterSensor, SensorManager.SENSOR_DELAY_UI);
    }

    public void prepare() {

    }

    public int countSteps() {
        return 0;
    }

    public void resumeCounter() {
        running = true;
    }
}
