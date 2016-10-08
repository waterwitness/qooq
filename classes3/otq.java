import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class otq
  implements DialogInterface.OnClickListener
{
  public otq(SendHbActivity paramSendHbActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("hb_id", SendHbActivity.a(this.a));
    paramDialogInterface.putExtra("send_uin", SendHbActivity.b(this.a));
    paramDialogInterface.putExtra("hb_type", "1");
    paramDialogInterface.putExtra("forward_text", "发红包啦!");
    paramDialogInterface.putExtra("forward_type", 17);
    paramDialogInterface.putExtra("invoke_from", "qwallet");
    ForwardBaseOption.a(this.a, paramDialogInterface);
    this.a.a(SendHbActivity.b(this.a), this.a.a(), "hongbao.wrapped.send", "", "", 2, "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */