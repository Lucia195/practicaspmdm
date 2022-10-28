package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable{
    ProgressBar pb;
    Thread hilo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
    }
    public void run (){
        //Modificamos cuando empieza la barra de proceso
        pb.setProgress(0);
        while (pb.getProgress()<100){
            try{
                Thread.sleep(300);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            pb.post(new Runnable() {
                @Override
                public void run() {
                    pb.incrementProgressBy(1);
                }
            });
        }
    }
    //Al pulsar el botón tarea empieza el hilo y la barra de progreso.
    public void tarea (View v) {
        hilo = new Thread(this);
        hilo.start();
    }
    public void saluda (View v){
        Toast.makeText(this, "Hola Mundo", Toast.LENGTH_LONG).show();
    }
}