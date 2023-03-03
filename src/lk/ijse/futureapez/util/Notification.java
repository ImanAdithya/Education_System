package lk.ijse.futureapez.util;

import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Notification {
    public static void notification(String text){
        Notifications.create()
                .title("Futureapez Technologies\n\n")
                //.graphic(new ImageView(image))
                .text(text).
                darkStyle()
                .hideAfter(Duration.seconds(5))
                .show();

    }
}
