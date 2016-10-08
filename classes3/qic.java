import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class qic
  implements Runnable
{
  public qic(VideoBroadcastReceiver paramVideoBroadcastReceiver, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */