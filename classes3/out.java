import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.OnThemeHbClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class out
  implements Runnable
{
  public out(ThemeHbFragment paramThemeHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ThemeHbFragment.a(this.a).startAnimation(ThemeHbFragment.a(this.a));
    ThemeHbFragment.a(this.a).setVisibility(0);
    if (ThemeHbFragment.a(this.a) != null) {
      ThemeHbFragment.a(this.a).a("theme.pack.show", 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\out.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */