package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class TbsHandlerThread
  extends HandlerThread
{
  private static final String THREAD_NAME = "TbsHandlerThread";
  private static TbsHandlerThread mHandlerThread;
  
  public TbsHandlerThread(String paramString)
  {
    super(paramString);
  }
  
  public static TbsHandlerThread getInstance()
  {
    try
    {
      if (mHandlerThread == null)
      {
        mHandlerThread = new TbsHandlerThread("TbsHandlerThread");
        mHandlerThread.start();
      }
      TbsHandlerThread localTbsHandlerThread = mHandlerThread;
      return localTbsHandlerThread;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsHandlerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */