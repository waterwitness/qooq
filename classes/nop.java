import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nop
  implements DialogInterface.OnClickListener
{
  public nop(ShakeItemBuilder paramShakeItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */