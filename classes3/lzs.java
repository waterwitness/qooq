import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lzs
  implements DialogInterface.OnCancelListener
{
  public lzs(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */