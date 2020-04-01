package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css="[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css="[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css="[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css="[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    public List<String> columnNames(){
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }
    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        BrowserUtils.scrollTo(startTime);
        return startTime.getAttribute("value");
    }
    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        BrowserUtils.scrollTo(endTime);
        return endTime.getAttribute("value");
    }




    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clcikToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate.getAttribute("value");
    }
}
