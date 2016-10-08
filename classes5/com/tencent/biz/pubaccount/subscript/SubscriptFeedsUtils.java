package com.tencent.biz.pubaccount.subscript;

import android.util.Base64;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.List;

public class SubscriptFeedsUtils
{
  public static final int a = 86400;
  public static final long a = 86400000L;
  public static final String a = "刚刚";
  public static final int b = 172800;
  public static final long b = 172800000L;
  public static final String b = "分钟前";
  public static final int c = 28800;
  public static final String c = "小时前";
  public static final String d = "今天";
  public static final String e = "昨天";
  public static final String f = "前天";
  public static final String g = "天前";
  public static final String h = "月前";
  public static final String i = "年前";
  public static final String j = "时";
  public static final String k = "年";
  public static final String l = "月";
  public static final String m = "日";
  public static final String n = "分";
  public static final String o = "前";
  public static final String p = ":";
  public static final String q = "点";
  
  public SubscriptFeedsUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
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
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(1000L * paramLong);
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    long l2 = localCalendar1.get(11) * 60 * 60 * 1000;
    long l3 = localCalendar1.get(12) * 60 * 1000;
    long l4 = localCalendar1.get(13) * 1000;
    paramLong = l1 - localCalendar2.getTimeInMillis();
    l1 = l1 - l2 - l3 - l4 - localCalendar2.getTimeInMillis();
    int i1;
    int i2;
    int i3;
    if (paramLong < 0L)
    {
      i1 = localCalendar2.get(1);
      i2 = localCalendar2.get(2);
      i3 = localCalendar2.get(5);
      int i4 = localCalendar1.get(1);
      int i5 = localCalendar1.get(5);
      if (i4 != i1) {
        return i1 + "-" + a(i2 + 1) + "-" + a(i3);
      }
      if (i3 != i5) {
        return a(localCalendar2.get(2) + 1) + "-" + a(localCalendar2.get(5)) + " " + a(localCalendar2.get(11)) + ":" + a(localCalendar2.get(12));
      }
      return "今天" + a(localCalendar2.get(11)) + ":" + a(localCalendar2.get(12));
    }
    paramLong /= 1000L;
    if ((paramLong >= 0L) && (paramLong < 60L)) {
      return "刚刚";
    }
    if ((paramLong >= 60L) && (paramLong < 3600L)) {
      return paramLong / 60L + "分钟前";
    }
    if (l1 < 0L) {
      return paramLong / 3600L + "小时前";
    }
    if ((l1 >= 0L) && (l1 < 86400000L)) {
      return "昨天";
    }
    if (l1 >= 86400000L)
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
  
  public static String a(List paramList)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramList);
    paramList = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
    localObjectOutputStream.close();
    return paramList;
  }
  
  public static List a(String paramString)
  {
    paramString = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0)));
    List localList = (List)paramString.readObject();
    paramString.close();
    return localList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptFeedsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */