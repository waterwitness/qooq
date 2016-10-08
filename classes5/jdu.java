import android.view.View;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jdu
  implements URLDrawableDownListener
{
  public jdu(TroopNewGuidePopWindow paramTroopNewGuidePopWindow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.a(false, "onLoadCancelled");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.a(false, "onLoadFailed");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.a.a(false, "onLoadInterrupted");
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.a(true, "onLoadSuccessed");
    this.a.a = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */