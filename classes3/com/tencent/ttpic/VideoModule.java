package com.tencent.ttpic;

import android.content.Context;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;

public class VideoModule
{
  public static int getVersionCode()
  {
    return 400;
  }
  
  public static void init(Context paramContext)
  {
    VideoGlobalContext.setContext(paramContext);
    VideoPrefsUtil.init(paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\VideoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */