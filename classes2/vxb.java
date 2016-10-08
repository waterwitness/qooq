import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public final class vxb
  implements DownloadParams.DecodeHandler
{
  public vxb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
    }
    if (paramBitmap == null) {
      return null;
    }
    paramDownloadParams = paramDownloadParams.tag;
    if (((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 2))
    {
      paramDownloadParams = (int[])paramDownloadParams;
      float f2 = DeviceInfoUtil.a();
      float f1 = f2;
      if (f2 < 0.01F) {
        f1 = 1.0F;
      }
      paramDownloadParams[0] = ((int)(paramDownloadParams[0] / f1));
      paramDownloadParams[1] = ((int)(paramDownloadParams[1] / f1));
      return ImageUtil.b(paramBitmap, paramDownloadParams[0], paramDownloadParams[1]);
    }
    return ImageUtil.b(paramBitmap, 50, 50);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */