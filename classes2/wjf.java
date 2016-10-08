import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

public class wjf
  implements View.OnClickListener
{
  public wjf(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (SwiftBrowserTBSHandler.a(this.a) != null) {
      SwiftBrowserTBSHandler.a(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */