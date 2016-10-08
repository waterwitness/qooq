package com.tencent.proxyinner.utility;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class UtilMisc
{
  static final String TAG = "XProxy|UtilMisc";
  private static boolean isCheckEnv;
  private static boolean isCheckTargetSdkVersion = false;
  private static boolean isTestEnv;
  public static String sPluginId = "";
  private static int targetSdkVersion = 0;
  
  static
  {
    isCheckEnv = false;
    isTestEnv = false;
  }
  
  public static int getTargetSdkVersion()
  {
    if (!isCheckTargetSdkVersion) {
      isCheckTargetSdkVersion = true;
    }
    return targetSdkVersion;
  }
  
  public static String getTestFilePath()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + sPluginId + "/xproxy.test";
  }
  
  public static String getTestPluginPath()
  {
    Object localObject2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + sPluginId + "/xproxy.test");
    if ((localObject2 == null) || (!((File)localObject2).exists())) {
      return null;
    }
    String str1 = " ";
    Object localObject1 = str1;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream((File)localObject2);
      localObject2 = str1;
      if (localFileInputStream != null)
      {
        localObject1 = str1;
        localObject2 = new BufferedReader(new InputStreamReader(localFileInputStream));
        for (;;)
        {
          localObject1 = str1;
          String str2 = ((BufferedReader)localObject2).readLine();
          if (str2 == null) {
            break;
          }
          localObject1 = str1;
          str1 = str1 + str2;
        }
        localObject1 = str1;
        localFileInputStream.close();
        localObject2 = str1;
      }
      localObject1 = localObject2;
      str1 = ((String)localObject2).trim();
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return (String)localObject1;
  }
  
  public static boolean isTestEnv(String paramString)
  {
    boolean bool2 = true;
    if (!isCheckEnv)
    {
      isCheckEnv = true;
      Object localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + paramString + "/xproxy.test";
      Object localObject1 = "/storage/emulated/0/" + paramString + "/xproxy.test";
      paramString = "/sdcard/" + paramString + "/xproxy.test";
      localObject2 = new File((String)localObject2);
      localObject1 = new File((String)localObject1);
      paramString = new File(paramString);
      bool1 = bool2;
      if (!((File)localObject2).exists())
      {
        bool1 = bool2;
        if (!((File)localObject1).exists()) {
          if (!paramString.exists()) {
            break label162;
          }
        }
      }
    }
    label162:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isTestEnv = bool1;
      return isTestEnv;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\utility\UtilMisc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */