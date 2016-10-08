import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gxt
  implements DialogInterface.OnClickListener
{
  gxt(gxq paramgxq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */