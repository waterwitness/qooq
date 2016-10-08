import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListViewItemTag;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ppi
  implements View.OnClickListener
{
  public ppi(TroopListAdapter2 paramTroopListAdapter2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopListAdapter2.TroopListViewItemTag)) {}
    do
    {
      return;
      paramView = (TroopListAdapter2.TroopListViewItemTag)paramView;
    } while ((paramView.a == null) || (paramView.a.a == null));
    this.a.a.a(paramView.a.a, paramView.a.i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ppi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */