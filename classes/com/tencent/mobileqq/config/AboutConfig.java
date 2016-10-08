package com.tencent.mobileqq.config;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import rac;
import rad;
import rae;

public class AboutConfig
{
  public static final String a = "com.tx.aboutfunction";
  public static final boolean a = true;
  public static final String b = "http://fwd.3g.qq.com:8080/forward.jsp?bid=942";
  public static final String c = "com.tx.aboutimage";
  public static final String d = "http://fwd.3g.qq.com:8080/forward.jsp?bid=943";
  public static final String e = "com.tencent.Feedback_5_8";
  public static final String f = "http://mma.qq.com/feedback/index.html";
  public static final String g = "#_rc=mqq_faq_feedback";
  public static final String h = "com.tencent.help_5_8";
  public static final String i = "http://kf.qq.com/touch/product/mobileqq_platform_app.html?scene_id=kf180";
  public static final String j = "con.test.now";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private List jdField_a_of_type_JavaUtilList;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver;
  private boolean b;
  
  public AboutConfig(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
    this.jdField_a_of_type_MqqObserverServerConfigObserver = new rad(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  }
  
  private Hashtable a()
  {
    Hashtable localHashtable = new Hashtable();
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.aboutfunction";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369598);
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://fwd.3g.qq.com:8080/forward.jsp?bid=942";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.aboutimage";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369599);
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://fwd.3g.qq.com:8080/forward.jsp?bid=943";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tencent.help_5_8";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367771);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 0;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://kf.qq.com/touch/product/mobileqq_platform_app.html?scene_id=kf180";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tencent.Feedback_5_8";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371626);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 0;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://mma.qq.com/feedback/index.html";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    return localHashtable;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ResourcePluginInfo paramResourcePluginInfo)
  {
    AboutConfig localAboutConfig = paramQQAppInterface.a();
    Object localObject2 = paramResourcePluginInfo.strGotoUrl;
    Object localObject1 = "version=6.5.5.2880&appid=" + AppSetting.a + "&QUA=" + QZoneHelper.a();
    Object localObject3;
    if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
    {
      localObject3 = localObject1;
      if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {}
    }
    else
    {
      localObject3 = (String)localObject1 + "&adtag=2880";
    }
    if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
    {
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("#_rc=mqq_faq_feedback")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - "#_rc=mqq_faq_feedback".length());
      }
      localObject3 = "?" + (String)localObject3;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = (String)localObject2 + (String)localObject1;
      if ((!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) && (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8"))) {
        break label965;
      }
      if (QLog.isColorLevel())
      {
        if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
          break label858;
        }
        QLog.i("About-Feedback", 2, "feedfack before: url = " + (String)localObject3);
      }
      label253:
      localObject1 = Build.MODEL;
      if (localObject1 == null) {
        break label901;
      }
      localObject1 = ((String)localObject1).replaceAll(" ", "_");
      label270:
      int k = StatisticCollector.a();
      localObject2 = localObject1;
      if (k > 0) {
        localObject2 = (String)localObject1 + "_qzpatch" + k;
      }
      localObject1 = Build.MANUFACTURER;
      if (localObject1 == null) {
        break label907;
      }
      localObject1 = ((String)localObject1).replaceAll(" ", "_");
      label326:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject3).append("&model=").append((String)localObject2).append("&manufacture=").append((String)localObject1).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.c() / 1024L / 1024L).append("&amem=").append(DeviceInfoUtil.d() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.f()).append("&h=").append(DeviceInfoUtil.g()).append("&pss=").append(MemoryManager.a(Process.myPid()) / 1024L / 1024L).append("&heapmax=").append(Runtime.getRuntime().maxMemory() / 1024L / 1024L).append("&heapsize=").append((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L / 1024L).append("&sysver=").append(Build.VERSION.RELEASE).append("&user_tag=").append(QLog.getReportLevel(QLog.getUIN_REPORTLOG_LEVEL()));
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
      {
        localObject2 = (String)localObject2 + "#_rc=mqq_faq_feedback";
        localObject1 = localObject2;
        if (4 != QLog.getUIN_REPORTLOG_LEVEL())
        {
          QLog.setUIN_REPORTLOG_LEVEL(4);
          localObject3 = MsfStore.getNativeConfigStore();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            ((NativeConfigStore)localObject3).setConfig("LOGLEVEL_", "4");
            ((NativeConfigStore)localObject3).setConfig("LOGLEVELTIME", "" + System.currentTimeMillis());
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
          break label913;
        }
        QLog.i("About-Feedback", 2, "feedfack after: url = " + (String)localObject1);
      }
    }
    label715:
    label858:
    label901:
    label907:
    label913:
    label965:
    for (localObject2 = localObject1;; localObject2 = localObject3)
    {
      localObject1 = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("portraitOnly", true);
      ((Intent)localObject1).putExtra("url", (String)localObject2).putExtra("bFormatUrl", false);
      ((Intent)localObject1).putExtra("uin", paramQQAppInterface.a());
      if ((paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) || (paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8"))) {
        ((Intent)localObject1).putExtra("reportMsfLog", true);
      }
      try
      {
        paramContext.startActivity((Intent)localObject1);
        if (paramResourcePluginInfo.isNew == 0)
        {
          paramResourcePluginInfo.isNew = 1;
          ThreadManager.a(new rae(localAboutConfig, paramResourcePluginInfo), 8, null, false);
        }
        return;
        localObject1 = "&" + (String)localObject3;
        break;
        if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
          break label253;
        }
        QLog.i("About-Help", 2, "help before: url = " + (String)localObject3);
        break label253;
        localObject1 = "";
        break label270;
        localObject1 = "";
        break label326;
        localObject2 = localObject1;
        if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
          break label715;
        }
        QLog.i("About-Help", 2, "help after: url = " + (String)localObject1);
        localObject2 = localObject1;
      }
      catch (SecurityException paramQQAppInterface)
      {
        for (;;) {}
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilHashtable != null) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramList.next();
        this.jdField_a_of_type_JavaUtilHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilHashtable != null) {
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
  
  public ResourcePluginInfo a(String paramString)
  {
    return (ResourcePluginInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
  }
  
  public void a()
  {
    int k = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().widthPixels >= 480) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      a(false);
      while (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        ResourcePluginListener.a((ResourcePluginListener)this.jdField_a_of_type_JavaUtilList.get(k), (byte)1, 2);
        k += 1;
      }
    }
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashtable != null)
    {
      Iterator localIterator = ((Hashtable)this.jdField_a_of_type_JavaUtilHashtable.clone()).values().iterator();
      while (localIterator.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
        if (localResourcePluginInfo.cDataType == 0)
        {
          GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
          localGetResourceReqInfoV2.cState = 0;
          localGetResourceReqInfoV2.sLanType = localResourcePluginInfo.sLanType;
          localGetResourceReqInfoV2.sResSubType = 0;
          localGetResourceReqInfoV2.strPkgName = localResourcePluginInfo.strPkgName;
          localGetResourceReqInfoV2.uiCurVer = localResourcePluginInfo.uiCurVer;
          localArrayList.add(localGetResourceReqInfoV2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "sendAboutConfig" + localArrayList.size());
    }
    paramPluginConfigProxy.a(32, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramResourcePluginListener);
    }
  }
  
  public void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    ResourcePluginInfo localResourcePluginInfo;
    if ((this.jdField_a_of_type_JavaUtilHashtable != null) && (paramResourcePluginInfo != null) && (this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramResourcePluginInfo.strPkgName)))
    {
      localResourcePluginInfo = (ResourcePluginInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramResourcePluginInfo.strPkgName);
      localResourcePluginInfo.cLocalState = paramResourcePluginInfo.cLocalState;
      localResourcePluginInfo.isNew = paramResourcePluginInfo.isNew;
      paramResourcePluginInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    }
    try
    {
      ResourcePluginInfo.persistOrReplace(paramResourcePluginInfo, localResourcePluginInfo);
      if (paramResourcePluginInfo != null) {
        paramResourcePluginInfo.a();
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException = localException;
      } while (paramResourcePluginInfo == null);
      paramResourcePluginInfo.a();
      return;
    }
    finally
    {
      localObject = finally;
      if (paramResourcePluginInfo != null) {
        paramResourcePluginInfo.a();
      }
      throw ((Throwable)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "error happens: loadAboutConfig while current account is null, which means there is no logined account now");
      }
    }
    do
    {
      return;
      if ((paramBoolean) || (this.jdField_a_of_type_JavaUtilHashtable == null) || (this.jdField_a_of_type_JavaUtilHashtable.size() <= 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AboutConfig", 2, "there has about data in memory cache, do not need load from DB");
    return;
    this.jdField_a_of_type_JavaUtilHashtable = a();
    ThreadManager.a(new rac(this), 5, null, false);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashtable.values().iterator();
    while (localIterator.hasNext())
    {
      ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
      if ((localResourcePluginInfo.isNew == 0) && (localResourcePluginInfo.cLocalState == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 2);
    }
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramResourcePluginListener);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\config\AboutConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */