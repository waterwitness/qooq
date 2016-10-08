import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lzk
  implements DialogInterface.OnClickListener
{
  lzk(lzj paramlzj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.setResult(4003);
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */