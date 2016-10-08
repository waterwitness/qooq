import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.webso.HttpResponsePackage;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import mqq.app.AppRuntime;

public class wkg
  implements Runnable
{
  public wkg(WebSoService paramWebSoService, HttpResponsePackage paramHttpResponsePackage, Uri paramUri, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.E != null)
      {
        WebSoUtils.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.E.getBytes(), WebSoUtils.b(this.jdField_a_of_type_AndroidNetUri));
        localObject1 = SHA1Util.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.E);
      }
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidNetUri != null))
    {
      localObject2 = WebSoService.a().edit();
      String str1 = String.valueOf(BaseApplicationImpl.a().a().getLongAccountUin());
      String str2 = WebSoUtils.a(this.jdField_a_of_type_AndroidNetUri);
      ((SharedPreferences.Editor)localObject2).putString("eTag_" + str1 + str2, this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject2).putString("htmlSha1_" + str1 + str2, (String)localObject1);
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject2).commit();
      }
    }
    else
    {
      return;
    }
    ((SharedPreferences.Editor)localObject2).apply();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */