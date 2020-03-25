package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ListNeighbourActivityTest {

    private NeighbourApiService service;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setup() throws Exception {
        service = DI.getNeighbourApiService();
    }

    @Test
    public void detailsIsOpen_Phase2_Number1(){

        onView(AllOf.allOf(withId(R.id.list_neighbours),isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.avatar)).check(matches(isDisplayed()));

    }

    @Test
    public void displayNameNewScreen_Phase2_Number2(){

        onView(AllOf.allOf(withId(R.id.list_neighbours),isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
        onView(withId(R.id.personName)).check(matches(withText(service.getNeighbours().get(2).getName())));
    }

    @Test
    public void deleteComplete_Phase2_Number3() throws Exception{


        onView(AllOf.allOf(ViewMatchers.withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(12));


        onView(AllOf.allOf(ViewMatchers.withId(R.id.list_neighbours),isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, new DeleteViewAction()));


        onView(AllOf.allOf(ViewMatchers.withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(11));
    }

    @Test
    public void displayOnlyNeighbourMarked_Phase2_Number4() throws Exception {


        onView(AllOf.allOf(withId(R.id.list_neighbours), isDisplayed())).perform(actionOnItemAtPosition(5, click()));

        onView(withId(R.id.fab)).perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction viewPager = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager.perform(swipeLeft());

        onView(withId(R.id.container)).check(matches(isDisplayed()));
        Thread.sleep(1500);
        onView(AllOf.allOf(withId(R.id.list_neighbours), isDisplayed())).perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.personName)).check(matches(withText(service.getNeighbours().get(5).getName())));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}
