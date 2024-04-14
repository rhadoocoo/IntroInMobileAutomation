import org.openqa.selenium.By;


public class Locators {
    public By key(int tastaNumerica) {
        switch (tastaNumerica) {
            case 1:
                return By.id("com.android.calculator2:id/digit_1");
            case 2:
                return By.id("com.android.calculator2:id/digit_2");
            case 3:
                return By.id("com.android.calculator2:id/digit_3");
            case 4:
                return By.id("com.android.calculator2:id/digit_4");
            case 5:
                return By.id("com.android.calculator2:id/digit_5");
            case 6:
                return By.id("com.android.calculator2:id/digit_6");
            case 7:
                return By.id("com.android.calculator2:id/digit_7");
            case 8:
                return By.id("com.android.calculator2:id/digit_8");
            case 9:
                return By.id("com.android.calculator2:id/digit_9");
            case 0:
                return By.id("com.android.calculator2:id/digit_0");
            default:
                throw new IllegalArgumentException("Butonul nu exista");
        }
    }
}