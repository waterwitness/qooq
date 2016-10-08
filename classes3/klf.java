import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class klf
  implements View.OnClickListener
{
  public klf(AuthDevEnableCompleteActivity paramAuthDevEnableCompleteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131296844);
    if (paramView != null)
    {
      int i = 0;
      if (paramView.getVisibility() == 0) {
        i = 4;
      }
      paramView.setVisibility(i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */