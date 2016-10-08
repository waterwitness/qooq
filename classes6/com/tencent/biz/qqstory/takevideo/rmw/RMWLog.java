package com.tencent.biz.qqstory.takevideo.rmw;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RMWLog
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qqstory.record.RMW.";
  private static final boolean jdField_a_of_type_Boolean = true;
  
  public RMWLog()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    return "Q.qqstory.record.RMW." + paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SLog.a(a(paramString1), paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    SLog.a(a(paramString1), String.format(paramString2, paramVarArgs));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    SLog.b(a(paramString1), paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    SLog.b(a(paramString1), String.format(paramString2, paramVarArgs));
  }
  
  public static void c(String paramString1, String paramString2)
  {
    SLog.c(a(paramString1), paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    SLog.c(a(paramString1), String.format(paramString2, paramVarArgs));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */