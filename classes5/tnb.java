import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.widget.ActionSheet;

public class tnb
  implements View.OnClickListener
{
  public tnb(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.a(this.a.a);
    paramView.a(2131366747, 1);
    paramView.d(2131367262);
    paramView.a(new tnc(this, paramView));
    paramView.show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */