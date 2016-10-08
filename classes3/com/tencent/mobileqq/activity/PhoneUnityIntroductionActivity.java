package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class PhoneUnityIntroductionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int b = 1;
  public int a;
  
  public PhoneUnityIntroductionActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      if (this.a != 9) {
        break label63;
      }
      super.setResult(paramInt2);
      super.finish();
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8006EF9", "0X8006EF9", 0, 0, "", "", "", "");
      return;
      label63:
      paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
      paramIntent.putExtra("kSrouce", this.a);
      paramIntent.putExtra("kBindNew", true);
      paramIntent.addFlags(603979776);
      super.startActivity(paramIntent);
      super.setResult(paramInt2);
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = super.getIntent().getIntExtra("kSrouce", -1);
    if (this.a == 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005B74", "0X8005B74", 1, 0, "", "", "", "");
      super.setContentView(2130904275);
      super.setTitle(getString(2131370987));
      super.setContentBackgroundResource(2130837958);
      if (this.a == 9)
      {
        paramBundle = (TextView)super.findViewById(2131298561);
        String str = ((PhoneContactManagerImp)this.app.getManager(10)).b();
        if (TextUtils.isEmpty(str)) {
          break label248;
        }
        paramBundle.setText(str);
      }
    }
    for (;;)
    {
      super.setTitle(2131370988);
      findViewById(2131298562).setVisibility(8);
      findViewById(2131298563).setVisibility(8);
      findViewById(2131302145).setVisibility(8);
      ReportController.b(this.app, "dc00898", "", "", "0X8006899", "0X8006899", 0, 0, "", "", "", "");
      paramBundle = (Button)super.findViewById(2131302146);
      if (paramBundle != null) {
        paramBundle.setOnClickListener(this);
      }
      return true;
      if (this.a != 1) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005B74", "0X8005B74", 2, 0, "", "", "", "");
      break;
      label248:
      paramBundle.setText(2131370992);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131302146)
    {
      if (NetworkUtil.e(this)) {
        break label40;
      }
      if (!isFinishing()) {
        QQToast.a(this, 0, 2131368805, 0).b(super.getTitleBarHeight());
      }
    }
    label40:
    do
    {
      return;
      if (this.a == 9)
      {
        ContactUtils.a(2);
        ReportController.b(this.app, "dc00898", "", "", "0X800689A", "0X800689A", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        paramView = new Intent(this, BindNumberActivity.class);
        if (this.a != 9) {
          paramView.putExtra("cmd_param_is_from_uni", true);
        }
        paramView.putExtra("cmd_param_is_from_change_bind", false);
        paramView.putExtra("kSrouce", this.a);
        super.startActivityForResult(paramView, 1);
        if (this.a != 0) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005B75", "0X8005B75", 1, 0, "", "", "", "");
        return;
        if (this.a == 1) {
          ContactUtils.a(3);
        }
      }
    } while (this.a != 1);
    ReportController.b(this.app, "CliOper", "", "", "0X8005B75", "0X8005B75", 2, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PhoneUnityIntroductionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */