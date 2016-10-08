import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.PubAccountMailJsPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jhu
  implements DialogInterface.OnClickListener
{
  public jhu(PubAccountMailJsPlugin paramPubAccountMailJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!TextUtils.isEmpty(this.a.d))
    {
      if (QLog.isColorLevel()) {
        QLog.d(PubAccountMailJsPlugin.a, 2, String.format("Contact menu dialog click phone = %s, which = %d", new Object[] { this.a.d, Integer.valueOf(paramInt) }));
      }
      switch (paramInt)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d(PubAccountMailJsPlugin.a, 2, String.format("Unknow contact button %d", new Object[] { Integer.valueOf(paramInt) }));
        }
        break;
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      PubAccountMailJsPlugin.e(this.a);
      return;
      PubAccountMailJsPlugin.f(this.a);
      return;
    }
    QLog.d(PubAccountMailJsPlugin.a, 2, "phone is empty");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */