package com.registration.tw.registration;

import android.content.Intent;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
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

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
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
    public void shouldDisplayMandatoryFieldsMessage() {
        activity.launchActivity(new Intent());
        onView(withId(R.id.registerButton)).perform(click());
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(activity.getActivity().getString(R.string.mandatory_field_validation_message))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void shouldDisplayEmailValidationMessage() {
        activity.launchActivity(new Intent());
        onView(withId(R.id.emailField)).perform(ViewActions.typeText("email"));
        onView(withId(R.id.usernameField)).perform(ViewActions.typeText("username"));
        onView(withId(R.id.passwordField)).perform(ViewActions.typeText("password"));
        onView(withId(R.id.registerButton)).perform(click());
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(activity.getActivity().getString(R.string.email_validation_message))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void shouldDisplayPasswordValidationMessage() {
        activity.launchActivity(new Intent());
        onView(withId(R.id.emailField)).perform(ViewActions.typeText("email@thoughtworks.com"));
        onView(withId(R.id.usernameField)).perform(ViewActions.typeText("username"));
        onView(withId(R.id.passwordField)).perform(ViewActions.typeText("abc"));
        onView(withId(R.id.registerButton)).perform(click());
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(activity.getActivity().getString(R.string.password_validation_message))))
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
