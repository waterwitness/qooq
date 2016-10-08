import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PhoneUnityIntroductionActivity;
import com.tencent.mobileqq.activity.ThemeNoviceGuideActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class qcf
  extends ContactBindObserver
{
  public qcf(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a()
  {
    Object localObject1 = new qch(this);
    PhoneContactManagerImp.a(this.a).a((Runnable)localObject1);
    if (PhoneContactManagerImp.f) {}
    label153:
    label282:
    label732:
    label738:
    label767:
    do
    {
      boolean bool3;
      do
      {
        int i;
        boolean bool2;
        do
        {
          do
          {
            do
            {
              return;
              if (!UserguideActivity.a(PhoneContactManagerImp.a(this.a).a(), PhoneContactManagerImp.a(this.a).a())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("PhoneContact", 2, "UserguideActivity.showUserGuideThisTime = ture");
            return;
          } while (PhoneNumLoginImpl.a().a());
          i = this.a.d();
          bool2 = LoginWelcomeManager.a(PhoneContactManagerImp.a(this.a)).jdField_a_of_type_Boolean;
          bool3 = PhoneContactManagerImp.a(this.a);
          long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_pop_time_for_switchphone", 0L);
          if ((!PhoneContactManagerImp.b(this.a)) || (System.currentTimeMillis() - l <= 86400000L)) {
            break;
          }
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "bindState = " + i + ", isFristRun = " + bool3 + ", attempPop = " + bool1 + l + ",showNewUserGuide = " + bool2);
          }
        } while ((!bool3) && (!bool1));
        Object localObject2 = null;
        localObject1 = localObject2;
        if (PhoneContactManagerImp.a(this.a).isLogin()) {}
        Object localObject3;
        switch (i)
        {
        default: 
          localObject1 = localObject2;
          localObject2 = BaseActivity.sTopActivity;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("topActivity is:").append(localObject2).append(",isFinishing is:");
            if (localObject2 == null) {
              break label732;
            }
          }
          break;
        }
        for (boolean bool1 = ((AppActivity)localObject2).isFinishing();; bool1 = false)
        {
          QLog.d("PhoneContact.Manager", 2, bool1 + ",i is:" + localObject1);
          if ((localObject2 == null) || (((AppActivity)localObject2).isFinishing()) || (((AppActivity)localObject2).getAppRuntime() != PhoneContactManagerImp.a(this.a)) || ((localObject2 instanceof UserguideActivity)) || (bool2)) {
            break;
          }
          if (localObject1 == null) {
            break label767;
          }
          ((AppActivity)localObject2).startActivity((Intent)localObject1);
          ((AppActivity)localObject2).overridePendingTransition(2130968793, 2130968589);
          if (!bool3) {
            break label738;
          }
          PhoneContactManagerImp.b(this.a);
          return;
          bool1 = false;
          break label153;
          localObject1 = localObject2;
          if (!bool3) {
            break label282;
          }
          if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_bind_style", 0) == 0)
          {
            localObject1 = new Intent(PhoneContactManagerImp.a(this.a).a().getApplicationContext(), PhoneUnityIntroductionActivity.class);
            ((Intent)localObject1).putExtra("kSrouce", 9);
            ReportController.b(PhoneContactManagerImp.a(this.a), "CliOper", "", "", "0X8006EF7", "0X8006EF7", 0, 0, "", "", "", "");
            break label282;
          }
          localObject1 = localObject2;
          if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_bind_style", 0) != 1) {
            break label282;
          }
          localObject1 = new Intent(PhoneContactManagerImp.a(this.a).a().getApplicationContext(), BindNumberActivity.class);
          ((Intent)localObject1).putExtra("kSrouce", 11);
          ReportController.b(PhoneContactManagerImp.a(this.a), "CliOper", "", "", "0X8006EF8", "0X8006EF8", 0, 0, "", "", "", "");
          break label282;
          localObject1 = localObject2;
          if (this.a.a() == null) {
            break label282;
          }
          localObject1 = localObject2;
          if (this.a.a().lastUsedFlag != 3L) {
            break label282;
          }
          localObject1 = new Intent(PhoneContactManagerImp.a(this.a).a().getApplicationContext(), PhoneMatchActivity.class);
          break label282;
          localObject3 = this.a.a();
          localObject1 = localObject2;
          if (this.a.c()) {
            break label282;
          }
          localObject1 = localObject2;
          if (localObject3 == null) {
            break label282;
          }
          localObject1 = localObject2;
          if (((RespondQueryQQBindingStat)localObject3).isStopFindMatch) {
            break label282;
          }
          localObject2 = new Intent(PhoneContactManagerImp.a(this.a).a().getApplicationContext(), PhoneMatchActivity.class);
          localObject1 = localObject2;
          if (!bool3) {
            break label282;
          }
          ((Intent)localObject2).putExtra("key_from_contact_first", true);
          localObject1 = localObject2;
          break label282;
        }
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).commit();
        return;
      } while (!bool3);
      localObject1 = PhoneContactManagerImp.a(this.a).getPreferences();
    } while ((localObject1 == null) || (((SharedPreferences)localObject1).getBoolean("THEME_NOVICE_GUIDE_RUNED", false)) || (!BaseApplicationImpl.jdField_a_of_type_Boolean));
    ((SharedPreferences)localObject1).edit().putBoolean("THEME_NOVICE_GUIDE_RUNED", true).commit();
    localObject1 = new Intent(BaseActivity.sTopActivity, ThemeNoviceGuideActivity.class);
    BaseActivity.sTopActivity.startActivity((Intent)localObject1);
    BaseActivity.sTopActivity.overridePendingTransition(2130968585, 2130968586);
    PhoneContactManagerImp.b(this.a);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (PhoneContactManagerImp.a(this.a) == null) {
      PhoneContactManagerImp.a(this.a, new qcu(this.a, null));
    }
    PhoneContactManagerImp.a(this.a).a(paramInt1, paramInt2);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, 2);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUploadContact, isSuc = " + paramBoolean + ", reason = " + paramInt);
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication != null) && (this.a.e))
    {
      if (paramBoolean)
      {
        QQToast.a(localBaseApplication, 0, "手机通讯录匹配完成。", 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131492908));
        this.a.e = false;
      }
    }
    else
    {
      if (PhoneContactManagerImp.a(this.a) != null)
      {
        PhoneContactManagerImp.a(this.a).b();
        PhoneContactManagerImp.a(this.a, null);
      }
      if (!paramBoolean) {
        break label198;
      }
      this.a.jdField_a_of_type_Int = 6;
      PhoneContactManagerImp.a(this.a, 0L, 0L);
      PhoneContactManagerImp.a(this.a, 15);
    }
    for (;;)
    {
      PhoneContactManagerImp.c(this.a);
      this.a.a(true, true);
      return;
      QQToast.a(localBaseApplication, 0, "手机通讯录匹配失败。", 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131492908));
      break;
      label198:
      this.a.jdField_c_of_type_Long = System.currentTimeMillis();
      if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Int = 4;
      }
      else if (paramInt == 3)
      {
        this.a.jdField_a_of_type_Int = 6;
        this.a.g = true;
      }
      else if (paramInt == 1)
      {
        this.a.jdField_a_of_type_Int = 1;
        this.a.jdField_c_of_type_Long = 0L;
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      MqqHandler localMqqHandler = PhoneContactManagerImp.a(this.a).a(Conversation.class);
      if (localMqqHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1041;
        localMqqHandler.sendMessage(localMessage);
      }
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_b_of_type_Long = System.currentTimeMillis();
    if (paramBoolean1)
    {
      PhoneContactManagerImp.a(this.a, this.a.jdField_a_of_type_Boolean);
      if (this.a.jdField_a_of_type_Boolean) {
        ThreadManager.b().postDelayed(new qcg(this), 1000L);
      }
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((MyBusinessManager)PhoneContactManagerImp.a(this.a).getManager(48)).a("", 0, "");
      this.a.a(true, true);
      this.a.jdField_a_of_type_Int = 1;
      PhoneContactManagerImp.c(this.a);
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.a(true, true);
    }
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onQueryContactList, isSuc = " + paramBoolean + ", updateFlag = " + paramInt);
    }
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, paramInt);
    }
    if (this.a.e() >= 4) {
      ThreadManager.b().postDelayed(PhoneContactManagerImp.a(this.a), PhoneContactManagerImp.jdField_a_of_type_Long);
    }
    PhoneContactManagerImp.d(this.a);
  }
  
  protected void d(boolean paramBoolean)
  {
    PhoneContactManagerImp.a(this.a, false);
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, 2);
    }
  }
  
  protected void d(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUpdateContact, isSuc = " + paramBoolean + ", reason = " + paramInt);
    }
    this.a.jdField_c_of_type_Boolean = false;
    if (paramBoolean)
    {
      PhoneContactManagerImp.a(this.a, 1);
      PhoneContactManagerImp.a(this.a, 0L, 0L);
    }
    for (;;)
    {
      this.a.a(true, true);
      return;
      if ((paramInt == 2) || (paramInt == 3)) {
        this.a.g = true;
      }
      this.a.d = System.currentTimeMillis();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */