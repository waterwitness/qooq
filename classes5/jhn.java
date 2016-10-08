import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.HashMap;

public class jhn
  implements View.OnClickListener
{
  public jhn(OfflinePlugin paramOfflinePlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.mRuntime.a();
    if (paramView == null) {}
    OfflineUpdateStatus localOfflineUpdateStatus;
    do
    {
      do
      {
        do
        {
          return;
        } while ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.a(this.a))));
        localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
      } while (localOfflineUpdateStatus == null);
      if (localOfflineUpdateStatus.b() == 3)
      {
        localOfflineUpdateStatus.a();
        this.a.a();
        localOfflineUpdateStatus.b(4);
        if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.remove(OfflinePlugin.a(this.a));
        return;
      }
    } while (localOfflineUpdateStatus.b() != 0);
    HtmlOffline.a(paramView.getApplicationContext(), OfflinePlugin.a(this.a), localOfflineUpdateStatus.jdField_f_of_type_JavaLangString, localOfflineUpdateStatus.jdField_f_of_type_Int, localOfflineUpdateStatus);
    localOfflineUpdateStatus.b(1);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(OfflinePlugin.a(this.a), 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */