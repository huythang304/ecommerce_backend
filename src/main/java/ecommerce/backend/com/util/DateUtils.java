package ecommerce.backend.com.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtils {

    //Lấy thời gian hiện tại
    public static Timestamp getCurrentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return java.sql.Timestamp.valueOf(localDateTime);
    }

}
