package com.tencent.open.base;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BspatchUtil
{
  protected static final String a;
  protected static boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BspatchUtil.class.getName();
    try
    {
      System.loadLibrary("bspatch");
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtility.e(jdField_a_of_type_JavaLangString, "load bspatch error : " + localThrowable.toString());
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "srcFile = " + paramString1 + "\n" + "patchFile = " + paramString2 + "\n" + "dstFile = " + paramString3 + "\n" + "isSupport = " + String.valueOf(jdField_a_of_type_Boolean));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (!jdField_a_of_type_Boolean)) {
      return false;
    }
    try
    {
      boolean bool = bspatch(paramString1, paramString3, paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      LogUtility.e(jdField_a_of_type_JavaLangString, "patch error : " + paramString1.toString());
    }
    return false;
  }
  
  protected static native boolean bspatch(String paramString1, String paramString2, String paramString3);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\BspatchUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */