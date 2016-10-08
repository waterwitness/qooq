import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.OnAdapterNotify;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ntr
  implements AIOGalleryAdapter.OnAdapterNotify
{
  public ntr(AIOGalleryScene paramAIOGalleryScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.a.a().findViewById(2131302166);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    localView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(300L);
    localView.startAnimation(localAlphaAnimation);
    localView.postDelayed(new nts(this, localView), 8000L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */