import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class vsw
  implements View.OnClickListener
{
  public vsw(MediaControllerX paramMediaControllerX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.c())
    {
      this.a.b(0);
      MediaControllerX.a(this.a).setContentDescription(this.a.getResources().getString(2131364336));
      return;
    }
    this.a.b(1);
    MediaControllerX.a(this.a, true);
    MediaControllerX.a(this.a).setContentDescription(this.a.getResources().getString(2131364337));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */