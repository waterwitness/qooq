package com.facebook.stetho.inspector.console;

import com.facebook.stetho.inspector.helper.ChromePeerManager;
import javax.annotation.Nullable;

public class ConsolePeerManager
  extends ChromePeerManager
{
  private static ConsolePeerManager sInstance;
  
  @Nullable
  public static ConsolePeerManager getInstanceOrNull()
  {
    try
    {
      ConsolePeerManager localConsolePeerManager = sInstance;
      return localConsolePeerManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static ConsolePeerManager getOrCreateInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new ConsolePeerManager();
      }
      ConsolePeerManager localConsolePeerManager = sInstance;
      return localConsolePeerManager;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\console\ConsolePeerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */