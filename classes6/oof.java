import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class oof
  implements DialogInterface.OnClickListener
{
  oof(ooe paramooe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "new user guild confirm unbind");
    }
    this.a.a.a.b(this.a.a.m, this.a.a.n, 0, BindNumberActivity.a(this.a.a), BindNumberActivity.c(this.a.a));
    this.a.a.a(2131368647, 1000L, true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */