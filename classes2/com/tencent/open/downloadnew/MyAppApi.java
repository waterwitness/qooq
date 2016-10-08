package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.io.File;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import wwl;
import wwm;
import wwn;
import wwq;
import wwr;
import wws;
import wwt;
import wwu;
import wwv;
import www;
import wwx;
import wxb;
import wxe;

public class MyAppApi
{
  protected static final int a = 3;
  protected static MyAppApi a;
  protected static final String a = "MyAppApi";
  protected static final int b = 0;
  protected static final int c = 1;
  protected long a;
  protected DialogInterface.OnClickListener a;
  public MyAppApi.InstallParams a;
  protected MyAppApi.YYBDownloadListener a;
  public MyAppDialog a;
  protected ITMAssistantCallBackListener a;
  public TMAssistantCallYYBParamStruct a;
  public TMAssistantBaseCallYYB a;
  protected boolean a;
  protected long b;
  TMAssistantCallYYBParamStruct b;
  public String b;
  protected boolean b;
  protected final long c;
  public boolean c;
  public long d;
  boolean d;
  public boolean e;
  
  protected MyAppApi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener = new MyAppApi.QQDownloadListener(this);
    this.jdField_b_of_type_Long = -1L;
    this.c = 180000L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    try
    {
      a();
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtility.c("MyAppApi", "MyAppApi init>>>", localThrowable);
      }
    }
  }
  
  public static MyAppApi a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = new MyAppApi();
      }
      MyAppApi localMyAppApi = jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
      return localMyAppApi;
    }
    finally {}
  }
  
  /* Error */
  public static boolean d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 73	com/tencent/open/downloadnew/MyAppApi:jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi	Lcom/tencent/open/downloadnew/MyAppApi;
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
    //   6	2	0	localMyAppApi	MyAppApi
    //   23	5	0	localObject	Object
    //   12	8	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public int a()
  {
    return TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a());
  }
  
  public int a(Bundle paramBundle)
  {
    int j = 1;
    int i = j;
    if (paramBundle != null)
    {
      i = j;
      if (paramBundle.getInt(DownloadConstants.j) == 3) {
        i = 2;
      }
    }
    return i;
  }
  
  public long a(Bundle paramBundle)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {
        return -1L;
      }
      LogUtility.c("MyAppApi", "--addDownloadTaskFromTmast--params = " + paramBundle);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("url");
        b();
        long l = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.addDownloadTaskFromTmast(paramBundle);
        return l;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  protected long a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("MyAppApi", "--addDownloadTaskFromTaskList--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = paramBundle;
    b();
    return this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.addDownloadTaskFromTaskList(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public DownloadInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.h = 1;
    localDownloadInfo.jdField_b_of_type_JavaLangString = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localDownloadInfo.jdField_i_of_type_JavaLangString = paramTMAssistantCallYYBParamStruct.taskAppId;
    localDownloadInfo.d = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localDownloadInfo.j = paramTMAssistantCallYYBParamStruct.taskApkId;
    localDownloadInfo.jdField_g_of_type_Int = paramTMAssistantCallYYBParamStruct.taskVersion;
    if (paramBundle != null)
    {
      localDownloadInfo.jdField_g_of_type_JavaLangString = paramBundle.getString(DownloadConstants.h);
      localDownloadInfo.e = paramBundle.getString(DownloadConstants.k);
      localDownloadInfo.c = paramBundle.getString(DownloadConstants.jdField_i_of_type_JavaLangString);
      localDownloadInfo.jdField_i_of_type_Int = paramBundle.getInt(DownloadConstants.D);
    }
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!b()) || (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null)) {
      return null;
    }
    paramBundle = a(paramBundle);
    c();
    if (a() <= 2)
    {
      paramBundle = ((TMAssistantCallYYB_V1)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).getDownloadTaskState(paramBundle);
      if (paramBundle != null) {
        return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
      }
      return null;
    }
    paramBundle = ((TMAssistantCallYYB_V2)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).getDownloadTaskState(paramBundle);
    if (paramBundle != null) {
      return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
    }
    return null;
  }
  
  protected TMAssistantCallYYBParamStruct a(Bundle paramBundle)
  {
    String str3 = paramBundle.getString(DownloadConstants.a);
    String str4 = paramBundle.getString(DownloadConstants.jdField_b_of_type_JavaLangString);
    String str5 = paramBundle.getString(DownloadConstants.c);
    String str6 = paramBundle.getString(DownloadConstants.e);
    Object localObject1 = paramBundle.getString(DownloadConstants.h);
    int i = paramBundle.getInt(DownloadConstants.d);
    String str1;
    Object localObject3;
    Object localObject2;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = StaticAnalyz.a((String)localObject1, "NEWYYB");
      localObject3 = paramBundle.getString(DownloadConstants.u);
      localObject1 = paramBundle.getString(DownloadConstants.v);
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = Long.valueOf(CommonDataAdapter.a().a()).toString();
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "qqNumber";
      }
      paramBundle.getString(DownloadConstants.y);
      localObject1 = paramBundle.getString(DownloadConstants.A);
      j = paramBundle.getInt(DownloadConstants.z);
      if (j != 1) {
        break label227;
      }
      paramBundle = "ANDROIDQQ-gray";
      localObject1 = "1";
    }
    for (;;)
    {
      LogUtility.b("State_Log", " channelId:" + paramBundle);
      return new TMAssistantCallYYBParamStruct(str3, str4, str5, i, str1, str6, (String)localObject2, (String)localObject3, paramBundle, (String)localObject1);
      str1 = StaticAnalyz.a((String)localObject1, "YYB");
      break;
      label227:
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramBundle = "ANDROIDQQ";
        localObject1 = j + "";
      }
      else
      {
        String str2 = j + "";
        paramBundle = (Bundle)localObject1;
        localObject1 = str2;
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle != null)) {
      return this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a);
    }
    return "";
  }
  
  protected void a()
  {
    if (a() <= 2) {}
    for (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V1.getInstance();; this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance())
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(CommonDataAdapter.a().a());
      g();
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.b().post(new wws(this, paramActivity));
  }
  
  protected void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, int paramInt3, boolean paramBoolean, String paramString2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog");
    LogUtility.c("MyAppApi", "-showTipDialog-");
    if (paramActivity == null) {
      return;
    }
    Resources localResources = paramActivity.getResources();
    String str2;
    label56:
    String str1;
    if (paramInt2 == 1) {
      if (paramInt1 == 2)
      {
        paramInt1 = 1;
        if (!TextUtils.isEmpty(paramString2)) {
          break label324;
        }
        str2 = ControlPolicyUtil.a(paramInt1, paramInt3);
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {}
        switch (paramInt1)
        {
        default: 
          str1 = localResources.getString(2131363027);
          label110:
          if (((paramInt1 != 2) && (paramInt1 != 4)) || (!TextUtils.isEmpty(paramString2))) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = String.format(str1, new Object[] { paramString1 });
        str1 = localResources.getString(2131363023);
        paramString2 = new MyAppDialog(paramActivity);
        paramString2.b(2131363024, paramOnClickListener2, true);
        if (!paramBoolean)
        {
          paramBoolean = true;
          paramString2.a(2131363025, paramOnClickListener1, paramBoolean);
          paramString2.a(str1);
          paramString2.b(paramString1);
          paramString2.setCancelable(true);
          paramString2.setOnCancelListener(paramOnCancelListener);
          paramString2.setOnDismissListener(new wxe(this));
          if ((!(paramActivity instanceof AppActivity)) || (((AppActivity)paramActivity).isResume())) {
            break label469;
          }
          LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---cancel !isResume");
          return;
          if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
          {
            paramInt1 = 2;
            break;
          }
          paramInt1 = 1;
          break;
          if (paramInt1 == 2)
          {
            paramInt1 = 3;
            break;
          }
          if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
          {
            paramInt1 = 4;
            break;
          }
          paramInt1 = 3;
          break;
          label324:
          str2 = paramString2;
          break label56;
          str1 = localResources.getString(2131363027);
          break label110;
          str1 = localResources.getString(2131363028, new Object[] { paramString1 });
          break label110;
          str1 = localResources.getString(2131363029);
          break label110;
          str1 = localResources.getString(2131363030, new Object[] { paramString1 });
        }
      }
      catch (Exception paramString2)
      {
        if (paramInt1 == 2)
        {
          paramString1 = localResources.getString(2131363027);
          LogUtility.c("MyAppApi", " errorMsg = " + paramString2.getMessage());
          continue;
        }
        paramString1 = localResources.getString(2131363029);
        continue;
        paramBoolean = false;
        continue;
      }
      try
      {
        label469:
        if (!paramActivity.isFinishing()) {
          paramString2.show();
        }
        LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---complete");
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = paramString2;
        return;
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          paramActivity.printStackTrace();
        }
      }
      paramString1 = str1;
    }
  }
  
  public void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {}
    label100:
    label121:
    label130:
    TicketUtils localTicketUtils;
    do
    {
      return;
      boolean bool = ControlPolicyUtil.d();
      long l = CommonDataAdapter.a().a();
      int i;
      if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long))
      {
        i = 1;
        if (i != 0) {
          break label130;
        }
        c();
        if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct == null) {
          break label121;
        }
        if (a() > 2) {
          break label100;
        }
        ((TMAssistantCallYYB_V1)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
        return;
        i = 0;
        break;
        ((TMAssistantCallYYB_V2)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      }
      LogUtility.e("MyAppApi", "startToAuthorizedDirect lastAuthorizeParam = null, needCarryQQIdentity = false");
      return;
      localTicketUtils = new TicketUtils();
      localTicketUtils.a(new wwn(this, localTicketUtils, l, paramActivity, paramOnClickListener));
    } while (!(paramActivity instanceof BaseActivity));
    localTicketUtils.a(((BaseActivity)paramActivity).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--handleDownloadAction");
    int i = -1;
    c();
    try
    {
      j = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        boolean bool5;
        DownloadInfo localDownloadInfo;
        localException1.printStackTrace();
        continue;
        bool1 = false;
      }
      if (i == 2) {
        break label283;
      }
    }
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.f, false);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.jdField_g_of_type_JavaLangString, true);
    int k = paramBundle.getInt(DownloadConstants.m);
    int j = paramBundle.getInt(DownloadConstants.j);
    String str2 = paramBundle.getString(DownloadConstants.h);
    String str1 = paramBundle.getString(DownloadConstants.a);
    int m = paramBundle.getInt(DownloadConstants.s, 0);
    int n = paramBundle.getInt(DownloadConstants.t, 0);
    boolean bool4 = ControlPolicyUtil.e();
    bool5 = ControlPolicyUtil.g();
    LogUtility.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool4);
    localDownloadInfo = DownloadManager.a().a(str1);
    boolean bool1;
    if ((localDownloadInfo != null) && (localDownloadInfo.h == 1))
    {
      bool1 = true;
      if (((bool4) && (bool5)) || (bool1)) {
        break label271;
      }
      if (paramOnClickListener != null)
      {
        LogUtility.a("MyAppApi", "allowMyApp=" + bool4 + " allowMyAppDownload=" + bool5 + " taskExist=" + bool1);
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
    }
    for (;;)
    {
      return;
      label271:
      if (i == 1) {
        label283:
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a() == paramActivity)
          {
            LogUtility.a("MyAppApi", "tipDialog is showing return");
            return;
          }
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
        for (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null; (!ControlPolicyUtil.f()) || ((j != 2) && (j != 12)); this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null)
        {
          LogUtility.a("MyAppApi", "not allowShowDialog return actionCode = " + j);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(null, 0);
          }
          StaticAnalyz.a("200", str2, str1);
          return;
        }
        ThreadManager.b().post(new wwu(this, str2, str1));
        bool4 = ControlPolicyUtil.a();
        wwv localwwv = new wwv(this, bool2, paramOnClickListener, paramBundle, k, bool4, paramActivity, str2, bool1, bool3, str1);
        MyAppApi.ClickListenerProxy localClickListenerProxy = new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str2, str1);
        MyAppApi.BackListener localBackListener = new MyAppApi.BackListener(this, str2, str1);
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (n > 0)
        {
          localObject1 = localObject2;
          if (m > 0)
          {
            k = n - m;
            localObject1 = localObject2;
            if (k > 0) {
              localObject1 = YybHandleUtil.a(k);
            }
          }
        }
        a(paramActivity, j, i, (String)localObject1, localwwv, localClickListenerProxy, localBackListener, paramBundle.getInt("source"), bool4, paramBundle.getString(DownloadConstants.o));
        ThreadManager.b().post(new www(this, str2, str1));
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
        return;
        if (i != 0) {
          continue;
        }
        if ((ControlPolicyUtil.h()) || (bool1))
        {
          paramOnClickListener = StaticAnalyz.a(str2, "YYB");
          if (k == 0) {
            a(paramActivity, paramBundle, bool2, bool3);
          }
          while ((localObject1 == null) && ((j == 2) || (j == 12)))
          {
            StaticAnalyz.a("202", paramOnClickListener, str1);
            return;
            a(paramActivity, paramBundle, bool2, bool3);
          }
          StaticAnalyz.a("200", paramOnClickListener, str1);
          return;
        }
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(null, 0);
        }
        StaticAnalyz.a("200", str2, str1);
        return;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    new YybHandleUtil.InstallBaseTask(paramActivity, paramString).execute(new Void[0]);
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt)
  {
    LogUtility.c("MyAppApi", "downloadYyb");
    if (paramInt == 1) {
      DownloadApi.a("_1101070898");
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener == null)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = new MyAppApi.YYBDownloadListener(this);
      DownloadManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
    }
    Object localObject = DownloadManager.a().a("1101070898");
    LogUtility.c("MyAppApi", "---startDownloadYYB---");
    if (localObject != null)
    {
      if (paramInt == 1)
      {
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = false;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = true;
      }
      for (((DownloadInfo)localObject).n = 1;; ((DownloadInfo)localObject).n = 0)
      {
        ((DownloadInfo)localObject).jdField_g_of_type_JavaLangString = paramString;
        DownloadManager.a().e((DownloadInfo)localObject);
        DownloadManager.a().a((DownloadInfo)localObject);
        return;
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = true;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = false;
      }
    }
    String str = ControlPolicyUtil.a();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "http://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    a(paramActivity, (String)localObject, paramString, paramInt, false);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    LogUtility.c("MyAppApi", "startDownloadYyb");
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "http://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    localBundle.putString(DownloadConstants.a, "1101070898");
    localBundle.putString(DownloadConstants.jdField_i_of_type_JavaLangString, str);
    localBundle.putString(DownloadConstants.e, "com.tencent.android.qqdownloader");
    localBundle.putInt(DownloadConstants.j, 2);
    localBundle.putString(DownloadConstants.h, paramString2);
    localBundle.putString(DownloadConstants.k, "应用宝");
    if (paramInt == 1) {
      localBundle.putBoolean(DownloadConstants.w, true);
    }
    for (;;)
    {
      localBundle.putInt(DownloadConstants.B, paramInt);
      localBundle.putString(DownloadConstants.l, "yyb");
      localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, "5848");
      localBundle.putBoolean(DownloadConstants.f, true);
      localBundle.putBoolean(DownloadConstants.jdField_g_of_type_JavaLangString, paramBoolean);
      localBundle.putInt(DownloadConstants.m, 1);
      DownloadApi.a(paramActivity, localBundle, 0, null, 0);
      return;
      localBundle.putBoolean(DownloadConstants.w, false);
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    boolean bool = ControlPolicyUtil.d();
    long l = CommonDataAdapter.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {
      i = 1;
    }
    Object localObject;
    label281:
    int j;
    while ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
    {
      localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
      DownloadManager.a().e((DownloadInfo)localObject);
      try
      {
        LogUtility.a("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via);
        LogUtility.c("TIME-STATISTIC", "downloadSdk.startToDownloadTaskList");
        c();
        if (a() > 2) {
          break label281;
        }
        ((TMAssistantCallYYB_V1)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
        return;
      }
      catch (Exception paramContext)
      {
        LogUtility.e("MyAppApi", "--startToDownloadTaskList--Exception = " + paramContext);
        return;
      }
      i = 0;
      continue;
      i = paramBundle.getInt(DownloadConstants.j);
      j = a(paramBundle);
      if (i != 3) {
        break label386;
      }
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    label386:
    for (;;)
    {
      ((TMAssistantCallYYB_V2)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
      return;
      localObject = new TicketUtils();
      ((TicketUtils)localObject).a(new wxb(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
      if (!(paramContext instanceof BaseActivity)) {
        break;
      }
      ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
      return;
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    ThreadManager.b().post(new wwm(this, paramString, paramOnClickListener, paramActivity));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_JavaLangString = paramString;
    } while (!this.jdField_d_of_type_Boolean);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
    localEditor.putBoolean("showToast", this.jdField_d_of_type_Boolean);
    localEditor.putString("toast_msg", paramString);
    localEditor.commit();
  }
  
  protected boolean a()
  {
    return !TMAssistantCallYYB_V1.isExistActoin(this.jdField_a_of_type_Long);
  }
  
  public boolean a(Context paramContext, Bundle paramBundle)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToWebView");
    if (paramBundle == null) {
      return false;
    }
    paramBundle = paramBundle.getString("url");
    LogUtility.c("TIME-STATISTIC", "downloadSdk.startToAppDetail");
    c();
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.startToWebView(paramContext, paramBundle);
    return true;
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToAppDetail ");
    if (paramBundle == null) {
      return false;
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    if (!DownloadApi.b(localTMAssistantCallYYBParamStruct.SNGAppId)) {
      return false;
    }
    boolean bool = ControlPolicyUtil.d();
    long l = CommonDataAdapter.a().a();
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {}
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
      {
        localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
        DownloadManager.a().e((DownloadInfo)localObject);
      }
      for (;;)
      {
        try
        {
          LogUtility.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via + " autoDownload=" + paramBoolean1 + " autoInstall=" + paramBoolean2);
          LogUtility.c("TIME-STATISTIC", "downloadSdk.startToAppDetail");
          c();
          if (a() <= 2)
          {
            ((TMAssistantCallYYB_V1)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
          }
          else
          {
            i = paramBundle.getInt(DownloadConstants.j);
            int j = a(paramBundle);
            if (i == 3)
            {
              paramBoolean1 = false;
              paramBoolean2 = false;
              ((TMAssistantCallYYB_V2)this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
            }
          }
        }
        catch (Exception paramContext)
        {
          LogUtility.b("MyAppApi", "startToAppDetail err", paramContext);
          return false;
        }
        localObject = new TicketUtils();
        ((TicketUtils)localObject).a(new wwx(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
        if ((paramContext instanceof BaseActivity)) {
          ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
        }
        return true;
      }
      return true;
    }
  }
  
  public long b(Bundle paramBundle)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {
        return -1L;
      }
      LogUtility.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("url");
        b();
        if (!TextUtils.isEmpty(paramBundle))
        {
          if ((paramBundle.startsWith("tmast")) || (paramBundle.startsWith("tpmast"))) {
            return this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.addDownloadTaskFromTmast(paramBundle);
          }
          long l = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.addDownloadTaskFromWebview(paramBundle);
          return l;
        }
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  protected long b(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {}
    while (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = paramBundle;
    b();
    return this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.addDownloadTaskFromAppDetail(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance();
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(CommonDataAdapter.a().a());
    g();
  }
  
  public void b(Activity paramActivity)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    LogUtility.c("MyAppApi", "judgeInstallFlag -- installedFlag = " + this.jdField_a_of_type_Boolean + "installTime = " + this.jdField_b_of_type_Long + " countTime =" + l);
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Long != -1L) && (l <= 180000L)) {
        break label341;
      }
      i = 1;
      if (!b()) {
        break label408;
      }
      if (a()) {
        break label346;
      }
      this.jdField_b_of_type_Boolean = false;
      label107:
      if ((!this.jdField_b_of_type_Boolean) && (i == 0))
      {
        if (this.jdField_a_of_type_Long != -1L)
        {
          c();
          this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if (!ControlPolicyUtil.h()) {
          break label383;
        }
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null)
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int != 0) {
            break label354;
          }
          a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      e();
      if ((!this.jdField_d_of_type_Boolean) && (!b()))
      {
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0);
        this.jdField_d_of_type_Boolean = paramActivity.getBoolean("showToast", false);
        this.jdField_b_of_type_JavaLangString = paramActivity.getString("toast_msg", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (!b()) {
          new Handler(Looper.getMainLooper()).postDelayed(new wwt(this), 2000L);
        }
        this.jdField_d_of_type_Boolean = false;
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
        paramActivity.putBoolean("showToast", this.jdField_d_of_type_Boolean);
        paramActivity.commit();
      }
      return;
      label341:
      i = 0;
      break;
      label346:
      this.jdField_b_of_type_Boolean = true;
      break label107;
      label354:
      a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
      continue;
      label383:
      if ((i != 0) || (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
        continue;
      }
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      continue;
      try
      {
        label408:
        if (new File(CommonDataAdapter.a().a().getFilesDir() + File.separator + "yyb_via_info.txt").exists()) {
          CommonDataAdapter.a().a().deleteFile("yyb_via_info.txt");
        }
        if ((this.jdField_b_of_type_Boolean) || (i != 0)) {
          continue;
        }
        if (this.jdField_a_of_type_Long != -1L)
        {
          c();
          this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if ((i != 0) || (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
          continue;
        }
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      catch (Exception paramActivity)
      {
        for (;;) {}
      }
    }
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    c();
    if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null)
    {
      a();
      return;
    }
    int i = -1;
    try
    {
      j = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException)
    {
      int j;
      boolean bool1;
      boolean bool2;
      int k;
      int m;
      String str2;
      DownloadInfo localDownloadInfo;
      for (;;)
      {
        boolean bool3;
        boolean bool4;
        String str1;
        localException.printStackTrace();
        continue;
        j = 0;
      }
      if ((i != 2) && (i != 1)) {
        break label241;
      }
      if (paramOnClickListener == null) {
        break label230;
      }
      paramOnClickListener.onClick(null, 0);
      StaticAnalyz.a("202", str2, localException);
      return;
      if ((!ControlPolicyUtil.h()) && (j == 0)) {
        break label328;
      }
      if (k != 0) {
        break label305;
      }
      a(paramActivity, paramBundle, bool1, bool2);
      for (;;)
      {
        paramActivity = StaticAnalyz.a(str2, "YYB");
        if ((localDownloadInfo != null) || ((m != 2) && (m != 12))) {
          break;
        }
        StaticAnalyz.a("202", paramActivity, localException);
        return;
        a(paramActivity, paramBundle, bool1, bool2);
      }
      StaticAnalyz.a("200", paramActivity, localException);
      return;
      if (paramOnClickListener == null) {
        break label340;
      }
      paramOnClickListener.onClick(null, 0);
      StaticAnalyz.a("200", str2, localException);
    }
    bool1 = paramBundle.getBoolean(DownloadConstants.f, false);
    bool2 = paramBundle.getBoolean(DownloadConstants.jdField_g_of_type_JavaLangString, true);
    k = paramBundle.getInt(DownloadConstants.m);
    m = paramBundle.getInt(DownloadConstants.j);
    bool3 = ControlPolicyUtil.e();
    bool4 = ControlPolicyUtil.g();
    str1 = paramBundle.getString(DownloadConstants.a);
    str2 = paramBundle.getString(DownloadConstants.h);
    localDownloadInfo = DownloadManager.a().a(str1);
    if ((localDownloadInfo != null) && (localDownloadInfo.h == 1))
    {
      j = 1;
      LogUtility.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool3);
      if (((bool3) && (bool4)) || (j != 0)) {
        break label206;
      }
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
    }
    label206:
    label230:
    label241:
    label305:
    label328:
    label340:
    return;
  }
  
  public void b(Activity paramActivity, String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      long l2 = ControlPolicyUtil.a();
      l1 = l2;
      if (l2 > 0L) {}
    }
    for (long l1 = 2000L;; l1 = 0L)
    {
      ThreadManager.b().postDelayed(new wwr(this, paramActivity, paramString), l1);
      return;
    }
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    for (;;)
    {
      String str5;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        String str3 = localJSONObject.optString("appid", "");
        localJSONObject.optString("myAppid", "");
        localJSONObject.optString("apkId", "");
        String str2 = localJSONObject.optString("versionCode", "");
        String str4 = localJSONObject.optString("via", "");
        localJSONObject.optString("appPackageName", "");
        str5 = localJSONObject.optString("appName", "该游戏");
        localJSONObject.optString("channelId", "");
        String str1 = localJSONObject.optString("appAuthorizedStr", "");
        Bundle localBundle = new Bundle();
        paramString = str2;
        if (TextUtils.isEmpty(str2)) {
          paramString = "1";
        }
        int i = Integer.parseInt(paramString);
        localBundle.putString(DownloadConstants.a, localJSONObject.optString("appid", ""));
        localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, localJSONObject.optString("myAppid", ""));
        localBundle.putString(DownloadConstants.c, localJSONObject.optString("apkId"));
        localBundle.putInt(DownloadConstants.d, i);
        localBundle.putString(DownloadConstants.e, localJSONObject.optString("appPackageName"));
        localBundle.putString(DownloadConstants.h, localJSONObject.optString("via"));
        localBundle.putString(DownloadConstants.k, localJSONObject.optString("appName"));
        localBundle.putString(DownloadConstants.y, localJSONObject.optString("channelId"));
        localBundle.putString(DownloadConstants.A, localJSONObject.optString("channel"));
        localBundle.putString(DownloadConstants.u, localJSONObject.optString("uin"));
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = a(localBundle);
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.actionFlag = "2";
        if (b())
        {
          a(paramActivity, paramOnClickListener);
          return;
        }
        if (!TextUtils.isEmpty(str1))
        {
          paramString = str1;
          boolean bool = ControlPolicyUtil.a();
          a(paramActivity, 1, 1, "0", new wwq(this, localBundle, bool, paramActivity, str4, paramOnClickListener, str3), new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str4, str3), new MyAppApi.BackListener(this, str4, str3), 0, bool, paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = str5 + "限量内测中，可以到应用宝抢号并下载游戏哦~";
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    try
    {
      c();
      int i = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.checkQQDownloaderInstalled();
      if ((i == 2) || (i == 1)) {
        bool = false;
      }
      return bool;
    }
    catch (Exception localException)
    {
      LogUtility.c("MyAppApi", "hasValidQQDownloader>>>", localException);
    }
    return false;
  }
  
  public boolean b(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    LogUtility.c("TIME-STATISTIC", "downloadSdk.startToDownloadListWithParams");
    c();
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.startToDownloadTaskListWithParams(paramContext, paramBundle);
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {
      a();
    }
    for (;;)
    {
      return;
      if (((a() <= 2) && ((this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB instanceof TMAssistantCallYYB_V1))) || ((a() == 3) && ((this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB instanceof TMAssistantCallYYB_V2)))) {}
      for (int i = 0; i != 0; i = 1)
      {
        a();
        return;
      }
    }
  }
  
  public void c(Activity paramActivity)
  {
    new YybHandleUtil.InstallBaseTask(paramActivity, null).execute(new Void[0]);
  }
  
  public boolean c()
  {
    return (b()) && (ControlPolicyUtil.e()) && (ControlPolicyUtil.h());
  }
  
  protected void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    wwl localwwl = new wwl(this);
    CommonDataAdapter.a().a().registerReceiver(localwwl, localIntentFilter);
  }
  
  public void d(Activity paramActivity)
  {
    if ((this.e) && (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null))
    {
      if ((!a()) && (a().b()))
      {
        if (this.jdField_a_of_type_Long != -1L)
        {
          c();
          this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.removeDownloadTask(this.jdField_a_of_type_Long);
        }
        a(paramActivity, null);
      }
      this.e = false;
      e();
      return;
    }
    this.e = false;
    this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
    e();
  }
  
  protected void e()
  {
    LogUtility.c("MyAppApi", "clearInstallParam");
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
  }
  
  public boolean e()
  {
    return a() > 2;
  }
  
  public void f()
  {
    this.jdField_d_of_type_Long = 0L;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.registerListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
  }
  
  public void h()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.unregisterListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.destroyQQDownloaderOpenSDK();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = null;
          return;
        }
        finally {}
        localException = localException;
        LogUtility.a("MyAppApi", "onDestroy>>>", localException);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\MyAppApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */