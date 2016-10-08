package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.CallTabUnreadListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.observer.SdCardChangeListener;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import okx;
import oky;
import okz;
import ola;
import olb;
import olc;
import old;
import ole;
import olg;
import olk;
import oll;
import olm;
import oln;
import olo;
import olp;
import olr;
import ols;
import olt;
import olu;

public class MainAssistObserver
{
  private static final String jdField_a_of_type_JavaLangString = "MainAssistObserver";
  public final int a;
  public Handler a;
  public SplashActivity a;
  private CallTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener;
  private NewFriendManager.INewFriendListener jdField_a_of_type_ComTencentMobileqqAppNewFriendManager$INewFriendListener;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver;
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver;
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver;
  public SdCardChangeListener a;
  private VipGifObserver jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver;
  public QQCustomDialog a;
  public volatile boolean a;
  public final int b;
  public final int c;
  public final int d;
  
  public MainAssistObserver(SplashActivity paramSplashActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = 1;
    this.c = 3;
    this.d = 4;
    this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = null;
    this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new olm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new olo(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new olp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver = new olr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new ols(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new olt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = new olu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener = new oky(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager$INewFriendListener = new okz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new ola(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = new olg(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new olk(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private ReadInJoyNotifyRedTouchInfo a()
  {
    if (!b()) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return null;
    }
    ReadInJoyManager localReadInJoyManager = (ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(95);
    if (localReadInJoyManager == null) {
      return null;
    }
    return localReadInJoyManager.a();
  }
  
  private boolean a()
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null) {
        break label31;
      }
      bool2 = bool1;
    }
    label31:
    do
    {
      return bool2;
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
      bool1 = bool4;
      if (localQZoneManagerImp != null)
      {
        bool2 = bool3;
        if (localQZoneManagerImp.a(2) > 0) {
          bool2 = true;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d(QZoneLogTags.b + "MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localQZoneManagerImp.a(2) + " TYPE_ZEBRA_ALBUM:" + localQZoneManagerImp.a(17));
          bool1 = bool2;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d(QZoneLogTags.b + "MainAssistObserver", 2, "isNewQzoneMsgExist: " + bool1);
    return bool1;
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    Iterator localIterator = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(35)).b().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == 1130L) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b();
  }
  
  public int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
    if (localQZoneManagerImp != null)
    {
      int j = localQZoneManagerImp.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d(QZoneLogTags.b + "MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localQZoneManagerImp.a(1));
        i = j;
      }
    }
    return i;
  }
  
  public UpgradeDetailWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(33)).a(this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager$INewFriendListener);
      ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(43)).b();
      RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(35);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(localRedTouchManager.a());
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      ThreadManager.b().postDelayed(new okx(this), 1000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt1, paramInt2, paramObject);
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "WL_DEBUG updateTabRedTouch tabIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt, paramRedTypeInfo);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(33)).b(this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager$INewFriendListener);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
      ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(43)).c();
      RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(35);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(localRedTouchManager.a());
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void c()
  {
    try
    {
      ThreadManager.b().postDelayed(new oln(this), 500L);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MainAssistObserver", 4, "notifyWindowShowed e=" + localException);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.a(new olb(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.a(new olc(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(2, "NearbyUtils", "updateTabLebaNotify", new Object[0]);
    }
    ThreadManager.a(new old(this), 8, null, false);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    e();
    Object localObject = localQQAppInterface.a();
    NewFriendManager localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(33);
    if ((localObject != null) && (localNewFriendManager != null)) {
      ThreadManager.a(new ole(this, (QQMessageFacade)localObject, localQQAppInterface), 8, null, false);
    }
    localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(37);
    if (localObject != null) {
      a(36, 16, Integer.valueOf(((QCallFacade)localObject).a()));
    }
    g();
    f();
    localObject = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.a().sendBroadcast((Intent)localObject);
  }
  
  public void i()
  {
    System.out.println("consolidateMethod");
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "WL_DEBUG updateTabCallNotify");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.a(new oll(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\main\MainAssistObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */