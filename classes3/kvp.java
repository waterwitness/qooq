import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kvp
  implements View.OnClickListener
{
  public kvp(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */