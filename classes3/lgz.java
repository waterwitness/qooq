import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lgz
  implements View.OnClickListener
{
  public lgz(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    EditActivity.a(this.a).setVisibility(4);
    EditActivity.a(this.a).setImageResource(2130842146);
    EditActivity.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */