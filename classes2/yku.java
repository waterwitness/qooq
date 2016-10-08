import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty;

public class yku
  implements URLDrawable.URLDrawableListener
{
  public yku(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QZoneLiveVideoBaseDownLoadActivty.a(this.a).setImageDrawable(paramURLDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */