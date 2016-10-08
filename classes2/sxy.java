import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class sxy
  implements Runnable
{
  sxy(sxx paramsxx, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Activity localActivity = this.jdField_a_of_type_Sxx.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      try
      {
        if (!"1".equals(this.jdField_a_of_type_Sxx.d)) {
          break;
        }
        QQApiPlugin.a(this.jdField_a_of_type_Sxx.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Sxx.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Sxx.d, this.jdField_a_of_type_Sxx.e, this.jdField_a_of_type_Sxx.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Sxx.g, this.c);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareMsg error: " + localJSONException.toString());
    return;
    if (("2".equals(this.jdField_a_of_type_Sxx.d)) || ("3".equals(this.jdField_a_of_type_Sxx.d)))
    {
      QQApiPlugin.b(this.jdField_a_of_type_Sxx.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Sxx.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Sxx.d, this.jdField_a_of_type_Sxx.e, this.jdField_a_of_type_Sxx.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Sxx.g, this.c);
      return;
    }
    QQApiPlugin.a(this.jdField_a_of_type_Sxx.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Sxx.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Sxx.d, this.jdField_a_of_type_Sxx.e, this.jdField_a_of_type_Sxx.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Sxx.g, this.c, this.jdField_a_of_type_Sxx.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */