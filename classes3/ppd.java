import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.OnTroopListClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;

public class ppd
  implements View.OnClickListener
{
  public ppd(ShowExternalTroopListAdapter paramShowExternalTroopListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof NearbyTroops.CustomViewHolder)) {
      return;
    }
    paramView = (NearbyTroops.CustomViewHolder)paramView;
    this.a.a.a(paramView.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ppd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */