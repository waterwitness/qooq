import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebviewPoolUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

public class wgu
  implements QbSdk.PreInitCallback
{
  public wgu(WebAccelerateHelper paramWebAccelerateHelper, long paramLong, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCoreInitFinished()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "QbSdk.preInit.onCoreInitFinished, cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "QbSdk.preInit.onViewInitFinished, cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    int i;
    if (3 == BaseApplicationImpl.i)
    {
      i = 1;
      System.currentTimeMillis();
      if (i == 0) {
        break label176;
      }
    }
    label176:
    for (Object localObject = WebviewPoolUtils.a();; localObject = new CustomWebView(this.jdField_a_of_type_AndroidContentContext))
    {
      System.currentTimeMillis();
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqWebprocessWebAccelerateHelper.getWebViewFeatureConfigs().get("preloadUrl");
      System.currentTimeMillis();
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("http")) || (str.startsWith("https"))))
      {
        ((CustomWebView)localObject).loadUrl(str);
        if (i != 0) {
          new Handler(Looper.getMainLooper()).postDelayed(new wgv(this, (CustomWebView)localObject), 100L);
        }
        SwiftBrowserCookieMonster.a("http://zb.vip.qq.com/").a("http://zb.vip.qq.com/", null, null, null);
        System.currentTimeMillis();
      }
      WebAccelerateHelper.access$002(false);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */