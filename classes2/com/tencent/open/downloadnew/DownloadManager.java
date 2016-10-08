package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.open.downloadnew.common.NoticeDownloadListener;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;
import wvh;
import wvi;
import wvl;
import wvm;
import wvn;
import wvo;
import wvq;
import wvt;
import wvu;
import wvv;
import wvw;
import wvx;
import wvy;
import wvz;
import wwa;
import wwb;
import wwe;
import wwf;
import wwg;
import wwh;

public class DownloadManager
{
  protected static final int a = 3;
  public static final long a = 1000L;
  protected static DownloadManager a;
  public static final String a;
  protected static final byte[] a;
  protected static final int b = 200;
  public static final String b;
  public static final String c = "open_sdkcom.tencent.mobileqq:web";
  public static final String d = "com.tencent.mobileqq";
  public static final String f = "com.opensdk.downloadmanager.renameFilename";
  private ApkGetCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener = new wvv(this);
  private ApkWriteCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
  protected PackageInstallReceiver a;
  public ITMAssistantDownloadClientListener a;
  public ITMAssistantDownloadLogListener a;
  protected TMAssistantDownloadClient a;
  protected WeakReference a;
  public ConcurrentHashMap a;
  protected ConcurrentLinkedQueue a;
  public boolean a;
  protected long b;
  protected boolean b;
  protected final int c;
  protected long c;
  protected String e = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = DownloadManager.class.getName();
    jdField_b_of_type_JavaLangString = File.separator + "tencent" + File.separator + ".qqdownload" + File.separator;
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new wwb(this);
    this.jdField_c_of_type_Int = 1000;
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener = new wvy(this);
    LogUtility.c(jdField_a_of_type_JavaLangString, "DownloadManager create QQ5.0");
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver = new PackageInstallReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addDataScheme("package");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    CommonDataAdapter.a().a().registerReceiver(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver, localIntentFilter);
    NoticeDownloadListener.a().a(ThreadManager.b().getLooper());
    a(WebViewDownloadListener.a());
    a(NoticeDownloadListener.a());
    ThreadManager.b().post(new wvu(this));
    DownloaderGetCodeClient.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return 20;
    case 2: 
      return 2;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 6: 
      return 10;
    }
    return -2;
  }
  
  /* Error */
  public static DownloadManager a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +33 -> 41
    //   11: new 2	com/tencent/open/downloadnew/DownloadManager
    //   14: dup
    //   15: invokespecial 203	com/tencent/open/downloadnew/DownloadManager:<init>	()V
    //   18: putstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   21: getstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   24: ldc 18
    //   26: putfield 81	com/tencent/open/downloadnew/DownloadManager:e	Ljava/lang/String;
    //   29: getstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   32: invokevirtual 205	com/tencent/open/downloadnew/DownloadManager:b	()V
    //   35: getstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   38: invokevirtual 207	com/tencent/open/downloadnew/DownloadManager:f	()V
    //   41: getstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   55: goto -14 -> 41
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	43	0	localDownloadManager	DownloadManager
    //   50	2	0	localException	Exception
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	41	50	java/lang/Exception
    //   3	7	58	finally
    //   11	41	58	finally
    //   41	48	58	finally
    //   51	55	58	finally
    //   59	62	58	finally
  }
  
  public static DownloadManager a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager == null)
      {
        if (TextUtils.isEmpty(paramString)) {
          LogUtility.e(jdField_a_of_type_JavaLangString, "getInstance error, clientKey == null !!!!");
        }
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager = new DownloadManager();
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e = paramString;
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b();
      }
      paramString = jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager;
      return paramString;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "receive write code msg......");
    if (paramBundle == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "receive write code msg but data is null......");
      return;
    }
    ThreadManager.b().post(new wvx(this, paramBundle));
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_1
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_1
    //   20: goto -7 -> 13
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	localDownloadManager	DownloadManager
    //   23	5	0	localObject	Object
    //   12	8	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "receive get code msg......");
    if (paramDownloadInfo == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "receive get code msg but info is null......");
      return;
    }
    ThreadManager.b().post(new wvw(this, paramDownloadInfo));
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener != null) {
      return this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener.a(paramDownloadInfo.d, paramDownloadInfo.jdField_g_of_type_Int, paramDownloadInfo.jdField_k_of_type_JavaLangString, null);
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
    return -40;
  }
  
  public int a(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null) {
      if (((DownloadInfo)localObject).jdField_f_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (localObject = ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString)
    {
      ThreadManager.b().post(new wvl(this, (String)localObject));
      LogUtility.a(jdField_a_of_type_JavaLangString, "pause url=" + (String)localObject + ", appid=" + paramString);
      return 0;
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getDownloadInfoById appId == null");
      return null;
    }
    return (DownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public DownloadInfo a(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  public TMAssistantDownloadTaskInfo a(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, paramDownloadInfo.i);
    localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_j_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.e, paramDownloadInfo.d);
    localBundle.putInt(DownloadConstants.d, paramDownloadInfo.jdField_g_of_type_Int);
    localBundle.putString(DownloadConstants.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_g_of_type_JavaLangString);
    try
    {
      LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + paramDownloadInfo.jdField_b_of_type_JavaLangString + " apkId=" + paramDownloadInfo.jdField_j_of_type_JavaLangString + " taskAppId=" + paramDownloadInfo.i + " packageName=" + paramDownloadInfo.d + " version=" + paramDownloadInfo.jdField_g_of_type_Int + " via=" + paramDownloadInfo.jdField_g_of_type_JavaLangString);
      paramDownloadInfo = MyAppApi.a().a(localBundle);
      if (paramDownloadInfo != null) {}
      try
      {
        LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + paramDownloadInfo.mSavePath + " state=" + paramDownloadInfo.mState);
        return paramDownloadInfo;
      }
      catch (Exception localException1) {}
      LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramDownloadInfo = null;
      }
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "getTaskInfoFromMyApp>>>", localException1);
    return paramDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = a().getDownloadTaskState(paramString);
        if (localTMAssistantDownloadTaskInfo == null) {
          LogUtility.a(jdField_a_of_type_JavaLangString, "getTaskInfoFromSDK null url=" + paramString);
        }
        return localTMAssistantDownloadTaskInfo;
      }
      catch (Exception localException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
      }
      Object localObject = null;
    }
  }
  
  public TMAssistantDownloadClient a()
  {
    TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.e).registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    if (QLog.isColorLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "registerLogListener!");
      TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.e).registerLogListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
    }
    if (!this.jdField_b_of_type_Boolean) {}
    try
    {
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKSettingClient();
      if (localTMAssistantDownloadSettingClient != null)
      {
        localTMAssistantDownloadSettingClient.setDownloadSDKMaxTaskNum(3);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "exception: " + localException.toString());
      }
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.e);
    return this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_k_of_type_JavaLangString;
    }
    return "";
  }
  
  public WeakReference a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 == null) {}
      try
      {
        if ((BaseApplicationImpl.a().a() instanceof AppInterface))
        {
          localObject1 = (AppInterface)BaseApplicationImpl.a().a();
          if (localObject1 != null) {
            this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "getQQAppInterface>>>", localException);
        }
      }
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      return (WeakReference)localObject1;
    }
    finally {}
  }
  
  protected List a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo.a() == paramInt) {
          localArrayList.add(localDownloadInfo);
        }
      }
    }
    finally {}
    return localList;
  }
  
  public List a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "getDownloadInfoById via == " + paramString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo.jdField_g_of_type_JavaLangString)) && (localDownloadInfo.jdField_g_of_type_JavaLangString.equals(paramString))) {
        localArrayList.add(localDownloadInfo);
      }
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "getDownloadInfoByVia result =" + localArrayList);
    return localArrayList;
  }
  
  public ConcurrentHashMap a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public ConcurrentLinkedQueue a()
  {
    try
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
      return localConcurrentLinkedQueue;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    ThreadManager.b().post(new wvh(this));
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "notifyListener info == null id=" + paramInt1);
        return;
      }
      finally {}
      switch (paramInt1)
      {
      default: 
        break;
      case -2: 
        a(paramDownloadInfo, paramInt2, paramString);
        break;
      case 20: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载等待:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).b(paramDownloadInfo);
        }
      case 3: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载暂停:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).a(paramDownloadInfo);
        }
      case 4: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载完成:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).c(paramDownloadInfo);
        }
      case 10: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载取消:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        AppNotificationManager.a().a(paramDownloadInfo.jdField_f_of_type_JavaLangString);
        paramDownloadInfo.a(10);
        LogUtility.a(jdField_a_of_type_JavaLangString, "downloadInfo.state = " + paramDownloadInfo.a());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).d(paramDownloadInfo);
        }
      case 2: 
        if ((paramDownloadInfo.jdField_h_of_type_Int == 1) || (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载进度更新:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          paramDownloadInfo = a(2);
          LogUtility.a(jdField_a_of_type_JavaLangString, "###下载进度更新  size=" + paramDownloadInfo.size());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext()) {
            ((DownloadListener)paramString.next()).a(paramDownloadInfo);
          }
        }
        break;
      case 6: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###安装成功:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).a(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.d);
        }
      case 13: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "###包被替换:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).c(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.d);
        }
      case 9: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "###卸载成功:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).b(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.d);
        }
      }
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    new Handler(Looper.getMainLooper()).post(new wvq(this, paramBundle, paramActivity, paramInt1, paramApkUpdateDetail, paramInt2));
  }
  
  public void a(AppInterface paramAppInterface)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 600	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_Boolean	Z
    //   6: ifeq +27 -> 33
    //   9: ldc_w 602
    //   12: aload_1
    //   13: getfield 306	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: bipush 100
    //   18: invokestatic 607	com/tencent/open/base/ImageUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   21: new 609	wvj
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 610	wvj:<init>	(Lcom/tencent/open/downloadnew/DownloadManager;Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   30: invokestatic 615	com/tencent/open/base/img/ImageCache:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/open/base/img/ImageDownCallback;)V
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 306	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokevirtual 269	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +316 -> 359
    //   46: aload_0
    //   47: aload_3
    //   48: aload_1
    //   49: invokevirtual 618	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;Lcom/tencent/open/downloadnew/DownloadInfo;)Z
    //   52: ifeq +302 -> 354
    //   55: aload_3
    //   56: astore_2
    //   57: getstatic 50	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   60: new 52	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 620
    //   70: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: getfield 286	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 622
    //   83: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: getfield 624	com/tencent/open/downloadnew/DownloadInfo:a	Z
    //   90: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: ldc_w 629
    //   96: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: getfield 271	com/tencent/open/downloadnew/DownloadInfo:jdField_f_of_type_Int	I
    //   103: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc_w 631
    //   109: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: aload_1
    //   114: getfield 306	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   117: invokevirtual 269	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   120: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 284	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aload_2
    //   131: invokevirtual 633	com/tencent/open/downloadnew/DownloadManager:e	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   134: ldc 21
    //   136: aload_2
    //   137: getfield 254	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   140: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +15 -> 158
    //   146: aload_0
    //   147: invokevirtual 635	com/tencent/open/downloadnew/DownloadManager:b	()Z
    //   150: ifeq +8 -> 158
    //   153: aload_0
    //   154: aload_2
    //   155: invokevirtual 637	com/tencent/open/downloadnew/DownloadManager:f	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   158: aload_2
    //   159: getfield 271	com/tencent/open/downloadnew/DownloadInfo:jdField_f_of_type_Int	I
    //   162: iconst_1
    //   163: if_icmpne +276 -> 439
    //   166: aload_2
    //   167: getfield 273	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   170: astore_1
    //   171: aload_2
    //   172: getfield 271	com/tencent/open/downloadnew/DownloadInfo:jdField_f_of_type_Int	I
    //   175: istore 5
    //   177: new 639	java/util/HashMap
    //   180: dup
    //   181: invokespecial 640	java/util/HashMap:<init>	()V
    //   184: astore 4
    //   186: aload 4
    //   188: getstatic 645	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   191: aload_2
    //   192: getfield 306	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   195: invokeinterface 651 3 0
    //   200: pop
    //   201: aload 4
    //   203: getstatic 654	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   206: aload_2
    //   207: getfield 254	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   210: invokeinterface 651 3 0
    //   215: pop
    //   216: aload 4
    //   218: getstatic 657	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   221: aload_2
    //   222: getfield 257	com/tencent/open/downloadnew/DownloadInfo:jdField_g_of_type_Int	I
    //   225: invokestatic 661	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   228: invokeinterface 651 3 0
    //   233: pop
    //   234: aload 4
    //   236: getstatic 664	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   239: aload_2
    //   240: getfield 326	com/tencent/open/downloadnew/DownloadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   243: invokeinterface 651 3 0
    //   248: pop
    //   249: aload 4
    //   251: getstatic 667	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   254: ldc_w 669
    //   257: invokestatic 672	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   260: invokeinterface 651 3 0
    //   265: pop
    //   266: aload 4
    //   268: getstatic 675	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   271: iconst_2
    //   272: invokestatic 661	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   275: invokeinterface 651 3 0
    //   280: pop
    //   281: aload 4
    //   283: getstatic 678	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   286: aload_2
    //   287: getfield 681	com/tencent/open/downloadnew/DownloadInfo:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   290: invokeinterface 651 3 0
    //   295: pop
    //   296: aload 4
    //   298: getstatic 684	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   301: aload_2
    //   302: getfield 685	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   305: invokeinterface 651 3 0
    //   310: pop
    //   311: aload 4
    //   313: getstatic 688	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   316: aload_2
    //   317: getfield 691	com/tencent/open/downloadnew/DownloadInfo:o	I
    //   320: invokestatic 661	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   323: invokeinterface 651 3 0
    //   328: pop
    //   329: invokestatic 164	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   332: new 693	wvk
    //   335: dup
    //   336: aload_0
    //   337: aload_1
    //   338: aload 4
    //   340: iload 5
    //   342: aload_2
    //   343: aload_3
    //   344: invokespecial 696	wvk:<init>	(Lcom/tencent/open/downloadnew/DownloadManager;Ljava/lang/String;Ljava/util/Map;ILcom/tencent/open/downloadnew/DownloadInfo;Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   347: invokevirtual 188	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   350: pop
    //   351: aload_0
    //   352: monitorexit
    //   353: return
    //   354: aload_1
    //   355: astore_2
    //   356: goto -299 -> 57
    //   359: ldc_w 698
    //   362: astore_2
    //   363: aload_1
    //   364: getfield 701	com/tencent/open/downloadnew/DownloadInfo:jdField_m_of_type_Int	I
    //   367: bipush 12
    //   369: if_icmpne +7 -> 376
    //   372: ldc_w 703
    //   375: astore_2
    //   376: aload_2
    //   377: aload_1
    //   378: getfield 326	com/tencent/open/downloadnew/DownloadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   381: aload_1
    //   382: getfield 306	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   385: aload_1
    //   386: getfield 705	com/tencent/open/downloadnew/DownloadInfo:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   389: invokestatic 710	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   392: getstatic 50	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   395: new 52	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 712
    //   405: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_1
    //   409: getfield 286	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   412: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc_w 629
    //   418: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_1
    //   422: getfield 271	com/tencent/open/downloadnew/DownloadInfo:jdField_f_of_type_Int	I
    //   425: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 284	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_1
    //   435: astore_2
    //   436: goto -307 -> 129
    //   439: aload_2
    //   440: getfield 286	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   443: astore_1
    //   444: goto -273 -> 171
    //   447: astore_1
    //   448: aload_0
    //   449: monitorexit
    //   450: aload_1
    //   451: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	DownloadManager
    //   0	452	1	paramDownloadInfo	DownloadInfo
    //   56	384	2	localObject	Object
    //   41	303	3	localDownloadInfo	DownloadInfo
    //   184	155	4	localHashMap	java.util.HashMap
    //   175	166	5	i	int
    // Exception table:
    //   from	to	target	type
    //   2	33	447	finally
    //   33	42	447	finally
    //   46	55	447	finally
    //   57	129	447	finally
    //   129	158	447	finally
    //   158	171	447	finally
    //   171	351	447	finally
    //   363	372	447	finally
    //   376	434	447	finally
    //   439	444	447	finally
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramDownloadInfo == null)
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "handleDownloadErrorCallBack info == null code = " + paramInt + " msg = " + paramString);
      return;
    }
    LogUtility.d(jdField_a_of_type_JavaLangString, "handleDownloadErrorCallBack code = " + paramInt + " msg = " + paramString);
    label112:
    int i;
    if ((paramInt >= 400) && (paramInt <= 599))
    {
      try
      {
        paramString = CommonDataAdapter.a().a().getString(2131363013);
      }
      catch (Exception paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
        return;
      }
      paramString = CommonDataAdapter.a().a().getString(2131363014);
      i = 3;
    }
    for (;;)
    {
      paramDownloadInfo.a(i);
      LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载错误:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ((DownloadListener)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt, paramString, i);
          continue;
          LogUtility.a(jdField_a_of_type_JavaLangString, "onDownloadError ###写码失败引起的..........11111");
          if ((paramDownloadInfo.d != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.d)) && (paramDownloadInfo.jdField_f_of_type_Int != 1) && (b()))
          {
            LogUtility.a(jdField_a_of_type_JavaLangString, "onDownloadError ###写码失败引起的..........");
            ThreadManager.b().post(new wwe(this, paramDownloadInfo));
            return;
          }
          paramDownloadInfo.a(4);
          if (paramDownloadInfo.jdField_f_of_type_Int == 1)
          {
            ThreadManager.b().post(new wwf(this, paramDownloadInfo));
            return;
          }
          ThreadManager.b().post(new wwg(this, paramDownloadInfo));
          return;
          paramString = CommonDataAdapter.a().a().getString(2131363021);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131363013);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131363014);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131363019);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131363020);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131363018);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131363012);
          if (paramDownloadInfo == null) {
            break label538;
          }
          if (paramDownloadInfo.jdField_f_of_type_Int == 1) {}
          for (localObject = paramDownloadInfo.jdField_h_of_type_JavaLangString; localObject != null; localObject = paramDownloadInfo.jdField_c_of_type_JavaLangString)
          {
            ThreadManager.b().post(new wwh(this, (String)localObject, paramDownloadInfo));
            break;
          }
          LogUtility.a(jdField_a_of_type_JavaLangString, "onDownloadError ###失败处理..........");
          i = 3;
          break;
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      b(paramString);
      return;
      label538:
      i = 10;
      continue;
      switch (paramInt)
      {
      }
      break label112;
      i = 10;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    int i;
    if ((AppInterface)a().get() != null)
    {
      i = 14;
      switch (paramDownloadInfo.jdField_j_of_type_Int)
      {
      default: 
        i = 40;
      }
    }
    for (;;)
    {
      Bundle localBundle1 = null;
      if (!TextUtils.isEmpty(paramDownloadInfo.e))
      {
        localBundle1 = new Bundle();
        localBundle1.putString("appname", paramDownloadInfo.e + ".apk");
      }
      Intent localIntent = new Intent("com.opensdk.downloadmanager.renameFilename");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("filePath", paramDownloadInfo.jdField_k_of_type_JavaLangString);
      localBundle2.putLong("dataLength", paramLong);
      localBundle2.putInt("fileSourceId", i);
      localBundle2.putBundle("otherData", localBundle1);
      localBundle2.putInt("peerType", -1);
      localIntent.putExtra("extraBundle", localBundle2);
      CommonDataAdapter.a().a().sendBroadcast(localIntent);
      return;
      i = 15;
      continue;
      i = 17;
      continue;
      i = 18;
      continue;
      i = 40;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "trafficReport info == null code = " + paramInt);
      return;
    }
    LogUtility.c(jdField_a_of_type_JavaLangString, "trafficReport code = " + paramInt);
    if ((paramInt >= 400) && (paramInt <= 599)) {
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "open appstore network error");
    }
    switch (paramInt)
    {
    default: 
      return;
    case -24: 
      a(paramDownloadInfo, 0L, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "package invalid");
      return;
    case 0: 
    case 5: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "do not need to handle error");
      return;
    case 4: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "DownloadSDK_START_FAILED_EXISTED");
      return;
    case 1: 
    case 601: 
    case 602: 
    case 603: 
    case 605: 
    case 701: 
    case 702: 
    case 706: 
    case 707: 
    case 708: 
    case 709: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "network error");
      return;
    case 3: 
    case 600: 
    case 604: 
    case 700: 
    case 704: 
    case 705: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "download error");
      return;
    }
    a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "write file error");
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong2 > 0L)
    {
      paramDownloadInfo.jdField_b_of_type_Long = paramLong1;
      e(paramDownloadInfo);
      a(paramString, paramLong2, paramDownloadInfo.jdField_j_of_type_Int);
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +11 -> 14
    //   6: aload_2
    //   7: getfield 832	com/tencent/apkupdate/logic/data/ApkUpdateDetail:updatemethod	I
    //   10: iconst_4
    //   11: if_icmpeq +20 -> 31
    //   14: getstatic 50	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: ldc_w 834
    //   20: invokestatic 117	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 835	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_2
    //   32: getfield 838	com/tencent/apkupdate/logic/data/ApkUpdateDetail:url	Ljava/lang/String;
    //   35: astore_3
    //   36: aload_2
    //   37: getfield 841	com/tencent/apkupdate/logic/data/ApkUpdateDetail:patchsize	I
    //   40: i2l
    //   41: lstore 4
    //   43: getstatic 50	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: new 52	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 843
    //   56: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload 4
    //   61: ldc2_w 844
    //   64: ldiv
    //   65: invokevirtual 848	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: ldc_w 850
    //   71: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 852
    //   77: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_3
    //   81: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 117	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_1
    //   91: aload_3
    //   92: putfield 273	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_1
    //   96: iconst_1
    //   97: putfield 271	com/tencent/open/downloadnew/DownloadInfo:jdField_f_of_type_Int	I
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual 835	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   105: goto -77 -> 28
    //   108: astore_2
    //   109: getstatic 50	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   112: ldc_w 854
    //   115: aload_2
    //   116: invokestatic 385	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 835	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   124: goto -96 -> 28
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	DownloadManager
    //   0	132	1	paramDownloadInfo	DownloadInfo
    //   0	132	2	paramApkUpdateDetail	ApkUpdateDetail
    //   35	57	3	str	String
    //   41	19	4	l	long
    // Exception table:
    //   from	to	target	type
    //   31	105	108	java/lang/Exception
    //   6	14	127	finally
    //   14	28	127	finally
    //   31	105	127	finally
    //   109	124	127	finally
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramDownloadListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramDownloadListener);
      }
      return;
    }
    finally
    {
      paramDownloadListener = finally;
      throw paramDownloadListener;
    }
  }
  
  public void a(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "unregisterLogListener logListener == null");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "unregisterLogListener");
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null)
        {
          this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterLogListener(paramITMAssistantDownloadLogListener);
          return;
        }
      }
      catch (Exception paramITMAssistantDownloadLogListener)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "unregisterLogListener Exception:", paramITMAssistantDownloadLogListener);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      AppNotificationManager.a().a(paramString);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    String[] arrayOfString = null;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      switch (paramInt)
      {
      }
    }
    while ((a() == null) || (arrayOfString == null))
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "application or tags is null");
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterDefaultDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterQQUpdateDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterGameCenterDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterOthersDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      switch (paramInt)
      {
      default: 
        arrayOfString = null;
        break;
      case 0: 
        arrayOfString = new String[] { "param_XGAppCenterDefaultDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 1: 
        arrayOfString = new String[] { "param_XGAppCenterQQUpdateDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 2: 
        arrayOfString = new String[] { "param_XGAppCenterGameCenterDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 3: 
        arrayOfString = new String[] { "param_XGAppCenterOthersDownloadFlow", "param_XGFlow", "param_Flow" };
      }
    }
    AppInterface localAppInterface = (AppInterface)a().get();
    if (localAppInterface == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "appinterface is null");
      return;
    }
    try
    {
      localAppInterface.a(localAppInterface.a(), arrayOfString, paramLong);
      LogUtility.c(jdField_a_of_type_JavaLangString, "sendAppDataIncerment logMsg: " + paramString + " ,fileSize : " + paramLong);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "appid is empty");
      return;
    }
    Object localObject = a(paramString);
    if (localObject == null)
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "clearDownloadInfo info == null");
      return;
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "clearDownloadInfo info =" + ((DownloadInfo)localObject).toString());
    if (((DownloadInfo)localObject).jdField_h_of_type_Int == 0) {
      if (((DownloadInfo)localObject).jdField_f_of_type_Int != 1) {
        break label127;
      }
    }
    label127:
    for (localObject = ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.b().post(new wvi(this, paramBoolean, (String)localObject));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      DownloadDBHelper.a().a(paramString);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i = 0;
    String str = "";
    Object localObject2 = new ArrayList();
    if (((Iterator)localObject1).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject1).next();
      if ((localDownloadInfo == null) || (localDownloadInfo.jdField_k_of_type_Int == 4) || (localDownloadInfo.jdField_k_of_type_Int == 1) || (localDownloadInfo.jdField_h_of_type_Int != 1)) {
        break label275;
      }
      ((ArrayList)localObject2).add(localDownloadInfo);
      if ((!TextUtils.isEmpty(str)) || (AppUtil.a(localDownloadInfo.d))) {
        break label272;
      }
      str = localDownloadInfo.e;
      label112:
      i += 1;
    }
    label257:
    label272:
    label275:
    for (;;)
    {
      break;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DownloadInfo)((Iterator)localObject1).next();
          ((DownloadInfo)localObject2).a(10);
          a(10, (DownloadInfo)localObject2);
        }
      }
      boolean bool = AppViewBaseActivity.b();
      if ((paramBoolean) && (i > 0))
      {
        localObject1 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
          break label257;
        }
      }
      for (str = str + "等";; str = "")
      {
        str = str + i + "款应用下载失败，请重新下载";
        if (!bool) {
          break;
        }
        ToastUtil.a().a(str, 1);
        return;
      }
      MyAppApi.a().a(true, str);
      return;
      break label112;
    }
  }
  
  public boolean a(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    if (paramApkWriteCodeListener == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = paramApkWriteCodeListener;
    return true;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    int i = 3;
    LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo DownloadInfo=" + paramDownloadInfo);
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    Object localObject;
    label264:
    label275:
    label286:
    long l1;
    long l2;
    if (localDownloadInfo != null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo cacheInfo =" + localDownloadInfo);
      if (localDownloadInfo.jdField_h_of_type_Int == 0)
      {
        LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.n = localDownloadInfo.n;
        if (localDownloadInfo.jdField_f_of_type_Int == 1)
        {
          localObject = localDownloadInfo.jdField_h_of_type_JavaLangString;
          localObject = a().a((String)localObject);
          if (localObject == null) {
            break label286;
          }
          LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo sdk getReceiveDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen + " getTotalDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
          paramDownloadInfo.jdField_l_of_type_Int = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
          paramDownloadInfo.a(a(((TMAssistantDownloadTaskInfo)localObject).mState));
          paramDownloadInfo.jdField_h_of_type_Int = 0;
          if (localDownloadInfo.jdField_f_of_type_Int != 1) {
            break label275;
          }
          if (!TextUtils.isEmpty(localDownloadInfo.jdField_k_of_type_JavaLangString)) {
            break label264;
          }
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        for (;;)
        {
          if (paramDownloadInfo.jdField_k_of_type_Int == 4)
          {
            paramDownloadInfo.p = localDownloadInfo.p;
            if (paramDownloadInfo.p != 0)
            {
              paramDownloadInfo.jdField_k_of_type_Int = 3;
              e(localDownloadInfo);
            }
          }
          return true;
          localObject = localDownloadInfo.jdField_c_of_type_JavaLangString;
          break;
          paramDownloadInfo.jdField_k_of_type_JavaLangString = localDownloadInfo.jdField_k_of_type_JavaLangString;
          continue;
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
        paramDownloadInfo.jdField_k_of_type_Int = -100;
        return true;
      }
      if (localDownloadInfo.jdField_h_of_type_Int == 1)
      {
        localObject = a(localDownloadInfo);
        if (localObject != null)
        {
          j = a(((TMAssistantDownloadTaskInfo)localObject).mState);
          i = j;
          if (j == -2) {
            i = 3;
          }
          paramDownloadInfo.a(i);
          paramDownloadInfo.jdField_h_of_type_Int = 1;
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
          l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
          paramDownloadInfo.jdField_l_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
          if (!MyAppApi.a().e()) {
            paramDownloadInfo.jdField_l_of_type_Int = 0;
          }
          return true;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
      }
    }
    do
    {
      return false;
      localObject = a(paramDownloadInfo);
    } while (localObject == null);
    int j = a(((TMAssistantDownloadTaskInfo)localObject).mState);
    if (j == -2) {}
    for (;;)
    {
      paramDownloadInfo.a(i);
      l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
      l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
      paramDownloadInfo.jdField_l_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
      if (!MyAppApi.a().e()) {
        paramDownloadInfo.jdField_l_of_type_Int = 0;
      }
      paramDownloadInfo.jdField_h_of_type_Int = 1;
      e(paramDownloadInfo);
      return true;
      i = j;
    }
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo1.a = paramDownloadInfo2.a;
    paramDownloadInfo1.jdField_b_of_type_Boolean = paramDownloadInfo2.jdField_b_of_type_Boolean;
    paramDownloadInfo1.jdField_h_of_type_Int = paramDownloadInfo2.jdField_h_of_type_Int;
    paramDownloadInfo1.jdField_g_of_type_JavaLangString = paramDownloadInfo2.jdField_g_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramDownloadInfo1.jdField_c_of_type_JavaLangString))
    {
      if (!paramDownloadInfo1.jdField_c_of_type_JavaLangString.equals(paramDownloadInfo2.jdField_c_of_type_JavaLangString))
      {
        a(paramDownloadInfo2.jdField_b_of_type_JavaLangString, false);
        return false;
      }
    }
    else {
      paramDownloadInfo1.jdField_c_of_type_JavaLangString = paramDownloadInfo2.jdField_c_of_type_JavaLangString;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    paramString = a().a(paramString);
    return (paramString != null) && (paramString.a() == 4);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      a(paramString1, false);
    }
    if (paramString2 != null)
    {
      if (!paramBoolean) {
        break label33;
      }
      a(10, paramString2);
    }
    for (;;)
    {
      return true;
      try
      {
        label33:
        AppNotificationManager.a().a(paramString2.jdField_f_of_type_JavaLangString);
      }
      catch (Exception paramString1)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", paramString1);
      }
    }
  }
  
  /* Error */
  public DownloadInfo b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +56 -> 62
    //   9: aload_0
    //   10: getfield 86	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 458	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   16: invokeinterface 464 1 0
    //   21: astore_3
    //   22: aload_3
    //   23: invokeinterface 469 1 0
    //   28: ifeq +34 -> 62
    //   31: aload_3
    //   32: invokeinterface 473 1 0
    //   37: checkcast 252	com/tencent/open/downloadnew/DownloadInfo
    //   40: astore_2
    //   41: aload_1
    //   42: aload_2
    //   43: getfield 254	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   46: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: istore 4
    //   51: iload 4
    //   53: ifeq -31 -> 22
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -6 -> 58
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	DownloadManager
    //   0	72	1	paramString	String
    //   40	17	2	localDownloadInfo	DownloadInfo
    //   21	11	3	localIterator	Iterator
    //   49	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	67	finally
    //   22	51	67	finally
  }
  
  public DownloadInfo b(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      int i = paramInt;
      if (paramInt == -2) {
        i = 3;
      }
      paramString.a(i);
    }
    return paramString;
  }
  
  public List b(String paramString)
  {
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = localArrayList2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject = a().getDownloadTaskInfosByVia(paramString);
      if (((List)localObject).size() == 0) {
        LogUtility.a(jdField_a_of_type_JavaLangString, "getTaskInfoFromSDK null via=" + paramString);
      }
      return (List)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
        ArrayList localArrayList1 = localArrayList2;
      }
    }
  }
  
  protected void b()
  {
    ThreadManager.b().postDelayed(new wvz(this), 5000L);
    ThreadManager.b().postDelayed(new wwa(this), 10000L);
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "complete info == null ");
        return;
      }
      finally {}
      LogUtility.a(jdField_a_of_type_JavaLangString, "onDownload complete, info = " + paramDownloadInfo.toString());
      if (paramDownloadInfo.jdField_h_of_type_Int == 0)
      {
        if (paramDownloadInfo.jdField_f_of_type_Int == 1) {
          ThreadManager.b().post(new wvm(this, paramDownloadInfo));
        } else {
          ThreadManager.b().post(new wvn(this, paramDownloadInfo));
        }
      }
      else {
        ThreadManager.b().post(new wvo(this, paramDownloadInfo));
      }
    }
  }
  
  public void b(DownloadListener paramDownloadListener)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramDownloadListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramDownloadListener);
      }
      return;
    }
    finally
    {
      paramDownloadListener = finally;
      throw paramDownloadListener;
    }
  }
  
  public void b(String paramString)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect showToast:" + paramString + " isResuming=" + AppViewBaseActivity.b());
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.jdField_c_of_type_Long > 1000L))
      {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        ToastUtil.a().a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "showToast>>>", paramString);
    }
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.i == 1;
  }
  
  public boolean b(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    if (paramApkWriteCodeListener == null) {}
    while ((this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener == null) || (paramApkWriteCodeListener != this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
    return true;
  }
  
  public boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      a(paramString1, true);
    }
    if (paramString2 != null)
    {
      if (paramBoolean) {
        a(10, paramString2);
      }
    }
    else {
      return true;
    }
    try
    {
      AppNotificationManager.a().a(paramString2.jdField_f_of_type_JavaLangString);
      return true;
    }
    catch (Exception paramString1)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", paramString1);
    }
    return true;
  }
  
  public DownloadInfo c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (((localDownloadInfo.jdField_f_of_type_Int == 0) && (paramString.equals(localDownloadInfo.jdField_c_of_type_JavaLangString))) || ((localDownloadInfo.jdField_f_of_type_Int == 1) && (paramString.equals(localDownloadInfo.jdField_h_of_type_JavaLangString))) || ((localDownloadInfo.jdField_f_of_type_Int == 2) && (paramString.equals(localDownloadInfo.jdField_c_of_type_JavaLangString)))) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public DownloadInfo c(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.jdField_l_of_type_Int = paramInt;
    }
    return paramString;
  }
  
  public List c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo != null) {
          if (localDownloadInfo.jdField_h_of_type_Int == 0)
          {
            if (localDownloadInfo.jdField_f_of_type_Int == 1)
            {
              paramString = localDownloadInfo.jdField_h_of_type_JavaLangString;
              label82:
              paramString = a().a(paramString);
              if (paramString == null) {
                break label231;
              }
              LogUtility.a(jdField_a_of_type_JavaLangString, "queryDownloadInfosByVia sdk getReceiveDataLen=" + paramString.mReceiveDataLen + " getTotalDataLen=" + paramString.mTotalDataLen);
              localDownloadInfo.jdField_l_of_type_Int = ((int)((float)paramString.mReceiveDataLen * 100.0F / (float)paramString.mTotalDataLen));
              localDownloadInfo.a(a(paramString.mState));
              if (localDownloadInfo.jdField_f_of_type_Int != 1) {
                break label219;
              }
              if (!TextUtils.isEmpty(localDownloadInfo.jdField_k_of_type_JavaLangString)) {}
            }
            label219:
            for (localDownloadInfo.jdField_k_of_type_JavaLangString = paramString.mSavePath;; localDownloadInfo.jdField_k_of_type_JavaLangString = paramString.mSavePath)
            {
              localArrayList.add(localDownloadInfo);
              break;
              paramString = localDownloadInfo.jdField_c_of_type_JavaLangString;
              break label82;
            }
            label231:
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
            DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
            DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void c()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20))) {
          a(localDownloadInfo.jdField_b_of_type_JavaLangString);
        }
      }
    }
    finally {}
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    Object localObject3 = null;
    if (paramDownloadInfo == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload info == null");
      return;
    }
    if (!paramDownloadInfo.jdField_c_of_type_Boolean)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload info is not apk");
      return;
    }
    Object localObject2 = "";
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.jdField_k_of_type_JavaLangString)) {
      if (paramDownloadInfo.jdField_h_of_type_Int == 0)
      {
        localTMAssistantDownloadTaskInfo = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo != null)
        {
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo.mState == 4) {
            localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = a(paramDownloadInfo);
          localObject2 = localObject1;
        }
        label106:
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
            localObject1 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((String)localObject1);
          paramDownloadInfo.a(4);
          e(paramDownloadInfo);
        }
      }
    }
    for (localObject2 = localObject1;; localObject2 = paramDownloadInfo.jdField_k_of_type_JavaLangString)
    {
      localObject1 = AppUtil.a((String)localObject2);
      LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.jdField_f_of_type_Int);
      if (localObject1 == null) {
        break label396;
      }
      if ((!AppUtil.a(CommonDataAdapter.a().a(), (String)localObject2)) || (!((String)localObject1).equals("com.tencent.android.qqdownloader")) || (!paramDownloadInfo.jdField_b_of_type_JavaLangString.equals("1101070898"))) {
        break;
      }
      LogUtility.a(jdField_a_of_type_JavaLangString, "report yyb start install");
      localObject3 = StaticAnalyz.a(paramDownloadInfo.jdField_g_of_type_JavaLangString, "NEWYYB");
      MyAppApi.a().b();
      localObject2 = MyAppApi.a().a();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramDownloadInfo.jdField_b_of_type_JavaLangString;
      }
      StaticAnalyz.a("311", (String)localObject3, (String)localObject1, paramDownloadInfo.jdField_m_of_type_JavaLangString);
      paramDownloadInfo = CommonDataAdapter.a().a();
      if (paramDownloadInfo == null) {
        break;
      }
      StaticAnalyz.a(paramDownloadInfo, "312", (String)localObject3, (String)localObject1);
      return;
      localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
      localObject1 = localObject2;
      if (localTMAssistantDownloadTaskInfo != null)
      {
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo.mState == 4) {
          localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label106;
      }
      localObject3 = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
      localObject2 = localObject1;
      break label106;
    }
    label396:
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject2);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      a(-2, paramDownloadInfo, -24, "");
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void d()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && (localDownloadInfo.jdField_h_of_type_Int == 1) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20)))
        {
          localDownloadInfo.a(3);
          a(3, localDownloadInfo);
        }
      }
    }
    finally {}
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onReveiveInstallIntent info=" + paramDownloadInfo);
    if (paramDownloadInfo.jdField_h_of_type_Int == 0) {
      StaticAnalyz.a("310", paramDownloadInfo.jdField_g_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_m_of_type_JavaLangString);
    }
    if (paramDownloadInfo.jdField_j_of_type_Int != 5) {
      a(paramDownloadInfo.jdField_b_of_type_JavaLangString, false);
    }
    AppNotificationManager.a().a(paramDownloadInfo.jdField_f_of_type_JavaLangString);
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   4: invokevirtual 515	java/util/concurrent/ConcurrentLinkedQueue:iterator	()Ljava/util/Iterator;
    //   7: astore_1
    //   8: aload_1
    //   9: invokeinterface 469 1 0
    //   14: ifeq +41 -> 55
    //   17: aload_0
    //   18: aload_1
    //   19: invokeinterface 473 1 0
    //   24: checkcast 517	com/tencent/open/downloadnew/DownloadListener
    //   27: invokevirtual 1115	com/tencent/open/downloadnew/DownloadManager:b	(Lcom/tencent/open/downloadnew/DownloadListener;)V
    //   30: goto -22 -> 8
    //   33: astore_1
    //   34: getstatic 50	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: ldc_w 1117
    //   40: aload_1
    //   41: invokestatic 370	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: ldc 2
    //   46: monitorenter
    //   47: aconst_null
    //   48: putstatic 202	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   51: ldc 2
    //   53: monitorexit
    //   54: return
    //   55: invokestatic 164	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   58: new 1119	wvp
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 1120	wvp:<init>	(Lcom/tencent/open/downloadnew/DownloadManager;)V
    //   66: invokevirtual 188	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   69: pop
    //   70: goto -26 -> 44
    //   73: astore_1
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	DownloadManager
    //   7	12	1	localIterator	Iterator
    //   33	8	1	localException	Exception
    //   73	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	33	java/lang/Exception
    //   8	30	33	java/lang/Exception
    //   55	70	33	java/lang/Exception
    //   47	54	73	finally
    //   74	77	73	finally
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {}
    try
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadInfo info = " + paramDownloadInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo);
      DownloadDBHelper.a().a(paramDownloadInfo);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200) {
      ThreadManager.b().postDelayed(new wvt(this), 3000L);
    }
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener != null)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener.a(paramDownloadInfo.d, paramDownloadInfo.jdField_g_of_type_Int, null);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
  }
  
  public void g(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "patchNewApkSuccess DownloadInfo|" + paramDownloadInfo);
    h(paramDownloadInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\DownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */