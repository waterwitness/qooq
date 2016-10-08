package com.tencent.map.swlocation.api;

import android.content.Context;
import android.os.Handler;
import st.p;
import st.s;

public class SwEngine
{
  public static void creatLocationEngine(Context paramContext, p paramp)
  {
    s.a(paramContext, paramp);
  }
  
  public static void onDestroy() {}
  
  public static void setQQ(String paramString)
  {
    s.a(paramString);
  }
  
  public static void startContinousLocationUpdate(Handler paramHandler, int paramInt1, int paramInt2, LocationUpdateListener paramLocationUpdateListener, ServerMessageListener paramServerMessageListener)
  {
    s.a(paramHandler, paramInt2, paramLocationUpdateListener, paramServerMessageListener);
  }
  
  public static void stopContinousLocationUpdate() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\map\swlocation\api\SwEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */