import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kyf
  implements DialogInterface.OnClickListener
{
  public kyf(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing())) {
      ChatSettingActivity.a(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */