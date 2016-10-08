import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class rny
  extends WebViewClient
{
  long jdField_a_of_type_Long;
  
  public rny(FilePreviewActivity paramFilePreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_Boolean)
    {
      super.onPageFinished(paramWebView, paramString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Int == 0)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.getInitString(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.h, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b, Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.i), this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.g, null);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str + "]");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
        str = "javascript:qpreview.onClientResponse('showFileList', {})";
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
      }
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str + ")");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_Boolean = true;
      super.onPageFinished(paramWebView, paramString);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Int == 1)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.getInitString(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.h, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b, Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.i), this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.g, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_d_of_type_JavaLangString);
        break;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      throw new NullPointerException("压缩文件类型错误！！！");
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.getInitString(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.h, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b, Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.i), this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.g, null);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str);
      str = "javascript:qpreview.onClientResponse('addMorePage',{})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        String str = URLDecoder.decode(paramString, "UTF-8");
        paramString = str;
      }
      catch (Exception localException)
      {
        boolean bool;
        long l;
        int k;
        int j;
        int i;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("<FileAssistant>FilePreviewActivity", 1, "URLDecoder.decode, url:" + paramString);
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.a(paramWebView, paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface);
        if (!bool) {
          continue;
        }
      }
      catch (Exception paramWebView)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("<FileAssistant>FilePreviewActivity", 2, "parseUrl error,exception:" + paramWebView.toString());
        if ((paramString != null) && (!"".equals(paramString)) && (!"about:blank;".equals(paramString)) && (!"about:blank".equals(paramString))) {
          continue;
        }
        QLog.e("<FileAssistant>FilePreviewActivity", 1, "request url is null,or about:blank! return");
        return true;
        l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Long < 1500L) {
          continue;
        }
        this.jdField_a_of_type_Long = l;
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "start load new[" + paramString + "]");
        k = paramString.lastIndexOf("/") + 1;
        j = paramString.lastIndexOf("&");
        i = j;
        if (j >= k) {
          continue;
        }
        i = paramString.length();
        paramWebView = paramString.substring(k, i);
        try
        {
          URLDecoder.decode(paramWebView, "UTF-8");
          return true;
        }
        catch (UnsupportedEncodingException paramWebView)
        {
          paramWebView.printStackTrace();
          return true;
        }
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */