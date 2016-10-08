package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeFormatterUtils
{
  private static final char jdField_a_of_type_Char = '/';
  public static final int a = 0;
  public static final long a = 86400000L;
  private static final String jdField_a_of_type_JavaLangString = "EEEE";
  private static StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  private static java.text.DateFormat jdField_a_of_type_JavaTextDateFormat;
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  public static final int b = 1;
  private static java.text.DateFormat b;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  private static int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 7;
  
  public TimeFormatterUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar(paramInt1, paramInt2, paramInt3);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(paramInt4, paramInt5, paramInt6);
    return (int)((localGregorianCalendar1.getTimeInMillis() - localGregorianCalendar2.getTimeInMillis()) / 1000L / 60L / 60L / 24L);
  }
  
  public static int a(long paramLong)
  {
    int i1 = -1;
    int i2 = (int)((System.currentTimeMillis() + k) / 86400000L);
    int i3 = (int)((k + paramLong) / 86400000L);
    if (i3 == i2) {
      i1 = 2131368833;
    }
    do
    {
      return i1;
      if (i3 == i2 - 1) {
        return 2131368834;
      }
    } while (i3 != i2 - 2);
    return 2131368835;
  }
  
  public static int a(long paramLong, Calendar paramCalendar)
  {
    int i2 = -1;
    int i3 = (int)((System.currentTimeMillis() + k) / 86400000L);
    int i4 = i3 - 1;
    int i5 = (int)((k + paramLong) / 86400000L);
    int i1;
    if (i5 == i3) {
      i1 = 2131368833;
    }
    do
    {
      do
      {
        return i1;
        if (i5 == i4) {
          return 2131368834;
        }
        i1 = i2;
      } while (i5 >= i4);
      i1 = i2;
    } while (i5 <= i3 - 7);
    Calendar localCalendar = paramCalendar;
    if (paramCalendar == null)
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
    }
    switch (localCalendar.get(7))
    {
    default: 
      return -1;
    case 1: 
      return 2131368842;
    case 2: 
      return 2131368836;
    case 3: 
      return 2131368837;
    case 4: 
      return 2131368838;
    case 5: 
      return 2131368839;
    case 6: 
      return 2131368840;
    }
    return 2131368841;
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong)
  {
    return a(paramContext, paramInt, paramLong, true);
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      SimpleDateFormat localSimpleDateFormat1 = (SimpleDateFormat)a();
      if (paramInt == 0)
      {
        localStringBuilder.append(localSimpleDateFormat1.toLocalizedPattern());
        return android.text.format.DateFormat.format(localStringBuilder.append(" ").toString(), paramLong) + b().format(Long.valueOf(paramLong));
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      SimpleDateFormat localSimpleDateFormat2;
      for (;;)
      {
        localSimpleDateFormat2 = new SimpleDateFormat("HH:mm");
      }
      return a(paramContext, paramLong, localStringBuilder, localSimpleDateFormat2, paramInt, paramBoolean);
    }
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    if (jdField_a_of_type_JavaUtilCalendar == null) {
      jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    }
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    int i1 = jdField_a_of_type_JavaUtilCalendar.get(2);
    int i2 = jdField_a_of_type_JavaUtilCalendar.get(5);
    return String.format("%s%s%s%s", new Object[] { Integer.valueOf(i1 + 1), paramContext.getString(2131368850), Integer.valueOf(i2), paramContext.getString(2131368851) });
  }
  
  private static CharSequence a(Context paramContext, long paramLong, StringBuilder paramStringBuilder, SimpleDateFormat paramSimpleDateFormat, int paramInt, boolean paramBoolean)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    Time localTime2 = new Time();
    localTime2.setToNow();
    int i1;
    int i2;
    if ((paramInt & 0x2) != 0)
    {
      i1 = 1;
      if ((paramInt & 0x1) == 0) {
        break label118;
      }
      i2 = 1;
      label49:
      if ((paramInt & 0x4) == 0) {
        break label124;
      }
      paramInt = 1;
      label59:
      if (localTime1.year == localTime2.year) {
        break label130;
      }
      paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramInt == 0) && (!paramBoolean))
      {
        return android.text.format.DateFormat.format(paramStringBuilder.toString().trim(), paramLong);
        i1 = 0;
        break;
        label118:
        i2 = 0;
        break label49;
        label124:
        paramInt = 0;
        break label59;
        label130:
        if (localTime1.yearDay == localTime2.yearDay) {
          break label472;
        }
        int i4 = Math.abs(localTime2.yearDay - localTime1.yearDay);
        if (localTime2.yearDay > localTime1.yearDay) {}
        for (int i3 = 1;; i3 = 0)
        {
          if (i3 != 0) {
            break label207;
          }
          paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
          paramInt = 0;
          break;
        }
        label207:
        if ((i4 == 1) && (i2 != 0))
        {
          paramStringBuilder.append(paramContext.getString(2131370221)).append(" ");
          if (!paramBoolean) {
            return paramStringBuilder.toString().trim();
          }
          return paramStringBuilder.toString() + b().format(Long.valueOf(paramLong));
        }
        if ((i4 == 2) && (paramInt != 0))
        {
          paramStringBuilder.append(paramContext.getString(2131368835)).append(" ");
          if (!paramBoolean) {
            return paramStringBuilder.toString().trim();
          }
          return paramStringBuilder.toString() + b().format(Long.valueOf(paramLong));
        }
        if ((i4 > 1) && (i4 < 7) && (i1 != 0))
        {
          paramStringBuilder.append("EEEE").append(" ");
          paramInt = 0;
          continue;
        }
        if (localTime1.year == localTime2.year)
        {
          paramStringBuilder.append("MM-dd").append(" ");
          paramInt = 0;
          continue;
        }
        paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
        paramInt = 0;
        continue;
      }
      return android.text.format.DateFormat.format(paramStringBuilder.toString(), paramLong) + b().format(Long.valueOf(paramLong));
      label472:
      paramInt = 1;
    }
  }
  
  public static String a(long paramLong)
  {
    int i1 = 2131368834;
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l1);
    int i2 = localTime2.yearDay - 1;
    int i3 = localTime2.yearDay;
    if (localTime1.year == localTime2.year) {
      if (localTime2.yearDay < localTime1.yearDay) {
        i1 = -1;
      }
    }
    for (;;)
    {
      i2 = i1;
      if (i1 == -1) {
        i2 = 2131368844;
      }
      return BaseApplication.getContext().getString(i2);
      if (localTime2.yearDay == localTime1.yearDay)
      {
        i1 = 2131368833;
      }
      else if (localTime1.yearDay != i2)
      {
        if ((localTime1.yearDay < i2) && (localTime1.yearDay > i3 - 7))
        {
          i1 = 2131368843;
          continue;
          if (localTime1.year + 1 == localTime2.year)
          {
            paramLong = (l1 - paramLong + 86400000L - 1L) / 86400000L;
            if ((paramLong > 0L) && (paramLong <= 7L))
            {
              if (paramLong == 1L) {
                continue;
              }
              i1 = 2131368843;
            }
          }
          else
          {
            i1 = 2131368844;
            continue;
          }
        }
        i1 = -1;
      }
    }
  }
  
  public static String a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString).format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    jdField_a_of_type_JavaLangStringBuffer.setLength(0);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    int i1 = 0;
    int i3 = a(paramLong);
    if (i3 != -1)
    {
      i2 = 1;
      i1 = i2;
      if (i3 != 2131368833)
      {
        jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(i3));
        i1 = i2;
      }
    }
    int i4 = jdField_a_of_type_JavaUtilCalendar.get(11);
    int i2 = jdField_a_of_type_JavaUtilCalendar.get(12);
    if (i1 != 0) {
      if (i3 == 2131368833) {
        if ((i4 >= 0) && (i4 < 12))
        {
          jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(2131368847));
          jdField_a_of_type_JavaLangStringBuffer.append(' ');
          if (i4 != 12) {
            break label218;
          }
          i1 = 12;
          label136:
          if (i1 < 10) {
            jdField_a_of_type_JavaLangStringBuffer.append('0');
          }
          jdField_a_of_type_JavaLangStringBuffer.append(i1);
          jdField_a_of_type_JavaLangStringBuffer.append(':');
          if (i2 < 10) {
            jdField_a_of_type_JavaLangStringBuffer.append('0');
          }
          jdField_a_of_type_JavaLangStringBuffer.append(i2);
        }
      }
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangStringBuffer.toString();
      jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(2131368848));
      break;
      label218:
      i1 = i4 % 12;
      break label136;
      if (!paramBoolean)
      {
        jdField_a_of_type_JavaLangStringBuffer.append(' ');
        if (i4 < 10) {
          jdField_a_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_a_of_type_JavaLangStringBuffer.append(i4);
        jdField_a_of_type_JavaLangStringBuffer.append(':');
        if (i2 < 10) {
          jdField_a_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_a_of_type_JavaLangStringBuffer.append(i2);
        continue;
        jdField_a_of_type_JavaLangStringBuffer.append(jdField_a_of_type_JavaUtilCalendar.get(1)).append('/').append(jdField_a_of_type_JavaUtilCalendar.get(2) + 1).append('/').append(jdField_a_of_type_JavaUtilCalendar.get(5));
        if (!paramBoolean)
        {
          jdField_a_of_type_JavaLangStringBuffer.append(' ');
          jdField_a_of_type_JavaLangStringBuffer.append(i4);
          jdField_a_of_type_JavaLangStringBuffer.append(':');
          if (i2 < 10) {
            jdField_a_of_type_JavaLangStringBuffer.append('0');
          }
          jdField_a_of_type_JavaLangStringBuffer.append(i2);
        }
      }
    }
  }
  
  public static String a(long paramLong, boolean paramBoolean, String paramString)
  {
    return a(jdField_a_of_type_JavaLangStringBuffer, paramLong, paramBoolean, paramString);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i1 = jdField_a_of_type_JavaUtilCalendar.get(1);
    int i2 = jdField_a_of_type_JavaUtilCalendar.get(2);
    int i3 = jdField_a_of_type_JavaUtilCalendar.get(5);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    i1 = a(i1, i2, i3, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(5));
    if (i1 == 0)
    {
      try
      {
        i1 = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
        if (i1 == 12) {
          if (jdField_a_of_type_JavaUtilCalendar.get(11) < 12)
          {
            i1 = 2131368847;
            return String.format("%s %s", new Object[] { paramContext.getString(i1), new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)) });
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          i1 = 0;
          continue;
          i1 = 2131368848;
        }
      }
      return new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (i1 == 1) {
      return paramContext.getString(2131368834);
    }
    if ((i1 < 7) && (i1 > 1)) {
      return new SimpleDateFormat("E", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return a().format(new Date(paramLong));
  }
  
  public static String a(StringBuffer paramStringBuffer, long paramLong, boolean paramBoolean, String paramString)
  {
    int i1 = 0;
    if (paramStringBuffer != null)
    {
      paramStringBuffer.setLength(0);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      int i3 = b(paramLong, localCalendar);
      if (i3 != -1)
      {
        i2 = 1;
        i1 = i2;
        if (i3 != 2131368833)
        {
          paramStringBuffer.append(BaseApplication.getContext().getString(i3));
          i1 = i2;
        }
      }
      int i4 = localCalendar.get(11);
      int i2 = localCalendar.get(12);
      if (i1 != 0)
      {
        boolean bool = android.text.format.DateFormat.is24HourFormat(BaseApplication.getContext());
        if (i3 == 2131368833) {
          if (!bool) {
            if ((i4 >= 0) && (i4 < 12))
            {
              paramStringBuffer.append(BaseApplication.getContext().getString(2131368847));
              if (i4 != 12) {
                break label203;
              }
              i1 = 12;
              label147:
              paramStringBuffer.append(i1);
              paramStringBuffer.append(':');
              if (i2 < 10) {
                paramStringBuffer.append('0');
              }
              paramStringBuffer.append(i2);
            }
          }
        }
      }
      for (;;)
      {
        return paramStringBuffer.toString();
        paramStringBuffer.append(BaseApplication.getContext().getString(2131368848));
        break;
        label203:
        i1 = i4 % 12;
        break label147;
        paramStringBuffer.append(i4);
        paramStringBuffer.append(':');
        if (i2 < 10) {
          paramStringBuffer.append('0');
        }
        paramStringBuffer.append(i2);
        continue;
        if (!paramBoolean)
        {
          paramStringBuffer.append(' ');
          paramStringBuffer.append(i4);
          paramStringBuffer.append(':');
          if (i2 < 10) {
            paramStringBuffer.append('0');
          }
          paramStringBuffer.append(i2);
          continue;
          String str = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str = "yyyy-MM-dd";
          }
          try
          {
            paramString = new SimpleDateFormat(str);
            paramStringBuffer.append(paramString.format(localCalendar.getTime()));
            if (!paramBoolean)
            {
              paramStringBuffer.append(' ');
              paramStringBuffer.append(i4);
              paramStringBuffer.append(':');
              if (i2 < 10) {
                paramStringBuffer.append('0');
              }
              paramStringBuffer.append(i2);
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString = new SimpleDateFormat("yyyy-MM-dd");
            }
          }
        }
      }
    }
    return null;
  }
  
  private static java.text.DateFormat a()
  {
    try
    {
      if (b == null) {
        b = android.text.format.DateFormat.getDateFormat(BaseApplicationImpl.a().getApplicationContext());
      }
      java.text.DateFormat localDateFormat = b;
      return localDateFormat;
    }
    finally {}
  }
  
  public static void a()
  {
    k = TimeZone.getTimeZone("GMT+8").getRawOffset();
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 != paramInt4) {
      return 5;
    }
    if (paramInt3 == paramInt6) {
      return 1;
    }
    if (paramInt3 == paramInt6 + 1) {
      return 2;
    }
    if (paramInt3 == paramInt6 + 2) {
      return 3;
    }
    return 4;
  }
  
  public static int b(long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i1 = jdField_a_of_type_JavaUtilCalendar.get(1);
    int i2 = jdField_a_of_type_JavaUtilCalendar.get(2);
    int i3 = jdField_a_of_type_JavaUtilCalendar.get(6);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    return b(i1, i2, i3, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6));
  }
  
  public static int b(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = new Time();
    paramCalendar.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime = new Time();
    localTime.set(l1);
    int i1 = localTime.yearDay - 1;
    int i2 = localTime.yearDay;
    if (paramCalendar.year == localTime.year) {
      if (localTime.yearDay >= paramCalendar.yearDay) {}
    }
    do
    {
      do
      {
        do
        {
          return -1;
          if (localTime.yearDay == paramCalendar.yearDay) {
            return 2131368833;
          }
          if (paramCalendar.yearDay == i1) {
            return 2131368834;
          }
        } while ((paramCalendar.yearDay >= i1) || (paramCalendar.yearDay <= i2 - 7));
        switch (paramCalendar.weekDay)
        {
        default: 
          return -1;
        case 0: 
          return 2131368842;
        case 1: 
          return 2131368836;
        case 2: 
          return 2131368837;
        case 3: 
          return 2131368838;
        case 4: 
          return 2131368839;
        case 5: 
          return 2131368840;
        }
        return 2131368841;
      } while (paramCalendar.year + 1 != localTime.year);
      paramLong = (l1 - paramLong + 86400000L - 1L) / 86400000L;
    } while ((paramLong <= 0L) || (paramLong > 7L));
    if (paramLong == 1L) {
      return 2131368834;
    }
    switch (paramCalendar.weekDay)
    {
    default: 
      return -1;
    case 0: 
      return 2131368842;
    case 1: 
      return 2131368836;
    case 2: 
      return 2131368837;
    case 3: 
      return 2131368838;
    case 4: 
      return 2131368839;
    case 5: 
      return 2131368840;
    }
    return 2131368841;
  }
  
  public static CharSequence b(Context paramContext, long paramLong)
  {
    return b().format(new Date(paramLong));
  }
  
  public static String b(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Date localDate = new Date(paramLong);
    localCalendar1.setTime(localDate);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      return "今天";
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) + 1 == localCalendar2.get(6))) {
      return "昨天";
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) > localCalendar2.get(6) - 7)) {
      switch (localCalendar1.get(7))
      {
      }
    }
    while (localCalendar1.get(1) != localCalendar2.get(1))
    {
      return new SimpleDateFormat("yy-MM-dd").format(localDate);
      return "星期日";
      return "星期一";
      return "星期二";
      return "星期三";
      return "星期四";
      return "星期五";
      return "星期六";
    }
    return new SimpleDateFormat("MM-dd").format(localDate);
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i1 = jdField_a_of_type_JavaUtilCalendar.get(1);
    int i2 = jdField_a_of_type_JavaUtilCalendar.get(2);
    int i3 = jdField_a_of_type_JavaUtilCalendar.get(5);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    i1 = a(i1, i2, i3, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(5));
    SimpleDateFormat localSimpleDateFormat2;
    Object localObject;
    if (i1 == 0) {
      try
      {
        i1 = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
        if (i1 == 12) {
          if (jdField_a_of_type_JavaUtilCalendar.get(11) < 12)
          {
            i1 = 2131368847;
            String str = paramContext.getString(i1);
            localSimpleDateFormat2 = new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale);
            return paramContext.getString(2131368833) + " " + String.format("%s %s", new Object[] { str, localSimpleDateFormat2.format(new Date(paramLong)) });
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException1)
      {
        for (;;)
        {
          i1 = 0;
          continue;
          i1 = 2131368848;
        }
        localObject = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
        return paramContext.getString(2131368833) + " " + ((SimpleDateFormat)localObject).format(new Date(paramLong));
      }
    }
    if (i1 == 1) {
      try
      {
        i1 = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
        if (i1 == 12) {
          if (jdField_a_of_type_JavaUtilCalendar.get(11) < 12)
          {
            i1 = 2131368847;
            localObject = paramContext.getString(i1);
            localSimpleDateFormat2 = new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale);
            return paramContext.getString(2131368834) + " " + String.format("%s %s", new Object[] { localObject, localSimpleDateFormat2.format(new Date(paramLong)) });
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException2)
      {
        for (;;)
        {
          i1 = 0;
          continue;
          i1 = 2131368848;
        }
        SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
        return paramContext.getString(2131368834) + " " + localSimpleDateFormat1.format(new Date(paramLong));
      }
    }
    if ((i1 < 7) && (i1 > 1)) {
      return new SimpleDateFormat("E", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("yyyy-MM-dd", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
  }
  
  private static java.text.DateFormat b()
  {
    try
    {
      if (jdField_a_of_type_JavaTextDateFormat == null) {
        jdField_a_of_type_JavaTextDateFormat = android.text.format.DateFormat.getTimeFormat(BaseApplicationImpl.a().getApplicationContext());
      }
      java.text.DateFormat localDateFormat = jdField_a_of_type_JavaTextDateFormat;
      return localDateFormat;
    }
    finally {}
  }
  
  public static String c(long paramLong)
  {
    int i1 = (int)((System.currentTimeMillis() + k) / 86400000L);
    int i2 = (int)((k + paramLong) / 86400000L);
    if (i1 - i2 > 365) {
      return (i1 - i2) / 365 + "年前";
    }
    if (i1 - i2 > 30) {
      return (i1 - i2) / 30 + "月前";
    }
    if (i1 - i2 >= 1) {
      return i1 - i2 + "天前";
    }
    try
    {
      String str = a(paramLong, "HH:mm");
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimeFormatterUtils", 2, localException.getMessage());
      }
    }
    return "";
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i1 = jdField_a_of_type_JavaUtilCalendar.get(1);
    int i2 = jdField_a_of_type_JavaUtilCalendar.get(2);
    int i3 = jdField_a_of_type_JavaUtilCalendar.get(6);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    switch (b(i1, i2, i3, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6)))
    {
    default: 
      return null;
    case 1: 
      return new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    case 2: 
      return String.format("%s %s", new Object[] { "昨天", new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)) });
    case 3: 
      return String.format("%s %s", new Object[] { "前天", new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)) });
    case 4: 
      return new SimpleDateFormat("MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("yyyy-MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
  }
  
  public static String d(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i1 = jdField_a_of_type_JavaUtilCalendar.get(1);
    int i2 = jdField_a_of_type_JavaUtilCalendar.get(2);
    int i3 = jdField_a_of_type_JavaUtilCalendar.get(6);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    switch (b(i1, i2, i3, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6)))
    {
    default: 
      return null;
    case 1: 
      return String.format("%s %s", new Object[] { "今天", new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)) });
    case 2: 
      return String.format("%s %s", new Object[] { "昨天", new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)) });
    case 3: 
      return String.format("%s %s", new Object[] { "前天", new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)) });
    case 4: 
      return new SimpleDateFormat("MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("yyyy-MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\TimeFormatterUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */