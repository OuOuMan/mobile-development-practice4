package ru.mirea.miroshnichenko.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    EditText days;
    EditText pars;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = (TextView) findViewById(R.id.textResult);

        Thread mainThread = Thread.currentThread();
        mainThread.setName("GeorgeTread");

    }

    public void countClickHandler(View view) {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    days = (EditText)findViewById(R.id.countOfDays);
                    pars = (EditText)findViewById(R.id.countOfPars);
                    textResult = (TextView) findViewById(R.id.textResult);
                    int medium = Integer.parseInt(days.getText().toString()) / Integer.parseInt(pars.getText().toString());
                    Log.i(TAG, Integer.toString(medium));
                    textResult.setText(Integer.toString(medium));
                } catch (Exception e) {
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

/*        new Thread(new Runnable() {
            public void run() {
                days = (EditText)findViewById(R.id.countOfDays);
                pars = (EditText)findViewById(R.id.countOfPars);
                textResult = (TextView) findViewById(R.id.textResult);
                int medium = Integer.parseInt(days.getText().toString()) / Integer.parseInt(pars.getText().toString());
                Log.i(TAG, Integer.toString(medium));
                textResult.setText(Integer.toString(medium));
            }
        }).start();*/
    }
}