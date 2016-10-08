import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class qia
  implements Runnable
{
  public qia(VideoBroadcastReceiver paramVideoBroadcastReceiver, QQCustomDialog paramQQCustomDialog, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.a, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, false, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, false, null, false, new Object[0]);
      VideoBroadcastReceiver.a(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver, 8, this.jdField_a_of_type_JavaLangString, this.c, this.d);
      DataReport.e(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.a.isBackground_Pause);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */