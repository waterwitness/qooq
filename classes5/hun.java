import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class hun
  implements View.OnClickListener
{
  public hun(EcShopRecommendView paramEcShopRecommendView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.get() != null)) {
      ((EcShopAssistantActivity)this.a.a.get()).b(1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */