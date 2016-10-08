import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kuz
  implements DialogInterface.OnClickListener
{
  public kuz(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.a(new kva(this), 8, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kuz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */