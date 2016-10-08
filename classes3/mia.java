import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mia
  implements DialogInterface.OnClickListener
{
  public mia(RegisterActivity paramRegisterActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity.a.sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */