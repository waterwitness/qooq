package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nullable;

@DoNotStrip
public class ReactMarker
{
  @Nullable
  private static MarkerListener sMarkerListener = null;
  
  @DoNotStrip
  public static void logMarker(String paramString)
  {
    if (sMarkerListener != null) {
      sMarkerListener.logMarker(paramString);
    }
  }
  
  public static void setMarkerListener(MarkerListener paramMarkerListener)
  {
    sMarkerListener = paramMarkerListener;
  }
  
  public static abstract interface MarkerListener
  {
    public abstract void logMarker(String paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\ReactMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */