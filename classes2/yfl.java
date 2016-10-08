import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qlink.QlinkStandardDialogActivity;

public class yfl
  implements DialogInterface.OnClickListener
{
  public yfl(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.app.a().getApplicationContext(), 1, this.jdField_a_of_type_JavaLangString, null, 3020, 0, this.b, null, null, "返回", null);
    localIntent.putExtra("_FROM_QLINK_", true);
    this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */