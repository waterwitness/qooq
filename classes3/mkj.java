import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mkj
  implements DialogInterface.OnClickListener
{
  public mkj(SendMultiPictureHelper paramSendMultiPictureHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b = true;
    SendMultiPictureHelper.b(this.a);
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */