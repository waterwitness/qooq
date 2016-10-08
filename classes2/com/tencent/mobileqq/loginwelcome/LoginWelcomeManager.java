package com.tencent.mobileqq.loginwelcome;

import SecurityAccountServer.RecommendedContactInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONArray;
import szf;
import szg;
import szh;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.ContactBindInfo;

public class LoginWelcomeManager
  implements BusinessObserver, PhoneContactManager.IPhoneContactListener, Runnable, Manager
{
  public static final int a = 1;
  static long jdField_a_of_type_Long = 0L;
  public static final String a = "NewerGuide";
  public static final int b = 0;
  public static final String b = "loginwelcome_";
  public static final int c = 1;
  public static final String c = "first_login";
  public static final int d = 2;
  public static final String d = "http://ti.qq.com/newguide/index.html?_wv=16777217&bind=%s&appid=%d";
  public Bundle a;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public QQAppInterface a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  LoginWelcomeHandler jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler;
  public NearbyCardObserver a;
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  Bundle jdField_b_of_type_AndroidOsBundle;
  boolean jdField_b_of_type_Boolean;
  int e;
  public String e;
  
  public LoginWelcomeManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new szf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new szg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_e_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuide", 2, "LoginWelcomeManager newinstance");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler = ((LoginWelcomeHandler)paramQQAppInterface.a(84));
  }
  
  public static LoginWelcomeManager a(QQAppInterface paramQQAppInterface)
  {
    return (LoginWelcomeManager)paramQQAppInterface.getManager(145);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    run();
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("loginwelcome_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 0);
    int i = localSharedPreferences.getInt("first_login", 0);
    if (i != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this, true);
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler.a();
      localSharedPreferences.edit().putInt("first_login", 1).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuide", 2, "requestIsFirstLogin : " + i);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 558) {
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 2)
        {
          if ((paramObject[0] != null) && ((paramObject[0] instanceof String))) {
            this.jdField_e_of_type_JavaLangString = ((String)paramObject[0]);
          }
          if ((paramObject[1] == null) || (!(paramObject[1] instanceof oidb_0x59f.ContactBindInfo))) {
            break label201;
          }
          paramObject = (oidb_0x59f.ContactBindInfo)paramObject[1];
          if ((paramObject == null) || (!((oidb_0x59f.ContactBindInfo)paramObject).mobile.has()) || (TextUtils.isEmpty(((oidb_0x59f.ContactBindInfo)paramObject).mobile.get()))) {
            break label201;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006E3A", "0X8006E3A", 0, 0, "", "", "", "");
        }
      }
    }
    label201:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuide", 2, "onUpdate number: " + this.jdField_e_of_type_JavaLangString + " bind " + paramBoolean);
      }
      this.jdField_a_of_type_Boolean = true;
      a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
      return;
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuide", 2, "startWebPage " + paramInt + paramContext.getClass().getSimpleName());
    }
    String str = String.format("http://ti.qq.com/newguide/index.html?_wv=16777217&bind=%s&appid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AppSetting.a) });
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    NearbyCardHandler localNearbyCardHandler = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(60);
    long l = paramBundle.getLong("tinyId");
    NearbyProfileUtil.a(localNearbyCardHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, null, 100, null, 0L, false, 0L);
  }
  
  public void a(MessengerService paramMessengerService, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramMessengerService);
    }
    paramMessengerService = paramBundle.getBundle("request");
    String str = paramMessengerService.getString("key_action");
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuide", 2, "handleWebRequest " + str);
    }
    if (str.equals("getRecommendedList"))
    {
      this.jdField_b_of_type_AndroidOsBundle = paramBundle;
      c();
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidOsBundle == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NewerGuide", 2, "invalid");
      return;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      if (str.equals("followPublicAccount"))
      {
        c(paramMessengerService);
        return;
      }
      if (str.equals("joinTroop"))
      {
        b(paramMessengerService);
        return;
      }
    } while (!str.equals("sayHi"));
    a(paramMessengerService);
  }
  
  public void a(List paramList)
  {
    Object localObject = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    int i;
    if (paramList == null)
    {
      ((Bundle)localObject).putString("op_result", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("resp Recommended ");
        if (paramList != null) {
          break label245;
        }
        i = 0;
        label51:
        QLog.d("NewerGuide", 2, i);
      }
      paramList = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramList == null) {
        break label256;
      }
      paramList.a(this.jdField_b_of_type_AndroidOsBundle);
    }
    label245:
    label256:
    while (!QLog.isColorLevel())
    {
      return;
      QQHeadDownloadHandler localQQHeadDownloadHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)localIterator.next();
        String str = MsfSdkUtils.insertMtype("QQHeadIcon", localRecommendedContactInfo.faceUrl + localQQHeadDownloadHandler.a((byte)(int)localRecommendedContactInfo.faceFlag));
        localRecommendedContactInfo.url = (str + "&t=" + System.currentTimeMillis());
        localJSONArray.put(localRecommendedContactInfo.toJson());
      }
      ((Bundle)localObject).putString("op_result", localJSONArray.toString());
      break;
      i = paramList.size();
      break label51;
    }
    QLog.d("NewerGuide", 2, "no service");
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b()
  {
    MessengerService localMessengerService = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localMessengerService != null)
    {
      localMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidOsBundle = null;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("NewerGuide", 2, "no service");
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuide", 2, "onBindStateChanged" + paramInt);
    }
    if (paramInt != 5)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("NewerGuide", 2, "upload end");
        QLog.d("NewerGuide", 2, "cost " + (SystemClock.uptimeMillis() - jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
        if (paramInt != 6) {
          break label115;
        }
        d();
      }
    }
    return;
    label115:
    a(null);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      localTroopHandler.a(Long.parseLong(paramBundle), 8390784);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NewerGuide", 2, "joinTroop err", paramBundle);
    }
  }
  
  public void c()
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i();
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c >= 2))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("NewerGuide", 2, "onUpdateMatchProgress >4");
        QLog.d("NewerGuide", 2, "cost " + (SystemClock.uptimeMillis() - jdField_a_of_type_Long));
      }
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
    }
  }
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str, new szh(this, paramBundle));
  }
  
  public void d()
  {
    Bundle localBundle = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 36);
    localNewIntent.putExtra("unique_phone_no", ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a());
    int i = localBundle.getInt("wantCount");
    if (i > 0) {}
    for (;;)
    {
      localNewIntent.putExtra("wantCount", i);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuide", 2, "realGetRecommendedList " + i);
      }
      return;
      i = 21;
    }
  }
  
  public void d(int paramInt) {}
  
  public void onDestroy() {}
  
  public void run()
  {
    int i;
    try
    {
      i = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = i;
      if (i > 10)
      {
        QLog.d("NewerGuide", 1, "retry max");
        return;
      }
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity == null) || (!(localBaseActivity instanceof RegisterQQNumberActivity))) {
        break label75;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 200L);
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label274;
      }
    }
    QLog.d("NewerGuide", 2, localException, new Object[0]);
    return;
    label75:
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuide", 2, "real start guide " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuide", 2, "no permission");
      }
      a(localException, 0);
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", localException, localException, 0, 0, "", "", "", "");
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        a(localException, 1);
        i = 1;
      }
      else
      {
        Intent localIntent = new Intent(localException, BindNumberActivity.class);
        localIntent.putExtra("kSrouce", 10);
        localException.startActivity(localIntent);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006E3B", "0X8006E3B", 0, 0, "", "", "", "");
        i = 1;
      }
      label274:
      while (i == 0)
      {
        str = "0X8006E39";
        break;
        return;
      }
      String str = "0X8006E38";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\loginwelcome\LoginWelcomeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */