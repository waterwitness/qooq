import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hoy
  implements URLDrawable.URLDrawableListener
{
  public hoy(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((MultiVideoPlayActivity.a(this.a) != null) && (MultiVideoPlayActivity.a(this.a).getStatus() == 1) && ((MultiVideoPlayActivity.a(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)MultiVideoPlayActivity.a(this.a).getCurrDrawable();
      MultiVideoPlayActivity.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hoy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */