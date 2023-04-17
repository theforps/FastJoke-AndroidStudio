package com.example.fastjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.logging.Logger;

public class ChooseCategory extends Activity{

    public MC mobileConstants = new MC();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

    }

    public void CategoryClick(View view) {

        String temp = ((Button) view).getText().toString();

        mobileConstants.category = temp;

        startActivity(new Intent(ChooseCategory.this, ShowJokes.class));
    }
}