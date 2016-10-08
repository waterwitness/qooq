import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.photoplus.PhotoPlusBridgeActivity;

public class wis
  implements View.OnClickListener
{
  public wis(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
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
      paramView = new Intent(this.a.a, PhotoPlusBridgeActivity.class);
      paramView.putExtra("photo_path", SwiftBrowserShareMenuHandler.c(this.a));
      paramView.putExtra("iswaitforsult", true);
      paramView.putExtra("type", 1008);
      this.a.a.startActivityForResult(paramView, 100003);
    }
    localObject = paramView;
    if (paramView == null) {
      localObject = "";
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject, "", "");
    if (SwiftBrowserShareMenuHandler.c(this.a))
    {
      SwiftBrowserShareMenuHandler.c(this.a, true);
      QQToast.a(this.a.a, 0, 2131372583, 0).b(this.a.a.getResources().getDimensionPixelSize(2131492908));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */