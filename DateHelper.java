package com.company;
import java.time.LocalDateTime;

/**
 * Created by Someone on 29.11.2016.
 */
public class DateHelper {
    private LocalDateTime currentTime;

    public String getFormattedStartDate() {
        currentTime = LocalDateTime.now();
        currentTime = currentTime.minusYears(1500);
        return "Время начала сражения:\nГод:  " + currentTime.getYear() + "\nМесяц: " + currentTime.getMonth()
                + "\nДень: " + currentTime.getDayOfMonth() + "\nВремя: " + currentTime.getHour() + ":"
                + currentTime.getMinute();
    }

    public void skipTime() {
        currentTime = currentTime.plusMinutes(45);
    }


    public String getFormattedDiff() {
        return "Время окночания сражения:\nГод:  " + currentTime.getYear() + "\nМесяц: " + currentTime.getMonth()
                + "\nДень: " + currentTime.getDayOfMonth() + "\nВремя: " + currentTime.getHour() + ":"
                + currentTime.getMinute();
    }


}
