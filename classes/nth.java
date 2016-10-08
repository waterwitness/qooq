import android.media.ExifInterface;
import android.os.AsyncTask;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class nth
  extends AsyncTask
{
  public nth(AIOGalleryScene paramAIOGalleryScene, File paramFile, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (JpegExifReader.isCrashJpeg(this.jdField_a_of_type_JavaIoFile.getAbsolutePath())) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new ExifInterface(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        if (this.jdField_a_of_type_Int != 0) {
          break label86;
        }
        paramVarArgs.setAttribute("Orientation", String.valueOf(1));
        paramVarArgs.saveAttributes();
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene;
        paramVarArgs.i += 1;
        return null;
      }
      catch (IOException paramVarArgs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOGalleryScene", 2, "save exif error", paramVarArgs);
      return null;
      label86:
      if (this.jdField_a_of_type_Int == 1) {
        paramVarArgs.setAttribute("Orientation", String.valueOf(6));
      } else if (this.jdField_a_of_type_Int == 2) {
        paramVarArgs.setAttribute("Orientation", String.valueOf(3));
      } else if (this.jdField_a_of_type_Int == 3) {
        paramVarArgs.setAttribute("Orientation", String.valueOf(8));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */