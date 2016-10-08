import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.Display;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.AndroidCamera.CameraPreviewCallback;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ggk
  implements Camera.PreviewCallback
{
  public ggk(AndroidCamera paramAndroidCamera)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool = true;
    int i;
    if (AndroidCamera.jdField_a_of_type_Int > 0)
    {
      if (!this.a.a()) {
        break label537;
      }
      if (this.a.jdField_d_of_type_Int != 1) {
        break label277;
      }
      i = this.a.jdField_a_of_type_AndroidViewDisplay.getRotation() * 90;
      if (this.a.e) {
        i = 0;
      }
      i = (360 - (i + this.a.g()) % 360) % 360;
    }
    for (;;)
    {
      int j = i + this.a.h();
      label185:
      label220:
      long l;
      if ((this.a.g() == 270) || (this.a.g() == 90))
      {
        i = j;
        if (this.a.h() % 180 == 0)
        {
          i = j;
          if (this.a.jdField_d_of_type_Int == 1) {
            if (PhoneStatusTools.a(this.a.jdField_a_of_type_AndroidContentContext, "ro.qq.orientation").equalsIgnoreCase("ZTE"))
            {
              i = j;
              if (!this.a.jdField_d_of_type_Boolean) {}
            }
            else
            {
              i = j + 180;
            }
          }
        }
        if (this.a.jdField_d_of_type_Int != 1) {
          break label487;
        }
        if (this.a.j <= 0) {
          break label460;
        }
        i += 360 - this.a.j;
        i = i % 360 / 90;
        if (this.a.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback != null)
        {
          paramCamera = this.a.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback;
          l = AndroidCamera.jdField_a_of_type_Int;
          if (this.a.jdField_d_of_type_Int != 1) {
            break label796;
          }
        }
      }
      for (;;)
      {
        paramCamera.a(paramArrayOfByte, i, l, bool);
        return;
        label277:
        if (this.a.jdField_d_of_type_Int != 2) {
          break label802;
        }
        i = this.a.jdField_a_of_type_AndroidViewDisplay.getRotation() * 90;
        if (this.a.e) {
          i = 0;
        }
        i = (this.a.g() - i + 360) % 360;
        break;
        if (this.a.g() != 0)
        {
          i = j;
          if (this.a.g() != 180) {
            break label185;
          }
        }
        if ((this.a.h() == 90) || (this.a.h() == 270))
        {
          i = j;
          if (this.a.jdField_d_of_type_Int != 1) {
            break label185;
          }
          i = j;
          if (this.a.c) {
            break label185;
          }
          i = j + 180;
          break label185;
        }
        i = j;
        if (this.a.jdField_d_of_type_Int != 1) {
          break label185;
        }
        i = j;
        if (!this.a.c) {
          break label185;
        }
        i = j + 180;
        break label185;
        label460:
        i += this.a.a(this.a.h(), this.a.e);
        break label220;
        label487:
        if (this.a.k > 0)
        {
          i += this.a.k;
          break label220;
        }
        i += this.a.b(this.a.h(), this.a.e);
        break label220;
        label537:
        j = (this.a.h() + this.a.h + 90) % 360;
        if (this.a.g() != 270)
        {
          i = j;
          if (this.a.g() != 90) {}
        }
        else
        {
          if (this.a.jdField_d_of_type_Int != 1) {
            break label696;
          }
          i = j + 90;
        }
        label606:
        if (this.a.jdField_d_of_type_Int == 1) {
          if (PhoneStatusTools.a(this.a.jdField_a_of_type_AndroidContentContext, "ro.qq.orientation").equalsIgnoreCase("ZTE"))
          {
            j = i;
            if (!this.a.jdField_d_of_type_Boolean) {}
          }
          else
          {
            j = i + 180;
          }
        }
        for (;;)
        {
          if (this.a.jdField_d_of_type_Int == 1)
          {
            if (this.a.j > 0)
            {
              i = j + (360 - this.a.j);
              break;
              label696:
              i = j + 180;
              break label606;
              j = i + 180;
              continue;
            }
            i = j + this.a.a(this.a.h(), this.a.e);
            break;
          }
        }
        if (this.a.k > 0)
        {
          i = j + this.a.k;
          break label220;
        }
        i = j + this.a.b(this.a.h(), this.a.e);
        break label220;
        label796:
        bool = false;
      }
      label802:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */