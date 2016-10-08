import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vxg
  implements DownloadParams.DecodeHandler
{
  public vxg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    return DatingTopListActivity.a(paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */