import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

public class wix
  implements Runnable
{
  public wix(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TextView localTextView = new TextView(SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler));
    localTextView.setBackgroundColor(2130706432);
    localTextView.setTextColor(Integer.MAX_VALUE);
    StringBuilder localStringBuilder = new StringBuilder().append("当前内核:");
    if (this.jdField_a_of_type_Int == 0) {}
    for (String str = "系统WebView";; str = "x5 " + this.jdField_a_of_type_Int)
    {
      localTextView.setText(str);
      SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler).addContentView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */