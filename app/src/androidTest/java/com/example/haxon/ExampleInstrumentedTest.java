package com.example.haxon;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class  ExampleInstrumentedTest {
    private static final String STRING_TO_BE_TYPED = "chandra sekhar sahu";

    @Before
    public void intentsInit() {
        // initialize Espresso Intents capturing
        Intents.init();
    }

    @After
    public void intentsTeardown() {
        // release Espresso Intents capturing
        Intents.release();
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void check(){
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED),null);
        onView(withId(R.id.button)).perform(click(),null);
    }


}