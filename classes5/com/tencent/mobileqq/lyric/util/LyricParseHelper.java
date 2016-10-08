package com.tencent.mobileqq.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Lyric;
import java.util.ArrayList;

public class LyricParseHelper
{
  private static final String a = "LyricParseHelper";
  
  public LyricParseHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Lyric a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() >= 0))
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          paramString = new ParsingQrc(paramString).a();
          if ((paramString == null) || (paramString.a.size() <= 0)) {
            break;
          }
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.e("LyricParseHelper", "parse exception:", paramString);
        }
        paramString = new ParsingLrc(paramString).a(false);
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\util\LyricParseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */