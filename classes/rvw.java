import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rvw
  implements Runnable
{
  public rvw(FileTransferHandler paramFileTransferHandler, String paramString, int paramInt, short paramShort, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.msgSeq = this.jdField_a_of_type_Short;
      localFileManagerEntity.msgUid = this.jdField_a_of_type_Long;
      localFileManagerEntity.msgTime = this.b;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().f(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "online change to offline, update offline msg seq , uid and msgTime" + FileManagerUtil.a(localFileManagerEntity));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */