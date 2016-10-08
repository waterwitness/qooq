import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class wig
  implements AsyncCallBack
{
  wig(wif paramwif, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Wif.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i(SwiftBrowserOfflineHandler.jdField_a_of_type_JavaLangString, 2, "now offline bid has checked, bid " + SwiftBrowserOfflineHandler.a(this.jdField_a_of_type_Wif.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler) + ", loadMode: " + this.jdField_a_of_type_Wif.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", cost: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (paramInt != 0)
    {
      OfflinePlugin.c(SwiftBrowserOfflineHandler.a(this.jdField_a_of_type_Wif.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler));
      OfflineWebResManager.a(this.jdField_a_of_type_Wif.jdField_a_of_type_JavaLangString);
    }
    SwiftBrowserOfflineHandler.a(this.jdField_a_of_type_Wif.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */