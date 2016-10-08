import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import java.util.ArrayList;

public class vwq
  extends AbsWebView
{
  public vwq(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.B();
    this.a = new TouchWebView(this.e);
    c(paramAppInterface);
  }
  
  public void a()
  {
    super.x();
  }
  
  public void a(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
    this.a.loadUrl(this.k);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new WebViewJumpPlugin());
    }
  }
  
  public void b()
  {
    super.y();
  }
  
  public void c()
  {
    super.z();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */