import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class voc
  implements View.OnClickListener
{
  public voc(VideoPlayLogic paramVideoPlayLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (((this.a.a instanceof ChatActivity)) || ((this.a.a instanceof SplashActivity))) {
      ((FragmentActivity)this.a.a).getChatFragment().a().ah();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\voc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */