package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReadInJoyTimeUtils
{
  public static final int a = 86400;
  public static final long a = 86400000L;
  public static final String a = "ReadInJoyTimeUtils";
  public static final int b = 172800;
  public static final long b = 172800000L;
  public static final String b = "刚刚";
  public static final int c = 28800;
  public static final String c = "分钟前";
  public static final String d = "小时前";
  public static final String e = "今天";
  public static final String f = "昨天";
  public static final String g = "前天";
  public static final String h = "天前";
  public static final String i = "月前";
  public static final String j = "年前";
  public static final String k = "时";
  public static final String l = "年";
  public static final String m = "月";
  public static final String n = "日";
  public static final String o = "分";
  public static final String p = "前";
  public static final String q = ":";
  public static final String r = "点";
  
  public ReadInJoyTimeUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  public static Boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  static String a(int paramInt)
  {
    if (paramInt < 10) {
      return '0' + String.valueOf(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  public static String a(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    if ((localCalendar.get(1) == ((Calendar)localObject).get(1)) && (localCalendar.get(6) == ((Calendar)localObject).get(6))) {
      return "今天";
    }
    if ((localCalendar.get(1) == ((Calendar)localObject).get(1)) && (localCalendar.get(6) + 1 == ((Calendar)localObject).get(6))) {
      return "昨天";
    }
    if ((localCalendar.get(1) == ((Calendar)localObject).get(1)) && (localCalendar.get(6) > ((Calendar)localObject).get(6) - 7)) {
      return c(paramLong);
    }
    localObject = new Date(paramLong);
    return new SimpleDateFormat("yy/MM/dd").format((Date)localObject);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(1000L * paramLong);
    if (paramBoolean) {}
    long l1;
    int i1;
    int i2;
    int i3;
    int i5;
    for (paramLong = a() * 1000L;; paramLong = localCalendar1.getTimeInMillis())
    {
      long l2 = localCalendar1.get(11) * 60 * 60 * 1000;
      long l3 = localCalendar1.get(12) * 60 * 1000;
      long l4 = localCalendar1.get(13) * 1000;
      l1 = paramLong - localCalendar2.getTimeInMillis();
      paramLong = paramLong - l2 - l3 - l4 - localCalendar2.getTimeInMillis();
      if (l1 >= 0L) {
        break label341;
      }
      i1 = localCalendar2.get(1);
      i2 = localCalendar2.get(2);
      i3 = localCalendar2.get(5);
      int i4 = localCalendar1.get(1);
      i5 = localCalendar1.get(5);
      if (i4 == i1) {
        break;
      }
      return i1 + "-" + a(i2 + 1) + "-" + a(i3);
    }
    if (i3 != i5) {
      return a(localCalendar2.get(2) + 1) + "-" + a(localCalendar2.get(5)) + " " + a(localCalendar2.get(11)) + ":" + a(localCalendar2.get(12));
    }
    return "今天" + a(localCalendar2.get(11)) + ":" + a(localCalendar2.get(12));
    label341:
    l1 /= 1000L;
    if ((l1 >= 0L) && (l1 < 60L)) {
      return "刚刚";
    }
    if ((l1 >= 60L) && (l1 < 3600L)) {
      return l1 / 60L + "分钟前";
    }
    if (paramLong < 0L) {
      return l1 / 3600L + "小时前";
    }
    if ((paramLong >= 0L) && (paramLong < 86400000L)) {
      return "昨天";
    }
    if (paramLong >= 86400000L)
    {
      i1 = localCalendar2.get(1);
      i2 = localCalendar2.get(2) + 1;
      i3 = localCalendar2.get(5);
      if (localCalendar1.get(1) != i1) {
        return i1 + "-" + a(i2) + "-" + a(i3);
      }
      return a(i2) + "-" + a(i3);
    }
    return "";
  }
  
  public static Boolean b(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2);
    int i1 = localCalendar.get(11);
    int i2 = localCalendar.get(12);
    int i3 = localCalendar.get(13);
    if (paramLong1 >= paramLong2 - (localCalendar.get(14) + ((i1 * 60 + i2) * 60 + i3) * 1000) - 518400000L) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public static String b(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    if (l1 - paramLong < 3600000L)
    {
      i1 = (int)Math.ceil((l1 - paramLong) / 60000.0D);
      return i1 + "分钟前";
    }
    if (l1 - paramLong < 86400000L)
    {
      i1 = (int)Math.ceil((l1 - paramLong) / 3600000.0D);
      return i1 + "小时前";
    }
    if (b(paramLong, l1).booleanValue()) {
      return c(paramLong);
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("yy/MM/dd").format(localDate);
  }
  
  public static String c(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    switch (localCalendar.get(7))
    {
    default: 
      return "";
    case 1: 
      return "星期日";
    case 2: 
      return "星期一";
    case 3: 
      return "星期二";
    case 4: 
      return "星期三";
    case 5: 
      return "星期四";
    case 6: 
      return "星期五";
    }
    return "星期六";
  }
  
  public static String d(long paramLong)
  {
    paramLong *= 1000L;
    Object localObject1 = null;
    try
    {
      Object localObject2 = new Date(paramLong);
      localObject2 = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyTimeUtils", 2, "getDateTimeString() ERROR millisTime=" + paramLong);
    }
    return (String)localObject1;
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\common\ReadInJoyTimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */