package cooperation.qqhotspot.ipc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeApEx;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.qqhotspot.WifiConversationManager.FocusApInfo;
import cooperation.qqhotspot.WifiNetworkUtil;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeCacheManager;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import cooperation.qqhotspot.hotspotnode.PublicAccountHandler.PublicAccountInfo;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListCacheHandler;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import yhy;
import yhz;
import yia;
import yib;
import yic;
import yid;
import yie;
import yif;
import yig;
import yih;
import yii;
import yij;

public class QQHotSpotRemoteManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "QQHotSpotRemoteManager";
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public QQAppInterface a;
  public IQQHotSpotService a;
  public ArrayList a;
  public boolean a;
  
  public QQHotSpotRemoteManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentServiceConnection = new yhy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
    paramQQAppInterface = new HandlerThread("qqhotspot_async_remotemanager", 10);
    paramQQAppInterface.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramQQAppInterface.getLooper());
  }
  
  private Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      return null;
      str = paramBundle.getString("notify_cmd");
      if (this.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQHotSpotRemoteManager", 2, "mQQHotSpotService not started strNotifyCmd:" + str);
        }
        a();
        return null;
      }
      b();
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        paramBundle = this.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService.a("com.qqhotspot.action.notify", paramBundle);
        if (paramBundle != null) {
          paramBundle.setClassLoader(getClass().getClassLoader());
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQHotSpotRemoteManager", 2, "sendRemoteNotify send success strNotifyCmd:" + str);
        }
        return paramBundle;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQHotSpotRemoteManager", 2, "sendRemoteNotify send failed strNotifyCmd:" + str);
    return null;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQHotSpotRemoteManager", 2, "QQHotSpot start service");
      }
      QQHotSpotProxyService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new yif(this, paramBundle));
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        str = paramBundle.getString("notify_cmd");
        if (this.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService == null)
        {
          if (paramBoolean) {
            a();
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQHotSpotRemoteManager", 2, "postRemoteNotify mQQHotSpotService not started strNotifyCmd:" + str + " cached");
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new yic(this, paramBundle));
          return;
        }
        b();
        try
        {
          paramBundle.setClassLoader(getClass().getClassLoader());
          this.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService.a("com.qqhotspot.action.notify", paramBundle);
          if (QLog.isColorLevel())
          {
            QLog.d("QQHotSpotRemoteManager", 2, "postRemoteNotify send success strNotifyCmd:" + str);
            return;
          }
        }
        catch (RemoteException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQHotSpotRemoteManager", 2, "postRemoteNotify send failed strNotifyCmd:" + str);
  }
  
  private Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      String str;
      do
      {
        return null;
        str = paramBundle.getString("invoke_cmd");
      } while (str == null);
      if (QLog.isColorLevel()) {
        QLog.d("QQHotSpotRemoteManager", 2, "收到插件发往QQ的IPC strInvokeCmd: " + str);
      }
      if (str.equals("BusinessHandler_makeSureProxyServiceStart"))
      {
        a();
        return null;
      }
      if (str.equals("BusinessHandler_Notify_apInfo"))
      {
        a(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_isApConnActive"))
      {
        b(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_Get_MSF_STATE"))
      {
        c(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_Back_To_Root"))
      {
        d(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_get_hotspotNode_cache")) {
        return c(paramBundle);
      }
      if (str.equals("BusinessHandler_set_hotspotNode_cache")) {
        return d(paramBundle);
      }
      if (str.equals("BusinessHandler_get_wifilist_fromsvr_bssid"))
      {
        f(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_get_wifilist_focus_bssid")) {
        return e(paramBundle);
      }
      if (str.equals("BusinessHandler_get_cur_location"))
      {
        g(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_get_wifilist_fromsvr_wifiid"))
      {
        e(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_get_public_account_info"))
      {
        h(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_follow_public_account"))
      {
        i(paramBundle);
        return null;
      }
      if (str.equals("BusinessHandler_goto_public_account_aio"))
      {
        j(paramBundle);
        return null;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQHotSpotRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
    return null;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new yid(this));
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new yig(this, paramBundle));
  }
  
  private Bundle c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "BusinessHandler_get_hotspotNode_cache");
    int i = paramBundle.getInt("type");
    if (i == 0) {
      localBundle.putStringArrayList("listinfo", (ArrayList)HotSpotNodeCacheManager.a().a());
    }
    for (;;)
    {
      return localBundle;
      if (i == 1) {
        localBundle.putStringArrayList("listinfo", (ArrayList)HotSpotNodeCacheManager.a().b());
      } else if (i == 2) {
        localBundle.putStringArrayList("listinfo", (ArrayList)HotSpotNodeCacheManager.a().c());
      } else if (i == 3) {
        localBundle.putSerializable("listinfo", (Serializable)HotSpotNodeCacheManager.a().a());
      }
    }
  }
  
  private void c()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQHotSpotRemoteManager", 2, "registerRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (localPluginCommunicationHandler.containsCmd("qqhotspot.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.register(new yie(this, "qqhotspot.remotecall"));
  }
  
  private void c(Bundle paramBundle)
  {
    paramBundle = new Bundle();
    paramBundle.putString("notify_cmd", "BusinessHandler_Get_MSF_STATE");
    paramBundle.putBoolean("result", HotSpotNodeUtil.a());
    a(paramBundle, true);
  }
  
  private Bundle d(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    int i = paramBundle.getInt("type");
    if (i == 0) {
      HotSpotNodeCacheManager.a().a(paramBundle.getStringArrayList("listinfo"), (Map)paramBundle.getSerializable("listinfoex"));
    }
    for (;;)
    {
      localBundle.putInt("result", 0);
      return localBundle;
      if (i == 1) {
        HotSpotNodeCacheManager.a().a(paramBundle.getStringArrayList("listinfo"));
      } else if (i == 2) {
        HotSpotNodeCacheManager.a().b(paramBundle.getStringArrayList("listinfo"));
      }
    }
  }
  
  private void d()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQHotSpotRemoteManager", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (!localPluginCommunicationHandler.containsCmd("qqhotspot.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.unregister("qqhotspot.remotecall");
  }
  
  private void d(Bundle paramBundle)
  {
    paramBundle = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), SplashActivity.class);
    paramBundle.putExtra("tab_index", MainFragment.a);
    paramBundle.addFlags(335544320);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(paramBundle);
  }
  
  private Bundle e(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = null;
    }
    Bundle localBundle;
    WifiConversationManager.FocusApInfo localFocusApInfo;
    do
    {
      do
      {
        return paramBundle;
        localBundle = new Bundle();
        localFocusApInfo = WifiConversationManager.a().a();
        paramBundle = localBundle;
      } while (localFocusApInfo == null);
      paramBundle = localBundle;
    } while (localFocusApInfo.a == null);
    localBundle.putString("focus_bssid", WifiNetworkUtil.b());
    return localBundle;
  }
  
  private void e(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      paramBundle = new Bundle();
      paramBundle.putBoolean("result", false);
      a(paramBundle, true);
      return;
    }
    int i = paramBundle.getInt("listinfoprotoex_seq", 0);
    String str = paramBundle.getString("listinfoproto");
    paramBundle = paramBundle.getString("listinfoprotoex");
    QQHotSpotListCacheHandler.a().a(str, paramBundle, new yih(this, i));
  }
  
  private void f(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      paramBundle = new Bundle();
      paramBundle.putBoolean("result", false);
      a(paramBundle, true);
      return;
    }
    int i = paramBundle.getInt("listinfoprotoex_seq", 0);
    if (paramBundle.getBoolean("listinfoprotoex_cache", false))
    {
      localObject = paramBundle.getString("listinfoproto");
      QQHotSpotListCacheHandler.a().a((String)localObject, (QQHotSpotHelper.HotSpotNodeApEx)paramBundle.getSerializable("listinfoprotoex"), new yii(this, i));
      return;
    }
    Object localObject = paramBundle.getStringArrayList("listinfoproto");
    ((QQHotSpotListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(83)).a(1, (List)localObject, null, new yij(this, i), paramBundle.getSerializable("listinfoprotoex"));
  }
  
  private void g(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    HotSpotNodeUtil.a(new yhz(this, paramBundle.getInt("listinfoprotoex_seq")));
  }
  
  private void h(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("listinfoprotoex_seq");
    paramBundle = paramBundle.getString("publicaccount_uin");
    Object localObject1 = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    if (localObject1 != null)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("notify_cmd", "BusinessHandler_get_public_account_info");
      ((Bundle)localObject2).putInt("listinfoprotoex_seq", i);
      PublicAccountHandler.PublicAccountInfo localPublicAccountInfo = new PublicAccountHandler.PublicAccountInfo();
      localPublicAccountInfo.mUin = paramBundle;
      localPublicAccountInfo.mName = ((AccountDetail)localObject1).name;
      if (((AccountDetail)localObject1).followType == 1) {
        bool = true;
      }
      localPublicAccountInfo.mIsFollow = bool;
      localPublicAccountInfo.mBrief = ((AccountDetail)localObject1).summary;
      localPublicAccountInfo.mAccountFlag = ((AccountDetail)localObject1).accountFlag;
      ((Bundle)localObject2).putBoolean("result", true);
      ((Bundle)localObject2).putSerializable("publicaccount_info", localPublicAccountInfo);
      a((Bundle)localObject2, true);
      return;
    }
    localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), PublicAccountServlet.class);
    ((NewIntent)localObject1).putExtra("cmd", "get_detail_info");
    Object localObject2 = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).versionInfo.set("6.5.5,3,2880");
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).version.set(1);
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).seqno.set(0);
    try
    {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).uin.set((int)Long.parseLong(paramBundle));
      ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(new yia(this, paramBundle, i));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void i(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("listinfoprotoex_seq");
    paramBundle = paramBundle.getString("publicaccount_uin");
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBundle, new yib(this, i));
  }
  
  private void j(Bundle paramBundle)
  {
    int j = 0;
    if (paramBundle == null) {}
    String str;
    int m;
    do
    {
      return;
      str = paramBundle.getString("publicaccount_uin");
      m = paramBundle.getInt("publicaccount_accountflag");
      if (QLog.isColorLevel()) {
        QLog.d("QQHotSpotRemoteManager", 2, "gotoAIO uin: " + str + " | accountFlag: " + m);
      }
    } while (TextUtils.isEmpty(str));
    paramBundle = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.c(str);
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.name;; paramBundle = "")
    {
      Object localObject = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        localObject = str;
      }
      paramBundle = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      if ((paramBundle == null) || (paramBundle.followType != 1))
      {
        paramBundle = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), AccountDetailActivity.class);
        j = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        i = j;
        if (j == -1) {
          i = PublicAccountUtil.a(m);
        }
        if (i != -7) {
          break label399;
        }
        paramBundle.putExtra("chat_subType", 1);
      }
      label399:
      for (int i = 0;; i = 1008)
      {
        paramBundle.putExtra("uin", str);
        paramBundle.putExtra("uintype", i);
        paramBundle.addFlags(268435456);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(paramBundle);
        return;
        int k = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        i = k;
        if (k == -1) {
          i = PublicAccountUtil.a(m);
        }
        paramBundle = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ChatActivity.class);
        if (i == -7) {
          paramBundle.putExtra("chat_subType", 1);
        }
        for (i = j;; i = 1008)
        {
          paramBundle.putExtra("uin", str);
          paramBundle.putExtra("uintype", i);
          paramBundle.putExtra("uinname", (String)localObject);
          paramBundle.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131367975));
          paramBundle.addFlags(268435456);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(paramBundle);
          return;
        }
      }
    }
  }
  
  public void a(QQHotSpotHelper.APInfo paramAPInfo)
  {
    if (paramAPInfo == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "BusinessHandler_connectAp");
    localBundle.putSerializable("APINFO", paramAPInfo);
    a(localBundle, true);
  }
  
  public void a(QQHotSpotHelper.APInfo paramAPInfo, int paramInt)
  {
    if (paramAPInfo == null) {}
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "BusinessHandler_isApConnActive");
      localBundle.putSerializable("APINFO", paramAPInfo);
      localBundle.putInt("from_type", paramInt);
      a(localBundle, true);
    } while (!QLog.isColorLevel());
    QLog.i("QQHotSpotRemoteManager", 2, "send isApConnActive");
  }
  
  public void onDestroy()
  {
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\ipc\QQHotSpotRemoteManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */