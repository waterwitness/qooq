import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class voj
  extends LruCache
{
  public voj(int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(String paramString, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\voj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */