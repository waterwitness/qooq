import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class wtv
  implements View.OnClickListener
{
  public wtv(WebAppActivity paramWebAppActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      if (paramView == this.a.jdField_a_of_type_AndroidWidgetImageView)
      {
        if (!this.a.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack()) {
          return;
        }
        this.a.jdField_a_of_type_ComTencentSmttSdkWebView.goBack();
        return;
      }
      if (paramView == this.a.b)
      {
        this.a.jdField_a_of_type_ComTencentSmttSdkWebView.goForward();
        return;
      }
    }
    catch (Exception paramView)
    {
      LogUtility.c("WebAppActivity", "onClick", paramView);
      return;
    }
    if (paramView == this.a.c)
    {
      this.a.jdField_a_of_type_ComTencentSmttSdkWebView.reload();
      return;
    }
    if (paramView == this.a.d) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */