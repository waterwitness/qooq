package com.tencent.proxyinner.plugin.Downloader;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.LocalPlugin;
import com.tencent.proxyinner.utility.UtilMisc;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class PluginChecker
{
  private static final String CONFIGURL_DEFAULT = "http://tiantian.qq.com/cgi-bin/hylove/version?platform=2&apptype=";
  private static final String CONFIGURL_HY = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=hy&platform=2";
  private static final String CONFIGURL_LIVE = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=now&platform=2";
  private static final String CONFIGURL_OD = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=od&platform=2";
  public static final int CS_CHECKED = 2;
  public static final int CS_CHECKING = 1;
  public static final int CS_NO_CHECK = 0;
  private static final String TAG = "ODSDK | PluginChecker";
  String mAppId;
  Event mEvent = null;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool = false;
      Object localObject;
      if (PluginChecker.this.mEvent != null)
      {
        localObject = PluginChecker.this;
        if (paramAnonymousMessage.arg1 != 1) {
          break label73;
        }
      }
      label73:
      for (int i = 2;; i = 0)
      {
        ((PluginChecker)localObject).mStatus = i;
        paramAnonymousMessage.getData();
        localObject = PluginChecker.this.mEvent;
        if (paramAnonymousMessage.arg1 == 1) {
          bool = true;
        }
        ((PluginChecker.Event)localObject).onCheckCompleted(bool, PluginChecker.this.mUpdateParam);
        return;
      }
    }
  };
  String mJson = "";
  String mLastError;
  String mLastHeadInfo;
  int mLastHttpResponseCode;
  long mLastUpdateTime = 0L;
  String mReqUrl;
  int mStatus = 0;
  String mUin;
  UpdateParam mUpdateParam = new UpdateParam();
  LocalPlugin pluginMgr;
  
  public PluginChecker(LocalPlugin paramLocalPlugin)
  {
    this.pluginMgr = paramLocalPlugin;
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
  
  private String downloadBuffer(String paramString)
  {
    XLog.i("ODSDK | PluginChecker", "开始访问check cgi url= " + paramString);
    localObject3 = null;
    for (Object localObject1 = null;; localObject2 = new InputStreamReader(((URLConnection)localObject3).getInputStream()))
    {
      try
      {
        localObject4 = new URL(paramString);
        paramString = (String)localObject1;
        try
        {
          XLog.i("ODSDK | PluginChecker", " new URL 结束");
          paramString = (String)localObject1;
          localObject3 = ((URL)localObject4).openConnection();
          paramString = (String)localObject3;
          XLog.i("ODSDK | PluginChecker", "openConnection结束");
          paramString = (String)localObject3;
          ((URLConnection)localObject3).setUseCaches(false);
          paramString = (String)localObject3;
          ((URLConnection)localObject3).setRequestProperty("Accept-Encoding", "identity");
          paramString = (String)localObject3;
          XLog.i("ODSDK | PluginChecker", "getInputStream结束");
          paramString = (String)localObject3;
          localObject1 = (HttpURLConnection)localObject3;
          if (localObject1 != null)
          {
            paramString = (String)localObject3;
            this.mLastHttpResponseCode = ((HttpURLConnection)localObject1).getResponseCode();
          }
          paramString = (String)localObject3;
          XLog.i("ODSDK | PluginChecker", "getResponseCode结束");
          paramString = (String)localObject3;
          ((URLConnection)localObject3).getContentEncoding();
          paramString = (String)localObject3;
          if (!"gzip".equals(((URLConnection)localObject3).getContentEncoding())) {
            break label315;
          }
          paramString = (String)localObject3;
          localObject1 = new InputStreamReader(new GZIPInputStream(((URLConnection)localObject3).getInputStream()));
          paramString = (String)localObject3;
          localObject1 = new BufferedReader((Reader)localObject1);
          paramString = (String)localObject3;
          localObject4 = new StringBuilder();
          for (;;)
          {
            paramString = (String)localObject3;
            String str = ((BufferedReader)localObject1).readLine();
            if (str == null) {
              break;
            }
            paramString = (String)localObject3;
            ((StringBuilder)localObject4).append(str);
          }
          if (paramString == null) {
            break label350;
          }
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject4;
          label315:
          Object localObject2;
          paramString = (String)localObject3;
        }
      }
      localObject3 = paramString.getHeaderFields();
      XLog.i("ODSDK | PluginChecker", "getHeaderFields结束");
      paramString = new StringBuilder();
      if (localObject3 == null) {
        break label342;
      }
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (localObject4 != null) {
          paramString.append(((Map.Entry)localObject4).getValue() + " ");
        }
      }
      paramString = (String)localObject3;
    }
    paramString = (String)localObject3;
    localObject2 = ((StringBuilder)localObject4).toString();
    return (String)localObject2;
    label342:
    this.mLastHeadInfo = paramString.toString();
    label350:
    this.mLastError = ((Exception)localObject2).toString();
    ((Exception)localObject2).printStackTrace();
    XLog.i("ODSDK | PluginChecker", "check Exception e = " + ((Exception)localObject2).toString());
    return "";
  }
  
  private String getConfigUrl()
  {
    int j = this.pluginMgr.getMaxSdkVersionWithoutConfirm();
    Object localObject;
    if (this.mAppId.equals("Live"))
    {
      localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=now&platform=2";
      if (!UtilMisc.isTestEnv(this.mAppId)) {
        break label242;
      }
    }
    label242:
    for (int i = 1;; i = 0)
    {
      if (this.mAppId.equals("Hy")) {
        i = 1;
      }
      String str = (String)localObject + "&mode=" + i + "&frameversion=" + 3 + "&cursdkversion=" + j + "&uin=" + this.mUin;
      localObject = str;
      if (UtilMisc.getTargetSdkVersion() != 0) {
        localObject = str + "&targetSdkVersion=" + UtilMisc.getTargetSdkVersion();
      }
      this.mReqUrl = ((String)localObject);
      Log.i("ODSDK | PluginChecker", "checkurl= " + (String)localObject);
      return (String)localObject;
      if (this.mAppId.equals("Hy"))
      {
        localObject = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=hy&platform=2";
        break;
      }
      if (this.mAppId.equals("Od"))
      {
        localObject = "http://tiantian.qq.com/cgi-bin/hylove/version?apptype=od&platform=2";
        break;
      }
      localObject = "http://tiantian.qq.com/cgi-bin/hylove/version?platform=2&apptype=" + this.mAppId;
      break;
    }
  }
  
  private void postCallback(boolean paramBoolean)
  {
    int i = 0;
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (paramBoolean) {
      i = 1;
    }
    localMessage.arg1 = i;
    this.mHandler.sendMessage(localMessage);
  }
  
  private void runImpl()
  {
    Object localObject = downloadBuffer(getConfigUrl());
    this.mJson = ((String)localObject);
    if ((localObject == null) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      this.mLastError += " mJson == null";
      postCallback(false);
      return;
    }
    XLog.e("ODSDK | PluginChecker", "check 收到回包 ，json = " + (String)localObject);
    localObject = this.mUpdateParam.update((String)localObject);
    if (localObject != null)
    {
      this.mLastError = (this.mLastError + "parse json fail,exception = " + (String)localObject);
      postCallback(false);
      return;
    }
    this.mLastUpdateTime = System.currentTimeMillis();
    if (!this.mUpdateParam.curVersionExit)
    {
      localObject = new File(this.pluginMgr.getSdkPath());
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory())) {
        deleteFoler((File)localObject);
      }
    }
    postCallback(true);
  }
  
  public String getCheckUrl()
  {
    return this.mReqUrl;
  }
  
  public String getJsonString()
  {
    return this.mJson;
  }
  
  public String getLastError()
  {
    return this.mLastError + " json = " + this.mJson;
  }
  
  public String getLastHeadInfo()
  {
    return this.mLastHeadInfo;
  }
  
  public int getLastHttpResponseCode()
  {
    return this.mLastHttpResponseCode;
  }
  
  public String getPackName()
  {
    UpdateParam.ApkParam localApkParam2 = this.mUpdateParam.getFirstTagParam();
    UpdateParam.ApkParam localApkParam1 = localApkParam2;
    if (localApkParam2 == null) {
      localApkParam1 = this.mUpdateParam.getFirstCurParam();
    }
    if (localApkParam1 == null) {
      return "";
    }
    return localApkParam1.name;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  String hardCodeName(String paramString)
  {
    String str;
    if (paramString.equals("Live")) {
      str = "com.tencent.now";
    }
    do
    {
      return str;
      if (paramString.equals("Hy")) {
        return "com.tencent.intervideo.xplatform";
      }
      str = paramString;
    } while (!paramString.equals("Od"));
    return "com.tencent.mobileqq";
  }
  
  public boolean isForceDownload()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mUpdateParam != null)
    {
      bool1 = bool2;
      if (!this.mUpdateParam.curVersionExit)
      {
        bool1 = bool2;
        if (this.mUpdateParam.newVersionExit) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isVersionInfoExpired()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.mLastUpdateTime;
    long l1 = 86400000L;
    if (UtilMisc.isTestEnv(this.mAppId)) {
      l1 = 300000L;
    }
    return l2 - l3 > l1;
  }
  
  public void resetStatus()
  {
    this.mStatus = 0;
  }
  
  public void run(String paramString1, String paramString2, Event paramEvent)
  {
    if (paramEvent != null) {
      this.mEvent = paramEvent;
    }
    this.mUin = paramString1;
    this.mAppId = paramString2;
    if (this.mStatus == 1) {
      return;
    }
    if ((this.mStatus == 0) || (isVersionInfoExpired()))
    {
      this.mStatus = 1;
      new Thread()
      {
        public void run()
        {
          PluginChecker.this.runImpl();
        }
      }.start();
      return;
    }
    postCallback(true);
  }
  
  public static abstract interface Event
  {
    public abstract void onCheckCompleted(boolean paramBoolean, UpdateParam paramUpdateParam);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\Downloader\PluginChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */