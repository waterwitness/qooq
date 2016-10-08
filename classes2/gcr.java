import android.os.Message;
import com.tencent.arrange.op.ArrangeHandler;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.arrange.ui.ArrangeUtil;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;
import mqq.os.MqqHandler;

public class gcr
  extends TimerTask
{
  public gcr(ArrangeHandler paramArrangeHandler, MeetingInfo paramMeetingInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.b.a().a(2, Long.parseLong(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getDiscuss_uin())) <= 0L) {
      ArrangeUtil.a(this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.b, this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo, 1);
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.b.a(AVNotifyCenter.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(10013);
      localMessage.obj = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo;
      localMqqHandler.sendMessage(localMessage);
    }
    ArrangeHandler.a(this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler, this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */