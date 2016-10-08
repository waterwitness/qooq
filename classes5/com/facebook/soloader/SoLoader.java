package com.facebook.soloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.bitapp.pre.RNJniLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

@SuppressLint({"BadMethodUse-android.util.Log.v", "BadMethodUse-android.util.Log.d", "BadMethodUse-android.util.Log.i", "BadMethodUse-android.util.Log.w", "BadMethodUse-android.util.Log.e"})
public class SoLoader
{
  static final boolean DEBUG = false;
  static final String TAG = "SoLoader";
  public static List<String> extSoSource = new ArrayList();
  private static final Set<String> sLoadedLibraries = new HashSet();
  @Nullable
  private static SoSource[] sSoSources = null;
  
  private static void assertInitialized()
  {
    if (sSoSources == null) {
      throw new RuntimeException("SoLoader.init() not yet called");
    }
  }
  
  public static void init(@Nullable Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList;
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (sSoSources != null) {
          break label338;
        }
        localArrayList = new ArrayList();
        String str = System.getenv("LD_LIBRARY_PATH");
        localObject = str;
        if (str == null) {
          localObject = "/vendor/lib:/system/lib";
        }
        localObject = ((String)localObject).split(":");
        i = 0;
        if (i < localObject.length)
        {
          localArrayList.add(new RNJniLoader(new File(localObject[i]), 2));
          i += 1;
          continue;
        }
        if (paramContext != null)
        {
          localObject = paramContext.getApplicationInfo();
          if ((((ApplicationInfo)localObject).flags & 0x1) == 0) {
            continue;
          }
          i = ((ApplicationInfo)localObject).flags;
          if ((i & 0x80) != 0) {
            continue;
          }
          i = 1;
          if (!paramBoolean) {
            continue;
          }
        }
        try
        {
          localArrayList.add(0, new ExoSoSource(paramContext));
          i = 0;
        }
        catch (IOException paramContext)
        {
          int j;
          int k;
          throw new RuntimeException(paramContext);
        }
      }
      finally {}
      try
      {
        if (Build.VERSION.SDK_INT <= 17) {
          i = 0x0 | 0x1;
        }
        j = 0;
        k = extSoSource.size();
        if (j >= k) {
          break;
        }
        localArrayList.add(0, new RNJniLoader(new File((String)extSoSource.get(j)), i));
        j += 1;
        continue;
        i = 0;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        sSoSources = (SoSource[])localArrayList.toArray(new SoSource[localArrayList.size()]);
      }
      if (i != 0)
      {
        localArrayList.add(0, new ApkSoSource(paramContext));
      }
      else
      {
        SysUtil.dumbDeleteRecrusive(SysUtil.getLibsDirectory(paramContext));
        i = 0;
        if (Build.VERSION.SDK_INT <= 17) {
          i = 0x0 | 0x1;
        }
        localArrayList.add(0, new RNJniLoader(new File(((ApplicationInfo)localObject).nativeLibraryDir), i));
      }
    }
    label338:
  }
  
  /* Error */
  public static void loadLibrary(String paramString)
    throws UnsatisfiedLinkError
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	com/facebook/soloader/SoLoader:sSoSources	[Lcom/facebook/soloader/SoSource;
    //   6: ifnonnull +19 -> 25
    //   9: ldc -96
    //   11: ldc -94
    //   13: invokestatic 165	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +14 -> 33
    //   22: invokestatic 170	com/facebook/soloader/SoLoader:assertInitialized	()V
    //   25: aload_0
    //   26: invokestatic 173	com/facebook/soloader/SoLoader:loadLibraryDependency	(Ljava/lang/String;)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: invokestatic 175	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   37: goto -8 -> 29
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	25	40	finally
    //   25	29	40	finally
    //   33	37	40	finally
  }
  
  static void loadLibraryBySoName(String paramString, int paramInt)
    throws IOException
  {
    if (sLoadedLibraries.contains(paramString)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      int k = 0;
      j = i;
      i = k;
      while ((j == 0) && (i < sSoSources.length))
      {
        j = sSoSources[i].loadLibrary(paramString, paramInt);
        i += 1;
      }
    }
    if (j == 0) {
      throw new UnsatisfiedLinkError("could find DSO to load: " + paramString);
    }
    if (j == 1) {
      sLoadedLibraries.add(paramString);
    }
  }
  
  private static void loadLibraryDependency(String paramString)
  {
    if ("folly_json".equals(paramString))
    {
      loadLibraryDependency("glog");
      loadLibraryDependency("gnustl_shared");
    }
    for (;;)
    {
      try
      {
        loadLibraryBySoName(System.mapLibraryName(paramString), 0);
        return;
      }
      catch (IOException paramString)
      {
        throw new RuntimeException(paramString);
      }
      if ("jsc".equals(paramString))
      {
        loadLibraryDependency("icu_common");
        loadLibraryDependency("gnustl_shared");
      }
      else if ("fb".equals(paramString))
      {
        loadLibraryDependency("gnustl_shared");
        loadLibraryDependency("log");
      }
      else if ("gifimage".equals(paramString))
      {
        loadLibraryDependency("log");
      }
      else if ("icu_common".equals(paramString))
      {
        loadLibraryDependency("gnustl_shared");
      }
      else if ("fbjni".equals(paramString))
      {
        loadLibraryDependency("fb");
        loadLibraryDependency("gnustl_shared");
        loadLibraryDependency("log");
      }
      else if ("glog".equals(paramString))
      {
        loadLibraryDependency("gnustl_shared");
      }
      else if ("imagepipeline".equals(paramString))
      {
        loadLibraryDependency("log");
      }
      else if ("reactnativejni".equals(paramString))
      {
        loadLibraryDependency("bitmaps");
        loadLibraryDependency("gifimage");
        loadLibraryDependency("imagepipeline");
        loadLibraryDependency("memchunk");
        loadLibraryDependency("icu_common");
        loadLibraryDependency("fb");
        loadLibraryDependency("fbjni");
        loadLibraryDependency("folly_json");
        loadLibraryDependency("jsc");
        loadLibraryDependency("gnustl_shared");
        loadLibraryDependency("log");
      }
    }
  }
  
  public static void setInTestMode()
  {
    sSoSources = new SoSource[] { new NoopSoSource() };
  }
  
  public static File unpackLibraryAndDependencies(String paramString)
    throws UnsatisfiedLinkError
  {
    
    try
    {
      paramString = unpackLibraryBySoName(System.mapLibraryName(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  static File unpackLibraryBySoName(String paramString)
    throws IOException
  {
    int i = 0;
    while (i < sSoSources.length)
    {
      File localFile = sSoSources[i].unpackLibrary(paramString);
      if (localFile != null) {
        return localFile;
      }
      i += 1;
    }
    throw new FileNotFoundException(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\SoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */