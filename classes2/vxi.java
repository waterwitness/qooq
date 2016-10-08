import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;

public final class vxi
  implements DownloadParams.DecodeHandler
{
  public vxi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    Object localObject;
    do
    {
      do
      {
        return paramDownloadParams;
        localObject = paramDownloadParams.tag;
        paramDownloadParams = paramBitmap;
      } while (!(localObject instanceof int[]));
      paramDownloadParams = paramBitmap;
    } while (((int[])localObject).length != 2);
    paramDownloadParams = (int[])localObject;
    float f2 = DeviceInfoUtil.a();
    float f1 = f2;
    if (f2 < 0.01F) {
      f1 = 1.0F;
    }
    paramDownloadParams[0] = ((int)(paramDownloadParams[0] / f1));
    paramDownloadParams[1] = ((int)(paramDownloadParams[1] / f1));
    return ImageUtil.a(paramBitmap, paramDownloadParams[0], paramDownloadParams[1]);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */