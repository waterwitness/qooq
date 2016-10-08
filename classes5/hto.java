import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ADViewIndividuation;

public class hto
  implements URLDrawableDownListener
{
  public hto(EcShopAssistantActivity paramEcShopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (View)paramView.getTag();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof ProgressBar))) {
      paramURLDrawable.setVisibility(8);
    }
    for (;;)
    {
      ((FrameLayout.LayoutParams)paramView.getLayoutParams()).height = AIOUtils.a(100.0F, this.a.getResources());
      return;
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof ADViewIndividuation))) {
        ((ADViewIndividuation)paramURLDrawable).setNavVisible(1, true);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */