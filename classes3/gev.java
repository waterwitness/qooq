import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gev
  implements Runnable
{
  public gev(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "connectingRunnable");
    }
    if (!this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().f())
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 0);
      this.a.c(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */