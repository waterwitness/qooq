import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.CallBack;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;

public class wkf
  implements Runnable
{
  public wkf(WebSoService paramWebSoService, String paramString1, String paramString2, String paramString3, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean, WebSoService.CallBack paramCallBack)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = WebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack.a(str);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */