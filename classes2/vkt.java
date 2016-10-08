import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;

public class vkt
  implements View.OnClickListener
{
  public vkt(TroopTagViewActivity paramTroopTagViewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, TroopTagViewActivity.class);
    paramView.putExtra("troopuin", this.a.h);
    paramView.putExtra("tags", this.a.i);
    paramView.putExtra("act_type", 2);
    paramView.putExtra("modifyToSrv", this.a.e);
    if ((this.a.getAppRuntime() instanceof BrowserAppInterface)) {
      paramView.putExtra("uin", ((BrowserAppInterface)this.a.getAppRuntime()).a());
    }
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vkt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */