package com.registration.tw.registration;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class RegistrationSuccessActivityTest {


    private User user = new User("username", "email@email.com", "password");

    @Rule
    public ActivityTestRule<RegistrationSuccessActivity> rule = new ActivityTestRule<RegistrationSuccessActivity>(
            RegistrationSuccessActivity.class){
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.putExtra("REGISTERED_USER", user);
            return intent;
        }
    };

    @Test
    public void shouldDisplayWelcomeMessageWithRegisteredUsername(){
        RegistrationSuccessActivity activity = rule.getActivity();
        View welcomeMessage = activity.findViewById(R.id.welcomeMessage);
        assertThat(welcomeMessage ,notNullValue());
        assertThat(welcomeMessage , instanceOf(TextView.class));
        assertThat(((TextView) welcomeMessage).getText().toString(), is(format("Welcome %s!", user.getUsername())));
    }
}
