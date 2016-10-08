import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class kjw
  implements DialogInterface.OnClickListener
{
  public kjw(AddRequestActivity paramAddRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */