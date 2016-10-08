import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kxh
  implements Animation.AnimationListener
{
  public kxh(ChatHistoryForC2C paramChatHistoryForC2C, View paramView1, View paramView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).show();
    this.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.b.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */