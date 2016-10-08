import android.os.Build.VERSION;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mtj
  implements View.OnClickListener
{
  public mtj(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      paramView = (ClipboardManager)this.a.getSystemService("clipboard");
      if (this.a.N == 0)
      {
        paramView.setText(this.a.v);
        this.a.d("Clk_copyinfo", "P_CliOper");
      }
    }
    do
    {
      do
      {
        return;
        if (this.a.N == 3)
        {
          paramView.setText(this.a.r);
          return;
        }
        if (this.a.N == 4)
        {
          paramView.setText(this.a.p);
          return;
        }
        if (this.a.N == 5)
        {
          paramView.setText(this.a.q);
          return;
        }
      } while (6 != this.a.N);
      paramView.setText(this.a.d());
      this.a.g("Clk_copyname");
      return;
      paramView = (ClipboardManager)this.a.getSystemService("clipboard");
      if (this.a.N == 0)
      {
        paramView.setText(this.a.v);
        this.a.d("Clk_copyinfo", "P_CliOper");
        return;
      }
      if (this.a.N == 3)
      {
        paramView.setText(this.a.r);
        return;
      }
      if (this.a.N == 4)
      {
        paramView.setText(this.a.p);
        return;
      }
      if (this.a.N == 5)
      {
        paramView.setText(this.a.q);
        return;
      }
    } while (6 != this.a.N);
    paramView.setText(this.a.d());
    this.a.g("Clk_copyname");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */