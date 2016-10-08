import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapterOfContactsMode;
import com.tencent.mobileqq.adapter.TroopListAdapterOfContactsMode.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapterOfContactsMode.TroopListItem;
import com.tencent.mobileqq.adapter.TroopListAdapterOfContactsMode.TroopListViewItemTag;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ppj
  implements View.OnClickListener
{
  public ppj(TroopListAdapterOfContactsMode paramTroopListAdapterOfContactsMode)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (paramView.getId() == 2131305157) {
      if ((localObject instanceof TroopListAdapterOfContactsMode.TroopListViewItemTag)) {}
    }
    while ((paramView.getId() != 2131305165) || (!(localObject instanceof TroopInfo)))
    {
      do
      {
        return;
        paramView = (TroopListAdapterOfContactsMode.TroopListViewItemTag)localObject;
      } while ((paramView.a == null) || (paramView.a.a == null));
      this.a.b(paramView.a.a.troopuin);
      TroopListAdapterOfContactsMode.a(this.a).a(paramView.a.a, paramView.a.e);
      return;
    }
    paramView = (TroopInfo)localObject;
    this.a.a(paramView.troopuin);
    TroopListAdapterOfContactsMode.a(this.a).a(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ppj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */