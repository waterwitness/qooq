import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public final class uzx
  implements Runnable
{
  public uzx(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a.getApplication(), "漫游主题已更新", 4000).a();
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "setSkinTheme, QQToast.makeText: set sv theme");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */