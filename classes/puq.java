import android.text.TextUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class puq
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  
  puq(BrowserAppInterface paramBrowserAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(), this.jdField_a_of_type_JavaLangString, 1).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\puq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */