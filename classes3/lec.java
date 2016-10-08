import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lec
  implements DialogInterface.OnDismissListener
{
  public lec(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == Conversation.a(this.a)) {
      Conversation.a(this.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */