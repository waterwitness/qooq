import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QlinkStandardDialogActivity;

public class yfi
  implements DialogInterface.OnClickListener
{
  public yfi(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.b) {
        FileManagerUtil.a(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity, null, 777, false, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.finish();
      return;
      FileManagerUtil.a(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity, null, 888, false, 0);
      continue;
      paramDialogInterface = new Intent(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity, ScannerActivity.class);
      paramDialogInterface.putExtra("from", "qlink");
      this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */