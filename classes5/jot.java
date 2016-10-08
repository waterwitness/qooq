import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class jot
  implements DialogInterface.OnClickListener
{
  public jot(ScannerView paramScannerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a != null) {
      this.a.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */