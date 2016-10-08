import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

class opy
  implements DialogInterface.OnClickListener
{
  opy(opw paramopw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.c == 2) {
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B8A", "0X8005B8A", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      if (NetworkUtil.e(this.a.a)) {
        break;
      }
      this.a.a.b(2131368805);
      return;
      if (this.a.a.c == 6) {
        ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B8A", "0X8005B8A", 2, 0, "", "", "", "");
      } else if (this.a.a.c == 7) {
        ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B8A", "0X8005B8A", 3, 0, "", "", "", "");
      }
    }
    paramDialogInterface = this.a.a.a.a();
    if ((paramDialogInterface == null) || (paramDialogInterface.nationCode == null) || (paramDialogInterface.mobileNo == null))
    {
      this.a.a.setResult(0);
      this.a.a.finish();
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new opz(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)this.a.a.app.getManager(101);
    this.a.a.a.c(paramDialogInterface.nationCode, paramDialogInterface.mobileNo);
    this.a.a.a(2131368647, 0L, true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */