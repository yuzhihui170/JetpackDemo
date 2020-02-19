package me.forrest.commonlib.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    /*
     * 将时间戳转换为时间(MS) yyyy-MM-dd HH:mm:ss
     */
    public static String dateToString(String stamp){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        long lt = Long.valueOf(stamp);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

}
