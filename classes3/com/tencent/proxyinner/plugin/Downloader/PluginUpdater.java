package com.tencent.proxyinner.plugin.Downloader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.LocalPlugin;
import com.tencent.txproxy.HostEventListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class PluginUpdater
{
  protected static final int DC_CFG_DOWN_FAIL = 2;
  protected static final int DC_CFG_PARSE_FAIL = 3;
  protected static final int DC_CHECK_FAIL = 6;
  protected static final int DC_DOWNLOAD_FAIL = 4;
  protected static final int DC_FAIL = -1;
  protected static final int DC_INC_UPDATE_FAIL = 9;
  protected static final int DC_INC_UPDATE_TIMEOUT = 10;
  protected static final int DC_NO_NEED_UPDATE = 8;
  protected static final int DC_NO_SPACE_LEFT = 11;
  protected static final int DC_NO_UPDATE = 5;
  protected static final int DC_SUCCESS = 0;
  protected static final int DC_UNZIP_FAIL = 7;
  public static final int DOWNLOAD_ENGINE_USER_HOST = 2;
  public static final int DOWNLOAD_ENGINE_USER_SELF = 1;
  private static final int DS_NOUPDATE = 1;
  private static final int DS_UPDATED = 3;
  private static final int DS_UPDATING = 2;
  private static final int MSG_COMPLETE = 1;
  private static final int MSG_HAS_PLUGIN = 3;
  private static final int MSG_PROGRESS = 2;
  private static final int MSG_START_DOWNLOAD_FILE = 4;
  private static final int MSG_START_INC_UPDATE = 5;
  private static final String TAG = "XProxy|PluginUpdater";
  protected boolean mDownloadHost = true;
  Event mEvent = null;
  protected Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool = true;
      switch (paramAnonymousMessage.what)
      {
      }
      label118:
      do
      {
        do
        {
          do
          {
            int i;
            for (;;)
            {
              return;
              i = paramAnonymousMessage.arg1;
              if ((i == 0) || (i == 5))
              {
                PluginUpdater.access$002(PluginUpdater.this, 3);
                PluginUpdater.access$102(PluginUpdater.this, System.currentTimeMillis());
              }
              while (PluginUpdater.this.mEvent != null)
              {
                if (i != 0) {
                  break label118;
                }
                PluginUpdater.this.mEvent.onUpdated();
                return;
                PluginUpdater.access$002(PluginUpdater.this, 1);
              }
            }
            if (i == 5)
            {
              PluginUpdater.this.mEvent.onNoUpdate();
              return;
            }
            if (i == 8)
            {
              PluginUpdater.this.mEvent.onNoNeedUpdate();
              return;
            }
            PluginUpdater.this.mEvent.onUpdateError(i);
            return;
          } while (PluginUpdater.this.mEvent == null);
          PluginUpdater.this.mEvent.onUpdateProgress(paramAnonymousMessage.arg1);
          return;
          if (PluginUpdater.this.mHasPluginEvent != null)
          {
            localObject1 = PluginUpdater.this.mHasPluginEvent;
            if (paramAnonymousMessage.arg1 == 0) {
              bool = false;
            }
            ((PluginUpdater.Event)localObject1).onHasPlugin(bool);
          }
        } while (PluginUpdater.this.mEvent == null);
        Object localObject2 = paramAnonymousMessage.getData();
        Object localObject1 = ((Bundle)localObject2).getString("url");
        localObject2 = ((Bundle)localObject2).getString("path");
        paramAnonymousMessage = (HostEventListener)paramAnonymousMessage.obj;
        PluginUpdater.this.mEvent.onStartDownloadFile((String)localObject1, (String)localObject2, paramAnonymousMessage);
        return;
      } while (PluginUpdater.this.mEvent == null);
      paramAnonymousMessage = paramAnonymousMessage.getData();
      PluginUpdater.this.mEvent.onStartIncUpdate(paramAnonymousMessage);
    }
  };
  Event mHasPluginEvent = null;
  private String mLastError;
  private String mLastHeadInfo;
  private int mLastHostErrCode = 0;
  private int mLastResponseCode = 200;
  private long mLastUpdateTime = 0L;
  private int mStatus = 1;
  protected int mVasType = 1;
  protected LocalPlugin pluginMgr;
  
  public static PluginUpdater create(int paramInt, LocalPlugin paramLocalPlugin, long paramLong)
  {
    MyDownloader localMyDownloader = new MyDownloader(paramLong);
    localMyDownloader.setVasType(paramInt);
    localMyDownloader.pluginMgr = paramLocalPlugin;
    return localMyDownloader;
  }
  
  public static boolean isIncUpdateError(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10);
  }
  
  public static boolean isNoSpaceError(int paramInt)
  {
    return paramInt == 11;
  }
  
  private void postCallback(int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void _requestHasPlugin(Event paramEvent)
  {
    this.mHasPluginEvent = paramEvent;
    requestHasPlugin();
  }
  
  protected boolean checkMd5(String paramString1, String paramString2)
  {
    try
    {
      XLog.i("XProxy|PluginUpdater", "服务器md5值 = " + paramString2);
      String str = MD5.getFileMD5String(new File(paramString1));
      XLog.i("XProxy|PluginUpdater", "当前下载文件的md5值 = " + str + "file = " + paramString1);
      if ((str != null) && (!TextUtils.isEmpty(str)))
      {
        boolean bool = str.equalsIgnoreCase(paramString2);
        if (bool) {}
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramString1)
    {
      return false;
    }
    return true;
  }
  
  protected abstract void download(String paramString);
  
  public String getLastError()
  {
    return this.mLastError;
  }
  
  public String getLastHeadInfo()
  {
    return this.mLastHeadInfo;
  }
  
  public int getLastHostErrCode()
  {
    return this.mLastHostErrCode;
  }
  
  public int getLastResponseCode()
  {
    return this.mLastResponseCode;
  }
  
  protected void getLastStatusInfo(URLConnection paramURLConnection)
  {
    Object localObject = paramURLConnection.getHeaderFields();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append(localEntry.getValue() + "\n");
    }
    this.mLastHeadInfo = localStringBuilder.toString();
    paramURLConnection = (HttpURLConnection)paramURLConnection;
    if (paramURLConnection != null) {}
    try
    {
      this.mLastResponseCode = paramURLConnection.getResponseCode();
      return;
    }
    catch (IOException paramURLConnection)
    {
      paramURLConnection.printStackTrace();
    }
  }
  
  public boolean hasPatchDiffFailed(int paramInt)
  {
    return false;
  }
  
  protected void notifyHostDownload(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    Log.i("XProxy|PluginUpdater", "通知宿主下载");
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = paramHostEventListener;
    paramHostEventListener = new Bundle();
    paramHostEventListener.putString("url", paramString1);
    paramHostEventListener.putString("path", paramString2);
    localMessage.setData(paramHostEventListener);
    this.mHandler.sendMessage(localMessage);
  }
  
  protected void notifyPluginIncUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    Bundle localBundle = new Bundle();
    localBundle.putInt("version", paramInt);
    localBundle.putString("tmpDir", paramString1);
    localBundle.putString("oldApkPathName", paramString2);
    localBundle.putString("newApkPathName", paramString3);
    localBundle.putString("patchUrl", paramString4);
    localBundle.putString("patchHash", paramString5);
    localBundle.putString("apkHash", paramString6);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  protected void onCompleted(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    this.mHandler.sendMessage(localMessage);
  }
  
  protected void onHasPlugin(boolean paramBoolean)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void onHostNotifyDownloadFileProgress(Long paramLong1, Long paramLong2) {}
  
  public void onHostNotifyDownloadFileResult(boolean paramBoolean, int paramInt1, int paramInt2, String paramString) {}
  
  protected void onProgress(int paramInt)
  {
    if (paramInt <= 25) {}
    for (paramInt = paramInt * 75 / 25;; paramInt = (paramInt - 25) * 25 / 75 + 75)
    {
      onRealProgress(paramInt);
      return;
    }
  }
  
  protected void onRealProgress(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.mHandler.sendMessage(localMessage);
  }
  
  protected abstract void requestHasPlugin();
  
  public void resetStatus()
  {
    if (this.mStatus == 3) {
      this.mStatus = 1;
    }
  }
  
  public boolean run(Event paramEvent, boolean paramBoolean, String paramString)
  {
    this.mDownloadHost = paramBoolean;
    if (paramEvent != null) {
      this.mEvent = paramEvent;
    }
    if (this.mStatus == 2) {
      return false;
    }
    this.mStatus = 2;
    Log.i("XProxy|PluginUpdater", "插件开始下载");
    download(paramString);
    return true;
  }
  
  protected void setLastError(String paramString)
  {
    this.mLastError = paramString;
  }
  
  protected void setLastHostErrCode(int paramInt)
  {
    this.mLastHostErrCode = paramInt;
  }
  
  protected void setLastResponseCode(int paramInt)
  {
    this.mLastResponseCode = paramInt;
  }
  
  public void setVasType(int paramInt)
  {
    this.mVasType = paramInt;
  }
  
  protected boolean unzip(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        localZipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        ZipInputStream localZipInputStream;
        Object localObject;
        byte[] arrayOfByte;
        File localFile;
        return false;
      }
      try
      {
        localObject = localZipInputStream.getNextEntry();
        if (localObject == null) {
          break;
        }
      }
      catch (Exception paramString1)
      {
        continue;
      }
      try
      {
        arrayOfByte = new byte['က'];
        ((ZipEntry)localObject).getName();
        localObject = new File(paramString2 + paramString3);
        localFile = new File(((File)localObject).getParent());
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        localObject = new BufferedOutputStream(new FileOutputStream((File)localObject), 4096);
        try
        {
          int i = localZipInputStream.read(arrayOfByte, 0, 4096);
          if (i == -1) {
            continue;
          }
          ((BufferedOutputStream)localObject).write(arrayOfByte, 0, i);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1)
        {
          paramString1 = (String)localObject;
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      continue;
      ((BufferedOutputStream)localObject).flush();
      ((BufferedOutputStream)localObject).close();
      paramString1 = (String)localObject;
    }
    localZipInputStream.close();
    return true;
  }
  
  public static abstract interface Event
  {
    public abstract void onHasPlugin(boolean paramBoolean);
    
    public abstract void onNoNeedUpdate();
    
    public abstract void onNoUpdate();
    
    public abstract void onStartDownloadFile(String paramString1, String paramString2, HostEventListener paramHostEventListener);
    
    public abstract void onStartIncUpdate(Bundle paramBundle);
    
    public abstract void onUpdateError(int paramInt);
    
    public abstract void onUpdateProgress(int paramInt);
    
    public abstract void onUpdated();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\Downloader\PluginUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */