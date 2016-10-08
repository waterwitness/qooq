import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.PhoneFrame;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class opm
  implements View.OnClickListener
{
  public opm(PhoneFrameActivity paramPhoneFrameActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a();
    if (paramView != null) {
      paramView.a(false);
    }
    com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */