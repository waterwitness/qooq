package com.tencent.bitapp.pre.binder.client;

public class Java2jniClientFactory
{
  static IJava2jniClient INSTANCE = null;
  static Boolean mIsSoStandAlone = null;
  
  public static void destory()
  {
    INSTANCE = null;
  }
  
  public static IJava2jniClient getJava2jniClient()
  {
    if (INSTANCE == null) {
      if (!isSoStandAlone()) {
        break label26;
      }
    }
    label26:
    for (INSTANCE = new Java2jniClient();; INSTANCE = new Java2jniClientSameProcess()) {
      return INSTANCE;
    }
  }
  
  public static boolean isCreated()
  {
    return INSTANCE != null;
  }
  
  public static boolean isSoStandAlone()
  {
    if (mIsSoStandAlone == null) {
      return true;
    }
    return mIsSoStandAlone.booleanValue();
  }
  
  public static void setSoStandAlone(boolean paramBoolean)
  {
    if (mIsSoStandAlone == null) {
      mIsSoStandAlone = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\client\Java2jniClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */