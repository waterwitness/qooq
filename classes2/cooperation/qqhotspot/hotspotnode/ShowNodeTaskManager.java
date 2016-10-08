package cooperation.qqhotspot.hotspotnode;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.QQHotSpotHelper.ConversationShowApinfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.qqhotspot.WifiNetworkUtil;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheckResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import yhn;
import yhp;
import yhq;
import yhr;
import yht;
import yhu;
import yhv;
import yhw;

public class ShowNodeTaskManager
{
  public static int a = 0;
  private static ShowNodeTaskManager jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager;
  private static final String jdField_a_of_type_JavaLangString = "ShowNodeTaskManager";
  public static int b = 0;
  public static int c = jdField_b_of_type_Int + 1;
  public static int d = c + 1;
  public static final int e = -1;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 5;
  private static final int n = 50;
  private Handler jdField_a_of_type_AndroidOsHandler = new yhp(this, Looper.getMainLooper());
  private HotSpotNodeUtil.GetLocalWiFiListCallBack jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeUtil$GetLocalWiFiListCallBack = new yhr(this);
  private HotSpotNodeUtil.LocationCallBack jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeUtil$LocationCallBack = new yhn(this);
  private QQHotSpotListHandler.Callback jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListHandler$Callback = new yht(this);
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private HashSet b;
  private final int l = 1;
  private final int m = 120000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = jdField_a_of_type_Int + 1;
  }
  
  private ShowNodeTaskManager()
  {
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    d();
    e();
    WifiConversationManager.a();
  }
  
  private int a()
  {
    if (!HotSpotNodeUtil.c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "preCheckNeedRunTask() isHotSpotNodeSwitch is not Open");
      }
      if (HotSpotNodeUtil.d()) {
        WifiConversationManager.a().c();
      }
      WifiConversationManager.a().a(1, null);
      return 0;
    }
    if (!HotSpotNodeUtil.a(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "preCheckNeedRunTask() App not OnForeground ");
      }
      return 2;
    }
    if (!WifiNetworkUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "preCheckNeedRunTask() Wifi is not enabled ");
      }
      WifiConversationManager.a().a(1, null);
      return 1;
    }
    if (System.currentTimeMillis() - HotSpotNodeUtil.a(0) < HotSpotNodeUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "LastShowNodeTime in the middle of 0-30min");
      }
      QQHotSpotHelper.ConversationShowApinfo localConversationShowApinfo = WifiConversationManager.a().a();
      if ((localConversationShowApinfo != null) && (localConversationShowApinfo.mStatus == 2) && (localConversationShowApinfo.mApInfo != null) && (!HotSpotNodeUtil.a(localConversationShowApinfo.mApInfo.mApInfo.BSSID, localConversationShowApinfo.mApInfo.mApInfo.SSID)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShowNodeTaskManager", 2, "ConversationShowApinfo not in localwifilist BSSID: " + localConversationShowApinfo.mApInfo.mApInfo.BSSID + " SSID: " + localConversationShowApinfo.mApInfo.mApInfo.SSID);
        }
        WifiConversationManager.a().a(1, null);
      }
      return 5;
    }
    if (WifiNetworkUtil.c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "preCheckNeedRunTask() Wifi CanPassData");
      }
      return 4;
    }
    return -1;
  }
  
  public static ShowNodeTaskManager a()
  {
    if (jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager == null) {
        jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager = new ShowNodeTaskManager();
      }
      return jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager;
    }
    finally {}
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "onQQForeground");
    }
    a().a(jdField_a_of_type_Int);
  }
  
  private void a(List paramList, Map paramMap)
  {
    int i1 = 0;
    if ((!NetworkUtil.h(BaseApplicationImpl.getContext())) || (!HotSpotNodeUtil.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "preCheckNeedRunTask() Network is not Available or msf is not Available");
      }
      a(true);
      return;
    }
    if (paramList.size() > 50) {
      paramList = new ArrayList(paramList.subList(0, 50));
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      while (i1 < paramList.size())
      {
        localHashMap.put(paramList.get(i1), paramMap.get(paramList.get(i1)));
        i1 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "stepSendWiFiListToSvr() list size() : " + String.valueOf(paramList.size()));
      }
      ((QQHotSpotListHandler)((QQAppInterface)BaseApplicationImpl.a().a()).a(83)).a(1, paramList, null, this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListHandler$Callback, (Serializable)paramMap);
      return;
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "hasTaskRuning");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "not hasTaskRuning");
    }
    return false;
  }
  
  private void b()
  {
    if (!NetworkUtil.h(BaseApplicationImpl.getContext()))
    {
      a(false);
      return;
    }
    c();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "stepGeLocaltWiFiList()");
    }
    HotSpotNodeUtil.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeUtil$GetLocalWiFiListCallBack, false, true);
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    BaseApplicationImpl.getContext().registerReceiver(new yhv(this), localIntentFilter);
  }
  
  private void e()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    BaseApplicationImpl.getContext().registerReceiver(new yhw(this), localIntentFilter);
  }
  
  public void a(int paramInt)
  {
    ThreadManager.a(new yhq(this, paramInt), 5, null, true);
  }
  
  public void a(APNodeCheckResult paramAPNodeCheckResult, Map paramMap)
  {
    ThreadManager.a(new yhu(this, paramAPNodeCheckResult, paramMap), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "endShowNodeTask()  bNeedSaveLasrCooperateApList: " + String.valueOf(paramBoolean));
    }
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localObject1 = HotSpotNodeUtil.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
      if (((List)localObject1).size() > 0)
      {
        HashSet localHashSet = new HashSet();
        localObject1 = (QQHotSpotHelper.HotSpotNodeAPInfo)this.jdField_a_of_type_JavaUtilList.get(0);
        int i1 = 1;
        int i2 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject2 = localObject1;
          if (((QQHotSpotHelper.HotSpotNodeAPInfo)localObject1).mApInfo.SignLevel < ((QQHotSpotHelper.HotSpotNodeAPInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).mApInfo.SignLevel) {
            localObject2 = (QQHotSpotHelper.HotSpotNodeAPInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
          }
          if (this.jdField_b_of_type_JavaUtilHashSet.contains(new Pair(((QQHotSpotHelper.HotSpotNodeAPInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).mApInfo.BSSID, ((QQHotSpotHelper.HotSpotNodeAPInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).mApInfo.SSID))) {
            i2 = 1;
          }
          localHashSet.add(new Pair(((QQHotSpotHelper.HotSpotNodeAPInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).mApInfo.BSSID, ((QQHotSpotHelper.HotSpotNodeAPInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).mApInfo.SSID));
          i1 += 1;
          localObject1 = localObject2;
        }
        this.jdField_b_of_type_JavaUtilHashSet = localHashSet;
        if (System.currentTimeMillis() - HotSpotNodeUtil.a(1) < HotSpotNodeUtil.b()) {
          if (i2 == 0)
          {
            WifiConversationManager.a().a(2, (QQHotSpotHelper.HotSpotNodeAPInfo)localObject1);
            HotSpotNodeUtil.a(1);
            ReportController.b((QQAppInterface)BaseApplicationImpl.a().a(), "CliOper", "", "", "0X8006351", "0X8006351", 0, 0, String.valueOf(this.jdField_a_of_type_JavaUtilList.size()), "", "", "");
            if (QLog.isColorLevel()) {
              QLog.i("ShowNodeTaskManager", 2, "endShowNodeTask() need ShowNode mCurCooperateApList.size(): " + String.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
            }
            HotSpotNodeUtil.a(0);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((HotSpotNodeUtil.a(BaseApplicationImpl.getContext())) && (HotSpotNodeUtil.c()) && (this.jdField_a_of_type_Boolean) && (WifiNetworkUtil.a()))
      {
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 120000L);
        if (QLog.isColorLevel()) {
          QLog.i("ShowNodeTaskManager", 2, "endShowNodeTask() start START_TASK_2MIN");
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      localObject1 = WifiConversationManager.a().a();
      if ((localObject1 != null) && (((QQHotSpotHelper.ConversationShowApinfo)localObject1).mStatus == 2) && (!this.jdField_b_of_type_JavaUtilHashSet.contains(new Pair(((QQHotSpotHelper.ConversationShowApinfo)localObject1).mApInfo.mApInfo.BSSID, ((QQHotSpotHelper.ConversationShowApinfo)localObject1).mApInfo.mApInfo.SSID)))) {
        WifiConversationManager.a().a(1, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ShowNodeTaskManager", 2, "endShowNodeTask() not need ShowNode in 3 hour and have same Ap");
      break;
      WifiConversationManager.a().a(2, (QQHotSpotHelper.HotSpotNodeAPInfo)localObject1);
      HotSpotNodeUtil.a(1);
      ReportController.b((QQAppInterface)BaseApplicationImpl.a().a(), "CliOper", "", "", "0X8006351", "0X8006351", 0, 0, String.valueOf(this.jdField_a_of_type_JavaUtilList.size()), "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ShowNodeTaskManager", 2, "endShowNodeTask() need ShowNode mCurCooperateApList.size(): " + String.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      break;
      if (System.currentTimeMillis() - HotSpotNodeUtil.a(0) >= HotSpotNodeUtil.a()) {
        WifiConversationManager.a().a(1, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\ShowNodeTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */