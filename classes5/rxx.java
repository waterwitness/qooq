import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class rxx
  extends TimerTask
{
  public rxx(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + OnlineFileSessionWorker.a(this.a).a() + " WaitSenderReplayOnRecvTimer time out!!!!!!!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 42, new Object[] { Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */