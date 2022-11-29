package util.helper;

import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class Converter {
    //conversion params.
    private static final long MILIS_IN_SECOND = 1_000L;

    private Converter() {
    }

    /**
     * Convert String date to timestamp.
     *
     * @param strDate date string in format "YYYY-MM-DDTHH:mm:ss.SSSZ".
     * @return timestamp long.
     */
    @SneakyThrows
    public static Long convertStringToTimestampLong(String strDate, String dateFormatPattern) {
        if (strDate == null) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat(dateFormatPattern);
        Date date = formatter.parse(strDate);
        return date.getTime() / MILIS_IN_SECOND;
    }
}
