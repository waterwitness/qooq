import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.GVideoUpdateUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hay
  implements DialogInterface.OnClickListener
{
  public hay(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GVideoUpdateUtil.a(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */