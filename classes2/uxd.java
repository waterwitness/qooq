import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

public class uxd
  extends URLDrawableDecodeHandler
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  
  public uxd(StructMsgItemVideo paramStructMsgItemVideo, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int j = this.c;
    int k = paramBitmap.getWidth();
    if (paramBitmap.getHeight() != 0) {}
    for (int i = paramBitmap.getHeight();; i = this.c)
    {
      i = k * j / i;
      return ImageUtil.b(paramBitmap, this.jdField_a_of_type_Int, i, this.c);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */