import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ooe
  extends ContactBindObserver
{
  public ooe(BindNumberActivity paramBindNumberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    int i;
    BindNumberActivity localBindNumberActivity;
    if ((BindNumberActivity.a(this.a) == 10) || (BindNumberActivity.a(this.a) == 11))
    {
      this.a.rightViewText.setEnabled(true);
      this.a.b();
      if (!paramBoolean) {
        break label1165;
      }
      localObject = ContactUtils.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ReportController.b(this.a.app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      i = paramBundle.getInt("k_result");
      localBindNumberActivity = this.a;
      if (!paramBundle.getBoolean("k_buto_bind", false)) {
        break label272;
      }
      if (BindNumberActivity.a(this.a) != 10) {
        break label200;
      }
      LoginWelcomeManager.a(this.a.app).a(this.a, 2);
      label140:
      this.a.setResult(-1);
      BindNumberActivity.a(this.a, 3);
    }
    for (;;)
    {
      ContactUtils.a();
      this.a.app.unRegistObserver(BindNumberActivity.b(this.a));
      BindNumberActivity.b(this.a, null);
      label185:
      return;
      this.a.a.setEnabled(true);
      break;
      label200:
      paramBundle = (PhoneContactManagerImp)this.a.app.getManager(10);
      localObject = paramBundle.a();
      if ((paramBundle.c()) || (localObject == null) || (((RespondQueryQQBindingStat)localObject).isStopFindMatch)) {
        break label140;
      }
      paramBundle = new Intent(this.a, PhoneMatchActivity.class);
      paramBundle.putExtra("key_from_contact_first", true);
      this.a.startActivity(paramBundle);
      break label140;
      label272:
      if ((i == 104) || (i == 0))
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("kSrouce", BindNumberActivity.a(this.a));
        paramBundle.putExtra("keyReqBindMode", 0);
        paramBundle.putExtra("k_number", this.a.n);
        paramBundle.putExtra("k_country_code", this.a.m);
        paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
        paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
        paramBundle.putExtra("cmd_param_is_from_uni", BindNumberActivity.a(this.a));
        paramBundle.putExtra("key_is_from_qav_multi_call", BindNumberActivity.b(this.a));
        paramBundle.putExtra("cmd_param_is_from_change_bind", BindNumberActivity.c(this.a));
      }
      for (;;)
      {
        if ((paramBundle == null) || (this.a.isFinishing())) {
          break label1163;
        }
        paramBundle.addFlags(536870912);
        paramBundle.addFlags(67108864);
        this.a.startActivityForResult(paramBundle, 2);
        break;
        if (i == 107)
        {
          if ((BindNumberActivity.a(this.a) == 10) || (BindNumberActivity.a(this.a) == 11))
          {
            localObject = paramBundle.getString("k_uin");
            paramBundle = (Bundle)localObject;
            if (((String)localObject).contains("***")) {
              paramBundle = ((String)localObject).replace("***", "");
            }
            paramBundle = DialogUtil.a(localBindNumberActivity, 230, null, this.a.getResources().getString(2131362955, new Object[] { this.a.n, paramBundle, this.a.app.a() }), "取消", "确定", new oof(this), new oog(this));
            if ((paramBundle == null) || (paramBundle.isShowing()) || (this.a.isFinishing())) {
              break label185;
            }
            paramBundle.show();
            return;
          }
          localObject = new Intent(this.a, RebindActivity.class);
          ((Intent)localObject).putExtra("k_uin", paramBundle.getString("k_uin"));
          ((Intent)localObject).putExtra("k_number", this.a.n);
          ((Intent)localObject).putExtra("k_country_code", this.a.m);
          ((Intent)localObject).putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
          ((Intent)localObject).putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
          ((Intent)localObject).putExtra("cmd_param_is_from_uni", BindNumberActivity.a(this.a));
          ((Intent)localObject).putExtra("key_is_from_qav_multi_call", BindNumberActivity.b(this.a));
          ((Intent)localObject).putExtra("cmd_param_is_from_change_bind", BindNumberActivity.c(this.a));
          paramBundle = (Bundle)localObject;
          continue;
        }
        if (i == 106)
        {
          if (this.a.getIntent().getBooleanExtra("k_is_block", false)) {
            ReportController.b(this.a.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 1, 0, "", "", "", "");
          }
          this.a.setResult(-1);
          BindNumberActivity.a(this.a, 2);
          paramBundle = null;
        }
        else
        {
          if (i == 227)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
            if (this.a.b == null) {
              this.a.b = DialogUtil.a(localBindNumberActivity, 230, "绑定冲突", "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, "我知道了", new ooh(this), null);
            }
            if ((this.a.b != null) && (!this.a.b.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.b.show();
              paramBundle = null;
            }
          }
          else if (i == 226)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8005B77", "0X8005B77", 0, 0, "", "", "", "");
            if (this.a.c == null) {
              this.a.c = DialogUtil.a(localBindNumberActivity, 230, "无法绑定", "当前要改绑QQ号未设置密码，无法绑定新的手机号码。请设置密码后重试。", null, "我知道了", new ooi(this), null);
            }
            if ((this.a.c != null) && (!this.a.c.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.c.show();
              paramBundle = null;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("IphoneTitleBarActivity", 2, "bind error " + i);
            }
            this.a.a(a(i));
          }
          paramBundle = null;
        }
      }
      label1163:
      continue;
      label1165:
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "onBindMobile failed");
      }
      this.a.b(2131368649);
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    if ((BindNumberActivity.a(this.a) == 10) || (BindNumberActivity.a(this.a) == 11))
    {
      this.a.b();
      if (!paramBoolean) {
        break label240;
      }
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("k_number", this.a.n);
      paramBundle.putExtra("kBindType", 0);
      paramBundle.putExtra("k_country_code", this.a.m);
      paramBundle.putExtra("cmd_param_is_from_uni", BindNumberActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_change_bind", BindNumberActivity.c(this.a));
      paramBundle.putExtra("kSrouce", BindNumberActivity.a(this.a));
      paramBundle.putExtra("keyReqBindMode", 1);
      paramBundle.addFlags(67108864);
      paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
      paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      paramBundle.putExtra("key_is_from_qav_multi_call", this.a.getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
      this.a.startActivityForResult(paramBundle, 2);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindNumberActivity.b(this.a));
      BindNumberActivity.b(this.a, null);
      return;
      label240:
      this.a.b(2131368649);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ooe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */