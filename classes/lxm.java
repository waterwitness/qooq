import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class lxm
  implements DialogInterface.OnClickListener
{
  public lxm(NotificationActivity paramNotificationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    Bundle localBundle = new Bundle();
    localBundle.putString("password", null);
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a.app.a()))
    {
      this.a.app.updateSubAccountLogin(this.a.app.a(), false);
      this.a.app.getApplication().refreAccountList();
    }
    paramDialogInterface = (SubAccountManager)this.a.app.getManager(60);
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = paramDialogInterface.a();; paramDialogInterface = null)
    {
      if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
      {
        paramDialogInterface = paramDialogInterface.iterator();
        while (paramDialogInterface.hasNext())
        {
          String str = (String)paramDialogInterface.next();
          if (!PhoneNumLoginImpl.a().a(this.a.app, str))
          {
            this.a.app.updateSubAccountLogin(str, false);
            this.a.app.getApplication().refreAccountList();
          }
        }
      }
      this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(localBundle).addFlags(67108864));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */