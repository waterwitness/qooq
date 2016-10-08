import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

public class mmy
  implements DialogInterface.OnClickListener
{
  public mmy(SubAccountMessageActivity paramSubAccountMessageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.a().c(SubAccountMessageActivity.a(this.a).subuin, 7000);
    paramDialogInterface = (SubAccountManager)this.a.app.getManager(60);
    if (paramDialogInterface != null) {
      paramDialogInterface.b(SubAccountMessageActivity.a(this.a).subuin);
    }
    paramDialogInterface = new Intent(this.a, SubLoginActivity.class);
    paramDialogInterface.putExtra("fromWhere", this.a.a);
    this.a.startActivity(paramDialogInterface);
    this.a.b();
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */