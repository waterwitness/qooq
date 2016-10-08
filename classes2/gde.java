import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

class gde
  implements View.OnClickListener
{
  gde(gdd paramgdd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (paramView == null) {}
    while (!paramView.equals(this.a.a.getString(2131369432))) {
      return;
    }
    paramView = new Intent(this.a.a, SelectMemberActivity.class);
    ArrayList localArrayList = new ArrayList(this.a.a.a);
    paramView.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    paramView.putExtra("param_groupcode", this.a.a.jdField_b_of_type_JavaLangString);
    paramView.putExtra("param_max", 100 - localArrayList.size());
    paramView.putExtra("param_only_troop_member", this.a.a.jdField_b_of_type_Boolean);
    paramView.putExtra("group_uin", this.a.a.c);
    paramView.putExtra("group_name", this.a.a.d);
    this.a.a.startActivityForResult(paramView, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */