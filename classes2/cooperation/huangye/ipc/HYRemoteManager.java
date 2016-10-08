package cooperation.huangye.ipc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.C2BUtils;
import cooperation.huangye.HYBlankActivity;
import cooperation.huangye.HYConfigLoader;
import cooperation.huangye.HYConfigLoader.GetConfigListener;
import cooperation.huangye.HYIvrBusinessManager;
import cooperation.huangye.HYIvrBusinessManager.OnGetIvrBusinessContentListener;
import cooperation.huangye.HYPluginProxyActivity;
import cooperation.huangye.HuangyeHandler;
import java.util.ArrayList;
import java.util.HashMap;
import yda;
import ydb;
import ydc;
import ydd;
import yde;

public class HYRemoteManager
  implements HYIvrBusinessManager.OnGetIvrBusinessContentListener
{
  private static final String jdField_a_of_type_JavaLangString = "HYRemoteManager";
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public QQAppInterface a;
  private HYConfigLoader.GetConfigListener jdField_a_of_type_CooperationHuangyeHYConfigLoader$GetConfigListener;
  public IHuangyeService a;
  public ArrayList a;
  public boolean a;
  private String b;
  
  public HYRemoteManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentServiceConnection = new yda(this);
    this.jdField_a_of_type_CooperationHuangyeHYConfigLoader$GetConfigListener = new yde(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    d();
    paramQQAppInterface = new HandlerThread("huangye_async_remotemanager", 10);
    paramQQAppInterface.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramQQAppInterface.getLooper());
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (EqqDetail)paramQQAppInterface.a().createEntityManager().a(EqqDetail.class, paramString);
    if (localObject == null)
    {
      localObject = ((PublicAccountDataManager)paramQQAppInterface.getManager(55)).c(String.valueOf(paramString));
      if (localObject != null)
      {
        if (((PublicAccountInfo)localObject).isNeedShow()) {
          return 1;
        }
        return -1;
      }
      if (((FriendsManager)paramQQAppInterface.getManager(50)).c(String.valueOf(paramString)) != null) {
        return 1;
      }
      return -1;
    }
    return ((EqqDetail)localObject).followType;
  }
  
  private Bundle a(Bundle paramBundle)
  {
    String str = paramBundle.getString("notify_cmd");
    if (this.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HYRemoteManager", 2, "mHuangyeService not started strNotifyCmd:" + str);
      }
      b();
    }
    do
    {
      return null;
      c();
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        paramBundle = this.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService.a("com.huangye.action.notify", paramBundle);
        if (paramBundle != null) {
          paramBundle.setClassLoader(getClass().getClassLoader());
        }
        if (QLog.isColorLevel()) {
          QLog.d("HYRemoteManager", 2, "sendRemoteNotify send success strNotifyCmd:" + str);
        }
        return paramBundle;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("HYRemoteManager", 2, "sendRemoteNotify send failed strNotifyCmd:" + str);
    return null;
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    String str = paramBundle.getString("notify_cmd");
    if (this.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService == null)
    {
      if (paramBoolean) {
        b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("HYRemoteManager", 2, "postRemoteNotify mHuangyeService not started strNotifyCmd:" + str + " cached");
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ydb(this, paramBundle));
    }
    do
    {
      for (;;)
      {
        return;
        c();
        try
        {
          paramBundle.setClassLoader(getClass().getClassLoader());
          this.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService.a("com.huangye.action.notify", paramBundle);
          if (QLog.isColorLevel())
          {
            QLog.d("HYRemoteManager", 2, "postRemoteNotify send success strNotifyCmd:" + str);
            return;
          }
        }
        catch (RemoteException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("HYRemoteManager", 2, "postRemoteNotify send failed strNotifyCmd:" + str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("curPageName", paramString);
    localHashMap.put("category", "");
    localHashMap.put("businessName", "businessName");
    localHashMap.put("operPosition", "");
    localHashMap.put("operation", "clickAccessBtn");
    localHashMap.put("termType", "1");
    localHashMap.put("termVersion", "6.5.5");
    localHashMap.put("uin", paramQQAppInterface.a());
    localHashMap.put("cityName", "");
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "actQQYellowpageEvt", true, 0L, 0L, localHashMap, null);
  }
  
  private Bundle b(Bundle paramBundle)
  {
    String str = paramBundle.getString("invoke_cmd");
    if (str.equals("BusinessHandler_makeSureProxyServiceStart")) {
      b();
    }
    for (;;)
    {
      return null;
      if (str.equals("BusinessHandler_getHuangyeConfig"))
      {
        f();
      }
      else if (str.equals("BusinessHandler_voiceCall"))
      {
        a(paramBundle);
      }
      else if (str.equals("BusinessHandler_callContact"))
      {
        c(paramBundle);
      }
      else if (str.equals("BusinessHandler_enterChat"))
      {
        e(paramBundle);
      }
      else if (str.equals("BusinessHandler_enterBusinessHistory"))
      {
        f(paramBundle);
      }
      else if (str.equals("BusinessHandler_sendCmdToService"))
      {
        b(paramBundle);
      }
      else if (str.equals("BusinessHandler_sendPhoneList"))
      {
        d(paramBundle);
      }
      else if (str.equals("BusinessHandler_getPublicAccount"))
      {
        g(paramBundle);
      }
      else if (str.equals("BusinessHandler_getBusinessList"))
      {
        paramBundle = HYIvrBusinessManager.a();
        paramBundle.a(this);
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("HYRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("HYRemoteManager", 2, "mHuangyeService start service");
      }
      HYProxyService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    long l = paramBundle.getLong("sessionId");
    String str = paramBundle.getString("strServiceCmd");
    paramBundle = paramBundle.getByteArray("body");
    ((HuangyeHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a(l, str, paramBundle);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ydc(this));
  }
  
  private void c(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("friendUin");
    String str2 = paramBundle.getString("phoneNumber");
    a(null, str1, paramBundle.getString("name"), paramBundle.getString("logoUrl"), paramBundle.getString("businessSeId"), str2);
  }
  
  private void d()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("HYRemoteManager", 2, "registerRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (localPluginCommunicationHandler.containsCmd("huangye.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.register(new ydd(this, "huangye.remotecall"));
  }
  
  private void d(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("businessName");
    String str2 = paramBundle.getString("businessId");
    ArrayList localArrayList = paramBundle.getStringArrayList("phoneList");
    paramBundle = paramBundle.getStringArrayList("phoneDescList");
    ((HuangyeHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a(str1, str2, localArrayList, paramBundle);
  }
  
  private void e()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("HYRemoteManager", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (!localPluginCommunicationHandler.containsCmd("huangye.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.unregister("huangye.remotecall");
  }
  
  private void e(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), HYBlankActivity.class);
    localIntent.putExtra("Bundle", paramBundle);
    localIntent.addFlags(268435456);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(localIntent);
  }
  
  private void f()
  {
    this.b = null;
    HYConfigLoader.a().a(this.jdField_a_of_type_CooperationHuangyeHYConfigLoader$GetConfigListener);
    HYConfigLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void f(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    if (j == -1) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ChatHistory.class);
    localIntent.putExtra("uin", paramBundle);
    int i = 0;
    if (j != 1) {
      i = 1024;
    }
    localIntent.putExtra("uintype", i);
    localIntent.addFlags(268435456);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(localIntent);
  }
  
  private void g(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    boolean bool = C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onPublicAccountChanged");
    localBundle.putString("uin", paramBundle);
    localBundle.putBoolean("bFollowed", bool);
    a(localBundle, false);
  }
  
  public void a()
  {
    HYConfigLoader.a().b(this.jdField_a_of_type_CooperationHuangyeHYConfigLoader$GetConfigListener);
    HYIvrBusinessManager.a().b(this);
    e();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent;
    if ((paramString5 != null) && (paramString5.length() > 0))
    {
      localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString5));
      if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
        KapalaiAdapterUtil.a().a(localIntent);
      }
      if (paramContext != null) {
        break label130;
      }
      localIntent.addFlags(268435456);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2, paramString3, paramString4, 9502, System.currentTimeMillis() / 1000L, paramString5);
      return;
      label130:
      paramContext.startActivity(localIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), HYBlankActivity.class);
    localIntent.putExtra("Bundle", paramBundle);
    localIntent.addFlags(268435456);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(localIntent);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReciveToService");
    localBundle.putParcelable("req", paramToServiceMsg);
    localBundle.putParcelable("res", paramFromServiceMsg);
    localBundle.putLong("srvTime", paramLong);
    a(localBundle, true);
  }
  
  public void a(String paramString)
  {
    if (HYPluginProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "SendIvrBusinessContent");
      localBundle.putString("strContent", paramString);
      a(localBundle, true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendGetPhoneListRequest");
    if (paramString1 != null) {
      localBundle.putString("businessName", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("businessId", paramString2);
    }
    a(localBundle, true);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "SendHuangyeConfig");
    localBundle.putString("strContent", paramString);
    a(localBundle, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\ipc\HYRemoteManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */