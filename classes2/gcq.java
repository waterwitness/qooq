import com.tencent.arrange.op.ArrangeHandler;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gcq
  implements QavWrapper.OnReadyListener
{
  public gcq(ArrangeHandler paramArrangeHandler, MeetingInfo paramMeetingInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QavWrapper paramQavWrapper)
  {
    paramQavWrapper.a(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo);
    paramQavWrapper.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */