import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.forward.ForwardMarketFaceOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;

class slg
  implements URLDrawable.URLDrawableListener
{
  slg(slf paramslf)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setBounds(ImageUtil.a(paramURLDrawable, 36, 100, this.a.a.a));
    this.a.a.a(paramURLDrawable, false, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */