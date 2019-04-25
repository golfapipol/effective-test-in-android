package com.example.myapplication;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class LoginResultUITest {
    @Rule
    public ActivityTestRule<ResultActivity>  activityRule =
        new ActivityTestRule<>(ResultActivity.class, false, false);

    @Test
    public void success_to_display_result_from_intent() {
        // 1. Arrange (Given)
        // Prepare data or env for testing
        Intent dummyIntent = new Intent();
        String dummyData = "dummy data";
        dummyIntent.putExtra("RESULT", dummyData);
        activityRule.launchActivity(dummyIntent);

        // 3. Assert (Then)
        onView(withId(R.id.tv_result)).check(matches(withText(dummyData)));
    }

    @Test
    public void failure_with_not_send_data() {
        // 1. Arrange (Given)
        // Prepare data or env for testing
        Intent dummyIntent = new Intent();
        activityRule.launchActivity(dummyIntent);

        // 3. Assert (Then)
        onView(withId(R.id.tv_result)).check(matches(withText("")));
    }
}
