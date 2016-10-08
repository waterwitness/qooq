package cooperation.qqhotspot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import yhc;
import yhd;
import yhe;

public class WifiConversationManager
  implements Manager
{
  private static WifiConversationManager jdField_a_of_type_CooperationQqhotspotWifiConversationManager;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private final int jdField_a_of_type_Int;
  protected BroadcastReceiver a;
  public QQHotSpotHelper.AP a;
  private QQHotSpotHelper.ConversationShowApinfo jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$ConversationShowApinfo;
  private WifiConversationManager.FocusApInfo jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo;
  public String a;
  
  private WifiConversationManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "WifiConversationManager";
    this.jdField_a_of_type_Int = 0;
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
  }
  
  public static WifiConversationManager a()
  {
    if (jdField_a_of_type_CooperationQqhotspotWifiConversationManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqhotspotWifiConversationManager == null) {
        jdField_a_of_type_CooperationQqhotspotWifiConversationManager = new WifiConversationManager();
      }
      return jdField_a_of_type_CooperationQqhotspotWifiConversationManager;
    }
    finally {}
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!WifiNetworkUtil.b()) {
        break label179;
      }
    }
    label179:
    for (Object localObject = WifiNetworkUtil.a();; localObject = null)
    {
      if (!WifiNetworkUtil.a((String)localObject, this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.SSID)) {
        a(null, 0);
      }
      do
      {
        return;
        if (paramBoolean) {
          break;
        }
        a(null, 0);
        if (((a() != null) && (a().mStatus == 3)) || (!WifiNetworkUtil.a())) {
          b();
        }
        localObject = ((QQAppInterface)BaseApplicationImpl.a().a()).a(Conversation.class);
      } while (localObject == null);
      Message localMessage = Message.obtain();
      if (paramInt == 0) {
        localMessage.what = 1042;
      }
      if (paramBoolean) {}
      for (paramInt = 2;; paramInt = 0)
      {
        localMessage.arg1 = paramInt;
        ((MqqHandler)localObject).sendMessage(localMessage);
        return;
        if (paramInt != 0) {
          break;
        }
        a(this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP, 1);
        a(3, new QQHotSpotHelper.HotSpotNodeAPInfo(this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo, this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.APInfoEx));
        break;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return jdField_a_of_type_JavaUtilHashMap.isEmpty();
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramString + "in ConnList");
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramString + "not in ConnList");
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.a().a();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(50);
    RecentUserProxy localRecentUserProxy = ((QQAppInterface)localObject1).a().a();
    if (localObject2 == null) {
      return false;
    }
    if ((!paramBoolean) && (localRecentUserProxy.b(AppConstants.aV, 9505) == null)) {
      return false;
    }
    localObject2 = localRecentUserProxy.a(AppConstants.aV, 9505);
    if (paramBoolean) {
      ((RecentUser)localObject2).lastmsgtime = (System.currentTimeMillis() / 1000L);
    }
    localRecentUserProxy.a((RecentUser)localObject2);
    localObject1 = ((QQAppInterface)localObject1).a(Conversation.class);
    if (localObject1 != null) {
      ((MqqHandler)localObject1).sendEmptyMessage(1009);
    }
    return true;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver has registered");
      }
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yhc(this);
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public QQHotSpotHelper.AP a()
  {
    return this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP;
  }
  
  public QQHotSpotHelper.APConnInfo a()
  {
    if ((this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo != null) && (this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP != null)) {
      return this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo;
    }
    return null;
  }
  
  public QQHotSpotHelper.ConversationShowApinfo a()
  {
    return this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$ConversationShowApinfo;
  }
  
  public WifiConversationManager.FocusApInfo a()
  {
    return this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo != null) && (this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP != null)) {
      return this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.SSID;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP == null) {}
    label145:
    do
    {
      return;
      if ((this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus == 2) || (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus == 7))
      {
        if (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus == 7) {
          if (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.From == null) {
            break label145;
          }
        }
        for (String str = this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.From;; str = "")
        {
          ReportController.b(null, "CliOper", "", "", "0X800634C", "0X800634C", 0, 0, str, this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.AuthType, "", this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.ManuID);
          a(0, true);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "RefreshConnWiFiBar isShow: true type: 0");
          return;
        }
      }
      if (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus == 5) {
        a(null);
      }
      a(0, false);
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "RefreshConnWiFiBar isShow: false");
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (WifiNetworkUtil.b())
      {
        QQHotSpotHelper.AP localAP = new QQHotSpotHelper.AP();
        localAP.Apinfo.SSID = WifiNetworkUtil.a();
        localAP.Apinfo.BSSID = WifiNetworkUtil.b();
        a(localAP);
        if (a(localAP.Apinfo.SSID)) {
          ((QQHotSpotRemoteManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(117)).a(this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo, paramInt);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt, QQHotSpotHelper.HotSpotNodeAPInfo paramHotSpotNodeAPInfo)
  {
    QQHotSpotHelper.ConversationShowApinfo localConversationShowApinfo = a();
    if (paramInt == 1) {
      if ((localConversationShowApinfo != null) && (localConversationShowApinfo.mStatus == 2))
      {
        a(new QQHotSpotHelper.ConversationShowApinfo(1, null));
        a(false);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateConversationShowApInfo() stauts: " + String.valueOf(paramInt));
        if ((paramInt == 2) || (paramInt == 3)) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateConversationShowApInfo() BSSID:" + paramHotSpotNodeAPInfo.mApInfo.BSSID + " SSID:" + paramHotSpotNodeAPInfo.mApInfo.SSID);
        }
      }
      return;
      if (paramInt == 2)
      {
        if ((localConversationShowApinfo == null) || (localConversationShowApinfo.mStatus != 3))
        {
          a(new QQHotSpotHelper.ConversationShowApinfo(2, paramHotSpotNodeAPInfo));
          a(true);
        }
      }
      else if (paramInt == 3)
      {
        a(new QQHotSpotHelper.ConversationShowApinfo(3, paramHotSpotNodeAPInfo));
        a(false);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int k = 0;
    if (paramBundle == null) {}
    do
    {
      return;
      paramBundle = paramBundle.getSerializable("APINFO");
    } while (!(paramBundle instanceof QQHotSpotHelper.AP));
    QQHotSpotHelper.AP localAP = (QQHotSpotHelper.AP)paramBundle;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "NotifyApConnActiveResp() Apinfo：" + localAP.Apinfo.toString());
    }
    int i;
    if (localAP.ApConnInfo.ConnStatus == 7)
    {
      paramBundle = (ArrayList)jdField_a_of_type_JavaUtilHashMap.get(localAP.Apinfo.SSID);
      j = k;
      if (paramBundle != null)
      {
        i = 0;
        j = k;
        if (i < paramBundle.size())
        {
          if (!localAP.Apinfo.equals(((QQHotSpotHelper.AP)paramBundle.get(i)).Apinfo)) {
            break label194;
          }
          j = 1;
        }
      }
      if (j == 0)
      {
        localAP.ApConnInfo.ConnStatus = 8;
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "NotifyApConnActiveResp() not in cache");
        }
      }
    }
    label194:
    while (localAP.ApConnInfo.ConnStatus != 8) {
      for (;;)
      {
        int j;
        a(localAP);
        a();
        return;
        i += 1;
      }
    }
    label236:
    String str1;
    if (localAP.Apinfo.From != null)
    {
      paramBundle = localAP.Apinfo.From;
      if (localAP.Apinfo.AuthType == null) {
        break label325;
      }
      str1 = localAP.Apinfo.AuthType;
      label256:
      i = localAP.ApConnInfo.ConnErrorCode;
      if (localAP.Apinfo.ManuID == null) {
        break label332;
      }
    }
    label325:
    label332:
    for (String str2 = localAP.Apinfo.ManuID;; str2 = "")
    {
      ReportController.b(null, "CliOper", "", "", "0X8006366", "0X8006366", 0, 0, paramBundle, str1, String.valueOf(i), str2);
      break;
      paramBundle = "";
      break label236;
      str1 = "";
      break label256;
    }
  }
  
  public void a(QQHotSpotHelper.AP paramAP)
  {
    int k = 0;
    this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP = paramAP;
    if (paramAP == null) {
      break label12;
    }
    label12:
    while ((this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus != 2) || (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.SSID == null)) {
      return;
    }
    if (!jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.SSID))
    {
      localArrayList = new ArrayList();
      localArrayList.add(paramAP);
      jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.SSID, localArrayList);
      d();
      return;
    }
    ArrayList localArrayList = (ArrayList)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.SSID);
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localArrayList.size())
      {
        if (paramAP.Apinfo.equals(((QQHotSpotHelper.AP)localArrayList.get(i)).Apinfo)) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        ((ArrayList)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.SSID)).add(paramAP);
        return;
      }
      i += 1;
    }
  }
  
  public void a(QQHotSpotHelper.AP paramAP, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo == null) {
        this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo = new WifiConversationManager.FocusApInfo(this);
      }
      this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP = paramAP;
      this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.c = paramInt;
      return;
    }
    finally {}
  }
  
  public void a(QQHotSpotHelper.ConversationShowApinfo paramConversationShowApinfo)
  {
    this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$ConversationShowApinfo = paramConversationShowApinfo;
  }
  
  public void a(boolean paramBoolean)
  {
    ((QQAppInterface)BaseApplicationImpl.a().a()).runOnUiThread(new yhd(this, paramBoolean));
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo != null) && (this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP != null)) {
      return this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.StoreName;
    }
    return null;
  }
  
  public void b()
  {
    QQHotSpotHelper.ConversationShowApinfo localConversationShowApinfo = a();
    if ((localConversationShowApinfo != null) && ((localConversationShowApinfo.mStatus == 2) || (localConversationShowApinfo.mStatus == 3)))
    {
      a(new QQHotSpotHelper.ConversationShowApinfo(1, null));
      a(false);
    }
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo != null) && (this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP != null)) {
      return this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager$FocusApInfo.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.APInfoEx.StorebannerAdUrl;
    }
    return null;
  }
  
  public void c()
  {
    ((QQAppInterface)BaseApplicationImpl.a().a()).runOnUiThread(new yhe(this));
  }
  
  public void onDestroy()
  {
    a(BaseApplicationImpl.getContext());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\WifiConversationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */