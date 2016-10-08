import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.FavoriteActionSheet;
import cooperation.qqfav.widget.FavoriteActionSheet.Actions;
import cooperation.qqfav.widget.LocationDetailActivity;
import mqq.app.AppRuntime;

public class ygx
  extends FavoriteActionSheet
{
  public ygx(LocationDetailActivity paramLocationDetailActivity, Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, paramActions, paramInt1, paramInt2, paramAppRuntime);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (LocationDetailActivity.a(this.a))
    {
      QfavUtil.a(true);
      if (LocationDetailActivity.a(this.a) != null) {
        LocationDetailActivity.a(this.a).setVisibility(8);
      }
    }
    super.onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */