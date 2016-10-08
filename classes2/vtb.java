import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaPlayerControlX;

public class vtb
  implements View.OnClickListener
{
  public vtb(MediaControllerX paramMediaControllerX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = MediaControllerX.a(this.a).b();
    MediaControllerX.a(this.a).a(i - 5000);
    MediaControllerX.a(this.a);
    this.a.a(5000);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vtb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */