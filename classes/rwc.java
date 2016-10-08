import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rwc
  implements Runnable
{
  public rwc(FileTransferHandler paramFileTransferHandler, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] Handle upload progress notify. speed=" + this.jdField_a_of_type_Int + " progress =" + this.b);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */