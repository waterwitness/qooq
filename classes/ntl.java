import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import java.io.File;

public class ntl
  implements Runnable
{
  public ntl(AIOGalleryScene paramAIOGalleryScene, File paramFile, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h.equals(this.jdField_a_of_type_JavaIoFile.getPath())) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_JavaIoFile).booleanValue())) {
      new Handler(Looper.getMainLooper()).post(new ntm(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */