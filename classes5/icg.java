import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView.DrawFinishedListener;

public class icg
  implements XListView.DrawFinishedListener
{
  public icg(ReadInJoySubscriptionListViewGroup paramReadInJoySubscriptionListViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((!this.a.b) && (this.a.c))
    {
      this.a.b = true;
      PublicTracker.a("SUBSCRIPT_FEEDS_COST", null);
      PublicTracker.a("KANDIAN_TO_SUBSCRIPT_COST", null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */