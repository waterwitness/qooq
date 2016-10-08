import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class lzt
  implements ActionSheet.OnDismissListener
{
  public lzt(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    if (this.a.b) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */