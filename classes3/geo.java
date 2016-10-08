import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class geo
  implements Runnable
{
  public geo(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "mDoubleVideoMeetingSwitchMulti timeOut ");
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.a.a().e), Boolean.valueOf(true) });
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\geo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */