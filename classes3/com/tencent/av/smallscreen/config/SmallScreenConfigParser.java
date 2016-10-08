package com.tencent.av.smallscreen.config;

import com.tencent.av.config.ConfigBaseParser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenConfigParser
  extends ConfigBaseParser
{
  public static final String a = "SmallScreenConfigParser";
  public static final String b = "sharp/small_window/";
  public static final String c = "version";
  public static final String d = "close_flag";
  public static final String e = "use_textureview";
  public static final String f = "close_video";
  public static final String g = "close_audio";
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public int a;
  public int b;
  public int c = -1;
  public int d;
  public int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    i = "sharp/small_window/" + "close_flag";
    h = "sharp/small_window/" + "version";
    j = "sharp/small_window/" + "use_textureview";
    k = "sharp/small_window/" + "close_video";
    l = "sharp/small_window/" + "close_audio";
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenConfigParser", 2, " SmallScreenConfigParser --> key_open_flag = " + i + " , key_version = " + h + " , key_textureview = " + j + " , key_close_video_flag = " + k + " , key_close_audio_flag = " + l);
    }
  }
  
  public SmallScreenConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public boolean a()
  {
    try
    {
      this.a = a(h, 0);
      this.b = a(i, 0);
      this.c = a(j, -1);
      this.d = a(k, 0);
      this.e = a(l, 0);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenConfigParser", 2, "value_version = " + this.a + " , value_close_flag = " + this.b + " , value_use_textureview = " + this.c + " ,value_close_video = " + this.d + " , value_close_audio = " + this.e);
      }
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenConfigParser", 2, "parseConfig --> Error");
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\config\SmallScreenConfigParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */