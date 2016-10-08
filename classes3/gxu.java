import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gxu
  implements DialogInterface.OnClickListener
{
  gxu(gxq paramgxq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */