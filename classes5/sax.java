import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sax
  implements Runnable
{
  public sax(FileManagerProxy paramFileManagerProxy, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */