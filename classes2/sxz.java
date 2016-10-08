import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

public class sxz
  implements Runnable
{
  public sxz(QQApiPlugin paramQQApiPlugin, String paramString1, String paramString2, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      QQApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, (Activity)localObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new sya(this);
      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.G = String.valueOf(System.currentTimeMillis());
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if ("audio".equals(this.c))
    {
      localWXShareHelper = WXShareHelper.a();
      str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.G;
      str2 = this.d;
      str3 = this.e;
      str4 = this.b;
      if ("2".equals(this.jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i, this.f);
        return;
        i = 1;
      }
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.G;
    String str2 = this.d;
    String str3 = this.e;
    String str4 = this.b;
    if ("2".equals(this.jdField_a_of_type_JavaLangString)) {}
    for (i = j;; i = 1)
    {
      localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */