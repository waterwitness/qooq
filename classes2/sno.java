import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class sno
  implements ActionSheet.OnDismissListener
{
  public sno(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */