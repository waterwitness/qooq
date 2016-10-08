import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridge;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridgeUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;

public class wjn
  implements Runnable
{
  public wjn(SwiftWebViewHttpBridge paramSwiftWebViewHttpBridge, boolean paramBoolean1, boolean paramBoolean2, Uri paramUri, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "--> start step three, save data");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        str = SwiftWebViewHttpBridgeUtils.b(this.jdField_a_of_type_AndroidNetUri) + ".txt";
        if (!WebSoUtils.a(this.jdField_a_of_type_ArrayOfByte, str)) {
          QLog.e("SwiftWebViewHttpBridge", 1, "save html error");
        }
        str = SwiftWebViewHttpBridgeUtils.b(this.jdField_a_of_type_AndroidNetUri) + "_data.txt";
        boolean bool = WebSoUtils.a(this.jdField_b_of_type_ArrayOfByte, str);
        if (!bool) {
          QLog.e("SwiftWebViewHttpBridge", 1, "save data error");
        }
        if (bool) {
          SwiftWebViewHttpBridgeUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_AndroidNetUri, true);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "save data cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
      return;
      VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "mergeDiffError", 0, 0, 0, 0, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.jdField_b_of_type_JavaLangString, "");
      SwiftWebViewHttpBridgeUtils.a(this.jdField_a_of_type_AndroidNetUri);
      str = SwiftWebViewHttpBridgeUtils.b(this.jdField_a_of_type_AndroidNetUri) + ".temp" + ".txt";
      WebSoUtils.a(this.jdField_a_of_type_ArrayOfByte, str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */