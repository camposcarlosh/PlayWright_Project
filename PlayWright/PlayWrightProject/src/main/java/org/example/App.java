package org.example;
import com.microsoft.playwright.*;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class App {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Browser browser = pw.chromium().launch(new
                    BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://app.clockify.me");
            System.out.println(page.title());
            assertThat( page ).hasTitle(
                    Pattern.compile("clockify") );
        }
    }
// mvn compile exec:java -Dexec.mainClass="org.example.App"
// mvn exec:java -e –D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://app.clockify.me"
}

