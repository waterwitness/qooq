import android.os.Process;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BWebPlugin;

public class yaa
  implements Runnable
{
  public yaa(C2BWebPlugin paramC2BWebPlugin, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      String str = String.format("window.%s(\"%s\",%d,'%s')", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_b_of_type_Int), this.c });
      CustomWebView localCustomWebView = this.jdField_a_of_type_CooperationC2bC2BWebPlugin.mRuntime.a();
      if (localCustomWebView != null) {
        localCustomWebView.c(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2BWebPlugin", 2, "onUpdateAddress js:" + str + " ,android.os.Process.myTid() = " + Process.myTid() + ",lbsType = " + this.jdField_a_of_type_Int);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */