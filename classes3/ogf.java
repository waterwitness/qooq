import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessTypeActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ogf
  implements View.OnClickListener
{
  ogf(oge paramoge)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, SelectMemberActivity.class);
    paramView.putExtra("param_type", 9003);
    paramView.putExtra("param_entrance", 16);
    paramView.putExtra("param_only_friends", true);
    paramView.putExtra("param_donot_need_contacts", true);
    paramView.putExtra("param_title", this.a.a.getString(2131372354));
    paramView.putExtra("param_done_button_wording", this.a.a.getString(2131366640));
    paramView.putExtra("param_uins_selected_friends", BlessTypeActivity.a(this.a.a));
    this.a.a.startActivityForResult(paramView, 101);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ogf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */