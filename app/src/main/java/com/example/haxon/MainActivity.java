package com.example.haxon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.mantralabsjailmonkey.AdbEnabled.AdbEnabled;
//import com.example.mantralabsjailmonkey.HookDetection.HookDetectionCheck;
//import com.example.mantralabsjailmonkey.MockLocation.MockLocationCheck;
//import com.example.mantralabsjailmonkey.Rooted.RootedCheck;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "MainActivity.java:onCreate: ");
        TextView t = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")){
                    t.setText(editText.getText().toString());
                }
            }
        });
//         Toast.makeText(this, "is rooted = "+ RootedCheck.isJailBroken(this), Toast.LENGTH_SHORT).show();
//         Toast.makeText(this, "is mock location present = "+ MockLocationCheck.isMockLocationOn(this), Toast.LENGTH_SHORT).show();
//         Toast.makeText(this, "is hooked = "+ HookDetectionCheck.hookDetected(this), Toast.LENGTH_SHORT).show();
//         Toast.makeText(this, "is usb debugged = "+ AdbEnabled.AdbEnabled(this), Toast.LENGTH_SHORT).show();

    }
}
