import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;

public class wjd
  implements Runnable
{
  public wjd(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler, MsfSdkUtils.insertMtype("Web", SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler)), 0);
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.i, SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler));
    localBundle.putInt(DownloadConstants.j, 2);
    localBundle.putString(DownloadConstants.k, this.b);
    localBundle.putBoolean(DownloadConstants.q, false);
    localBundle.putBoolean(DownloadConstants.w, false);
    localBundle.putString(DownloadConstants.l, "_" + this.jdField_a_of_type_JavaLangString);
    DownloadApi.a(SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler), localBundle, 0, null, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */