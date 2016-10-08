import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class gwt
  extends TimerTask
{
  public gwt(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentArrangeOpMeetingInfo = null;
    if ((this.a.e == 0) && (!this.a.jdField_a_of_type_Boolean)) {
      MultiVideoEnterPageActivity.g(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */