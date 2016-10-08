import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rvy
  implements Runnable
{
  public rvy(FileTransferHandler paramFileTransferHandler, long paramLong, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  handle cmd 0x211-0x1.save to weiyun");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */