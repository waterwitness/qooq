import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tuy
  implements ActionSheet.OnButtonClickListener
{
  public tuy(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    ProfileCardWebviewPlugin.a(this.a, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */