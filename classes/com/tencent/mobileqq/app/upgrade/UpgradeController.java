package com.tencent.mobileqq.app.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadQueryListener;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;
import qoe;

public final class UpgradeController
  implements Handler.Callback, AuthCodeWriter.ICheckCodeListener, DownloadListener, DownloadQueryListener, UpdateManager.OnCheckUpdateListener
{
  public static final int a = 0;
  private static UpgradeController jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController;
  public static final String a = "UpgradeController";
  public static final int b = 1;
  public static final String b = "qqupgrade";
  public static final int c = -1;
  public static final String c = "com.tencent.android.qqdownloader";
  public static final int d = 0;
  public static final String d = "100686848";
  public static final int e = 1;
  public static final int f = 2;
  private static final String f = "_100686848";
  public static final int g = 3;
  private static final String g = "ANDROIDQQ.QQUPDATE";
  public static final int h = 4;
  private static final String h = "6633";
  public static final int i = 100000;
  public static final int j = 100001;
  public static final int k = 100002;
  public static final int l = 100003;
  public static final int m = 100004;
  public static final int n = 100005;
  public static final int o = 100006;
  private static final int p = 1;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private AuthCodeWriter jdField_a_of_type_ComTencentMobileqqAppUpgradeAuthCodeWriter;
  private UpgradeController.AutoDownloadInWifiController jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private DownloadInfo jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  private boolean c;
  public volatile String e;
  private int q;
  
  private UpgradeController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    a(false);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 12) || (paramInt1 == 2)) && (a() == 4)) {
      return 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null)) {
      return 1;
    }
    String str;
    Bundle localBundle;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString;
      localBundle = new Bundle();
      localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, "100686848");
      localBundle.putString(DownloadConstants.i, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString(DownloadConstants.e, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
      localBundle.putInt(DownloadConstants.j, paramInt1);
      if (paramInt1 == 12) {
        localBundle.putBoolean(DownloadConstants.n, true);
      }
      localBundle.putString(DownloadConstants.h, "ANDROIDQQ.QQUPDATE");
      localBundle.putString(DownloadConstants.k, str);
      if (paramInt2 == 0) {
        break label319;
      }
      localBundle.putString(DownloadConstants.l, "_100686848");
      localBundle.putBoolean(DownloadConstants.w, false);
      i1 = paramInt2;
      if (paramInt1 != 5)
      {
        i1 = paramInt2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade != 0) {}
      }
    }
    for (int i1 = 0;; i1 = paramInt2)
    {
      localBundle.putString(DownloadConstants.b, "6633");
      localBundle.putInt(DownloadConstants.d, this.q);
      localBundle.putBoolean(DownloadConstants.f, true);
      localBundle.putBoolean(DownloadConstants.g, true);
      localBundle.putInt(DownloadConstants.m, 1);
      localBundle.putInt(DownloadConstants.z, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bGray);
      DownloadApi.a(BaseActivity.sTopActivity, localBundle, 1, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, i1);
      return 0;
      str = "新版手Q";
      break;
      label319:
      localBundle.putBoolean(DownloadConstants.w, true);
    }
  }
  
  private static PackageInfo a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
  }
  
  public static UpgradeController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController == null) {
      jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController = new UpgradeController();
    }
    return jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController;
  }
  
  public static String a()
  {
    String str2 = "";
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      localObject = ((UpgradeController)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          str1 = "" + ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId;
        }
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    return URLUtil.a(paramString, "nt", UpgradeConstants.a());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    Object localObject = a();
    boolean bool1 = bool3;
    if (localObject != null)
    {
      localObject = ((UpgradeController)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      bool1 = bool3;
      if (localObject != null)
      {
        bool1 = bool3;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
        {
          if ((((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch != 1)) {
            break label83;
          }
          bool1 = true;
          if (!bool1) {
            return bool1;
          }
          if (ConfigHandler.a(paramQQAppInterface, ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp)) {
            break label88;
          }
        }
      }
    }
    label83:
    label88:
    for (bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
    return bool1;
  }
  
  public static String b()
  {
    int i2 = 0;
    Object localObject = a();
    int i1 = i2;
    if (localObject != null)
    {
      localObject = ((UpgradeController)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      i1 = i2;
      if (localObject != null)
      {
        i1 = i2;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          i1 = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType;
        }
      }
    }
    return String.valueOf(i1);
  }
  
  private void b(int paramInt)
  {
    try
    {
      ConfigHandler localConfigHandler = (ConfigHandler)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a()).a(4);
      String str = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
      this.e = (str + "_" + paramInt);
      this.q = paramInt;
      localConfigHandler.a(str, paramInt, this.e);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void c(int paramInt)
  {
    if (this.b) {}
    UpgradeController.OnHandleUpgradeFinishListener localOnHandleUpgradeFinishListener;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localOnHandleUpgradeFinishListener = (UpgradeController.OnHandleUpgradeFinishListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localOnHandleUpgradeFinishListener == null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
      localOnHandleUpgradeFinishListener.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper, this);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "invokeStateChangedToListeners:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((UpgradeController.OnStateChangedListener)localIterator.next()).a(paramInt, this);
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();
    if (localObject == null) {
      return;
    }
    ConfigHandler.a((QQAppInterface)localObject, b());
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 1))
    {
      if (!paramBoolean) {
        break label213;
      }
      str = ConfigHandler.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    }
    for (;;)
    {
      try
      {
        BaseActivity localBaseActivity = BaseActivity.sTopActivity;
        if ((localBaseActivity != null) && (str != null) && (!str.startsWith("com.tencent.av.")) && (!str.equals("com.tencent.mobileqq.activity.UserguideActivity")) && (!str.equals("com.tencent.mobileqq.activity.UpgradeDetailActivity"))) {
          localBaseActivity.runOnUiThread(new qoe(this, localBaseActivity, (QQAppInterface)localObject));
        }
        localObject = ((QQAppInterface)localObject).a(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).obtainMessage(1134018).sendToTarget();
        }
      }
      catch (Exception localException)
      {
        int i1;
        label213:
        continue;
      }
      i1 = 0;
      if (NetworkUtil.i(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
        i1 = 1;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", Integer.toString(i1));
      ((HashMap)localObject).put("param_ErrMsg", "success");
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeErr", true, 0L, 0L, (HashMap)localObject, "", true);
      return;
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(1134018).sendToTarget();
      }
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.b = "100686848";
    localDownloadInfo.d = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
    localDownloadInfo.i = "6633";
    localDownloadInfo.g = this.q;
    localArrayList.add(localDownloadInfo);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "queryDownloadInfo:" + localDownloadInfo);
    }
    DownloadApi.a(localArrayList, this);
  }
  
  private void g()
  {
    try
    {
      if (!b())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController = new UpgradeController.AutoDownloadInWifiController(this);
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void h()
  {
    try
    {
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController.b();
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void i()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "initDownloadEnv: " + this.c);
      }
      if (!this.c)
      {
        UpdateManager.a().a(this);
        DownloadApi.a(this);
        this.c = true;
      }
      return;
    }
    finally {}
  }
  
  private void j()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "releaseDownloadEnv: " + this.c);
      }
      if (this.c)
      {
        UpdateManager.a().b(this);
        UpdateManager.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeAuthCodeWriter != null)
        {
          DownloadApi.b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeAuthCodeWriter);
          this.jdField_a_of_type_ComTencentMobileqqAppUpgradeAuthCodeWriter = null;
        }
        this.q = 0;
        DownloadApi.b(this);
        this.c = false;
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
    {
      i1 = i2;
      switch (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a())
      {
      default: 
        i1 = i2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "getDownloadState: " + i1);
      }
      return i1;
      i1 = 4;
      continue;
      i1 = 1;
      continue;
      i1 = 2;
      continue;
      i1 = 3;
    }
  }
  
  public UpgradeDetailWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1)) {}
    while (((this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h == 1)) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeWritten", bool, 0L, 0L, localHashMap, "", true);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onException:" + paramInt + ", " + paramString);
    }
    c(0);
  }
  
  public void a(Context paramContext)
  {
    int i2 = 1;
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a() != 4)) {
      return;
    }
    for (int i1 = i2;; i1 = 0)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h != 1) {
            continue;
          }
          i1 = i2;
        }
        a(5, i1);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UpgradeController", 2, "installApk:", paramContext);
      return;
    }
  }
  
  public void a(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadPause");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.jdField_a_of_type_Boolean = false;
    h();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadError: " + paramInt1 + ", " + paramString);
    }
    d(a());
    paramInt2 = paramInt1;
    if (NetworkUtil.i(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
      paramInt2 = paramInt1 | 0x1;
    }
    paramDownloadInfo = new HashMap();
    paramDownloadInfo.put("param_FailCode", Integer.toString(paramInt2));
    paramDownloadInfo.put("param_ErrMsg", paramString);
    StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeErr", false, 0L, 0L, paramDownloadInfo, "", true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "onCheckUpdateFailed");
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (ApkUpdateDetail)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int == paramArrayList.versioncode) && (paramArrayList.updatemethod == 4)) {
          this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramArrayList;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "onCheckUpdateSucceed:" + paramArrayList.url + " -- " + paramArrayList.updatemethod);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versioncode);
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ("100686848".equals(localDownloadInfo.b)) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = localDownloadInfo;
        }
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "onDownloadUpdate Status:" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a());
      }
      d(a());
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 2)) {
      return;
    }
    c();
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    j();
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.a();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = new UpgradeDetailWrapper(null, null);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    for (;;)
    {
      int i1;
      try
      {
        boolean bool = this.b;
        if (bool) {
          return;
        }
        if (!paramString1.equals(this.e)) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeAuthCodeWriter == null)
        {
          i1 = 1;
          if (!paramBoolean) {
            break label90;
          }
          if (i1 != 0) {
            f();
          }
          this.jdField_a_of_type_ComTencentMobileqqAppUpgradeAuthCodeWriter = new AuthCodeWriter(paramString2, this);
          DownloadApi.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeAuthCodeWriter);
          this.e = null;
          continue;
        }
        i1 = 0;
      }
      finally {}
      continue;
      label90:
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo = null;
        c(-1);
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == this.q) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.e == null)) {
        b(paramInt);
      }
      return bool;
    }
  }
  
  public boolean a(UpgradeInfo paramUpgradeInfo, UpgradeController.OnHandleUpgradeFinishListener paramOnHandleUpgradeFinishListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo = ConfigHandler.a(paramUpgradeInfo);
    if ((paramOnHandleUpgradeFinishListener == null) || (paramUpgradeInfo == null)) {}
    while ((paramUpgradeInfo.iUpgradeType == 0) || (this.b)) {
      return false;
    }
    i();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnHandleUpgradeFinishListener);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "handleUpgradeInfo packageName = " + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ", bGray = " + paramUpgradeInfo.bGray + ", versioncode = " + this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
    }
    paramUpgradeInfo = new ApkUpdateParam(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName(), paramUpgradeInfo.bGray, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
    paramOnHandleUpgradeFinishListener = new ArrayList();
    paramOnHandleUpgradeFinishListener.add(paramUpgradeInfo);
    UpdateManager.a().b(paramOnHandleUpgradeFinishListener);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (b())) {
      c();
    }
  }
  
  public void b(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadWait");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void b(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = ((DownloadInfo)paramList.get(0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onResult Status:" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
    c(0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "startDownload:" + paramBoolean + ", " + this.jdField_a_of_type_Boolean);
    }
    if (a() == 4) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramBoolean)
    {
      g();
      return;
    }
    c(false);
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController != null;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 21
    //   10: iconst_2
    //   11: ldc_w 629
    //   14: invokestatic 324	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 274	com/tencent/mobileqq/app/upgrade/UpgradeController:jdField_a_of_type_Boolean	Z
    //   21: ifeq +21 -> 42
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 274	com/tencent/mobileqq/app/upgrade/UpgradeController:jdField_a_of_type_Boolean	Z
    //   29: aload_0
    //   30: invokevirtual 631	com/tencent/mobileqq/app/upgrade/UpgradeController:e	()V
    //   33: aload_0
    //   34: invokespecial 527	com/tencent/mobileqq/app/upgrade/UpgradeController:h	()V
    //   37: ldc 37
    //   39: invokestatic 633	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: goto -13 -> 33
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	UpgradeController
    //   45	1	1	localException	Exception
    //   49	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	33	45	java/lang/Exception
    //   2	17	49	finally
    //   17	29	49	finally
    //   29	33	49	finally
    //   33	42	49	finally
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadFinish");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = paramDownloadInfo.k;
    Object localObject2 = a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, (String)localObject1);
    paramDownloadInfo = "";
    int i1;
    if (localObject2 != null)
    {
      i1 = ((PackageInfo)localObject2).versionCode;
      paramDownloadInfo = ((PackageInfo)localObject2).packageName;
    }
    for (;;)
    {
      int i3 = ApkUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName().equals(paramDownloadInfo)) && (i3 > 0) && (i1 >= i3))
      {
        d(a());
        d(true);
        h();
        return;
      }
      boolean bool = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean;
      if (bool)
      {
        DownloadApi.a("_100686848");
        localObject2 = PluginStatic.encodeFile((String)localObject1);
        h();
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new HashMap();
        if (i1 >= i3) {
          break label315;
        }
      }
      label315:
      for (i1 = 101;; i1 = 9527)
      {
        ((HashMap)localObject1).put("param_FailCode", Integer.toString(i1));
        ((HashMap)localObject1).put("param_ErrMsg", "MD5:" + (String)localObject2 + "_PN:" + paramDownloadInfo);
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeErr", false, 0L, 0L, (HashMap)localObject1, "", true);
        if (bool) {
          break;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(0);
        return;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean = false;
        if (!b()) {}
        for (int i2 = 1;; i2 = 0)
        {
          a(10, i2);
          break;
        }
      }
      i1 = 0;
    }
  }
  
  public void c(String paramString1, String paramString2) {}
  
  void c(boolean paramBoolean)
  {
    int i2 = 1;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod != 4)) {
        break label55;
      }
    }
    label55:
    for (int i1 = 12;; i1 = 2)
    {
      if (paramBoolean) {
        i2 = 0;
      }
      a(i1, i2);
      return;
    }
  }
  
  public void d()
  {
    int i2 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "resumeDownload:");
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4) {
        i1 = 12;
      }
    }
    if (!b()) {}
    for (i2 = 1;; i2 = 0)
    {
      a(i1, i2);
      return;
    }
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadCancel");
    }
    this.jdField_a_of_type_Boolean = false;
    h();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "pauseDownload:");
    }
    if (!b()) {}
    for (int i1 = 1;; i1 = 0)
    {
      a(3, i1);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      Toast.makeText(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 2131363012, 0).show();
      return true;
    }
    catch (Throwable paramMessage)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\upgrade\UpgradeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */