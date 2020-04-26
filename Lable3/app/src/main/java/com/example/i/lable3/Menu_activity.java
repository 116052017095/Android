package com.example.i.lable3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_activity extends AppCompatActivity {
    TextView test;
@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    test=findViewById(R.id.tv_test);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_settings,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_font_small:
                test.setTextSize(10*2);
                break;
            case R.id.menu_font_middle:
                test.setTextSize(16*2);
                break;
            case R.id.menu_font_big:
                test.setTextSize(20*2);
                break;
            case R.id.menu_normal:
                Toast.makeText(Menu_activity.this,"普通选项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_color_red:
                test.setTextColor(Color.RED);
                break;
            case R.id.menu_color_black:
                test.setTextColor(Color.BLACK);
                break;
        }
        return true;
    }

}
