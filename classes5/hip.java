import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.huangye.QQYPQRCodePreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hip
  implements DialogInterface.OnDismissListener
{
  public hip(QQYPQRCodePreviewActivity paramQQYPQRCodePreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.b)
    {
      this.a.a();
      return;
    }
    QQYPQRCodePreviewActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */