import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kjd
  implements View.OnClickListener
{
  public kjd(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a.getText().toString().length() > 30)
    {
      paramView = new Dialog(this.a, 2131558973);
      paramView.setContentView(2130904920);
      ((TextView)paramView.findViewById(2131296852)).setText(this.a.getString(2131368981));
      ((ProgressBar)paramView.findViewById(2131296851)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131304261)).setImageResource(2130838454);
      paramView.show();
      return;
    }
    paramView = this.a.a.getText().toString().trim();
    this.a.a(paramView, false);
    if ((this.a.getString(2131368659).equals(paramView)) && (!AddFriendVerifyActivity.a(this.a))) {
      AddFriendVerifyActivity.a(this.a);
    }
    this.a.a(this.a.a.getText().toString().trim(), null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */