import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class lzf
  implements CompoundButton.OnCheckedChangeListener
{
  public lzf(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a)) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == this.a.f.a()) || (paramCompoundButton == this.a.h.a())) && (!NetworkUtil.e(this.a.getActivity())))
    {
      this.a.a(2131368804, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        paramBoolean = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, paramCompoundButton, paramBoolean);
      }
    }
    label417:
    label751:
    label1012:
    label1096:
    label1174:
    label1212:
    do
    {
      do
      {
        do
        {
          return;
          paramBoolean = false;
          break;
          if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
          {
            if (AppSetting.j) {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("允许附近的人赞我");
            }
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
              this.a.app.d(true, paramBoolean);
              return;
            }
          }
          if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
          {
            if (!NetworkUtil.e(this.a.app.getApplication().getApplicationContext()))
            {
              QQToast.a(this.a.getApplicationContext(), 2131369008, 1).a();
              this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
              paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
              if (this.a.app.f() == 1) {}
              for (paramBoolean = true;; paramBoolean = false)
              {
                paramCompoundButton.setChecked(paramBoolean);
                this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
                return;
              }
            }
            if (paramBoolean)
            {
              i = 1;
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
              this.a.a(this.a.getApplication().getResources().getString(2131370422));
              if (!paramBoolean) {
                break label417;
              }
            }
            for (i = 1;; i = 0)
            {
              this.a.app.g(i);
              return;
              i = 0;
              break;
            }
          }
          if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
          {
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
              this.a.app.b(paramBoolean, false);
              this.a.a(paramBoolean);
              return;
            }
          }
          if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
          {
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
              this.a.app.d(false, paramBoolean);
              return;
            }
          }
          if (paramCompoundButton == this.a.e.a())
          {
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
              if ((!NetworkUtil.e(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
                break;
              }
              if (AppSetting.j) {
                this.a.e.setContentDescription("个性签名同步到说说");
              }
              PermisionPrivacyActivity.a(this.a).a(paramBoolean);
              return;
            }
            paramCompoundButton = this.a;
            if (PermisionPrivacyActivity.a(this.a) != null)
            {
              i = 2131368804;
              PermisionPrivacyActivity.a(paramCompoundButton, i);
              paramCompoundButton = this.a;
              localObject = this.a.e.a();
              if (paramBoolean) {
                break label751;
              }
            }
            for (paramBoolean = true;; paramBoolean = false)
            {
              PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
              return;
              i = 2131370267;
              break;
            }
          }
          if (paramCompoundButton == this.a.d.a())
          {
            if (AppSetting.j) {
              this.a.d.setContentDescription("可通过系统通讯录发起QQ聊天");
            }
            ((ContactSyncManager)this.a.app.getManager(40)).a(paramBoolean);
            return;
          }
          if (paramCompoundButton == this.a.b.a())
          {
            if (AppSetting.j) {
              this.a.b.setContentDescription("向好友展示网络状态");
            }
            PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean);
            this.a.app.c(paramBoolean, true);
            return;
          }
          if (paramCompoundButton != this.a.f.a()) {
            break label1012;
          }
          PermisionPrivacyActivity.a(this.a, this.a.f.a(), paramBoolean);
          if (AppSetting.j) {
            this.a.f.setContentDescription("接收约会消息");
          }
          this.a.b(paramBoolean);
          paramCompoundButton = (NearbyRelevantHandler)this.a.app.a(66);
        } while (paramCompoundButton == null);
        if (paramBoolean) {}
        for (b = 0;; b = 1)
        {
          paramCompoundButton.a(b);
          if ((!this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (this.a.isFinishing())) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131368647, 1000);
          return;
        }
        if (paramCompoundButton != this.a.h.a()) {
          break label1212;
        }
        PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean);
        if (AppSetting.j) {
          this.a.h.setContentDescription("接收来电消息");
        }
        if (!paramBoolean) {
          break label1174;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004E71", "0X8004E71", 0, 0, "", "", "", "");
        paramCompoundButton = (LightalkSwitchHanlder)this.a.app.a(52);
      } while (paramCompoundButton == null);
      if (paramBoolean) {}
      for (byte b = 0;; b = 1)
      {
        paramCompoundButton.a(b);
        if ((!this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (this.a.isFinishing())) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131368647, 1000);
        return;
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004E72", "0X8004E72", 0, 0, "", "", "", "");
        break label1096;
      }
      if (paramCompoundButton == this.a.g.a())
      {
        PermisionPrivacyActivity.a(this.a, this.a.g.a(), paramBoolean);
        PermisionPrivacyActivity.a(this.a).a(paramBoolean, true);
        return;
      }
    } while (paramCompoundButton != this.a.c.a());
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
      if (!NetworkUtil.e(this.a.getActivity())) {
        break;
      }
      if (AppSetting.j) {
        this.a.c.setContentDescription("连续登录天数对他人可见");
      }
      ((CardHandler)this.a.app.a(2)).c(paramBoolean);
      return;
    }
    paramCompoundButton = this.a;
    if (PermisionPrivacyActivity.a(this.a) != null)
    {
      i = 2131368804;
      PermisionPrivacyActivity.a(paramCompoundButton, i);
      paramCompoundButton = this.a;
      localObject = this.a.c.a();
      if (paramBoolean) {
        break label1435;
      }
    }
    label1435:
    for (paramBoolean = true;; paramBoolean = false)
    {
      PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
      return;
      i = 2131370267;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */