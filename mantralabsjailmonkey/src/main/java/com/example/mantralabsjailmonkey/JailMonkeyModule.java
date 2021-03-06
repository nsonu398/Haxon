package com.example.mantralabsjailmonkey;

import static com.example.mantralabsjailmonkey.AdbEnabled.AdbEnabled.AdbEnabled;
import static com.example.mantralabsjailmonkey.ExternalStorage.ExternalStorageCheck.isOnExternalStorage;
import static com.example.mantralabsjailmonkey.HookDetection.HookDetectionCheck.hookDetected;
import static com.example.mantralabsjailmonkey.MockLocation.MockLocationCheck.isMockLocationOn;
import static com.example.mantralabsjailmonkey.Rooted.RootedCheck.isJailBroken;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;


public class JailMonkeyModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;


    public JailMonkeyModule(ReactApplicationContext reactContext, boolean loadConstantsAsynchronously) {
        super(reactContext);

        this.reactContext = reactContext;

    }

    @Override
    public String getName() {
        return "JailMonkey";
    }


    @ReactMethod
    public void isDevelopmentSettingsMode(Promise p) {
        boolean isDevelopmentSettingsMode;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            isDevelopmentSettingsMode = Settings.System.getInt(this.reactContext.getContentResolver(), Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED, 0) != 1;
        } else {
            isDevelopmentSettingsMode = Settings.Global.getInt(this.reactContext.getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) == 1;
        }
        p.resolve(isDevelopmentSettingsMode);
    }


    @ReactMethod
    public void isDebuggedMode(Promise p) {
        boolean isDebuggedMode;
        if (Debug.isDebuggerConnected()) {
            isDebuggedMode = true;
        } else {
            isDebuggedMode = (this.reactContext.getApplicationContext().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
        p.resolve(isDebuggedMode);
    }


    @Override
    public @Nullable
    Map<String, Object> getConstants() {
        ReactContext context = getReactApplicationContext();
        final Map<String, Object> constants = new HashMap<>();
        constants.put("isJailBroken", isJailBroken(context));
        constants.put("hookDetected", hookDetected(context));
        constants.put("canMockLocation", isMockLocationOn(context));
        constants.put("isOnExternalStorage", isOnExternalStorage(context));
        constants.put("AdbEnabled", AdbEnabled(context));
        return constants;
    }
}
