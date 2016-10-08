import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridgeUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

class wjp
  implements Runnable
{
  wjp(wjo paramwjo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      String str1 = this.a.jdField_a_of_type_JavaIoByteArrayOutputStream.toString("UTF-8");
      String str2 = this.a.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("etag");
      String str3 = this.a.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("template-tag");
      String str4 = this.a.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("cache-offline");
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "close bridgeStream, start extractTemplateAndData, offline: " + str4);
      }
      SwiftWebViewHttpBridgeUtils.a(str1, this.a.jdField_a_of_type_JavaNetHttpURLConnection.getURL().toString(), false, str2, str3, SwiftWebViewHttpBridgeUtils.c(str4));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QLog.d("SwiftWebViewHttpBridge", 1, "error: can not encode stream ");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */