import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

public class wir
  implements View.OnClickListener
{
  public wir(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    SwiftBrowserShareMenuHandler.a(this.a, false, 0);
    paramView = "";
    Object localObject = Uri.parse(SwiftBrowserShareMenuHandler.a(this.a));
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("article_id");
      paramView = (View)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject = paramView;
    if (paramView == null) {
      localObject = "";
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A6A", "0X8006A6A", 0, 0, "", (String)localObject, "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */