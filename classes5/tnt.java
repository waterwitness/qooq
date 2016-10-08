import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class tnt
  implements ActionSheet.OnDismissListener
{
  public tnt(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    NearbyProfileEditPanel.a(this.a, this.a.b, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */