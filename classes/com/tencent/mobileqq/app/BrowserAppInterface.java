package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.MyLog;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.biz.common.util.QQThreadManager;
import com.tencent.biz.game.GamePushServlet;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.nearby.OldBigDataChannelManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import puk;
import pul;
import pum;
import pun;
import puo;
import pup;

public class BrowserAppInterface
  extends AppInterface
{
  public static final int a = 1;
  public static final String a;
  public static final AtomicBoolean a;
  public static final int b = 2;
  public static final String b = "qb_info";
  static final String c = "LastUIN";
  long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new pul(this);
  public Intent a;
  protected ReadInJoyLogicManager a;
  protected OldBigDataChannelManager a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  public URLInterceptManager a;
  public boolean a;
  public int c = -1;
  private int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BrowserAppInterface.class.getSimpleName();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public BrowserAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(int paramInt)
  {
    String str1 = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.RemoveSessionConfig.name());
    int i;
    try
    {
      if (TextUtils.isEmpty(str1)) {
        break label179;
      }
      i = Integer.parseInt(str1);
      if ((i & paramInt) != paramInt) {
        break label163;
      }
      if (Build.VERSION.SDK_INT >= 21) {
        break label133;
      }
      CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
      if (1 != paramInt) {
        break label101;
      }
      CookieManager.getInstance().removeAllCookie();
      label58:
      CookieSyncManager.getInstance().sync();
    }
    catch (Exception localException)
    {
      String str3;
      label101:
      while (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Remove all cookies failed", localException);
        return;
        label133:
        if (1 == paramInt) {
          CookieManager.getInstance().removeAllCookies(null);
        } else if (2 == paramInt) {
          CookieManager.getInstance().removeSessionCookies(null);
        }
      }
      label163:
      if (!QLog.isColorLevel()) {
        break label178;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Not required remove cookies");
    }
    if (QLog.isColorLevel())
    {
      str3 = jdField_a_of_type_JavaLangString;
      if (1 != paramInt) {
        break label185;
      }
    }
    label178:
    label179:
    label185:
    String str2;
    for (str1 = "all";; str2 = "session")
    {
      QLog.d(str3, 2, String.format("Remove %s cookies", new Object[] { str1 }));
      return;
      if (2 != paramInt) {
        break label58;
      }
      CookieManager.getInstance().removeSessionCookie();
      break label58;
      return;
      i = 15;
      break;
    }
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("qq_mode_foreground=");
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("qq_mode_foreground", false)))
      {
        bool = true;
        QLog.d((String)localObject, 2, bool);
      }
    }
    else
    {
      localObject = new pum(this);
      bool = WebProcessManager.b();
      if ((paramIntent == null) || (!paramIntent.getBooleanExtra("qq_mode_foreground", false))) {
        break label301;
      }
      if ((!bool) || (!WebProcessManager.c()) || (WebProcessManager.a())) {
        break label121;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "don't need kill web process!");
      }
    }
    label121:
    do
    {
      return;
      bool = false;
      break;
      if ((!SnapshotService.a()) || (this.d >= 10)) {
        break label187;
      }
      this.d += 1;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "don't kill web process for debug snapshot, " + this.d + "times");
    return;
    label187:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "restart web process");
    }
    this.d = 0;
    try
    {
      MsfServiceSdk.get().unRegisterMsfService();
      MsfServiceSdk.get().unbindMsfService();
      if (WebAccelerateHelper.getInstance().mTicketInfoListener != null) {
        ((TicketManager)getManager(2)).unregistTicketManagerListener(WebAccelerateHelper.getInstance().mTicketInfoListener);
      }
      WebProcessManager.b(false);
      paramIntent = new Intent();
      paramIntent.setAction("com.tencent.mobileqq.webprocess.restart_web_process");
      paramIntent.putExtra("isPreloadWebProcess", bool);
      BaseApplicationImpl.getContext().sendBroadcast(paramIntent);
      ThreadManager.b().post((Runnable)localObject);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    try
    {
      label301:
      MsfServiceSdk.get().unRegisterMsfService();
      MsfServiceSdk.get().unbindMsfService();
      if (WebAccelerateHelper.getInstance().mTicketInfoListener != null) {
        ((TicketManager)getManager(2)).unregistTicketManagerListener(WebAccelerateHelper.getInstance().mTicketInfoListener);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "exit web process");
      }
      WebProcessManager.b(false);
      if (bool)
      {
        paramIntent = new Intent();
        paramIntent.setAction("com.tencent.mobileqq.webprocess.report");
        BaseApplicationImpl.getContext().sendBroadcast(paramIntent);
      }
      ThreadManager.b().post((Runnable)localObject);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public static boolean a(ArrayList paramArrayList, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool1 = true;
      return bool1;
    }
    paramContext = MobileQQ.getMobileQQ().getProcessName();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void c()
  {
    QbSdk.setTbsLogClient(new pun(this, BaseApplicationImpl.getContext()));
  }
  
  public int a()
  {
    return 0;
  }
  
  public ReadInJoyLogicManager a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicManager = new ReadInJoyLogicManager(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicManager;
  }
  
  public OldBigDataChannelManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyOldBigDataChannelManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyOldBigDataChannelManager = new OldBigDataChannelManager(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyOldBigDataChannelManager;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public INetEngine a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public void a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if ((!AppNetConnInfo.isNetSupport()) || (!AppNetConnInfo.isWifiConn())) {}
    do
    {
      return;
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        long l = System.currentTimeMillis();
        QbSdk.setTbsListener(new puo(this, localBaseApplication.getSharedPreferences(localBaseApplication.getPackageName() + "_preferences", 4), l));
        if (QLog.isColorLevel()) {
          QLog.d("TBS_update", 2, "tbs start download");
        }
        TbsDownloader.startDownload(BaseApplication.getContext());
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TBS_update", 2, "tbs has started downloading");
  }
  
  public String c()
  {
    return null;
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush.GameStatusPush" };
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { GamePushServlet.class };
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    StartupTracker.a(null, "web_browserAppinterface_onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    b();
    c();
    String str = getAccount();
    if (TextUtils.isEmpty(str))
    {
      paramBundle = null;
      QbSdk.setCurrentID(paramBundle);
      HtmlOffline.a(new QQThreadManager());
      HtmlOffline.a(new OfflineDownloader());
      HtmlOffline.a(new MyLog());
      HtmlOffline.a(BaseApplicationImpl.getContext());
      if (getLongAccountUin() % 10L != 6L) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      HtmlOffline.jdField_a_of_type_Boolean = bool;
      ThreadManager.b().post(new puk(this, str));
      StartupTracker.a("web_browserAppinterface_onCreate", null);
      return;
      paramBundle = "QQ:" + str;
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyOldBigDataChannelManager == null) {}
    }
    catch (IllegalArgumentException localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyOldBigDataChannelManager.onDestroy();
        this.jdField_a_of_type_ComTencentMobileqqNearbyOldBigDataChannelManager = null;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
            return;
            localIllegalArgumentException = localIllegalArgumentException;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "unregisterReceiver: ", localIllegalArgumentException);
            }
          }
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  protected void onRunningBackground()
  {
    super.onRunningBackground();
    boolean bool = WebView.getTbsNeedReboot();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "tbs need reboot: " + bool);
    }
    if (bool) {
      a(BrowserAppInterface.class).postDelayed(new pup(this), 3000L);
    }
  }
  
  protected void onRunningForeground()
  {
    super.onRunningForeground();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentIntent = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\BrowserAppInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */