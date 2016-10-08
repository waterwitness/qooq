package cooperation.qzone.webviewplugin;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QzoneQunFeedJsPlugin$LoadingDialog
  extends Dialog
{
  QzoneQunFeedJsPlugin$LoadingDialog(Context paramContext)
  {
    super(paramContext, 2131558784);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    setContentView(2130904712);
    getWindow().setFlags(1024, 2048);
  }
  
  public void a(String paramString)
  {
    ((TextView)findViewById(2131297123)).setText(paramString);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(QzoneQunFeedJsPlugin.a, 2, localException, new Object[0]);
    }
  }
  
  public void setTitle(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = getContext().getResources().getString(paramInt))
    {
      a(str);
      return;
    }
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(QzoneQunFeedJsPlugin.a, 2, localException, new Object[0]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneQunFeedJsPlugin$LoadingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */