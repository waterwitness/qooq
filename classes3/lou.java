import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lou
  implements Runnable
{
  public lou(HongbaoShowerActivity paramHongbaoShowerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HongbaoShowerActivity.a(this.a).setVisibility(0);
    HongbaoShowerActivity.a(this.a).startAnimation(HongbaoShowerActivity.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */