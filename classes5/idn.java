import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class idn
  implements Runnable
{
  public idn(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SubscriptFeedsActivity.a(this.a, SubscriptRecommendController.b(this.a.app));
    if (PublicAccountUtil.a(this.a.app)) {
      SubscriptFeedsActivity.a(this.a, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */