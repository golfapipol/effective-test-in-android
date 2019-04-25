package com.example.myapplication;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void open_main_page() {
        // 1. Arrange (Given)
        // Prepare data or env for testing
        activityRule.launchActivity(new Intent());

        // 2.Act (When)
        onView(withId(R.id.et_username)).perform(replaceText("admin"), closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(replaceText("password"), closeSoftKeyboard());
        onView(withId(R.id.btn_signin)).perform(click());

        // 3.Assert (Then)
        onView(withId(R.id.tv_result)).check(matches(withText("Success!!!")));

    }
}
