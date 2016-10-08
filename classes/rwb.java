import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rwb
  implements Runnable
{
  public rwb(FileTransferHandler paramFileTransferHandler, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] Handle upload failed notify. retCode =" + this.jdField_a_of_type_Int + "(1:cancel upload) reason=" + this.jdField_a_of_type_JavaLangString);
    if (1 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.b, this.jdField_a_of_type_Long);
      return;
    }
    if (2 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.b, this.jdField_a_of_type_Long);
      return;
    }
    if (3 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().c(this.b, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.b, this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rwb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */