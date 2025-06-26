package TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import leaforg_automation.UpdateUserProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TestUtils {
	
	//For using in random string creation function
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int DEFAULT_LENGTH = 10;
    private static final int DEFAULT_SHORT_LENGTH = 10;
    private static final Random RANDOM = new Random();

    
    //For setting up date from Date picker
    public static void selectDate(AndroidDriver driver, String targetYear, int targetDay, int targetMonth) throws ParseException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the spinner if not already
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Spinner"))).click();

        // Select year
        driver.findElement(AppiumBy.id("android:id/date_picker_header_year")).click();
        WebElement yearList = driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward().scrollIntoView(new UiSelector().text(\"" + targetYear + "\"))"));
        yearList.click();

        // Get current displayed month
        String date_found = driver.findElement(AppiumBy.id("android:id/date_picker_header_date")).getText().trim();
        SimpleDateFormat inputFormat = new SimpleDateFormat("E, MMM dd", Locale.ENGLISH);
        Date date = inputFormat.parse(date_found);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currentMonth = calendar.get(Calendar.MONTH); // 0-based
        
        int clicks = currentMonth - targetMonth;

        if (clicks > 0) {
            // Go backward (to earlier months)
            for (int i = 0; i < clicks; i++) {
                driver.findElement(AppiumBy.id("android:id/prev")).click();
            }
        } else if (clicks < 0) {
            // Go forward (to future months)
            for (int i = 0; i < Math.abs(clicks); i++) {
                driver.findElement(AppiumBy.id("android:id/next")).click();
            }
        }

        // Select the day
        WebElement day = driver.findElement(By.xpath("//android.view.View[@text='" + targetDay + "']"));
        day.click();

        // Confirm
        driver.findElement(By.id("android:id/button1")).click();
    }
    
    //For date picker in license
    public static void selectDateForLicense(AndroidDriver driver, String targetYear, int targetDay, int targetMonth) throws ParseException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the spinner if not already
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Spinner"))).click();

        // Select year
        driver.findElement(By.id("android:id/date_picker_header_year")).click();
        WebElement yearList = driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward().scrollIntoView(new UiSelector().text(\"" + targetYear + "\"))"));
        yearList.click();

        // Get current displayed month
        String date_found = driver.findElement(AppiumBy.id("android:id/date_picker_header_date")).getText().trim();
        SimpleDateFormat inputFormat = new SimpleDateFormat("E, MMM dd", Locale.ENGLISH);
        Date date = inputFormat.parse(date_found);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currentMonth = calendar.get(Calendar.MONTH); // 0-based
        
        int clicks = currentMonth - targetMonth;

        if (clicks > 0) {
            // Go backward (to earlier months)
            for (int i = 0; i < clicks; i++) {
                driver.findElement(AppiumBy.id("android:id/prev")).click();
            }
        } else if (clicks < 0) {
            // Go forward (to future months)
            for (int i = 0; i < Math.abs(clicks); i++) {
                driver.findElement(AppiumBy.id("android:id/next")).click();
            }
        }

        // Select the day
        WebElement day = driver.findElement(By.xpath("//android.view.View[@text='" + targetDay + "']"));
        day.click();

        // Confirm
        driver.findElement(By.id("android:id/button1")).click();
    }
    
    //Random long string generator
    public static String generateRandomAlphabetic() {
        return generateRandomAlphabetic(DEFAULT_LENGTH);
    }

    // Overloaded: Allows custom length
    public static String generateRandomAlphabetic(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }
    
    //Random short string generator
    public static String generateRandomShortAlphabetic() {
        return generateRandomShortAlphabetic(DEFAULT_SHORT_LENGTH);
    }

    // Overloaded: Allows custom length
    public static String generateRandomShortAlphabetic(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }
    
    //Email ID generator
    private static final String[] DOMAINS = {
            "gmail.com", "yahoo.com", "outlook.com", "example.com", "testmail.com"
        };
        private static final String CHAR_POOL = "abcdefghijklmnopqrstuvwxyz0123456789";
        private static final SecureRandom RNG = new SecureRandom();

        
        public static String RandomEmailGenerator() {
            int usernameLength = 10;  // or make this configurable
            StringBuilder user = new StringBuilder(usernameLength);
            for (int i = 0; i < usernameLength; i++) {
                user.append(CHAR_POOL.charAt(RNG.nextInt(CHAR_POOL.length())));
            }
            String domain = DOMAINS[RNG.nextInt(DOMAINS.length)];
            return user + "@" + domain;
        }
        
        //Phone number generator
        public static String RandomPhoneNumberGenerator() {
            SecureRandom rand = new SecureRandom();

            int areaCode = rand.nextInt(900) + 100;    // 100–999
            int centralOfficeCode = rand.nextInt(900) + 100;  // 100–999
            int lineNumber = rand.nextInt(10000);      // 0000–9999

            return String.format("%03d-%03d-%04d", areaCode, centralOfficeCode, lineNumber);
        }
        
        //Participant ID generator
        public static String RandomNumericString(int length) {
            SecureRandom rand = new SecureRandom();
            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                sb.append(rand.nextInt(10));  // generates 0–9
            }

            return sb.toString();
        }
        
        //License number generator
        public static String RandomAlphaNumericId() {
            SecureRandom rand = new SecureRandom();

            // Generate a random uppercase letter (A–Z)
            char letter = (char) ('A' + rand.nextInt(26));

            // Generate 7-digit numeric string
            int number = rand.nextInt(10_000_000);  // 0 to 9999999
            String numberPart = String.format("%07d", number);  // zero-padded

            return letter + numberPart;
        }
        
        //Phone Number generator
        public static String RandomUSPhoneNumber() {
            SecureRandom rand = new SecureRandom();

            int areaCode = rand.nextInt(900) + 100;          // 100–999
            int centralOfficeCode = rand.nextInt(900) + 100; // 100–999
            int lineNumber = rand.nextInt(10000);            // 0000–9999

            return String.format("%03d-%03d-%04d", areaCode, centralOfficeCode, lineNumber);
        }
        
        //Random Year Generator
        public static String GenerateRandomYear(int minYear, int maxYear) {
            if (minYear < 1000 || maxYear > 9999) {
                throw new IllegalArgumentException("Years must be 4-digit numbers.");
            }
            if (minYear >= maxYear) {
                throw new IllegalArgumentException("minYear must be less than maxYear.");
            }

            SecureRandom rand = new SecureRandom();
            int randomYear = rand.nextInt(maxYear - minYear + 1) + minYear; // inclusive range
            System.out.println("The random year is: " + randomYear);
            return String.valueOf(randomYear);
        }
        
        //Name for profile
        public static String generateFirstName() {
        	if(TestDataStore.nameSelected == 0) {
        		String firstName = "Francis";
        		return firstName;
        	}
        	else {
        		String firstName = "Daniel";
        		return firstName;
        	}
        }
        
        public static String generateLastName() {
        	if(TestDataStore.nameSelected == 0) {
        		String lastName = "Xxevier";
        		return lastName;
        	}
        	else {
        		String lastName = "Raegan";
        		return lastName;
        	}
        }






    
}
