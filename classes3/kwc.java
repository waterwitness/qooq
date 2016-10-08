import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kwc
  implements View.OnClickListener
{
  public kwc(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    new kwd(this, paramView.getTag(), localView).run();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */