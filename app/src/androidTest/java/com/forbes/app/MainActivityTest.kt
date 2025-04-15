package com.forbes.app

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    private lateinit var driver: AndroidDriver

    @Before
    fun setUp() {
        val capabilities = DesiredCapabilities().apply {
            setCapability("platformName", "Android")
            setCapability("automationName", "UiAutomator2")
            setCapability("deviceName", "Android Emulator")
            setCapability("app", InstrumentationRegistry.getInstrumentation().targetContext.applicationInfo.sourceDir)
        }

        driver = AndroidDriver(URL("http://127.0.0.1:4723/wd/hub"), capabilities)
    }

    @Test
    fun testBreakingNewsSection() {
        // Test breaking news section visibility
        val breakingNewsTitle = driver.findElement(AppiumBy.xpath("//*[@testId='breaking_news_title']"))
        assert(breakingNewsTitle.isDisplayed)

        // Test breaking news list
        val breakingNewsList = driver.findElement(AppiumBy.xpath("//*[@testId='breaking_news_list']"))
        assert(breakingNewsList.isDisplayed)

        // Test clicking on a breaking news item
        val firstNewsItem = driver.findElement(AppiumBy.xpath("//*[@testId='breaking_news_item'][1]"))
        firstNewsItem.click()
        // Add assertions for news detail view
    }

    @Test
    fun testTabNavigation() {
        // Test Latest tab
        val latestTab = driver.findElement(AppiumBy.xpath("//*[@testId='latest_tab']"))
        latestTab.click()
        // Add assertions for Latest tab content

        // Test Magazine tab
        val magazineTab = driver.findElement(AppiumBy.xpath("//*[@testId='magazine_tab']"))
        magazineTab.click()
        // Add assertions for Magazine tab content
    }

    @Test
    fun testToolbarActions() {
        // Test search button
        val searchButton = driver.findElement(AppiumBy.xpath("//*[@testId='search_button']"))
        searchButton.click()
        // Add assertions for search action

        // Test settings button
        val settingsButton = driver.findElement(AppiumBy.xpath("//*[@testId='settings_button']"))
        settingsButton.click()
        // Add assertions for settings action
    }

    @After
    fun tearDown() {
        driver.quit()
    }
} 