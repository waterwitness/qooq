import com.tencent.arrange.op.ArrangeHandler;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.groupvideo.GroupVideoWrapper;
import cooperation.groupvideo.GroupVideoWrapper.OnGVideoReadyListener;

public class gcp
  implements GroupVideoWrapper.OnGVideoReadyListener
{
  public gcp(ArrangeHandler paramArrangeHandler, MeetingInfo paramMeetingInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GroupVideoWrapper paramGroupVideoWrapper)
  {
    paramGroupVideoWrapper.a(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo);
    paramGroupVideoWrapper.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */