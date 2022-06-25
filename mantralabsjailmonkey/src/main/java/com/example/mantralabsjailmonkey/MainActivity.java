package com.example.mantralabsjailmonkey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mantralabsjailmonkey.AdbEnabled.AdbEnabled;
import com.example.mantralabsjailmonkey.HookDetection.HookDetectionCheck;
import com.example.mantralabsjailmonkey.MockLocation.MockLocationCheck;
import com.example.mantralabsjailmonkey.Rooted.RootedCheck;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toast.makeText(this, "is rooted = "+ RootedCheck.isJailBroken(this), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "is mock location present = "+ MockLocationCheck.isMockLocationOn(this), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "is hooked = "+ HookDetectionCheck.hookDetected(this), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "is usb debugged = "+ AdbEnabled.AdbEnabled(this), Toast.LENGTH_SHORT).show();*/
    }
}