import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.utils.WebViewReportUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

public class wiw
  implements Runnable
{
  public wiw(SwiftBrowserStatistics paramSwiftBrowserStatistics, TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String[] paramArrayOfString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int k = 1;
    int i;
    int m;
    int n;
    int j;
    label39:
    label45:
    String str;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null)
    {
      i = 1;
      m = QbSdk.getTbsVersion(BaseApplicationImpl.getContext());
      n = WebView.getTbsSDKVersion(BaseApplicationImpl.getContext());
      if (!WebProcessManager.b()) {
        break label137;
      }
      j = 1;
      if (!SwiftBrowserStatistics.m) {
        break label142;
      }
      switch (HttpUtil.a())
      {
      case 0: 
      default: 
        str = "";
      }
    }
    for (;;)
    {
      WebViewReportUtils.a(i, m, n, j, k, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.d, this.e, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
      i = 0;
      break;
      label137:
      j = 0;
      break label39;
      label142:
      k = 0;
      break label45;
      str = " UNKNOWN";
      continue;
      str = "WIFI";
      continue;
      str = "2G";
      continue;
      str = "3G";
      continue;
      str = "4G";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */