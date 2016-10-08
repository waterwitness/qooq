import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class skt
  implements DialogInterface.OnClickListener
{
  public skt(ForwardBaseOption paramForwardBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -2: 
      this.a.i();
      return;
    }
    this.a.j();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\skt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */