import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.CallBack;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class wka
  implements WebSoService.CallBack
{
  public wka(WebSoService paramWebSoService, long paramLong, WebSoService.WebSoState paramWebSoState, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSoService", 2, "verifyHtmlData cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a.get() != 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.e = true;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 1, new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */