package cn.lyhxh.wechat;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 日期测试
 * @Author leiyang_39@163.com
 * @Date 2018/7/4 18:02
 * @Version V3.0
 */
public class DateTest {

    @Test
    public void testDate() {
        Date date = toDate("2018-07-05 11:30:00");
        boolean flag = new Date().after(date);
        System.out.println(flag);
    }

    public static Date toDate(String sDate) {
        String sFmt = "yyyy-MM-dd HH:mm:ss";
        if (StringUtils.isEmpty(sDate)) {
            return null;
        } else {
            SimpleDateFormat sdfFrom = null;
            Date dt = null;

            Object var5;
            try {
                sdfFrom = new SimpleDateFormat(sFmt);
                dt = sdfFrom.parse(sDate);
                return dt;
            } catch (Exception var9) {
                var5 = null;
            } finally {
                sdfFrom = null;
            }
            return (Date)var5;
        }
    }

}
