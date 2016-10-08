import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.net.URL;

public class rvr
  implements Runnable
{
  public rvr(FileManagerEngine paramFileManagerEngine, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      URL localURL = FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (localURL != null) {
        URLDrawableHelper.a(localURL).downloadImediatly();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */