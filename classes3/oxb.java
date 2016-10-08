import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxb
  implements View.OnClickListener
{
  public oxb(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    RecentCallHelper.a(this.a, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */