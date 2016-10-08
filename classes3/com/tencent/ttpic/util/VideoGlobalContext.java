package com.tencent.ttpic.util;

import android.content.Context;

public class VideoGlobalContext
{
  private static Context sContext;
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static void setContext(Context paramContext)
  {
    sContext = paramContext;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoGlobalContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */