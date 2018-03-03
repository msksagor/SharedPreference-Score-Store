package com.example.fondn.sharedprefernce;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button increment, decrement;
    private TextView textView;
    private int score = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        increment = (Button) findViewById(R.id.incrementID);
        decrement = (Button) findViewById(R.id.decrementID);
        textView = (TextView) findViewById(R.id.textViewID);

        if(loadScore()!=0){
            textView.setText("Score : " + loadScore());
        }

        increment.setOnClickListener(this);
        decrement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.incrementID) {
            score = score + 10;
            textView.setText("Score : " + score);
            SaveVariable(score);

        } else if (v.getId() == R.id.decrementID) {
            score = score - 10;
            textView.setText("Score : "+score);
            SaveVariable(score);
        }
    }

    private void SaveVariable(int a){
        SharedPreferences sharedPreferences = getSharedPreferences("sagor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("s",a);
        editor.commit();

    }
    private int loadScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("sagor",Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("s",0);
        return score;

    }
}
