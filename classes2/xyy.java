import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BScanCodeActivity;

public class xyy
  implements URLDrawable.URLDrawableListener
{
  public xyy(C2BScanCodeActivity paramC2BScanCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    C2BScanCodeActivity.a(this.a).setImageDrawable(null);
    C2BScanCodeActivity.a(this.a).setImageDrawable(paramURLDrawable);
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */