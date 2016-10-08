import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class vsz
  implements View.OnClickListener
{
  public vsz(MediaControllerX paramMediaControllerX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    MediaControllerX.b(this.a);
    this.a.a(5000);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */