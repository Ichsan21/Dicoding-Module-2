package com.rizky92.latihanmvvm;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.WildcardType;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityEspressoTest {
    private final String dummyVol = "504.0";
    private final String dummyCirc= "100.0";
    private final String dummySurf = "396.0";
    private final String dummyLength = "12.0";
    private final String dummyWidth = "7.0";
    private final String dummyHeight = "6.0";
    private final String emptyInput = "";
    private final String emptyField = "Field must not empty!";

    @Rule
    public ActivityTestRule<MainActivity> mRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void assertGetCircumference() {
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_cal_circ)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_cal_circ)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyCirc)));
    }

    @Test
    public void assertGetVolume() {
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_cal_vol)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_cal_vol)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyVol)));
    }

    @Test
    public void assertGetSurface() {
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_cal_surf)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_cal_surf)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummySurf)));
    }

    @Test
    public void assertInput() {
        // panjang
        onView(withId(R.id.et_panjang)).perform(typeText(emptyInput), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.et_panjang)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());

        // lebar
        onView(withId(R.id.et_lebar)).perform(typeText(emptyInput), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.et_lebar)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());

        // tinggi
        onView(withId(R.id.et_tinggi)).perform(typeText(emptyInput), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.et_tinggi)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
    }
}