import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class ppn
  implements DialogInterface.OnClickListener
{
  public ppn(AntiphingHandler paramAntiphingHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AntiphingHandler.a(this.a), 2, "On Click Left Button! ");
    }
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().finish();
    }
    for (;;)
    {
      AntiphingHandler.a(this.a, 1);
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d(AntiphingHandler.a(this.a), 4, "Call back object is null!");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ppn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */