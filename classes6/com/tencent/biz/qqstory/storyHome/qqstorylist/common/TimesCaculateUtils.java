package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Calendar;

public class TimesCaculateUtils
{
  public TimesCaculateUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "刚刚";
    case 0: 
      return "年";
    case 1: 
      return "月";
    case 2: 
      return "天";
    case 3: 
      return "小时";
    case 4: 
      return "分钟";
    }
    return "秒";
  }
  
  public static String a(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong1 = paramLong2 - paramLong1;
    if (paramLong1 < 60000L) {
      return "刚刚";
    }
    int i;
    if (paramLong1 < 3600000L)
    {
      i = (int)(paramLong1 / 60000L);
      return new StringBuilder().append(i).append(a(4)).toString() + "前";
    }
    if (paramLong1 < 86400000L)
    {
      i = (int)(paramLong1 / 3600000L);
      return new StringBuilder().append(i).append(a(3)).toString() + "前";
    }
    return "已过期";
  }
  
  public static int[] a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return new int[] { localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), localCalendar.get(11), localCalendar.get(12), localCalendar.get(13) };
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\common\TimesCaculateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */