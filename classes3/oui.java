import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oui
  implements View.OnFocusChangeListener
{
  public oui(CommonHbFragment paramCommonHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      CommonHbFragment.a(this.a).postDelayed(new ouj(this), 200L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */