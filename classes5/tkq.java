import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorAdapter.ChildItemHolder;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;

public class tkq
  implements View.OnClickListener
{
  public tkq(NearbyVisitorListActivity paramNearbyVisitorListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof NearbyVisitorAdapter.ChildItemHolder))
    {
      paramView = (NearbyVisitorAdapter.ChildItemHolder)paramView.getTag();
      NearbyMineHelper.a(this.a.b, this.a, paramView.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */