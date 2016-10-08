import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lgy
  implements View.OnClickListener
{
  public lgy(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!EditActivity.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      EditActivity.a(paramView, bool);
      if (!EditActivity.a(this.a)) {
        break;
      }
      this.a.e();
      EditActivity.a(this.a).setImageResource(2130837574);
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setVisibility(0);
      }
      return;
    }
    if (EditActivity.a(this.a) != null) {
      EditActivity.a(this.a).setVisibility(4);
    }
    EditActivity.a(this.a).setImageResource(2130842146);
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */