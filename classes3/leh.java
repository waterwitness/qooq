import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class leh
  implements View.OnClickListener
{
  private leh(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "OnHongBaoButtonClickListener");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\leh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */