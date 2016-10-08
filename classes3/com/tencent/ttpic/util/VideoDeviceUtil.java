package com.tencent.ttpic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLES20;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class VideoDeviceUtil
{
  public static final int MIN_STORAGE_SIZE = 52428800;
  private static final String TAG = VideoDeviceUtil.class.getSimpleName();
  
  @TargetApi(18)
  public static long getAvailableSize(StatFs paramStatFs)
  {
    if (VideoUtil.hasJellyBeanMR2()) {
      return paramStatFs.getAvailableBytes();
    }
    return paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize();
  }
  
  private static File getExternalFilesDir(Context paramContext)
  {
    File localFile2 = paramContext.getExternalFilesDir(null);
    File localFile1 = localFile2;
    if (localFile2 == null)
    {
      paramContext = "/Android/data/" + paramContext.getPackageName() + "/files/";
      localFile1 = new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
    }
    return localFile1;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isExternalStorageAvailable())
    {
      localObject1 = localObject2;
      if (isExternalStorageSpaceEnough(52428800L)) {
        localObject1 = getExternalFilesDir(paramContext).getPath();
      }
    }
    paramContext = new File((String)localObject1 + File.separator + paramString);
    try
    {
      if ((paramContext.exists()) && (paramContext.isFile())) {
        paramContext.delete();
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext;
    }
    catch (Exception paramString) {}
    return paramContext;
  }
  
  public static String getGPUInfo()
  {
    String str1 = GLES20.glGetString(7937);
    String str2 = GLES20.glGetString(7936);
    String str3 = GLES20.glGetString(7938);
    return str1 + "; " + str2 + "; " + str3;
  }
  
  public static long getHeapAllocatedSizeInKb()
  {
    return getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
  }
  
  private static long getRuntimeFreeMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().freeMemory();
    case 0: 
      return Runtime.getRuntime().freeMemory();
    case 1: 
      return Runtime.getRuntime().freeMemory() / 1024L;
    }
    return Runtime.getRuntime().freeMemory() / 1024L / 1024L;
  }
  
  public static long getRuntimeRemainSize(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory() - getHeapAllocatedSizeInKb() * 1024L;
    switch (paramInt)
    {
    case 0: 
    default: 
      return l;
    case 1: 
      return l / 1024L;
    }
    return l / 1048576L;
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().totalMemory();
    case 0: 
      return Runtime.getRuntime().totalMemory();
    case 1: 
      return Runtime.getRuntime().totalMemory() / 1024L;
    }
    return Runtime.getRuntime().totalMemory() / 1024L / 1024L;
  }
  
  public static boolean isExternalStorageAvailable()
  {
    boolean bool = false;
    if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable())) {}
    try
    {
      new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      bool = true;
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isExternalStorageSpaceEnough(long paramLong)
  {
    return getAvailableSize(new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())) > paramLong;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = paramContext.getActiveNetworkInfo();
    } while ((paramContext == null) || (!paramContext.isConnectedOrConnecting()));
    return true;
  }
  
  public static class MEMORY_CLASS
  {
    public static final int IN_B = 0;
    public static final int IN_KB = 1;
    public static final int IN_MB = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoDeviceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */