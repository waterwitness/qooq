import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class grd
  implements Runnable
{
  public grd(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity, this.jdField_a_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */