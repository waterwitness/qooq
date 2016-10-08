package com.tencent.mobileqq.highway.utils;

import com.tencent.qphone.base.util.QLog;

public class BdhLogUtil
{
  public static final String Tag = "BDH_LOG";
  
  public static void LogEvent(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, paramString1 + ". " + paramString2);
    }
  }
  
  public static void LogException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BDH_LOG", 2, paramString1 + ". " + paramString2, paramThrowable);
    }
  }
  
  public static abstract interface LogTag
  {
    public static final String Tag_Conn = "C";
    public static final String Tag_Engine = "E";
    public static final String Tag_Net = "N";
    public static final String Tag_Probe = "P";
    public static final String Tag_Req = "R";
    public static final String Tag_Trans = "T";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\utils\BdhLogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */