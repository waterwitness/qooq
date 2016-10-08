package com.tencent.mobileqq.voicechange;

import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class VoiceTuneUtil
{
  public static final int a = ListenChangeVoicePanel.a.length;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    String str = paramString.substring(0, paramString.lastIndexOf(".")).concat(".pcm");
    new File(paramString).renameTo(new File(str));
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(".");
    return paramString.substring(0, i).concat("_" + paramInt).concat(paramString.substring(i, paramString.length()));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    while (i < a)
    {
      new File(a(paramString1, i)).delete();
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = null;
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    paramString2 = str;
    if (i < a)
    {
      str = a(paramString1, i);
      if (i == paramInt) {
        paramString2 = str;
      }
      for (;;)
      {
        i += 1;
        break;
        new File(str).delete();
      }
    }
    if (paramString2 != null) {
      new File(paramString2).renameTo(new File(paramString1));
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    new File(paramString1).deleteOnExit();
    new File(paramString2).deleteOnExit();
    int i = 0;
    while (i < a)
    {
      new File(a(paramString1, i)).deleteOnExit();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\voicechange\VoiceTuneUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */