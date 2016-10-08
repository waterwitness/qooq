import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

class lxj
  implements DialogInterface.OnClickListener
{
  lxj(lxi paramlxi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.b().post(new lxk(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lxj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */