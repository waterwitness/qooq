import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class qhy
  implements Runnable
{
  public qhy(VideoBroadcastReceiver paramVideoBroadcastReceiver, QQCustomDialog paramQQCustomDialog, int paramInt, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.a;
      i = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      VideoMsgTools.a(localQQAppInterface, i, 10, bool, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, null, true, new Object[0]);
      DataReport.c(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.a.isBackground_Pause, this.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */