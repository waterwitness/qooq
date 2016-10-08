import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleBubbleImageView;
import java.net.URL;

public class npa
  extends CircleBubbleImageView
{
  URLDrawable a;
  public URLDrawable b;
  
  public npa(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(true);
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.a != null) {
      this.a.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.a = paramURLDrawable;
    paramURLDrawable.startDownload();
  }
  
  public boolean a(String paramString)
  {
    return (this.b == null) || (!this.b.getURL().getPath().equals(paramString));
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.b != paramURLDrawable) {
      this.b = paramURLDrawable;
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.a)
    {
      b(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.a) {
      b(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null)
    {
      this.a.setURLDrawableListener(null);
      this.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\npa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */