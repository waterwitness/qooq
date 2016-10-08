import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLRouterActivity;
import com.dataline.activities.RouterAdvanceActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class i
  implements View.OnClickListener
{
  public i(DLRouterActivity paramDLRouterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, RouterAdvanceActivity.class);
    paramView.putExtra("guid_flag", this.a.c);
    paramView.putExtra("uin", this.a.b);
    this.a.startActivityForResult(paramView, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */