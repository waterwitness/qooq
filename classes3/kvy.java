import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kvy
  implements View.OnClickListener
{
  public kvy(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    new kvz(this, paramView.getTag(), localView).run();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */