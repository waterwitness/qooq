package com.tencent.bitapp.compression;

import com.facebook.common.logging.FLog;

public class CompressionFactory
{
  private static final String TAG = CompressionFactory.class.getSimpleName();
  public static final int TYPE_ZIP = 1;
  
  public static ICompression getCompression(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "Unknow compression type");
      }
      return null;
    }
    return new Zip();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\compression\CompressionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */