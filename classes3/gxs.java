import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gxs
  implements DialogInterface.OnClickListener
{
  gxs(gxq paramgxq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.finish();
    PstnUtils.a(this.a.a.app, this.a.a, 1, 8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */