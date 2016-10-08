import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;

public class lxf
  implements DialogInterface.OnClickListener
{
  public lxf(NotificationActivity paramNotificationActivity, signature.SignatureKickData paramSignatureKickData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
    try
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_ComTencentImsSignature$SignatureKickData.str_url.get()));
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(paramDialogInterface);
      paramDialogInterface = new Intent("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.sendBroadcast(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */