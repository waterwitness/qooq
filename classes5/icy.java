import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class icy
  implements Runnable
{
  public icy(SubscriptFeedsActivity paramSubscriptFeedsActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      SubscriptionFeed localSubscriptionFeed = (SubscriptionFeed)localIterator.next();
      if (localSubscriptionFeed.h > 0) {
        localSubscriptionFeed.a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */