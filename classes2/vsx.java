import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class vsx
  implements View.OnClickListener
{
  public vsx(MediaControllerX paramMediaControllerX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      this.a.b = true;
      MediaControllerX.b(this.a).setBackgroundResource(2130840234);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131364342));
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.onClick(paramView);
      }
      return;
      this.a.b = false;
      MediaControllerX.b(this.a).setBackgroundResource(2130840224);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131364341));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */