package com.tencent.proxyinner.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.utility.UtilMisc;
import java.io.File;

public class LocalPlugin
{
  private static final String TAG = "TXProxy|LocalPlugin";
  private DebugPlugin debugPlugin = new DebugPlugin();
  private String mAppId;
  private Context mContext;
  boolean mNeedConfirm = false;
  public String mPluginName;
  
  private boolean checkExistAPKFile(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString).listFiles();
    boolean bool1 = bool2;
    int i;
    if (paramString != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramString.length) {}
      try
      {
        bool1 = paramString[i].getName().equals(this.mPluginName + ".apk");
        if (bool1)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      i += 1;
    }
  }
  
  private void clearPath(String paramString1, String paramString2)
  {
    Log.i("TXProxy|LocalPlugin", "清除不匹配的版本，rootpath = " + paramString1 + " " + "retainFile =" + paramString2);
    paramString1 = new File(paramString1);
    File[] arrayOfFile = paramString1.listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < arrayOfFile.length) {
          try
          {
            str = arrayOfFile[i].getName();
            if (!str.equalsIgnoreCase(paramString2))
            {
              if ((isNeedConfirm(Integer.parseInt(str))) && (!new File(paramString1 + File.separator + str + "/complete.data").exists()))
              {
                XLog.i("TXProxy|LocalPlugin", "插件版本 + " + str + "还没有完成标识，先不清除");
                return;
              }
              deleteFoler(arrayOfFile[i]);
            }
          }
          catch (Exception localException1)
          {
            try
            {
              String str;
              setPreinstalledPlugin(Integer.parseInt(str), "");
              for (;;)
              {
                i += 1;
                break;
                localException1 = localException1;
              }
            }
            catch (Exception localException2)
            {
              for (;;) {}
            }
          }
        }
      }
    }
  }
  
  private void deleteFoler(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        deleteFoler(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private boolean isFileExist(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.isFile());
  }
  
  private boolean isNeedConfirm(int paramInt)
  {
    return this.mContext.getSharedPreferences(String.valueOf(paramInt), 0).getBoolean("needconfirm", false);
  }
  
  public void clearAllExpiredSdkVersion()
  {
    clearPath(getSdkPath(), "3");
    if (this.mAppId.equals("Hy"))
    {
      clearPath(getSdkPath() + "/" + 3, "" + getMaxConfirmedVersion());
      return;
    }
    clearPath(getSdkPath() + "/" + 3, "" + getMaxSdkVersion());
  }
  
  public void clearAllSdkVersion()
  {
    clearPath(getSdkPath(), "");
    clearPath(getSdkPath() + "/" + 3, "");
  }
  
  public void createFolder(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory())) {
      deleteFoler(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdir();
    }
  }
  
  public int getMaxConfirmedVersion()
  {
    String str1 = getSdkPathForCurrentProxy();
    createFolder(getSdkPath());
    createFolder(str1);
    int j = 0;
    int i = 0;
    File[] arrayOfFile = new File(str1).listFiles();
    if (arrayOfFile != null)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= arrayOfFile.length) {
          break;
        }
        try
        {
          String str2 = arrayOfFile[k].getName();
          m = i;
          if (!isPluginIsConfirmed(str1 + "/" + str2, Integer.parseInt(str2))) {
            break label121;
          }
          j = Integer.parseInt(str2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            j = 0;
          }
        }
        m = i;
        if (j > i) {
          m = j;
        }
        label121:
        k += 1;
        i = m;
      }
    }
    return j;
  }
  
  public int getMaxSdkVersion()
  {
    String str1 = getSdkPathForCurrentProxy();
    createFolder(getSdkPath());
    createFolder(str1);
    int j = 0;
    int i = 0;
    File[] arrayOfFile = new File(str1).listFiles();
    if (arrayOfFile != null)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= arrayOfFile.length) {
          break;
        }
        try
        {
          String str2 = arrayOfFile[k].getName();
          m = i;
          if (!checkExistAPKFile(str1 + "/" + str2)) {
            break label155;
          }
          m = i;
          if (!isPluginIsConfirmed(str1 + "/" + str2, Integer.parseInt(str2))) {
            break label155;
          }
          j = Integer.parseInt(str2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            j = 0;
          }
        }
        m = i;
        if (j > i) {
          m = j;
        }
        label155:
        k += 1;
        i = m;
      }
    }
    return j;
  }
  
  public String getMaxSdkVersionPathWithoutConfirm()
  {
    return getSdkPath() + "/" + 3 + "/" + getMaxSdkVersionWithoutConfirm();
  }
  
  public int getMaxSdkVersionWithoutConfirm()
  {
    String str1 = getSdkPathForCurrentProxy();
    createFolder(getSdkPath());
    createFolder(str1);
    int i = 0;
    int j = 0;
    File[] arrayOfFile = new File(str1).listFiles();
    if (arrayOfFile != null)
    {
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= arrayOfFile.length) {
          break;
        }
        i = 0;
        try
        {
          String str2 = arrayOfFile[k].getName();
          if (isFileExist(str1 + "/" + str2 + "/" + this.mPluginName + ".apk")) {
            i = Integer.parseInt(str2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            i = 0;
          }
        }
        m = j;
        if (i > j) {
          m = i;
        }
        k += 1;
        j = m;
      }
    }
    return i;
  }
  
  public String getMaxVersionPath()
  {
    return getPluginPath();
  }
  
  public String getPackageName()
  {
    return "";
  }
  
  public String getPath()
  {
    String str = this.debugPlugin.getPath();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return getPluginPath();
  }
  
  public String getPathWithoutConfirm()
  {
    String str = this.debugPlugin.getPath();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return getPluginPath();
  }
  
  public String getPluginOptDexDir()
  {
    String str = this.mContext.getDir("SixGodPlugin", 0).getAbsolutePath() + File.separator;
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public String getPluginPath()
  {
    int i = getMaxSdkVersion();
    Object localObject;
    if (i == 0) {
      localObject = "";
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return (String)localObject;
        localObject = getSdkPath() + "/" + 3;
        str2 = (String)localObject + "/" + i;
        str1 = str2 + "/" + this.mPluginName + ".apk";
        localObject = str1;
      } while (!this.mNeedConfirm);
      localObject = str1;
    } while (isPluginIsConfirmed(str2, i));
    return "";
  }
  
  public String getPluginPathWihoutConfirm()
  {
    int i = getMaxSdkVersionWithoutConfirm();
    if (i == 0) {
      return "";
    }
    String str = getSdkPath() + "/" + 3;
    str = str + "/" + i;
    return str + "/" + this.mPluginName + ".apk";
  }
  
  public String getPreInstalledPlugin(int paramInt)
  {
    String str = this.mContext.getSharedPreferences(String.valueOf(paramInt), 0).getString("preinstall", "");
    XLog.d("TXProxy|LocalPlugin", "getPreInstalledPlugin version = " + paramInt + "path = " + str);
    return str;
  }
  
  public String getSdkPath()
  {
    String str2 = this.mAppId;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "pluginsdk";
    }
    return this.mContext.getDir(str1, 0).getAbsolutePath();
  }
  
  public String getSdkPathForCurrentProxy()
  {
    File localFile = new File(getSdkPath() + "/" + 3);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return getSdkPath() + "/" + 3;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2)
  {
    XLog.i("TXProxy|LocalPlugin", "localPlugin init");
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.mPluginName = paramString2;
    if (UtilMisc.isTestEnv(this.mAppId)) {
      this.debugPlugin.init(paramContext);
    }
    paramContext = paramContext.getSharedPreferences("Proxy", 0);
    int i = paramContext.getInt("Version", 0);
    if ((i != 3) && (i > 0))
    {
      if (UtilMisc.isTestEnv(this.mAppId)) {
        Log.i("TXProxy|LocalPlugin", "监测到覆盖安装了，且版本号修改，清掉本地安装的插件");
      }
      paramContext = paramContext.edit();
      paramContext.putInt("Version", 3);
      paramContext.commit();
    }
  }
  
  public boolean isExistDebugPlugin()
  {
    return !TextUtils.isEmpty(this.debugPlugin.getPath());
  }
  
  public boolean isExistInstallPlugin()
  {
    return getMaxSdkVersion() != 0;
  }
  
  public boolean isExistLocalPlugin()
  {
    return (getPath() != null) && (!TextUtils.isEmpty(getPath()));
  }
  
  public boolean isPluginIsConfirmed(String paramString, int paramInt)
  {
    if (!isNeedConfirm(paramInt)) {}
    while (new File(paramString + File.separator + "complete.data").exists()) {
      return true;
    }
    return false;
  }
  
  public void setNeedConfirm(boolean paramBoolean, int paramInt)
  {
    Log.i("TXProxy|LocalPlugin", "setNeedConfirm version = " + paramInt);
    SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences(String.valueOf(paramInt), 0).edit();
    localEditor.putBoolean("needconfirm", paramBoolean);
    localEditor.commit();
  }
  
  public void setPreinstalledPlugin(int paramInt, String paramString)
  {
    if (isPluginIsConfirmed(paramString, paramInt))
    {
      Object localObject = this.mContext.getSharedPreferences(String.valueOf(paramInt), 0);
      String str = ((SharedPreferences)localObject).getString("preinstall", "");
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString)))
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("preinstall", paramString);
        XLog.d("TXProxy|LocalPlugin", "setPreinstalledPlugin version = " + paramInt + "path = " + paramString);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\LocalPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */