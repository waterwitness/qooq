import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class kxq
  implements DialogInterface.OnCancelListener
{
  private final WeakReference a;
  
  public kxq(ChatHistoryForC2C paramChatHistoryForC2C)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramChatHistoryForC2C);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (ChatHistoryForC2C)this.a.get();
    if ((paramDialogInterface != null) && (ChatHistoryForC2C.a(paramDialogInterface) != null)) {
      ChatHistoryForC2C.a(paramDialogInterface).dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */