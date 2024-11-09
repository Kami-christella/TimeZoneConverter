import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the current time in the system's default time zone
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Current time: " + currentTime.format(formatter));
        System.out.println("Select the time zone to convert to:");
        System.out.println("1. EST (Eastern Standard Time)");
        System.out.println("2. PST (Pacific Standard Time)");
        System.out.println("3. GMT (Greenwich Mean Time)");
        System.out.println("4. IST (Indian Standard Time)");

        int choice = scanner.nextInt();

        // Get the current time in UTC
        ZonedDateTime utcTime = currentTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));
        ZonedDateTime convertedTime = null;

        switch (choice) {
            case 1: // EST
                convertedTime = utcTime.withZoneSameInstant(ZoneId.of("America/New_York"));
                System.out.println("Time in EST: " + convertedTime.format(formatter));
                break;
            case 2: // PST
                convertedTime = utcTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
                System.out.println("Time in PST: " + convertedTime.format(formatter));
                break;
            case 3: // GMT
                convertedTime = utcTime.withZoneSameInstant(ZoneId.of("GMT"));
                System.out.println("Time in GMT: " + convertedTime.format(formatter));
                break;
            case 4: // IST
                convertedTime = utcTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
                System.out.println("Time in IST: " + convertedTime.format(formatter));
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

        scanner.close();
    }
}
