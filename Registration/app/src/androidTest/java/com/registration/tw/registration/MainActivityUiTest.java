package com.registration.tw.registration;

import android.content.Intent;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.registration.tw.registration.mvc.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityUiTest {
    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        Intents.init();
    }

    @After
    public void tearDown() throws Exception {
        Intents.release();
    }

    @Test
    public void shouldDisplayEmailValidationMessage() {
        activity.launchActivity(new Intent());
        onView(withId(R.id.emailField)).perform(ViewActions.typeText("email"));
        onView(withId(R.id.usernameField)).perform(ViewActions.typeText("username"));
        onView(withId(R.id.passwordField)).perform(ViewActions.typeText("password"));
        onView(withId(R.id.registerButton)).perform(click());
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Email address must be in correct format")))
                .check(matches(isDisplayed()));
    }

    @Test
    public void shouldDisplayPasswordValidationMessage() {
        activity.launchActivity(new Intent());
        onView(withId(R.id.emailField)).perform(ViewActions.typeText("email@thoughtworks.com"));
        onView(withId(R.id.usernameField)).perform(ViewActions.typeText("username"));
        onView(withId(R.id.passwordField)).perform(ViewActions.typeText("abc"));
        onView(withId(R.id.registerButton)).perform(click());
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Password must be at least 4 alphanumeric characters")))
                .check(matches(isDisplayed()));
    }

    @Test
    public void shouldLaunchRegistrationSuccessActivity(){
        activity.launchActivity(new Intent());
        onView(withId(R.id.emailField)).perform(ViewActions.typeText("email@thoughtworks.com"));
        onView(withId(R.id.usernameField)).perform(ViewActions.typeText("username"));
        onView(withId(R.id.passwordField)).perform(ViewActions.typeText("abcd"));
        onView(withId(R.id.registerButton)).perform(click());

        intended(hasComponent(RegistrationSuccessActivity.class.getName()));
    }
}
