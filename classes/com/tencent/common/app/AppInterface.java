package com.tencent.common.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class AppInterface
  extends AppRuntime
  implements IHttpCommunicatorFlowCount
{
  protected BaseApplicationImpl a;
  protected HwEngine a;
  private ProtoReqManager jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager;
  protected HttpCommunicator a;
  protected final ConcurrentHashMap a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  protected String e;
  
  public AppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.e = paramString;
  }
  
  public static void a(PluginRuntime paramPluginRuntime, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    paramPluginRuntime.sendAppDataIncerment(paramString, a(paramString, paramBoolean, paramInt1, paramInt2, paramInt3, paramLong), paramLong);
  }
  
  private static void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIPicFlow");
      if (paramBoolean) {
        if (paramInt2 == 0) {
          paramArrayList.add("param_WIFIC2CPicUploadFlow");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramInt2 == 1) || (paramInt2 == 3000))
            {
              paramArrayList.add("param_WIFIGroupPicUploadFlow");
              return;
            }
          } while ((paramInt2 != 1001) && (paramInt2 != 1003) && (paramInt2 != 1025));
          paramArrayList.add("param_WIFINearbyPicUploadFlow");
          return;
          if (paramInt2 == 0)
          {
            paramArrayList.add("param_WIFIC2CPicDownloadFlow");
            return;
          }
          if ((paramInt2 == 1) || (paramInt2 == 3000))
          {
            paramArrayList.add("param_WIFIGroupPicDownloadFlow");
            return;
          }
        } while ((paramInt2 != 1001) && (paramInt2 != 1003) && (paramInt2 != 1025));
        paramArrayList.add("param_WIFINearbyPicDownloadFlow");
        return;
        paramArrayList.add("param_XGPicFlow");
        if (!paramBoolean) {
          break;
        }
        if (paramInt2 == 0)
        {
          paramArrayList.add("param_XGC2CPicUploadFlow");
          return;
        }
        if ((paramInt2 == 1) || (paramInt2 == 3000))
        {
          paramArrayList.add("param_XGGroupPicUploadFlow");
          return;
        }
      } while ((paramInt2 != 1001) && (paramInt2 != 1003));
      paramArrayList.add("param_XGNearbyPicUploadFlow");
      return;
      if (paramInt2 == 0)
      {
        paramArrayList.add("param_XGC2CPicDownloadFlow");
        return;
      }
      if ((paramInt2 == 1) || (paramInt2 == 3000))
      {
        paramArrayList.add("param_XGGroupPicDownloadFlow");
        return;
      }
    } while ((paramInt2 != 1001) && (paramInt2 != 1003));
    paramArrayList.add("param_XGNearbyPicDownloadFlow");
  }
  
  private static String[] a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowStat", 2, "uin:" + paramString + ",isUp:" + paramBoolean + ",netType:" + paramInt1 + ",fileType:" + paramInt2 + ",busiType:" + paramInt3 + ",flow:" + paramLong);
    }
    paramString = new ArrayList();
    paramString.add("param_Flow");
    if (paramInt1 == 1)
    {
      paramString.add("param_WIFIFlow");
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      return (String[])paramString.toArray(new String[0]);
      paramString.add("param_XGFlow");
      break;
      a(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      b(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      c(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      if (paramInt1 == 1)
      {
        paramString.add("param_WIFIUniformDLDownloadFlow");
      }
      else
      {
        paramString.add("param_XGUniformDLDownloadFlow");
        continue;
        if (paramInt1 == 1)
        {
          paramString.add("param_WIFIThemeDownloadFlow");
        }
        else
        {
          paramString.add("param_XGThemeDownloadFlow");
          continue;
          if (paramInt1 == 1)
          {
            paramString.add("param_WIFIAvatarPicDownloadFlow");
          }
          else
          {
            paramString.add("param_XGAvatarPicDownloadFlow");
            continue;
            if (paramInt1 == 1) {
              paramString.add("param_WIFICircleDownloadFlow");
            } else {
              paramString.add("param_XGCircleDownloadFlow");
            }
          }
        }
      }
    }
  }
  
  private static void b(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIVoiceFlow");
      return;
    }
    paramArrayList.add("param_XGVoiceFlow");
  }
  
  private static void c(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIFileFlow");
      return;
    }
    paramArrayList.add("param_XGFileFlow");
  }
  
  public abstract int a();
  
  public HwEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine = new HwEngine(getApplication(), a(), a(), this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine;
  }
  
  public EntityManagerFactory a()
  {
    return a(getAccount());
  }
  
  public abstract EntityManagerFactory a(String paramString);
  
  public BaseTransFileController a()
  {
    return null;
  }
  
  public INetEngine a(int paramInt)
  {
    return null;
  }
  
  public ProtoReqManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = new ProtoReqManager(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager;
    }
    finally {}
  }
  
  public HttpCommunicator a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator == null) {
      k();
    }
    return this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  }
  
  public abstract BaseApplication a();
  
  public Object a(int paramInt)
  {
    return null;
  }
  
  public abstract String a();
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    return null;
  }
  
  public List a(int paramInt)
  {
    return null;
  }
  
  public MqqHandler a(Class paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass) != null) {
      return (MqqHandler)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass);
    }
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a(BusinessObserver paramBusinessObserver) {}
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean) {}
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(Class paramClass)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramClass);
  }
  
  public void a(Class paramClass, MqqHandler paramMqqHandler)
  {
    if (paramMqqHandler == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramClass);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramClass, paramMqqHandler);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(paramString, a(paramString, paramBoolean, paramInt1, paramInt2, paramInt3, paramLong), paramLong);
  }
  
  public void a(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if (paramArrayOfString != null)
    {
      if (!BaseActivity.mAppForground)
      {
        String[] arrayOfString = new String[paramArrayOfString.length];
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          arrayOfString[i] = (paramArrayOfString[i] + "_bg");
          i += 1;
        }
        sendAppDataIncermentMsg(paramString, arrayOfString, paramLong);
      }
    }
    else {
      return;
    }
    sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(getAccount(), paramBoolean, paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public boolean a(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.processName.equals(paramContext)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.processName.equals(paramString)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    return "";
  }
  
  public void b(BusinessObserver paramBusinessObserver) {}
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9) {}
  
  protected void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = new HttpCommunicator(this, 128);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\AppInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */