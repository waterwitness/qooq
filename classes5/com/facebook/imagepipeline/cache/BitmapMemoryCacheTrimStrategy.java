package com.facebook.imagepipeline.cache;

import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;

public class BitmapMemoryCacheTrimStrategy
  implements CountingMemoryCache.CacheTrimStrategy
{
  private static final String TAG = "BitmapMemoryCacheTrimStrategy";
  
  public double getTrimRatio(MemoryTrimType paramMemoryTrimType)
  {
    switch (paramMemoryTrimType)
    {
    default: 
      FLog.wtf("BitmapMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[] { paramMemoryTrimType });
    case OnAppBackgrounded: 
      do
      {
        return 0.0D;
      } while (Build.VERSION.SDK_INT < 21);
      return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
    }
    return 1.0D;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\BitmapMemoryCacheTrimStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */