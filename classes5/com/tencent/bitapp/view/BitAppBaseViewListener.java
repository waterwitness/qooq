package com.tencent.bitapp.view;

import com.facebook.common.logging.FLog;

public class BitAppBaseViewListener
  implements IBitAppBaseViewListener
{
  private static final String TAG = BitAppBaseViewListener.class.getSimpleName();
  
  public void onInvalidViewClick()
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onInvalidViewClick");
    }
  }
  
  public void onLoadFail(String paramString, int paramInt)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadFail key: " + paramString + " | errorCode: " + paramInt);
    }
  }
  
  public void onLoadSuccess(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadSuccess key: " + paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\view\BitAppBaseViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */