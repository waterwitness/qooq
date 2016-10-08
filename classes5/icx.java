import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView.DrawFinishedListener;

public class icx
  implements XListView.DrawFinishedListener
{
  public icx(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((!this.a.c) && (this.a.d))
    {
      this.a.c = true;
      PublicTracker.a("SUBSCRIPT_FEEDS_COST", null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */