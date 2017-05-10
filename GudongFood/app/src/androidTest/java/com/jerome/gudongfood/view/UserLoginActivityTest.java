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

/**
 * Created by Jerome on 2017/5/7.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserLoginActivityTest {
    private static final String STRING_USERNAME = "gaofeng";
    private static final String STRING_PASSWORD = "123456";

    @Rule
    public ActivityTestRule<UserLoginActivity> mActivityRule = new ActivityTestRule<>(
            UserLoginActivity.class);

    @Test
    public void testOnCreate(){
        onView(withId(R.id.username)).perform(typeText(STRING_USERNAME), closeSoftKeyboard()); //line 1
        onView(withId(R.id.password)).perform(typeText(STRING_PASSWORD), closeSoftKeyboard()); //line 1

        onView(withText("登录")).perform(click()); //line 2
    }
}