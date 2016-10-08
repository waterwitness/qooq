import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public final class vxf
  implements DownloadParams.DecodeHandler
{
  public vxf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    do
    {
      do
      {
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
        } while (((int[])localObject).length != 3);
        paramDownloadParams = (int[])localObject;
        paramBitmap = ImageUtil.c(paramBitmap, paramDownloadParams[2], paramDownloadParams[0], paramDownloadParams[1]);
        paramDownloadParams = paramBitmap;
      } while (paramBitmap != null);
      paramDownloadParams = paramBitmap;
    } while (!QLog.isDevelopLevel());
    QLog.w(URLDrawableDecodeHandler.a(), 2, "ROUND_CORNER_DECODER bitmap == null");
    return paramBitmap;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */