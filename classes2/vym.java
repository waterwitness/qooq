import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.CustomLruCache;
import com.tencent.mobileqq.util.ImageCache;

public class vym
  extends CustomLruCache
{
  public vym(ImageCache paramImageCache, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(String paramString, Drawable paramDrawable)
  {
    int i = 0;
    int j = 0;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramString = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramString != null) {
        j = paramString.getRowBytes() * paramString.getHeight();
      }
    }
    int m;
    int k;
    do
    {
      do
      {
        return j;
      } while (!(paramDrawable instanceof AnimationDrawable));
      paramString = (AnimationDrawable)paramDrawable;
      m = paramString.getNumberOfFrames();
      k = 0;
      j = i;
    } while (k >= m);
    paramDrawable = paramString.getFrame(k);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        j = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * j + i;
      }
    }
    for (;;)
    {
      k += 1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */