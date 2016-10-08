import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qhx
  implements DialogInterface.OnClickListener
{
  public qhx(VideoBroadcastReceiver paramVideoBroadcastReceiver, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.a;
    paramInt = this.jdField_a_of_type_Int;
    int i = this.jdField_b_of_type_Int;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      VideoMsgTools.a(localQQAppInterface, paramInt, i, bool, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, null, true, new Object[0]);
      paramDialogInterface.dismiss();
      DataReport.b(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.a.isBackground_Pause, this.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qhx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */