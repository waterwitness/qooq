import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.CallBack;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import java.util.concurrent.atomic.AtomicInteger;

public class wkc
  implements WebSoService.CallBack
{
  public wkc(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.c = 10003;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString = paramString;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.f = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_e_of_type_Boolean = false;
      WebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */