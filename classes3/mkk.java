import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class mkk
  implements DialogInterface.OnClickListener
{
  public mkk(SendMultiPictureHelper paramSendMultiPictureHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.show();
    this.a.b = false;
    SendMultiPictureHelper.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */