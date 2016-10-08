import android.support.v4.view.ViewPager;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class hgb
  extends TimerTask
{
  public hgb(TroopCardBanner paramTroopCardBanner)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.post(new hgc(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */