package com.example.asus.tempoguiapasto;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progresbar);

        new Asynctasck_load().execute();
    }

    public  class Asynctasck_load extends AsyncTask<Void,Integer,Void> {
        int progreso;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progreso = 0;
        }
        @Override
        protected Void doInBackground(Void... voids) {

            while (progreso <= 100){
                progreso ++;
                publishProgress(progreso);
                SystemClock.sleep(20);
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Toast.makeText(MainActivity.this, "Bienvenido",Toast.LENGTH_LONG).show();
                Intent cambio = new Intent(getApplicationContext(), MapboxNavigation.class);
            startActivity(cambio);
        }

    }

}
