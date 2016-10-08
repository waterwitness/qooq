package com.tencent.biz.common.offline.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import hhg;
import hhh;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OfflineDownloader
  implements IOfflineDownloader
{
  public static final int a = 0;
  public static final String a = "OfflineDownload";
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static final int b = 10;
  protected static final String b = ".tmp";
  public static final int c = 11;
  public static final int d = 12;
  public static final int e = 13;
  public static final int f = 14;
  public static final int g = 15;
  public static final int h = 16;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new hhh(this);
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(AsyncBack paramAsyncBack, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, paramString3 + ", bid: " + paramString2 + ", errCode: " + paramInt);
    }
    if ((paramAsyncBack != null) && (paramInt >= 0)) {
      paramAsyncBack.a(paramString1, paramInt);
    }
    jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
  }
  
  private void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, hhg paramhhg, String paramString)
  {
    TMAssistantDownloadClient localTMAssistantDownloadClient = null;
    Object localObject = null;
    try
    {
      paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramTMAssistantDownloadClient == null) {}
      for (paramTMAssistantDownloadClient = (TMAssistantDownloadClient)localObject;; paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.mSavePath)
      {
        localTMAssistantDownloadClient = paramTMAssistantDownloadClient;
        if (!TextUtils.isEmpty(paramTMAssistantDownloadClient)) {
          break;
        }
        a(paramhhg.a, paramString, paramhhg.c, 14, "get current download path fail after download");
        return;
      }
      paramTMAssistantDownloadClient = new File(localTMAssistantDownloadClient);
    }
    catch (Exception paramTMAssistantDownloadClient)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
      }
    }
    finally
    {
      if (TextUtils.isEmpty(null))
      {
        a(paramhhg.a, paramString, paramhhg.c, 14, "get current download path fail after download");
        return;
      }
    }
    if (!paramTMAssistantDownloadClient.exists())
    {
      a(paramhhg.a, paramString, paramhhg.c, 15, "cannot get current file after download");
      return;
    }
    boolean bool = FileUtils.c(localTMAssistantDownloadClient, paramhhg.b);
    if (!bool) {
      bool = FileUtils.b(localTMAssistantDownloadClient, paramhhg.b);
    }
    for (;;)
    {
      if (!bool)
      {
        a(paramhhg.a, paramString, paramhhg.c, 16, "rename file fail after download");
        paramTMAssistantDownloadClient.delete();
        return;
      }
      a(paramhhg.a, paramString, paramhhg.c, 0, "offline zip download success");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString + ".tmp");
    } while (!paramString.exists());
    paramString.delete();
  }
  
  public int a(Context paramContext, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null) {
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload" + Process.myPid());
    }
    try
    {
      paramContext = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramContext == null) {
        return 0;
      }
      int i = paramContext.mState;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack)
  {
    a(paramContext, paramString1, "0", paramString2, paramAsyncBack, null);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack, Map paramMap)
  {
    a(paramContext, paramString1, "0", paramString2, paramAsyncBack, paramMap);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, AsyncBack paramAsyncBack, Map paramMap)
  {
    if (paramAsyncBack == null) {}
    int i;
    for (;;)
    {
      return;
      if (paramContext == null)
      {
        paramAsyncBack.a(paramString1, 11);
        return;
      }
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
      {
        paramAsyncBack.a(paramString1, 12);
        return;
      }
      if (AppNetConnInfo.getRecentNetworkInfo() == null)
      {
        paramAsyncBack.a(paramString1, 10);
        return;
      }
      i = paramString3.lastIndexOf("/");
      if (!new File(paramString3.substring(0, i)).exists())
      {
        paramAsyncBack.a(paramString1, 13);
        return;
      }
      String str = paramString3.substring(i + 1);
      paramString2 = new hhg(str, paramString3, paramString2, paramAsyncBack);
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null) {
        this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload" + Process.myPid());
      }
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
      try
      {
        i = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.startDownloadTask(paramString1, 0, "resource/tm.android.unknown", str, paramMap);
        if (i == 0)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("OfflineDownload", 2, "offline downloader start, url: " + paramString1);
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + -1 + ", url: " + paramString1);
        }
        paramAsyncBack.a(paramString1, 10);
        return;
      }
    }
    if (i == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "offline downloader start fail, file exists, url: " + paramString1);
      }
      a(this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient, paramString2, paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + i + ", url: " + paramString1);
    }
    paramAsyncBack.a(paramString1, 10);
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.pauseDownloadTask(paramString);
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "NetWorkState Unavailabel");
      }
    }
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OfflineDownload", 2, "NetWorkState Availabel");
            }
            return true;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\util\OfflineDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */