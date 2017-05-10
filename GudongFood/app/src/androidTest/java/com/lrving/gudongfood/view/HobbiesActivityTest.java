package com.lrving.gudongfood.view;

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
import com.jerome.gudongfood.view.UserLoginActivity;

import static org.junit.Assert.*;

/**
 * Created by Jerome on 2017/5/7.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HobbiesActivityTest {
    @Rule
    public ActivityTestRule<HobbiesActivity> mActivityRule = new ActivityTestRule<>(
            HobbiesActivity.class);
    @Test
    public void onCreate() throws Exception {
        onView(withId(R.id.cb_run)).perform(click()); //line 2
        onView(withId(R.id.cb_riding)).perform(click()); //line 2
        onView(withId(R.id.cb_soccer)).perform(click()); //line 2
        onView(withId(R.id.btn_hobbiesOk)).perform(click()); //line 2
    }

}