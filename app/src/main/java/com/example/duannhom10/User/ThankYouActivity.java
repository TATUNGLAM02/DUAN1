package com.example.duannhom10.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duannhom10.R;
import com.example.duannhom10.ui.MainActivity;
<<<<<<< HEAD
=======

>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
public class ThankYouActivity extends AppCompatActivity {
Button hoanthanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        hoanthanh=(Button) findViewById(R.id.complete);
        hoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ThankYouActivity.this, MainActivity.class);
                startActivity(i);
            }

        });
    }
}
