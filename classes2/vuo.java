import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class vuo
  implements View.OnFocusChangeListener
{
  public vuo(VideoViewX paramVideoViewX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).onClick(paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */