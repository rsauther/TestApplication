//package com.example.rsauther.testapplication;
//
//
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.espresso.DataInteraction;
//import android.support.test.espresso.Espresso;
//import android.support.test.espresso.ViewAction;
//import android.support.test.espresso.action.CoordinatesProvider;
//import android.support.test.espresso.action.GeneralClickAction;
//import android.support.test.espresso.action.Press;
//import android.support.test.espresso.action.Tap;
//import android.support.test.espresso.contrib.RecyclerViewActions;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
//import android.support.test.uiautomator.By;
//import android.support.test.uiautomator.UiDevice;
//import android.support.test.uiautomator.UiObject;
//import android.support.test.uiautomator.UiObjectNotFoundException;
//import android.support.test.uiautomator.UiScrollable;
//import android.support.test.uiautomator.UiSelector;
//import android.test.suitebuilder.annotation.LargeTest;
//import android.util.Log;
//import android.view.InputDevice;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewParent;
//import android.widget.EditText;
//import android.widget.ImageView;
//
//import com.medscape.android.util.AutomationHelper;
//import com.medscape.android.util.TestUtils;
//import com.medscape.android.welcome.WelcomeActivity;
//
//import org.hamcrest.CoreMatchers;
//import org.hamcrest.Description;
//import org.hamcrest.Matcher;
//import org.hamcrest.TypeSafeMatcher;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//
//import static android.support.test.espresso.Espresso.onData;
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
//import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
//import static android.support.test.espresso.action.ViewActions.replaceText;
//import static android.support.test.espresso.action.ViewActions.scrollTo;
//import static android.support.test.espresso.action.ViewActions.swipeDown;
//import static android.support.test.espresso.action.ViewActions.swipeUp;
//import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
//import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
//import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
//import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
//import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
//import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withSubstring;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static com.google.android.gms.common.ConnectionResult.TIMEOUT;
//import static junit.framework.Assert.fail;
//import static org.hamcrest.Matchers.anything;
//import static org.hamcrest.Matchers.is;
//
//
//@LargeTest
//@RunWith(AndroidJUnit4.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class RegressionDefectTests {
//
//    Context mContext;
//    final int timeOut = 1000 * 60;
//    final UiDevice mDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//
//    @Rule
//    public ActivityTestRule<WelcomeActivity> mActivityTestRule = new ActivityTestRule<>(WelcomeActivity.class);
//
//    @Before
//    public void setupTest(){
//        TestUtils.sleep(100);
//        mContext = InstrumentationRegistry.getContext();
//        AutomationHelper.getInstance().isInUITestMode = true;
//        //AutomationHelper.getInstance().stubbedLegalVer = -1;
//        //TestUtils.sleep(100);
//        //TestUtils.stubLoginResponse(mContext,true);
//        //TestUtils.launchApptoHomeScreen(TestUtils.getLoginCredentials(true));
//        TestUtils.sleep(100);
//    }
//
//    @After
//    public void afterTest(){
//        AutomationHelper.getInstance().isOffline = false;
//        AutomationHelper.getInstance().isInUITestMode = false;
//        //AutomationHelper.getInstance().stubbedLegalVer = -1;
//        //AutomationHelper.getInstance().stubbedVerXmlResponse = "";
//        //TestUtils.clearStubResponses(mContext);
//    }
//
//    @Test
//    public void A1LoginTest() throws InterruptedException {
//        Thread.sleep(10000);
//        onView(withId(R.id.btnSignIn)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.edit_text_user_name)).perform(replaceText("webmd_automation@yopmail.com"), closeSoftKeyboard());
//        onView(withId(R.id.edit_text_password)).perform(replaceText("1234567a"), closeSoftKeyboard());
//        onView(withId(R.id.button_login)).perform(click());
//        Thread.sleep(40000);
//        onView(withId(R.id.continueButton)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.skipButton)).perform(click());
//        Thread.sleep(10000);
//
//    }
//
////    @Test
////    public void A2LoginTest() throws InterruptedException {
////
////        final UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
////
//////        UiScrollable listView12 = null;
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.webmd.android:id/hospital_details_sections_list"));
//////        listView12 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/root_layout"));
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        listView12.setMaxSearchSwipes(100);
//////        Thread.sleep(10000);
//////        try {
//////            Log.d("WebMD Automation", "Try 12: ");
//////            listView12.scrollTextIntoView("CONSULT");
//////        } catch (UiObjectNotFoundException e) {
//////            Log.d("WebMD Automation", "Fail 12: "+e);
//////        }
////
//////        UiScrollable listView13 = null;
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.webmd.android:id/hospital_details_sections_list"));
//////        //listView12 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        listView13 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/root_layout"));
//////        //listView14 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        //listView15 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        listView13.setMaxSearchSwipes(100);
//////        Thread.sleep(10000);
//////        try {
//////            Log.d("WebMD Automation", "Try 13: ");
//////            listView13.scrollTextIntoView("CONSULT");
//////        } catch (UiObjectNotFoundException e) {
//////            Log.d("WebMD Automation", "Fail 13: "+e);
//////        }
////
////        //Refresh
//////        UiScrollable listView14 = null;
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.webmd.android:id/hospital_details_sections_list"));
//////        //listView12 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        //listView13 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/root_layout"));
//////        listView14 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/landing_feed_view"));
//////        //listView15 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        listView14.setMaxSearchSwipes(100);
//////        Thread.sleep(10000);
//////        try {
//////            Log.d("WebMD Automation", "Try 14: ");
//////            listView14.scrollTextIntoView("CONSULT");
//////        } catch (UiObjectNotFoundException e) {
//////            Log.d("WebMD Automation", "Fail 14: "+e);
//////        }
////
////        //Keeps scrolling
//////        UiScrollable listView15 = null;
//////    //    UiSelector selector15 = null;
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.webmd.android:id/hospital_details_sections_list"));
//////        //listView12 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        //listView13 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/root_layout"));
//////   //     selector15 = new UiSelector().resourceId("com.medscape.android.debug:id/content_comment");
//////        listView15 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/coordinator_layout"));
//////        listView15.setMaxSearchSwipes(100);
//////        Thread.sleep(10000);
//////        try {
//////            Log.d("WebMD Automation", "Try 15: ");
//////            listView15.scrollTextIntoView("Consult");
//////            //listView15.scrollTextIntoView("CONSULT");
//////    //        listView15.scrollIntoView(selector15);
//////            //listView15.scrollIntoView(object)
//////        } catch (UiObjectNotFoundException e) {
//////            Log.d("WebMD Automation", "Fail 15: "+e);
//////        }
////
////        //Keeps scrolling
//////        UiScrollable listView16 = null;
//////        UiSelector selector16 = null;
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.webmd.android:id/hospital_details_sections_list"));
//////        //listView12 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        //listView13 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/root_layout"));
//////        //listView14 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        listView16 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/home_container"));
//////        selector16 = new UiSelector().resourceId("com.medscape.android.debug:id/content_comment");
//////        listView16.setMaxSearchSwipes(100);
//////        Thread.sleep(10000);
//////        try {
//////            Log.d("WebMD Automation", "Try 16: ");
//////            //listView16.scrollTextIntoView("Consult");
//////            listView16.scrollTextIntoView("CONSULT");
//////            Log.d("WebMD Automation", "Try 16 - 2: ");
//////            listView16.scrollIntoView(selector16);
//////            Log.d("WebMD Automation", "Try 16 - 3: ");
//////            listView16.scrollTextIntoView("Consult");
//////        } catch (UiObjectNotFoundException e) {
//////            Log.d("WebMD Automation", "Fail 16: "+e);
//////        }
////
////////some scroll
//////        UiScrollable listView17 = null;
//////        //listView = new UiScrollable(new UiSelector().resourceId("com.webmd.android:id/hospital_details_sections_list"));
//////        //listView12 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        //listView13 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/root_layout"));
//////        //listView14 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/swipe_refresh"));
//////        listView17 = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/content_container"));
//////        listView17.setMaxSearchSwipes(100);
//////        Thread.sleep(10000);
//////        try {
//////            Log.d("WebMD Automation", "Try 17: ");
//////            listView17.scrollTextIntoView("CONSULT");
//////        } catch (UiObjectNotFoundException e) {
//////            Log.d("WebMD Automation", "Fail 17: "+e);
//////        }
//////
//////
//////        Thread.sleep(5000);
//////        try {
//////            onView(allOf(withText("CONSULT"), withId(R.id.type_label))).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 1: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.consult_header_body)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 2: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.contact_image_layout)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 3: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.contact_image)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 4: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.contact_field)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 5: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.contact_name)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 6: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.contact_info_layout)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 7: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.time_and_partner_logo)).perform(scrollTo());
//////
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 8: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.consult_partner_logo)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 9: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.content_comment)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 10: "+e);
//////        }
//////        Thread.sleep(5000);
//////        try {
//////            onView(withId(R.id.contact_info_layout)).perform(scrollTo());
//////        }catch (Exception e){
//////            Log.d("WebMD Automation", "Try 11: "+e);
//////        }
////        Thread.sleep(5000);
////        try {
////            Log.d("WebMD Automation", "Try 11");
////            onView(allOf(withId(R.id.root_layout), hasDescendant(withText("CONSULT")))).perform(scrollTo());
////        }catch (Exception e){
////            Log.d("WebMD Automation", "Fail 11: "+e);
////        }
////        Thread.sleep(5000);
////        //
////    }
//
//    @Test
//    public void ViewInteractionsButtonChecks_ShouldFailUntilPPEfixed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-191181
//        Thread.sleep(10000);
//        onView(withText("Interaction Checker")).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("Warfarin"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("ibuprofen"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.drug_interaction_interaction_message)).check(matches(withText("1 Interaction Found")));
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("a"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(3, click()));
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("melatonin"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("sea cucumber"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("feverfew"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("haemophilus"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("d"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(3, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("e"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(4, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("g"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(2, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("r"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(1, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("l"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("p"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(3, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("w"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(2, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("j"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(1, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("k"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(0, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("e"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(4, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("t"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(4, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("y"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(4, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("u"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(2, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("i"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(4, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("o"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(1, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("a"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(2, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("s"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(2, click()));
//        onView(allOf(withId(R.id.drug_interaction_search),childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")),0),1),isDisplayed())).perform(click());
//        onView(withId(R.id.drug_interaction_search)).perform(replaceText("g"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.drug_interaction_search_list),childAtPosition(withId(R.id.drug_interaction_search_layout),0))).perform(actionOnItemAtPosition(2, click()));
//        onView(withContentDescription("Navigate up")).perform(click());
//        onView(withText("Interaction Checker")).perform(click());
//        onView(withId(R.id.drug_interaction_interaction_message)).check(matches(withText("")));
//        onView(withId(R.id.drug_interaction_view_interactions_button)).check(matches(not(isEnabled())));//this will fail until PPE-191181 is fixed
//        Thread.sleep(40000);
//        onView(withId(R.id.drug_interaction_interaction_message)).check(matches(withText("19 Interactions Found")));
//        onView(withId(R.id.drug_interaction_view_interactions_button)).check(matches(isEnabled()));
//        onView(withId(R.id.drug_interaction_clear_all)).perform(click());
//        Thread.sleep(2000);
//        onView(withText("DELETE ALL")).perform(click());
//        Thread.sleep(5000);
//
//    }
//
//    @Test
//    public void DrugInteractionsScrollChecks_ShouldSucceed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-191337
//        Thread.sleep(2000);
//        onView(withText("Drugs")).perform(click());
//        onView(withText("abacavir")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Interactions")).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.drug_details_recycler_view)).perform(swipeUp());
//        Thread.sleep(2000);
//        onView(withId(R.id.drug_details_recycler_view)).perform(swipeUp());
//        Thread.sleep(3000);
//        onView(withId(R.id.drug_details_recycler_view)).perform(swipeDown());
//        Thread.sleep(5000);
//        onView(withId(R.id.drug_details_recycler_view)).perform(swipeDown());
//        Thread.sleep(10000);
//
//    }
//
//    @Test
//    public void DrugActionSheetOverflowChecks_ShouldSucceed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-191347
//        Thread.sleep(10000);
//        onView(withText("Drugs")).perform(click());
//        onView(withId(R.id.search_src_text)).check(matches(isDisplayed()));
//        onView(withId(R.id.search_src_text)).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).perform(replaceText("Warfarin"));//, closeSoftKeyboard());
//        Thread.sleep(1000);
//        onView(withId(R.id.search_src_text)).perform(pressImeActionButton());
//        Thread.sleep(1000);
//        onView(withText("warfarin")).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.action_share)).check(matches(isDisplayed()));
//        Thread.sleep(2000);
//        onView(withId(R.id.action_save)).check(matches(isDisplayed()));
//        Thread.sleep(3000);
//        onView(withContentDescription("More options")).check(matches(isDisplayed()));//this will fail until PPE-191347 is fixed
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void NoInteractionsFoundTextChecks_ShouldSucceed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-191340
//        Thread.sleep(10000);
//        onView(withText("Drugs")).perform(click());
//        onView(withId(R.id.search_src_text)).check(matches(isDisplayed()));
//        onView(withId(R.id.search_src_text)).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).perform(replaceText("albumin IV"));
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).perform(pressImeActionButton());
//        onView(withText("albumin IV")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Interactions")).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.action_share)).check(matches(isDisplayed()));
//        Thread.sleep(2000);
//        onView(withId(R.id.action_save)).check(matches(isDisplayed()));
//        Thread.sleep(3000);
//        onView(withId(R.id.text_view_error_message)).check(matches(isDisplayed()));//this will fail until PPE-191340 is fixed
//        onView(withText("No Interactions Found")).check(matches(isDisplayed()));//this will fail until PPE-191340 is fixed
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void NewsSearchInsteadForChecks_ShouldSucceed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-190978
//        Thread.sleep(10000);
//        onView(withId(R.id.bottomnav_news)).perform(click());
//        onView(withId(R.id.action_search)).check(matches(isDisplayed()));
//        onView(withId(R.id.action_search)).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).check(matches(isDisplayed()));
//        onView(withId(R.id.search_src_text)).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).perform(replaceText("Heartzz"));
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).perform(pressImeActionButton());
//        Thread.sleep(10000);
//        onView(withId(R.id.user_auto_msg_action)).check(matches(allOf(isDisplayed(),withSubstring("Showing results for hearted"))));//this will fail until PPE-190978 is fixed
//        onView(withId(R.id.list)).check(matches(allOf(isDisplayed(),hasDescendant(withSubstring("Search instead for")))));//this will fail until PPE-190978 is fixed
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void NewsAdSpinnerRemainingChecks_ShouldSucceed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-191930
//        Thread.sleep(10000);
//        onView(withId(R.id.bottomnav_news)).perform(click());
//        onView(withId(R.id.action_search)).check(matches(isDisplayed()));
//        onView(withId(R.id.action_search)).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).check(matches(isDisplayed()));
//        onView(withId(R.id.search_src_text)).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).perform(replaceText("Heartzz"));
//        Thread.sleep(2000);
//        onView(withId(R.id.search_src_text)).perform(pressImeActionButton());
//        Thread.sleep(10000);
//        try {
//            onView(withId(R.id.progress_layout)).check(matches(isDisplayed()));//this step will pass until PPE-191930 is fixed,
//            fail("Test failed - Ad Spinner should not be displayed"); //if this test gets to this point it fails
//        }catch (Exception e){
//            Log.d("WebMD Automation", "Test passed - Ad spinner was not there: "+e);
//        }
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void DrugRedirectAlertChecks_ShouldSucceed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-191350
//        Thread.sleep(10000);
//        onView(withId(R.id.bottomnav_news)).perform(click());
//        Thread.sleep(5000);
//        Context context = InstrumentationRegistry.getInstrumentation().getContext();
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.android.chrome");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        intent.setData(Uri.parse("http://img.staging.medscape.com/pi/iphone/MedscapeRedirect.html"));
//        context.startActivity(intent);
//        mDevice.wait(android.support.test.uiautomator.Until.hasObject(By.pkg("com.android.chrome").depth(0)), TIMEOUT);
//        Thread.sleep(5000);
//        mDevice.findObject(By.text("DrugNOTinDB")).click();
//        mDevice.findObject(By.res("Percent_Inspired_02_param"));
//        mDevice.findObject(By.desc("21"));
//        Thread.sleep(5000);
//        onView(withText("Content Unavailable.")).check(matches(isDisplayed()));//this will fail until PPE-191350 is fixed
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void NewsFeedRetryChecks_ShouldSucceed() throws InterruptedException {
//        //To test https://jira.webmd.net/browse/PPE-191006
//        Thread.sleep(10000);
//        onView(withId(R.id.bottomnav_news)).perform(click());
//        Thread.sleep(5000);
//        AutomationHelper.getInstance().isOffline = true;
//        Thread.sleep(3000);
//        onView(withId(R.id.landing_feed_view)).perform(clickXY(540,500));
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(isDisplayed()));
//        onView(withId(R.id.txtReloadText)).check(matches(isDisplayed()));
//        onView(withId(R.id.noNetworkBtn)).check(matches(isDisplayed()));
//        AutomationHelper.getInstance().isOffline = false;
//        Thread.sleep(3000);
//        onView(withId(R.id.noNetworkBtn)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.txtReloadText)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.noNetworkBtn)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void EducationFeedRetryChecks_ShouldSucceed() throws InterruptedException {
//        // To test https://jira.webmd.net/browse/PPE-191006
//        Thread.sleep(10000);
//        onView(withId(R.id.bottomnav_edu)).perform(click());
//        Thread.sleep(5000);
//        AutomationHelper.getInstance().isOffline = true;
//        Thread.sleep(3000);
//        onView(withId(R.id.landing_feed_view)).perform(clickXY(540,500));
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(isDisplayed()));
//        onView(withId(R.id.txtReloadText)).check(matches(isDisplayed()));
//        onView(withId(R.id.noNetworkBtn)).check(matches(isDisplayed()));
//        AutomationHelper.getInstance().isOffline = false;
//        Thread.sleep(3000);
//        onView(withId(R.id.noNetworkBtn)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.txtReloadText)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.noNetworkBtn)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void ManualInterventionHomeFeedRetryChecks_ShouldSucceed() throws InterruptedException {
//        // To test https://jira.webmd.net/browse/PPE-191006
//        Thread.sleep(10000);
//        AutomationHelper.getInstance().isOffline = true;
//        Thread.sleep(3000);
//        onView(withId(R.id.coordinator_layout)).perform(click()); //tap on an article
//        Thread.sleep(5000);
//        onView(withId(R.id.base_webview_error)).check(matches(isDisplayed()));
//        onView(withId(R.id.txtReloadText)).check(matches(isDisplayed()));
//        onView(withId(R.id.noNetworkBtn)).check(matches(isDisplayed()));
//        AutomationHelper.getInstance().isOffline = false;
//        Thread.sleep(3000);
//        onView(withId(R.id.noNetworkBtn)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(not(isDisplayed())));
//        onView(withId(R.id.txtReloadText)).check(matches(not(isDisplayed())));
//        onView(withId(R.id.noNetworkBtn)).check(matches(not(isDisplayed())));
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void CMETrackerRetryChecks_ShouldSucceed() throws InterruptedException {
//        // To test https://jira.webmd.net/browse/PPE-191006
//        Thread.sleep(10000);
//        onView(withId(R.id.bottomnav_edu)).perform(click());
//        Thread.sleep(5000);
//        AutomationHelper.getInstance().isOffline = true;
//        Thread.sleep(3000);
//        onView(withId(R.id.action_cme_tracker)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(isDisplayed()));
//        onView(withId(R.id.txtReloadText)).check(matches(isDisplayed()));
//        onView(withId(R.id.noNetworkBtn)).check(matches(isDisplayed()));
//        AutomationHelper.getInstance().isOffline = false;
//        Thread.sleep(3000);
//        onView(withId(R.id.noNetworkBtn)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.txtReloadText)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.noNetworkBtn)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void Z2ManualInterventionNotificationAlertRetryChecks_ShouldSucceed() throws InterruptedException {
//        // To test https://jira.webmd.net/browse/PPE-191006
//        Thread.sleep(10000);
//        onView(withId(R.id.profile_image_view)).perform(click());
//        onView(withText("Help")).perform(click());
//        onView(withText("Debug Settings")).perform(click());
//        onView(withText("My Invitations")).perform(scrollTo());
//        onView(withText("Push News Notification")).perform(click());
//        AutomationHelper.getInstance().isOffline = true;
//        Thread.sleep(20000);
//
//        //Tap the notification - broken https://jira.webmd.net/browse/PPE-196060
//
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(isDisplayed()));
//        onView(withId(R.id.txtReloadText)).check(matches(isDisplayed()));
//        onView(withId(R.id.noNetworkBtn)).check(matches(isDisplayed()));
//        AutomationHelper.getInstance().isOffline = false;
//        Thread.sleep(3000);
//        onView(withId(R.id.noNetworkBtn)).perform(click());
//        Thread.sleep(10000);
//        onView(withId(R.id.base_webview_error)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.txtReloadText)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        onView(withId(R.id.noNetworkBtn)).check(matches(not(isDisplayed()))); // this will fail until PPE-191006 is fixed
//        Thread.sleep(5000);
//    }
//
//
//    //@Test
//    public void NonUSMedicalStudentRegistartion_ShouldSucceed() throws InterruptedException {
//        // To test https://jira.webmd.net/browse/PPE-193644
//        Thread.sleep(10000);
//        onView(withId(R.id.btnSignUp)).perform(click());
//        Thread.sleep(3000);
//        onView(withId(R.id.buttonCountry)).perform(click());
//        UiScrollable listView = null;
//        listView = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/listViewSelection"));
//        listView.setMaxSearchSwipes(10);// Maximum number of scrolls up to text found
//
//        try {
//            listView.scrollTextIntoView("Brazil");
//            Thread.sleep(2000);
//            onView(withText("Brazil")).perform(click());
//        }catch (UiObjectNotFoundException e){
//            e.printStackTrace();
//        }
//        onView(withId(R.id.button_profession)).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Medical Student")).perform(click());
//        onView(withId(R.id.buttonSpeciality)).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Cardiology, General")).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.buttonContinue)).perform(click());
//        Thread.sleep(2000);
//        onView(withId(R.id.evFirstName)).perform(replaceText("MedicalStudent"), closeSoftKeyboard());
//        onView(withId(R.id.evLastName)).perform(replaceText("Brazil"),closeSoftKeyboard());
//        onView(withId(R.id.ev_email_address)).perform(replaceText("MS_automation01@yopmail.com"), pressImeActionButton());
//        Thread.sleep(30000);
//        onView(withId(R.id.ev_password)).perform(replaceText("qwertyui"),closeSoftKeyboard());
//        onView(withId(R.id.evPostalCode)).perform(replaceText("12345"),closeSoftKeyboard());
//        onView(withId(R.id.btnDone)).perform(click());
//        Thread.sleep(5000);
//        onView(withId(R.id.btnSchoolState)).perform(click());
//        onView(withText("California")).perform(click());
//        onView(withId(R.id.btnSchool)).perform(click());
//        onView(withText("Stanford University School of Medicine")).perform(click());
//        onView(withId(R.id.btnBirthYear)).perform(click());
//        onView(withText("1997")).perform(click());
//        onView(withId(R.id.btnGraduationYear)).perform(click());
//        onView(withText("2020")).perform(click());
//        onView(withId(R.id.btnDone)).check(matches(isEnabled()));
//        Thread.sleep(2000);
//        onView(withId(R.id.btnDone)).perform(click());
//        Thread.sleep(20000);
//        //  onView(withId(R.id.logo)).check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void ConsultSearchTagsBackNavigation_ShouldSucceed() throws InterruptedException {
//        //https://jira.webmd.net/browse/PPE-192741
//        Thread.sleep(20000);
//        onView(withId(R.id.bottomnav_consult)).perform(click());
//        Thread.sleep(10000);
//        UiObject Legal = mDevice.findObject(new UiSelector().text("ACCEPT"));
//        try{
//            if(Legal.exists()){
//                Legal.click();
//                Thread.sleep(10000);
//                onView(withText("OK, GOT IT")).perform(click());
//            }
//
//        }catch (UiObjectNotFoundException e){
//            e.printStackTrace();
//        }
//        onView(withId(R.id.action_search)).perform(click());
//        onView(withText("Tags")).perform(click());
//        onView(withId(R.id.search_src_text)).perform(replaceText("Heart"), pressImeActionButton());
//        Thread.sleep(3000);
//        onView(withText("Acute Heart Failure (HF)")).perform(click());
//        Espresso.pressBack();
//        Thread.sleep(3000);
//        onView(withText("Acute Heart Failure (HF)")).check(matches(isDisplayed()));
//        Thread.sleep(2000);
//    }
//
//
//    @Test
//    public void PrescriptionDetailsEnterCityDetails_ShouldSucceed() throws InterruptedException {
//        //https://jira.webmd.net/browse/PPE-193435
//        Thread.sleep(30000);
//        onView(withText("Drugs")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("A-Methapred")).perform(click());
//        onView(withId(R.id.drugMonographSections)).perform(swipeUp());
//        onView(withText("Pricing & Savings")).perform(click());
//        Thread.sleep(32000);
//        UiObject Okbutton = mDevice.findObject(new UiSelector().text("OK"));
//        if(Okbutton.exists()){
//            onView(allOf(withId(android.R.id.button1))).perform(click());
//            Thread.sleep(2000);
//            onView(withText("Pricing & Savings")).perform(click());
//            Thread.sleep(15000);
//        }
//        UiObject button = mDevice.findObject(new UiSelector().text("ALLOW"));
//        try {
//            if (button.exists()) {
//                button.click();
//            }
//        } catch (UiObjectNotFoundException e) {
//            e.printStackTrace();
//        }
//        //}
//        onView(withText("Location")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Enter your city & state or Zip code")).perform(click());
//        onView(withId(R.id.d_input_edit_text_input)).perform(replaceText("new york"));
//        Thread.sleep(3000);
//        onView(withId(R.id.input_dialog_button_positive)).perform(click());
//        Thread.sleep(5000);
//        onView(withId(R.id.a_p_details_button_find)).perform(click());
//        Thread.sleep(3000);
//        //if(Okbutton.exists()) {
//          /* onView(allOf(withId(android.R.id.button1))).perform(click());
//           Thread.sleep(2000);
//           onView(withId(R.id.a_p_details_button_find)).perform(click());
//           Thread.sleep(5000);*/
//        onView(withText("Duane Reade")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("SHOW COUPON")).perform(click());
//        //}
//        onView(withText("Send")).perform(click());
//        Thread.sleep(3000);
//        onView(withId(R.id.share_saving_card_info)).perform(TestUtils.clickClickableSpan("image of the savings card"));
//
//        Thread.sleep(5000);
//        onView(withId(R.id.button_faq)).perform(click());
//        Thread.sleep(5000);
//        mDevice.findObject(new UiSelector().text("WebMDRx")).exists();
//
//    }
//
//    @Test
//    public void PrescriptionDetailsSelectionIcon_ShouldSucceed() throws InterruptedException {
//        //https://jira.webmd.net/browse/PPE-193701
//        Thread.sleep(30000);
//        onView(withText("Drugs")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("A-Methapred")).perform(click());
//        onView(withId(R.id.drugMonographSections)).perform(swipeUp());
//        onView(withText("Pricing & Savings")).perform(click());
//        Thread.sleep(30000);
//        UiObject button = mDevice.findObject(new UiSelector().text("ALLOW"));
//        try {
//            if (button.exists()) {
//                button.click();
//            }
//        }catch (UiObjectNotFoundException e){
//            e.printStackTrace();
//        }
//        onView(withId(R.id.a_p_details_layout_drug_name)).check(matches(hasSibling(CoreMatchers.<View>instanceOf(ImageView.class))));
//        Thread.sleep(3000);
//
//
//    }
//
//
//    @Test
//    public void ConsultFromHomeFeed_ShouldSucceed() throws InterruptedException {
//        //https://jira.webmd.net/browse/PPE-190589
//        Thread.sleep(30000);
//        onView(withId(R.id.landing_feed_view)).perform(RecyclerViewActions.scrollToPosition(5));
//        /*UiScrollable listView = null;
//        listView = new UiScrollable(new UiSelector().resourceId("com.medscape.android.debug:id/landing_feed_view"));
//       // Thread.sleep(2000);
//        listView.setMaxSearchSwipes(100);// Maximum number of scrolls up to text found
//        listView.scrollTextIntoView("CONSULT");*/
//        AutomationHelper.getInstance().isOffline = true;
//        Thread.sleep(5000);
//        onView(withText("CONSULT")).perform(click());
//        Thread.sleep(5000);
//        UiObject Legal = mDevice.findObject(new UiSelector().text("ACCEPT"));
//        try {
//            if (Legal.exists()) {
//                Legal.click();
//                Thread.sleep(5000);
//            }
//
//        } catch (UiObjectNotFoundException e) {
//            e.printStackTrace();
//        }
//        onView(withText("Consult")).check(matches(isDisplayed()));
//        Thread.sleep(2000);
//    }
//
//    //@Test
//    public void PricingSavingsNonUSUser_ShouldSucceed() throws InterruptedException {
//        //https://jira.webmd.net/browse/PPE-193344
//        Thread.sleep(20000);
//        onView(withId(R.id.btnSignIn)).perform(click());
//        Thread.sleep(5000);
//        onView(withId(R.id.edit_text_user_name)).perform(replaceText("Afg@yy.com"), closeSoftKeyboard());
//        onView(withId(R.id.edit_text_password)).perform(replaceText("qwertyui"), closeSoftKeyboard());
//        onView(withId(R.id.button_login)).perform(click());
//        Thread.sleep(30000);
//        onView(withText("More")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Pricing & Saving")).check(doesNotExist());
//        Espresso.pressBack();
//        Thread.sleep(2000);
//        onView(withId(R.id.profile_image_view)).perform(click());
//        onView(withText("Log out")).perform(click());
//        Thread.sleep(5000);
//        onView(withText("Are you sure?")).check(matches(isDisplayed()));
//        Thread.sleep(3000);
//        onView(allOf(withId(R.id.yes_button), withText("Yes"), childAtPosition(allOf(withId(R.id.help_root_view), childAtPosition(withId(R.id.help_activity_recycler_view), 6)), 1))).perform(click());
//    }
//
//
//    @Test
//    public void FindOnPageLoadingSpinner_ShouldSucceed() throws InterruptedException {
//        //https://jira.webmd.net/browse/PPE-191817
//        Thread.sleep(30000);
//        onView(withText("Drugs")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("A and D Ointment")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Dosage & Indications")).perform(click());
//        Thread.sleep(3000);
//        onView(withContentDescription("More options")).perform(click());
//        Thread.sleep(2000);
//        onView(withText("Find in Page")).perform(click());
//        Thread.sleep(2000);
//        pressImeActionButton();
//        onView(withText("Dosing Forms & Strengths")).check(matches(isDisplayed()));
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void DrugsRecentlyViewed_ShouldSucceed() throws InterruptedException {
//        Thread.sleep(30000);
//        onView(withText("Drugs")).perform(click());
//        Thread.sleep(3000);
//        onView(withText("A and D Ointment")).perform(click());
//        Thread.sleep(2000);
//        Espresso.pressBack();
//        Thread.sleep(2000);
//        onView(withId(R.id.recycler_view)).perform(swipeUp());
//        Thread.sleep(2000);
//        onView(withText("Absorica")).perform(click());
//        Thread.sleep(2000);
//        Espresso.pressBack();
//        onView(withId(R.id.search_src_text)).perform(click());
//        Thread.sleep(3000);
//        DataInteraction relativeLayout = onData(anything()).inAdapterView(childAtPosition(withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
//                0)).atPosition(1);relativeLayout.check(matches(isDisplayed()));
//        //onView(withText("Recently Viewed")).check(matches(isDisplayed()));
//        //onView(withText("Absorica")).check(matches(isDisplayed()));
//
//        /*Thread.sleep(5000);
//        onView(withId(R.id.search_src_text)).perform(replaceText("Warfarin"), closeSoftKeyboard());
//        onView(allOf(withId(R.id.recycler_view),childAtPosition(withId(R.id.text),0))).perform(actionOnItemAtPosition(0, click()));
//        Thread.sleep(10000);*/
//
//
//    }
//
//    @Test
//    public void CalculatorErrorPopUp_ShouldSucceed() throws InterruptedException {
//        //https://jira.webmd.net/browse/PPE-192034
//
//        Thread.sleep(30000);
//        onView(withText("Calculators")).perform(click());
//        onView(withText("A-a Gradient")).perform(click());
//        Thread.sleep(2000);
//
//        try {
//            mDevice.findObject(new UiSelector().instance(3).className(EditText.class)).clearTextField();
//            mDevice.findObject(new UiSelector().instance(3).className(EditText.class)).setText("0");
//            Thread.sleep(3000);
//            UiObject button = mDevice.findObject(new UiSelector().textStartsWith("The minimum value for Percent Inspired"));
//            if (button.exists()) {
//                String AlertMessage = button.getText();
//                Log.d("Test", "Message is :"+ AlertMessage);
//                Thread.sleep(2000);
//            }
//        }catch (UiObjectNotFoundException e){
//            //e.printStackTrace();
//        }
//        onView(allOf(withId(android.R.id.button1))).perform(click());
//        Thread.sleep(5000);
//        try {
//            mDevice.findObject(new UiSelector().instance(5).className(EditText.class)).clearTextField();
//            mDevice.findObject(new UiSelector().instance(5).className(EditText.class)).setText("0");
//            //textfield2.waitForExists(timeOut);
//            Thread.sleep(3000);
//            UiObject button2 = mDevice.findObject(new UiSelector().textStartsWith("The minimum value for Resp Quot"));
//            if (button2.exists()) {
//                String AlertMessage2 = button2.getText();
//                Log.d("Test", "Message is :"+ AlertMessage2);
//            }
//        }catch (UiObjectNotFoundException e){
//            //e.printStackTrace();
//        }
//        onView(allOf(withId(android.R.id.button1))).perform(click());
//        Thread.sleep(3000);
//        //Thread.sleep(10000);
//
//
//    }
//
//
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }
//
//    public static ViewAction clickXY(final int x, final int y){
//        return new GeneralClickAction(
//                Tap.SINGLE,
//                new CoordinatesProvider() {
//
//                    @Override
//                    public float[] calculateCoordinates(View view) {
//
//                        final int[] screenPos = new int[2];
//                        view.getLocationOnScreen(screenPos);
//
//                        final float screenX = screenPos[0] + x;
//                        final float screenY = screenPos[1] + y;
//                        float[] coordinates = {screenX, screenY};
//
//                        return coordinates;
//                    }
//                },
//                Press.FINGER,
//                InputDevice.SOURCE_MOUSE,
//                MotionEvent.BUTTON_PRIMARY);
//    }
//
//}
