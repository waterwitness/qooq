import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class ttu
  extends AnimateUtils.AnimationAdapter
{
  public ttu(ConversationHongBao paramConversationHongBao)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 200L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */