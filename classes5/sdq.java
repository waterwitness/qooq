import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.ArrayList;
import java.util.List;

class sdq
  implements DialogInterface.OnClickListener
{
  sdq(sdp paramsdp, QlAndQQInterface.WorkState paramWorkState)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Sdp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("0X8004855", 1);
    Object localObject = new ArrayList();
    ((List)localObject).add(this.jdField_a_of_type_Sdp.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Sdp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin, (List)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("_FILE_PATH_", this.jdField_a_of_type_Sdp.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("STRING_CONTINUE_SEND_TO_", true);
    this.jdField_a_of_type_Sdp.jdField_a_of_type_AndroidAppActivity.setResult(10, (Intent)localObject);
    this.jdField_a_of_type_Sdp.jdField_a_of_type_AndroidAppActivity.finish();
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */