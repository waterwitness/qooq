import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XEditTextEx;

class kpv
  implements DialogInterface.OnClickListener
{
  kpv(kpt paramkpt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.a.a.a.a.setText("");
      BaseChatPie.a(this.a.a.a).delete(0, BaseChatPie.a(this.a.a.a).length());
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */