import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class qgp
  implements Runnable
{
  public qgp(ThemeHandler paramThemeHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a.a.getApplication(), "主题资源异常，为你恢复默认主题", 4000).a();
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, QQToast.makeText: set default theme");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */