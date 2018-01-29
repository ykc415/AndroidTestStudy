package com.app.ykc.roboletric

import android.widget.Button
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowApplication
import android.content.Intent
import junit.framework.Assert.assertEquals


/**
 * Created by ykc on 2018-01-30.
 */

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

}