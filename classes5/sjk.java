import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class sjk
  implements Runnable
{
  public sjk(String paramString, int paramInt1, boolean paramBoolean, FileManagerUtil.IGetVideoCallback paramIGetVideoCallback, int paramInt2, int paramInt3)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MediaMetadataRetriever localMediaMetadataRetriever;
    if (Build.VERSION.SDK_INT >= 10) {
      localMediaMetadataRetriever = new MediaMetadataRetriever();
    }
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(this.jdField_a_of_type_JavaLangString);
        long l = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Int <= 0) {
          l = 5000000L;
        }
        localBitmap1 = localMediaMetadataRetriever.getFrameAtTime(l, 2);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Bitmap localBitmap1;
        localIllegalArgumentException = localIllegalArgumentException;
        try
        {
          localRuntimeException5.release();
          localObject1 = null;
        }
        catch (RuntimeException localRuntimeException1)
        {
          localObject2 = null;
        }
        continue;
      }
      catch (RuntimeException localRuntimeException2)
      {
        localRuntimeException2 = localRuntimeException2;
        try
        {
          localRuntimeException5.release();
          localObject3 = null;
        }
        catch (RuntimeException localRuntimeException3)
        {
          localObject4 = null;
        }
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError = localOutOfMemoryError;
        try
        {
          localRuntimeException5.release();
          localObject5 = null;
        }
        catch (RuntimeException localRuntimeException4)
        {
          localObject6 = null;
        }
        continue;
      }
      finally {}
      try
      {
        localMediaMetadataRetriever.release();
        if (localBitmap1 == null) {
          return;
        }
      }
      catch (RuntimeException localRuntimeException5)
      {
        continue;
      }
      try
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        localRuntimeException5.release();
        throw localBitmap2;
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback.a(localBitmap2);
          return;
        }
        float f;
        label167:
        Matrix localMatrix;
        if (localBitmap2.getWidth() < localBitmap2.getHeight())
        {
          f = this.b / localBitmap2.getWidth();
          localMatrix = new Matrix();
          localMatrix.setScale(f, f);
        }
        for (;;)
        {
          try
          {
            localBitmap3 = FileManagerUtil.a(localMatrix, localBitmap2, this.b, this.c);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IGetVideoCallback.a(localBitmap3);
            return;
          }
          catch (Exception localException)
          {
            Bitmap localBitmap3;
            QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception:" + localException.toString());
          }
          f = this.c / localBitmap3.getHeight();
          break label167;
          Object localObject7 = null;
        }
      }
      catch (RuntimeException localRuntimeException6)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */