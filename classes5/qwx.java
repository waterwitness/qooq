import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper.CameraHelperCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class qwx
  extends AsyncTask
{
  Rect jdField_a_of_type_AndroidGraphicsRect;
  CameraHelper.CameraHelperCallback jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback;
  File jdField_a_of_type_JavaIoFile;
  byte[] jdField_a_of_type_ArrayOfByte;
  Rect b;
  
  public qwx(CameraHelper paramCameraHelper, byte[] paramArrayOfByte, File paramFile, Rect paramRect1, Rect paramRect2, CameraHelper.CameraHelperCallback paramCameraHelperCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
    this.b = paramRect2;
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback = paramCameraHelperCallback;
  }
  
  protected String a(Void... paramVarArgs)
  {
    File localFile = this.jdField_a_of_type_JavaIoFile;
    for (paramVarArgs = null;; paramVarArgs = Bitmap.createScaledBitmap(paramVarArgs, i, 1020, true))
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfByte != null)
        {
          long l1 = Runtime.getRuntime().totalMemory() / 1024L;
          long l2 = Runtime.getRuntime().maxMemory() / 1024L;
          long l3 = Runtime.getRuntime().freeMemory() / 1024L;
          long l4 = l2 - (l1 - l3);
          if (QLog.isColorLevel()) {
            QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "remain= " + l4 + ",totalMemory=" + l1 + ",maxMemory=" + l2 + ",freeMemory" + l3);
          }
          if (l4 < 10240L)
          {
            URLDrawable.clearMemoryCache();
            System.gc();
          }
          paramVarArgs = BitmapManager.a(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_Boolean = false;
        }
        if (paramVarArgs != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "bitmap with=" + paramVarArgs.getWidth() + " height=" + paramVarArgs.getHeight());
          }
          int j = 1020;
          i = this.jdField_a_of_type_AndroidGraphicsRect.height() * 1020 / this.jdField_a_of_type_AndroidGraphicsRect.width();
          if ((1020 <= paramVarArgs.getHeight()) && (i <= paramVarArgs.getWidth())) {
            continue;
          }
          j = paramVarArgs.getHeight();
          i = paramVarArgs.getWidth();
          if ((QLog.isColorLevel()) && (paramVarArgs != null)) {
            QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "scale with=" + paramVarArgs.getWidth() + " height=" + paramVarArgs.getHeight());
          }
          int k = this.b.height() * i / this.jdField_a_of_type_AndroidGraphicsRect.height();
          int m = this.b.width() * j / this.jdField_a_of_type_AndroidGraphicsRect.width();
          Object localObject = new Rect((i - k) / 2, (j - m) / 2, (i + k) / 2, (j + m) / 2);
          if (QLog.isColorLevel()) {
            QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "resizeRect: " + ((Rect)localObject).toString() + " resizeRectW= " + k + " resizeRectH= " + m);
          }
          paramVarArgs = Bitmap.createScaledBitmap(Bitmap.createBitmap(paramVarArgs, ((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height()), 600, 1000, true);
          localObject = new Matrix();
          ((Matrix)localObject).postRotate(90.0F);
          paramVarArgs = Bitmap.createBitmap(paramVarArgs, 0, 0, paramVarArgs.getWidth(), paramVarArgs.getHeight(), (Matrix)localObject, false);
          if (paramVarArgs != null) {
            a(paramVarArgs, localFile);
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.e(CameraHelper.jdField_a_of_type_JavaLangString, 2, paramVarArgs.toString());
          }
        }
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        for (;;)
        {
          System.gc();
          if (QLog.isColorLevel()) {
            QLog.e(CameraHelper.jdField_a_of_type_JavaLangString, 2, paramVarArgs.toString());
          }
        }
      }
      if (!localFile.exists()) {
        break;
      }
      return localFile.getAbsolutePath();
    }
    return null;
  }
  
  public void a(Bitmap paramBitmap, File paramFile)
  {
    try
    {
      paramFile = new BufferedOutputStream(new FileOutputStream(paramFile));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramFile);
      paramFile.flush();
      paramFile.close();
      return;
    }
    catch (IOException paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "saveJpeg", paramBitmap);
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback.a(paramString);
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.i(CameraHelper.jdField_a_of_type_JavaLangString, 2, "Picture bitmap data error or output file not exist");
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "startPreview[failed] Exception=" + paramString.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */