import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class tts
  extends AnimateUtils.AnimationAdapter
{
  public tts(ConversationHongBao paramConversationHongBao)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */