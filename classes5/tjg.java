import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

public class tjg
  implements View.OnClickListener
{
  public tjg(NearbyGuideActivity paramNearbyGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!this.a.isFinishing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
      this.a.e("0X800590A");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */