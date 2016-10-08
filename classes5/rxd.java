import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.UnsupportedEncodingException;

public class rxd
  implements Runnable
{
  public rxd(FileManagerRSWorker paramFileManagerRSWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OfflineFileUploadPara localOfflineFileUploadPara = new OfflineFileUploadPara();
    localOfflineFileUploadPara.jdField_a_of_type_JavaLangString = this.a.e;
    localOfflineFileUploadPara.jdField_a_of_type_Long = this.a.d;
    this.a.jdField_a_of_type_ArrayOfByte = FileManagerUtil.c(this.a.jdField_b_of_type_JavaLangString);
    this.a.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString);
    this.a.c = FileManagerUtil.b(this.a.jdField_b_of_type_JavaLangString);
    if ((this.a.c == null) || (this.a.c == null) || (this.a.c == null))
    {
      this.a.a(null);
      return;
    }
    localOfflineFileUploadPara.c = this.a.jdField_a_of_type_ArrayOfByte;
    localOfflineFileUploadPara.d = this.a.jdField_b_of_type_ArrayOfByte;
    localOfflineFileUploadPara.e = this.a.c;
    try
    {
      localOfflineFileUploadPara.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localOfflineFileUploadPara.jdField_a_of_type_ArrayOfByte = this.a.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localOfflineFileUploadPara, FileManagerRSWorker.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */