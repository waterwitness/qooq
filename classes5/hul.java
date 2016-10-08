import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hul
  implements ViewStub.OnInflateListener
{
  public hul(EcShopRecommendView paramEcShopRecommendView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.a.a = paramView;
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */