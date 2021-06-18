package Util;

import org.openqa.selenium.By;

public class ElementInfo {
    public String assertDesc;
    public By by;

    public ElementInfo(String assertDesc, By by) {
        super();
        this.assertDesc = assertDesc;
        this.by = by;
    }

    public String getAssertDesc() {
        return assertDesc;
    }

    public void setAssertDesc(String assertDesc) {
        this.assertDesc = assertDesc;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }
}
