package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class SearchStrategy
{
  public static int a;
  public static long a;
  public static Integer[] a;
  public static int b;
  public static Integer[] b;
  public static int c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 9999;
    jdField_b_of_type_Int = Integer.MAX_VALUE;
    c = 3000;
    jdField_a_of_type_Long = 863913600L;
    jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3000) };
    jdField_b_of_type_ArrayOfJavaLangInteger = new Integer[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(3) };
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = jdField_a_of_type_ArrayOfJavaLangInteger;
    int j = arrayOfInteger.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInteger[i].intValue() == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (NetConnInfoCenter.getServerTime() - paramRecentUser.lastmsgtime >= jdField_a_of_type_Long) {}
    while ((!a(paramRecentUser.type)) || ((paramRecentUser.type == 1) && (!b(paramQQAppInterface.b(paramRecentUser.uin))))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = jdField_b_of_type_ArrayOfJavaLangInteger;
    int j = arrayOfInteger.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInteger[i].intValue() == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\fms\SearchStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */