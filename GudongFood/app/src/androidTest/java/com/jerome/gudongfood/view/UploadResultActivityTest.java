package com.jerome.gudongfood.view;

import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import com.R;
import static org.junit.Assert.*;

/**
 * Created by Jerome on 2017/5/7.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UploadResultActivityTest {
    private static final String STRING_HOURS = "1";
    private static final String STRING_MINUTE = "30";
    private static final String STRING_SECOND = "30";
    private static final String STRING_kaluli = "50";
    private static final String STRING_bushu = "20";
    private static final String STRING_bufu = "40";
    private static final String STRING_busu1 = "10";
    private static final String STRING_speed = "90";
    @Rule
    public ActivityTestRule<UploadResultActivity> mActivityRule = new ActivityTestRule<>(
            UploadResultActivity.class);

    @Test
    public void testOnCreate() throws Exception {
        onView(withId(R.id.editTextHH)).perform(typeText(STRING_HOURS), closeSoftKeyboard()); //line 1
        onView(withId(R.id.editTextMM)).perform(typeText(STRING_MINUTE), closeSoftKeyboard());
        onView(withId(R.id.editTextSS)).perform(typeText(STRING_SECOND), closeSoftKeyboard()); //line 1
        onView(withId(R.id.editTextKaluli)).perform(typeText(STRING_kaluli), closeSoftKeyboard());
        onView(withId(R.id.editTextStepsPerMinute)).perform(typeText(STRING_bushu), closeSoftKeyboard()); //line 1
        onView(withId(R.id.editTextLength)).perform(typeText(STRING_bufu), closeSoftKeyboard());
        onView(withId(R.id.editTextSteps)).perform(typeText(STRING_busu1), closeSoftKeyboard()); //line 1
        onView(withId(R.id.editTextAverageSpeed)).perform(typeText(STRING_speed), closeSoftKeyboard());

        onView(withId(R.id.buttonUpload)).perform(click()); //line 2
    }

}