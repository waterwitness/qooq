import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

class lzx
  implements DialogInterface.OnClickListener
{
  lzx(lzv paramlzv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!NetworkUtil.e(this.a.a))
    {
      PhoneUnityChangeActivity.a(this.a.a, 2131368805);
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new lzy(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    PhoneUnityChangeActivity.a(this.a.a).b(true, false);
    PhoneUnityChangeActivity.a(this.a.a, 2131368647, 0L, true);
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */