import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class njh
  implements Runnable
{
  public njh(FilePicItemBuilder paramFilePicItemBuilder, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder.b.post(new nji(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\njh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */