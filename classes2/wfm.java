import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.VideoCallBack;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class wfm
  implements Runnable
{
  public wfm(VideoCallBack paramVideoCallBack, QQProgressDialog paramQQProgressDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在处理");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */