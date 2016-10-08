import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class vyp
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public vyp(Resources paramResources, Bitmap paramBitmap, vyq paramvyq)
  {
    super(paramResources, paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramvyq);
  }
  
  public vyq a()
  {
    return (vyq)this.a.get();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */