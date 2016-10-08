import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.UrlCheckPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jip
  implements SoftKeyboardObserver.OnSoftKeyboardToggledListener
{
  public jip(UrlCheckPlugin paramUrlCheckPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UrlCheckPlugin.a(this.a), 2, "onSoftKeyboardToggled");
    }
    if (QLog.isColorLevel()) {
      QLog.d(UrlCheckPlugin.b(this.a), 2, "isCheatDialogShow:" + this.a.e);
    }
    if ((!paramBoolean) || (UrlCheckPlugin.a(this.a) == null) || (this.a.a == null)) {}
    do
    {
      do
      {
        return;
      } while ((UrlCheckPlugin.a(this.a) < 1) || (UrlCheckPlugin.a(this.a) > 2) || (UrlCheckPlugin.a(this.a)));
      if (this.a.e != UrlCheckPlugin.c) {
        break;
      }
    } while (UrlCheckPlugin.a(this.a) != 2);
    this.a.a.removeCallbacks(UrlCheckPlugin.a(this.a));
    UrlCheckPlugin.a(this.a);
    UrlCheckPlugin.a(this.a, true);
    UrlCheckPlugin.a(this.a, 2131371617);
    return;
    UrlCheckPlugin.a(this.a, true);
    UrlCheckPlugin.a(this.a, 2131371617);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */