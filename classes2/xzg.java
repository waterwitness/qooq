import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Build;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BTakePhotoActivity;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class xzg
  implements Camera.PictureCallback
{
  public xzg(C2BTakePhotoActivity paramC2BTakePhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    for (;;)
    {
      try
      {
        if (this.a.c == 0)
        {
          paramCamera = new File(C2BTakePhotoActivity.h);
          if (!paramCamera.exists()) {
            paramCamera.mkdirs();
          }
          this.a.i = (C2BTakePhotoActivity.h + System.currentTimeMillis() + ".jpg");
          paramCamera = new FileOutputStream(new File(this.a.i));
          paramCamera.write(paramArrayOfByte);
          paramCamera.close();
        }
        paramArrayOfByte = BitmapFactory.decodeStream(new ByteArrayInputStream(paramArrayOfByte));
        paramCamera = new Matrix();
        if (this.a.g != this.a.e) {
          continue;
        }
        paramCamera.setScale(-1.0F, 1.0F);
        if (!Build.MODEL.toLowerCase().equals("nexus 6p")) {
          continue;
        }
        paramCamera.postRotate(270.0F);
      }
      catch (IOException paramArrayOfByte)
      {
        this.a.a("保存文件失败！");
        continue;
        paramCamera.postRotate(90.0F);
        continue;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        continue;
      }
      paramArrayOfByte = Bitmap.createBitmap(paramArrayOfByte, 0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), paramCamera, true);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(new BitmapDrawable(paramArrayOfByte));
      if (this.a.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.a.h();
        this.a.b(true);
      }
      this.a.jdField_a_of_type_Boolean = false;
      return;
      paramCamera.postRotate(90.0F);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */