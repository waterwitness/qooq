import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iej
  implements ViewStub.OnInflateListener
{
  public iej(SubscriptRecommendController paramSubscriptRecommendController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.a.a = paramView;
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */