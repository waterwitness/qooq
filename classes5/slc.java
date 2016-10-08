import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class slc
  implements DialogInterface.OnClickListener
{
  public slc(ForwardFileBaseOption paramForwardFileBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */