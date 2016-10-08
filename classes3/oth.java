import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oth
  extends LruCache
{
  public oth(PreloadImgManager paramPreloadImgManager, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(String paramString, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight() / 1024;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */