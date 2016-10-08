import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.qphone.base.util.QLog;

public class mcm
  implements View.OnLongClickListener
{
  private mcm(QQBrowserActivity paramQQBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!QQBrowserActivity.a(this.a).a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQBrowser", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!QQBrowserActivity.b(this.a).a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQBrowser", 1, "disable image long click on current url!");
      }
      return false;
    }
    SwiftBrowserLongClickHandler localSwiftBrowserLongClickHandler = (SwiftBrowserLongClickHandler)this.a.a.a(8);
    if ((localSwiftBrowserLongClickHandler != null) && (localSwiftBrowserLongClickHandler.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */