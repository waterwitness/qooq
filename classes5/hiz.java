import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;

public class hiz
  implements URLDrawable.URLDrawableListener
{
  public hiz(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.a(paramURLDrawable);
    Bitmap localBitmap = ImageUtil.b(paramURLDrawable, 110, 110);
    this.a.c.setImageBitmap(localBitmap);
    paramURLDrawable.recycle();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */