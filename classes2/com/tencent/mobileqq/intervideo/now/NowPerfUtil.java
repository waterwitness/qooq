package com.tencent.mobileqq.intervideo.now;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import svx;
import svy;

public class NowPerfUtil
{
  static long jdField_a_of_type_Long;
  static List jdField_a_of_type_JavaUtilList = new ArrayList();
  static boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilList.clear();
      jdField_a_of_type_JavaUtilList.add(new svy(paramString, jdField_a_of_type_Long));
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      long l = 0L;
      String str = "";
      int i = 0;
      if (i < jdField_a_of_type_JavaUtilList.size())
      {
        svy localsvy = (svy)jdField_a_of_type_JavaUtilList.get(i);
        if (i == 0)
        {
          QLog.i("NowPerf", 2, ">>>" + localsvy.jdField_a_of_type_JavaLangString);
          str = ">>>" + localsvy.jdField_a_of_type_JavaLangString + "time = " + localsvy.jdField_a_of_type_Long + "\r\n";
        }
        for (l = jdField_a_of_type_Long;; l = localsvy.jdField_a_of_type_Long)
        {
          i += 1;
          break;
          str = str + " time=" + (localsvy.jdField_a_of_type_Long - jdField_a_of_type_Long) + ",timeSpan=" + (localsvy.jdField_a_of_type_Long - l) + ",step=" + localsvy.jdField_a_of_type_JavaLangString + "timestamp = " + localsvy.jdField_a_of_type_Long + "\r\n";
        }
      }
      ThreadManager.c(new svx(str));
    }
  }
  
  public static void b(String paramString)
  {
    if ((!jdField_a_of_type_Boolean) || (jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    long l = System.currentTimeMillis();
    jdField_a_of_type_JavaUtilList.add(new svy(paramString, l));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\NowPerfUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */