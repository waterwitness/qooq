import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class mus
  implements View.OnClickListener
{
  public mus(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      return;
      i = ((Integer)localObject).intValue();
    } while (i < 0);
    paramView = paramView.findViewById(2131301785);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof Boolean))) {}
    for (boolean bool = ((Boolean)paramView.getTag()).booleanValue();; bool = false)
    {
      if (bool)
      {
        paramView = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.getItem(i);
        this.a.a(paramView);
        if ((this.a.b != null) && (this.a.b.isShowing())) {
          this.a.b.dismiss();
        }
        if (this.a.J != 11) {
          break;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
        return;
      }
      paramView = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.getItem(i);
      this.a.a(paramView);
      if (this.a.J != 11) {
        break;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */