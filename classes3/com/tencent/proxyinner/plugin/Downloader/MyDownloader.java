package com.tencent.proxyinner.plugin.Downloader;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.proxyinner.channel.PluginChannel.Event;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.LocalPlugin;
import com.tencent.txproxy.HostEventListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class MyDownloader
  extends PluginUpdater
  implements PluginChannel.Event, HostEventListener
{
  public static final int INC_UPDATE_SUCCESS = 0;
  private static final int PROGRESS_CONFIG_DOWNLOADED = 5;
  private static final int PROGRESS_CONFIG_PARSED = 10;
  private static final int PROGRESS_STARTED = 0;
  private static final int PROGRESS_TIMEOUT_MS = 15000;
  private static final String TAG = "XProxy|MyDownloader";
  private UpdateParam.ApkParam apkParam;
  private int incUpdateProgress;
  private Runnable mIncUpdateTimer = new Runnable()
  {
    public void run()
    {
      Log.e("XProxy|MyDownloader", "PROGRESS_TIMEOUT: version=" + MyDownloader.this.updateParam.newSdkVersion);
      MyDownloader.access$402(MyDownloader.this, MyDownloader.this.updateParam.newSdkVersion);
      MyDownloader.this.onProgress(100);
      MyDownloader.this.onCompleted(10);
    }
  };
  private int patchFailSdkVersion;
  private long uin;
  private UpdateParam updateParam;
  
  public MyDownloader(long paramLong)
  {
    this.uin = paramLong;
  }
  
  private void deleteFile(String paramString)
  {
    new File(paramString).delete();
  }
  
  private String downloadBuffer(String paramString)
  {
    try
    {
      localObject2 = new StringBuffer();
      FileInputStream localFileInputStream = new FileInputStream("sdcard/cgitest.txt");
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
      for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine())
      {
        ((StringBuffer)localObject2).append(str);
        ((StringBuffer)localObject2).append("\n");
      }
      localBufferedReader.close();
      localFileInputStream.close();
      str = ((StringBuffer)localObject2).toString();
      return str;
    }
    catch (Exception localException)
    {
      Object localObject2;
      XLog.i("XProxy|MyDownloader", "读本地HardCode数据失败 ");
      try
      {
        localObject1 = new URL(paramString).openConnection();
        ((URLConnection)localObject1).setUseCaches(false);
        getLastStatusInfo((URLConnection)localObject1);
        paramString = ((URLConnection)localObject1).getInputStream();
        int k = ((URLConnection)localObject1).getContentLength();
        int i = 0;
        localObject1 = new byte['က'];
        int j = 0;
        localObject2 = new byte['က'];
        for (;;)
        {
          int m = paramString.read((byte[])localObject2);
          if (m == -1) {
            break;
          }
          System.arraycopy(localObject2, 0, localObject1, j, m);
          j += m;
          i += m;
          Log.i("XProxy|MyDownloader", "下载配置文件，len = " + m + ", 总进度：" + i + "/" + k);
        }
        localObject1 = new String((byte[])localObject1, "UTF-8");
      }
      catch (Exception paramString)
      {
        prepareFailInfo(paramString.toString(), "version.tiantian.qq.com");
        return "";
      }
      XLog.i("XProxy|MyDownloader", "buf =    " + (String)localObject1);
      Object localObject1 = "" + (String)localObject1;
      paramString.close();
      return (String)localObject1;
    }
  }
  
  private boolean downloadFile(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.mDownloadHost) && (this.apkParam.downloadEngine == 2))
    {
      XLog.i("XProxy|MyDownloader", "在宿主中下载，url =" + paramString1 + "file = " + paramString2);
      notifyHostDownload(paramString1, paramString2, this);
    }
    for (;;)
    {
      return true;
      for (;;)
      {
        int i;
        int k;
        try
        {
          Object localObject = new URL(paramString1).openConnection();
          ((URLConnection)localObject).setUseCaches(false);
          paramString1 = ((URLConnection)localObject).getInputStream();
          File localFile = new File(paramString2);
          if (localFile.exists()) {
            localFile.delete();
          }
          localFile.createNewFile();
          int m = ((URLConnection)localObject).getContentLength();
          i = 0;
          localObject = new byte['က'];
          paramString2 = new FileOutputStream(paramString2);
          int j = paramString1.read((byte[])localObject);
          if (j == -1) {
            break;
          }
          paramString2.write((byte[])localObject, 0, j);
          j = i + j;
          k = (int)((paramInt2 - paramInt1) * j * 1.0D / m + paramInt1);
          if (k < paramInt1)
          {
            i = paramInt1;
            onProgress(i);
            i = j;
            continue;
          }
          i = k;
        }
        catch (Exception paramString1)
        {
          XLog.i("XProxy|MyDownloader", "下载SDK，出现异常 e = " + paramString1.toString());
          prepareFailInfo(paramString1.toString() + " " + this.apkParam.apkZipUrl + " " + this.updateParam.newSdkVersion + " " + this.apkParam.apkZipHash, "pub.idqqimg.com");
          return false;
        }
        if (k > paramInt2) {
          i = paramInt2;
        }
      }
      paramString2.close();
      paramString1.close();
    }
  }
  
  private String getConfigUrl()
  {
    return "";
  }
  
  private int prepareApkOrDiff(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!checkMd5(paramString1, paramString4)) {
      return 6;
    }
    onProgress(95);
    paramString3 = new File(paramString2);
    if (paramString3.exists()) {
      paramString3.delete();
    }
    paramString3 = paramString2 + "/" + this.pluginMgr.mPluginName + ".apk";
    XLog.i("XProxy|MyDownloader", "解压目录 = " + paramString3);
    if (!unzip(paramString1, paramString2 + "/", this.pluginMgr.mPluginName + ".apk")) {
      return 7;
    }
    return 0;
  }
  
  /* Error */
  private void prepareFailInfo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 169	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: invokestatic 295	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: new 169	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 297
    //   21: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokevirtual 301	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: astore_2
    //   35: new 98	java/io/BufferedReader
    //   38: dup
    //   39: new 100	java/io/InputStreamReader
    //   42: dup
    //   43: aload_2
    //   44: invokevirtual 304	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   47: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   50: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore 4
    //   55: aload 4
    //   57: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +94 -> 158
    //   67: ldc 28
    //   69: new 169	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 306
    //   79: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 5
    //   84: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 132	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: aload_3
    //   95: new 169	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   102: aload 5
    //   104: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc -8
    //   109: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: goto -64 -> 55
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   127: aload_0
    //   128: new 169	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   135: aload_1
    //   136: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc -8
    //   141: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_3
    //   145: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokevirtual 312	com/tencent/proxyinner/plugin/Downloader/MyDownloader:setLastError	(Ljava/lang/String;)V
    //   157: return
    //   158: aload_2
    //   159: invokevirtual 315	java/lang/Process:waitFor	()I
    //   162: ifne +22 -> 184
    //   165: aload_3
    //   166: ldc_w 317
    //   169: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: goto -46 -> 127
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 318	java/lang/InterruptedException:printStackTrace	()V
    //   181: goto -54 -> 127
    //   184: aload_3
    //   185: ldc_w 320
    //   188: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: goto -65 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	MyDownloader
    //   0	195	1	paramString1	String
    //   0	195	2	paramString2	String
    //   7	178	3	localStringBuilder	StringBuilder
    //   53	3	4	localBufferedReader	BufferedReader
    //   60	43	5	str	String
    // Exception table:
    //   from	to	target	type
    //   8	55	122	java/io/IOException
    //   55	62	122	java/io/IOException
    //   67	119	122	java/io/IOException
    //   158	173	122	java/io/IOException
    //   184	192	122	java/io/IOException
    //   8	55	176	java/lang/InterruptedException
    //   55	62	176	java/lang/InterruptedException
    //   67	119	176	java/lang/InterruptedException
    //   158	173	176	java/lang/InterruptedException
    //   184	192	176	java/lang/InterruptedException
  }
  
  private void renameFile(String paramString1, String paramString2)
  {
    XLog.i("XProxy|MyDownloader", "renameFile srcFileName = " + paramString1 + "targetFileName =" + paramString2);
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if (paramString2.exists()) {
      paramString2.delete();
    }
    if (paramString1.exists()) {
      paramString1.renameTo(paramString2);
    }
  }
  
  private void runImpl(String paramString)
  {
    String str2 = this.pluginMgr.getSdkPath();
    String str1 = this.pluginMgr.getSdkPathForCurrentProxy();
    int i = this.pluginMgr.getMaxSdkVersion();
    onProgress(0);
    this.pluginMgr.createFolder(str2);
    this.pluginMgr.createFolder(str1);
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      onCompleted(2);
    }
    do
    {
      return;
      Log.i("XProxy|MyDownloader", "下载配置文件 strJson = " + paramString);
      onProgress(5);
      if (this.updateParam == null) {
        this.updateParam = new UpdateParam();
      }
      str2 = this.updateParam.update(paramString);
      if (this.updateParam.newVersionExit) {
        this.apkParam = this.updateParam.getFirstTagParam();
      }
      if ((str2 != null) || (this.apkParam == null))
      {
        setLastError(str2 + " " + paramString);
        onCompleted(3);
        return;
      }
      if ((!this.updateParam.newVersionExit) || (this.updateParam.newSdkVersion <= i))
      {
        onCompleted(5);
        return;
      }
      onProgress(10);
      paramString = str1 + "/temp.zip";
      str2 = str1 + "/temp";
      str1 = str1 + "/" + this.updateParam.newSdkVersion;
      if (!downloadFile(this.apkParam.apkZipUrl, paramString, 10, 90)) {
        onCompleted(4);
      }
    } while ((this.mDownloadHost) && (2 == this.apkParam.downloadEngine));
    onProgress(90);
    i = prepareApkOrDiff(paramString, str2, this.apkParam.apkZipUrl, this.apkParam.apkZipHash);
    if (i != 0)
    {
      onCompleted(i);
      return;
    }
    renameFile(str2, str1);
    deleteFile(paramString);
    onProgress(100);
    onCompleted(0);
  }
  
  protected void download(final String paramString)
  {
    new Thread()
    {
      public void run()
      {
        MyDownloader.this.runImpl(paramString);
      }
    }.start();
  }
  
  public boolean hasPatchDiffFailed(int paramInt)
  {
    return (this.updateParam != null) && (paramInt == this.patchFailSdkVersion);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2)
  {
    int j = (int)(80 * paramLong1 * 1.0D / paramLong2 + 10);
    int i;
    if (j < 10) {
      i = 10;
    }
    for (;;)
    {
      Log.i("XProxy|MyDownloader", "HostDownloader下载SDK，len = " + paramLong1 + ", 总进度：" + paramLong1 + "/" + paramLong2);
      onProgress(i);
      return;
      i = j;
      if (j > 90) {
        i = 90;
      }
    }
  }
  
  public void onDownloadResult(int paramInt1, int paramInt2, String paramString)
  {
    String str1 = this.pluginMgr.getSdkPathForCurrentProxy();
    String str2 = str1 + "/temp.zip";
    String str3 = str1 + "/temp";
    this.pluginMgr.getMaxSdkVersion();
    if (paramInt1 == 0)
    {
      XLog.i("XProxy|MyDownloader", "HostDownloader下载SDK成功");
      paramInt1 = prepareApkOrDiff(str2, str3, this.apkParam.apkZipUrl, this.apkParam.apkZipHash);
      if (paramInt1 != 0)
      {
        onCompleted(paramInt1);
        return;
      }
      renameFile(str3, str1 + "/" + this.updateParam.newSdkVersion);
      deleteFile(str2);
      onProgress(100);
      onCompleted(0);
      return;
    }
    XLog.i("XProxy|MyDownloader", "HostDownloader下载SDK失败,retCode = " + paramInt1 + " httpCode = " + paramInt2 + "errMsg = " + paramString);
    prepareFailInfo(paramString + " " + this.apkParam.apkZipUrl + " " + this.updateParam.newSdkVersion + " " + this.apkParam.apkZipHash, "pub.idqqimg.com");
    setLastResponseCode(paramInt2);
    setLastHostErrCode(paramInt1);
    if (paramInt1 == 9040)
    {
      onCompleted(11);
      return;
    }
    onCompleted(4);
  }
  
  public void onRemoteRequest(String paramString, Bundle paramBundle)
  {
    int i;
    if ("com.tencent.od.incupdateresult".equals(paramString))
    {
      this.mHandler.removeCallbacks(this.mIncUpdateTimer);
      i = paramBundle.getInt("resultCode");
      paramString = paramBundle.getString("resultDesc");
      Log.i("XProxy|MyDownloader", "ACTION_INC_UPDATE_RESULT " + i + ":" + paramString);
      setLastError(paramString);
      switch (i)
      {
      default: 
        i = paramBundle.getInt("version");
        if (i != 0)
        {
          this.patchFailSdkVersion = i;
          onProgress(100);
          onCompleted(9);
        }
        break;
      }
    }
    do
    {
      do
      {
        return;
        onProgress(100);
        onCompleted(0);
        return;
        i = this.updateParam.newSdkVersion;
        break;
      } while (!"com.tencent.od.incupdateprogress".equals(paramString));
      this.mHandler.removeCallbacks(this.mIncUpdateTimer);
      this.mHandler.postDelayed(this.mIncUpdateTimer, 15000L);
      i = paramBundle.getInt("progress");
    } while (this.incUpdateProgress == i);
    this.incUpdateProgress = i;
    onRealProgress((int)(10.0F + i / 100.0F * 90.0F));
  }
  
  public void requestHasPlugin()
  {
    new Thread()
    {
      public void run()
      {
        String str1 = MyDownloader.this.getConfigUrl();
        String str2 = MyDownloader.this.downloadBuffer(str1);
        Log.i("XProxy|MyDownloader", "sdkSupport, url: " + str1);
        Log.i("XProxy|MyDownloader", "sdkSupport, json: " + str2);
        if ((str2 == null) || (TextUtils.isEmpty(str2)))
        {
          MyDownloader.this.onHasPlugin(false);
          return;
        }
        try
        {
          int i = new JSONObject(str2).getInt("errCode");
          Log.i("XProxy|MyDownloader", "sdkSupport, code: " + i);
          if (i == 0)
          {
            MyDownloader.this.onHasPlugin(true);
            return;
          }
        }
        catch (Exception localException)
        {
          MyDownloader.this.onHasPlugin(false);
        }
      }
    }.start();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\Downloader\MyDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */