import com.tencent.biz.pubaccount.readinjoy.SubscriptionViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class hwi
  extends ReadInJoyObserver
{
  public hwi(SubscriptionViewController paramSubscriptionViewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    if ((SubscriptionViewController.a(this.a) != null) && ((SubscriptionViewController.a(this.a) instanceof ReadInJoySubscriptionListViewGroup))) {
      ((ReadInJoySubscriptionListViewGroup)SubscriptionViewController.a(this.a)).a(paramList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */