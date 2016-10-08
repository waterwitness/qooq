import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Vector;

public class lpi
  implements URLDrawable.URLDrawableListener
{
  public lpi(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "individuation urldrawable onLoadCanceled!!! url = " + paramURLDrawable.getURL());
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = paramURLDrawable.getURL().toString();
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "individuation urldrawable onLoadFialed!!! url = " + paramURLDrawable);
    }
    if (this.a.a.contains(paramURLDrawable)) {
      return;
    }
    this.a.a.add(paramURLDrawable);
    IndividuationSetActivity.a(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "individuation urldrawable onLoadProgressed!!! url = " + paramURLDrawable.getURL());
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "individuation urldrawable onLoadSuccessed!!! url = " + paramURLDrawable.getURL());
    }
    this.a.f = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */