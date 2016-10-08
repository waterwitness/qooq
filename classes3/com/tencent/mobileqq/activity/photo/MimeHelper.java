package com.tencent.mobileqq.activity.photo;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class MimeHelper
{
  public static final String a = "image";
  public static final String b = "image/jpeg";
  public static final String c = "image/gif";
  public static final String d = "image/bmp";
  public static final String e = "image/png";
  public static final String f = "*/*";
  public static final String g = "jpg";
  public static final String h = "jpeg";
  public static final String i = "gif";
  public static final String j = "bmp";
  public static final String k = "bitmap";
  public static final String l = "png";
  public static final String m = "video";
  public static final String n = "video/mp4";
  public static final String o = "mobileqq";
  public static final String p = "mobileqq/camera";
  private static final String q = "MimeHelper";
  
  public MimeHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(String paramString)
  {
    if (("jpg".equals(paramString)) || ("gif".equals(paramString)) || ("png".equals(paramString)) || ("jpeg".equals(paramString))) {}
    while ((paramString.lastIndexOf("bmp") != -1) || (paramString.lastIndexOf("bitmap") != -1)) {
      return true;
    }
    return false;
  }
  
  public static String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramString.split("/");
      if (arrayOfString.length == 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MimeHelper", 2, "Mimetype error:" + paramString);
    return null;
    return arrayOfString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\MimeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */