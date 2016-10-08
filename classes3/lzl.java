import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lzl
  implements DialogInterface.OnCancelListener
{
  lzl(lzj paramlzj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.setResult(4003);
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */