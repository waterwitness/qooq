import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class msl
  implements View.OnClickListener
{
  public msl(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, ShowExternalTroopListActivity.class);
    if ((this.a.centerView != null) && (!TextUtils.isEmpty(this.a.centerView.getText()))) {
      paramView.putExtra("leftViewText", this.a.centerView.getText().toString().trim());
    }
    if (this.a.o == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.putExtra("isHost", bool);
      paramView.putExtra("dest_uin_str", this.a.v);
      paramView.putExtra("from_troop_uin", this.a.t);
      paramView.putExtra("from", 1);
      this.a.startActivityForResult(paramView, 9);
      this.a.d("Clk_joingrp", "P_CliOper");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */