package com.tencent.mobileqq.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.lang.ref.WeakReference;
import wfr;

public class VipVideoManager
{
  public static int a = 0;
  private static VipVideoManager jdField_a_of_type_ComTencentMobileqqVideoVipVideoManager;
  public static final String a = "VipVideoManager";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final String b = "ZDJ2DK+QcEksd+C8RIzfwQhjkPCNDsewhQBcxciUfYyphf1ntN4M1sXu5waGVy3CMB36XLopJFqaMtHxKS4BXScewkVRuSfBoAJVDEJHZv+opKWeviyxuUnc4R4MlMmTO2M2de47GRD6te9FtjtFCd1KLUPZuW QBq8aXUxi+IyhmKBZoXWUxLkdfIZ7Gleriirf7ewcykmS64TG7zbV1uMCdIaO9hwDhVJbRlGN2si1sepphKPCuuOoAdZz52edGEfp5oIgA7THflGFidFnsrPksn8nGbr+OYOI8kcixjzblTIjBAqHHFRJnIQhh74pVkqtiqE7iz46FclQB17JJmg==";
  
  private VipVideoManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static VipVideoManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVideoVipVideoManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqVideoVipVideoManager == null) {
        jdField_a_of_type_ComTencentMobileqqVideoVipVideoManager = new VipVideoManager();
      }
      return jdField_a_of_type_ComTencentMobileqqVideoVipVideoManager;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    StringBuilder localStringBuilder;
    String str;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("init video plugin context ");
      if (paramContext == null) {
        break label79;
      }
      str = "is not null";
    }
    for (;;)
    {
      QLog.d("VipVideoManager", 2, str);
      try
      {
        label79:
        try
        {
          if (!jdField_a_of_type_Boolean)
          {
            TVK_SDKMgr.setOnLogListener(new wfr());
            if (paramContext != null)
            {
              TVK_SDKMgr.initSdk(paramContext, "ZDJ2DK+QcEksd+C8RIzfwQhjkPCNDsewhQBcxciUfYyphf1ntN4M1sXu5waGVy3CMB36XLopJFqaMtHxKS4BXScewkVRuSfBoAJVDEJHZv+opKWeviyxuUnc4R4MlMmTO2M2de47GRD6te9FtjtFCd1KLUPZuW QBq8aXUxi+IyhmKBZoXWUxLkdfIZ7Gleriirf7ewcykmS64TG7zbV1uMCdIaO9hwDhVJbRlGN2si1sepphKPCuuOoAdZz52edGEfp5oIgA7THflGFidFnsrPksn8nGbr+OYOI8kcixjzblTIjBAqHHFRJnIQhh74pVkqtiqE7iz46FclQB17JJmg==", "");
              jdField_a_of_type_Boolean = true;
            }
          }
          return;
        }
        finally {}
        str = "is null";
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void a(Context paramContext, TVK_SDKMgr.InstallListener paramInstallListener)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("install video plugin and context=");
      if (paramContext != null) {
        break label110;
      }
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append(",mMediaSdkInited").append(jdField_a_of_type_Boolean).append(",listener=");
      if (paramInstallListener != null) {
        break label116;
      }
    }
    label110:
    label116:
    for (String str = "null";; str = "not null")
    {
      QLog.d("VipVideoManager", 2, str);
      if ((paramContext != null) && (paramInstallListener != null)) {}
      try
      {
        if (!jdField_a_of_type_Boolean) {
          a(paramContext);
        }
        jdField_a_of_type_Int = 0;
        TVK_SDKMgr.installPlugin(paramContext, (TVK_SDKMgr.InstallListener)new WeakReference(paramInstallListener).get());
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label157;
        }
        QLog.d("VipVideoManager", 2, "install video plugin exception msg=" + paramContext.getMessage());
        paramContext.printStackTrace();
      }
      str = "not null";
      break;
    }
    label157:
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramInt > 0))
    {
      Intent localIntent = new Intent(paramContext, VipVideoPlayActivity.class);
      localIntent.putExtra("vid", paramString1);
      localIntent.putExtra("videoFormat", paramString2);
      localIntent.putExtra("vtype", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isInstalled Plugin=").append(TVK_SDKMgr.isInstalled(paramContext)).append(",Context=");
      if (paramContext != null) {
        break label65;
      }
    }
    label65:
    for (String str = "null";; str = "not null")
    {
      QLog.d("VipVideoManager", 2, str);
      if ((paramContext == null) || (!TVK_SDKMgr.isInstalled(paramContext))) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\video\VipVideoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */