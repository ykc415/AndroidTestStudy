package com.app.ykc.roboletric

import android.widget.Button
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowApplication
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES.JELLY_BEAN
import junit.framework.Assert.assertEquals
import org.apache.tools.ant.Main
import org.junit.After
import org.junit.Before
import org.robolectric.RuntimeEnvironment
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config


/**
 * Created by ykc on 2018-01-30.
 */

@Config(constants = BuildConfig::class, sdk = intArrayOf(Build.VERSION_CODES.LOLLIPOP))
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun clickingLogin_shouldStartLoginActivity() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)

        activity.findViewById<Button>(R.id.login).performClick()

        val expectedIntent = Intent(activity, LoginActivity::class.java)
        val actual = ShadowApplication.getInstance().nextStartedActivity
        assertEquals(expectedIntent.component, actual.component)
    }


    //Simulating the Full Activity Lifecycle

    // ActivityController is a Roboletric class that drives the Activity lifecycle
    lateinit var activity: MainActivity

    @Before
    fun setUp() {
        // Call the "buildActivity" method so we get a ActivityController which we can use
        // to have more control over the activity lifecycle
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
    }

    @Test
    fun testOnResumeNotOnCreate() {
        val controller = Robolectric.buildActivity(MainActivity::class.java).create().start()
        val activity = controller.get()

        controller.resume()
    }

    @Test
    fun fullCreateionLifecycle() {
        val activity = Robolectric.buildActivity(MainActivity::class.java)
                .create()
                .start()
                .resume()
                .visible()
                .get()

        // this test fail
        assertEquals(activity.test, "4")
        // this test success
        assertEquals(activity.test, "3")

    }












}