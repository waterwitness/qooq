import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gey
  implements DialogInterface.OnClickListener
{
  public gey(VideoController paramVideoController, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    if (this.b) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
    }
    ReportController.b(null, "CliOper", "", "", "0x8006993", "0x8006993", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */