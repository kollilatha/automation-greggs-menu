// import org.openqa.selenium.*;
// import org.openqa.selenium.chrome.*;
// import org.openqa.selenium.devtools.DevTools;
// import org.openqa.selenium.devtools.HasDevTools;
// // Update the version number (e.g., v113) to match your Selenium/ChromeDriver version
// import org.openqa.selenium.devtools.v113.performance.Performance;
// import org.openqa.selenium.devtools.v113.performance.model.Metric;

// import java.util.List;

// public class Performance {
//     public static void main(String[] args) {
//         // Start Chrome
//         WebDriver driver = new ChromeDriver();
//         DevTools devTools = ((HasDevTools) driver).getDevTools();
//         devTools.createSession();

//         // Enable performance tracking
//         devTools.send(Performance.enable(java.util.Optional.empty()));

//         // Navigate to Greggs menu page
//         driver.get("https://www.greggs.co.uk/menu");

//         // Capture performance metrics
//         List<Metric> metrics = devTools.send(Performance.getMetrics());
//         for (Metric metric : metrics) {
//             System.out.println(metric.getName() + " = " + metric.getValue());
//         }

//         driver.quit();
//     }
// }

