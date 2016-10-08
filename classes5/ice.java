import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView.DrawFinishedListener;

public class ice
  implements XListView.DrawFinishedListener
{
  public ice(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((!this.a.a) && (this.a.b))
    {
      this.a.a = true;
      PublicTracker.a("KANDIAN_FEEDS_COST", null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */