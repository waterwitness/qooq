package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class QZoneFloatJsHandleLogic
{
  private static SurfaceView a;
  public static final String a;
  public static String b = "";
  private static String c = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QZoneFloatJsHandleLogic.class.getSimpleName();
  }
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime == null) || (paramPluginRuntime.a() == null) || (paramPluginRuntime.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)paramPluginRuntime.a().findViewById(2131296688);
        if ((jdField_a_of_type_AndroidViewSurfaceView != null) && (jdField_a_of_type_AndroidViewSurfaceView.getParent() == localFrameLayout))
        {
          QZoneHelper.b(paramPluginRuntime.a(), jdField_a_of_type_AndroidViewSurfaceView);
          return;
        }
        b = paramPluginRuntime.a().getUrl();
        if (paramVarArgs != null) {
          c = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(c));
      jdField_a_of_type_AndroidViewSurfaceView = QZoneHelper.a(paramPluginRuntime.a(), c);
    } while (jdField_a_of_type_AndroidViewSurfaceView == null);
    localFrameLayout.addView(jdField_a_of_type_AndroidViewSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    paramVarArgs = (FrameLayout)paramPluginRuntime.a().findViewById(2131296688);
    if ((paramVarArgs != null) && (jdField_a_of_type_AndroidViewSurfaceView != null)) {
      paramVarArgs.removeView(jdField_a_of_type_AndroidViewSurfaceView);
    }
    QZoneHelper.a(paramPluginRuntime.a(), jdField_a_of_type_AndroidViewSurfaceView);
    jdField_a_of_type_AndroidViewSurfaceView = null;
    paramVarArgs = new Intent("action_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "setFloat");
    paramVarArgs.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "actionString: " + paramVarArgs.getAction());
    }
    QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramVarArgs);
    paramPluginRuntime.a().finish();
    if (QZoneHelper.e()) {
      ToastUtil.a().a("主人~~你的手机系统不太适应漂浮装扮，请升级后再体验", 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\personalize\QZoneFloatJsHandleLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */