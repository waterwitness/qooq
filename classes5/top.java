import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class top
  implements ActionSheet.OnDismissListener
{
  public top(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    NearbyProfileEditPanel.a(this.a, this.a.h, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\top.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */