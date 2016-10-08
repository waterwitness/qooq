import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sif
  implements DialogInterface.OnClickListener
{
  sif(shz paramshz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface arg1, int paramInt)
  {
    synchronized ()
    {
      this.a.a.b = false;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */