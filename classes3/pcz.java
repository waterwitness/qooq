import android.view.View;
import com.tencent.mobileqq.activity.richmedia.PTVOperatingGuideActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pcz
  implements Runnable
{
  public pcz(PTVOperatingGuideActivity paramPTVOperatingGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PTVOperatingGuideActivity.a(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */