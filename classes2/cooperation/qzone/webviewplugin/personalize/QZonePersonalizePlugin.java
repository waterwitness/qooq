package cooperation.qzone.webviewplugin.personalize;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import ysf;

public class QZonePersonalizePlugin
  extends WebViewPlugin
  implements MultiNameSpacePluginCompact
{
  public static final String a;
  public static final String b = "QZoneCardLogic";
  private BroadcastReceiver a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QZonePersonalizePlugin.class.getSimpleName();
  }
  
  public QZonePersonalizePlugin()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ysf(this);
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("QZoneCardPreDownload");
    localIntentFilter.addAction("action_facade_qzone2js");
    BaseApplication.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void b()
  {
    BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qzcardstorre", "QzAvatar", "QzFloat" };
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 2L) && (paramString.equals(QZoneFloatJsHandleLogic.b))) {
      QZoneFloatJsHandleLogic.a(this.mRuntime, null);
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
    }
    if (paramString2.equals("qzcardstorre"))
    {
      if (paramString3.equals("closecardpreview")) {
        return true;
      }
      if (paramString3.equals("setcardfinish")) {
        QZoneCardJsHandleLogic.a(this, this.mRuntime, paramVarArgs);
      }
      if (paramString3.equals("downloadcard"))
      {
        QZoneCardJsHandleLogic.a(this.mRuntime, paramVarArgs);
        return true;
      }
    }
    else
    {
      if (!paramString2.equals("QzAvatar")) {
        break label189;
      }
      if (!paramString3.equals("downloadAvatar")) {
        break label143;
      }
      QZoneFacadeJsHandleLogic.b(this.mRuntime, paramVarArgs);
    }
    label143:
    label189:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (paramString3.equals("setAvatar")) {
            QZoneFacadeJsHandleLogic.a(this.mRuntime, paramVarArgs);
          } else if (paramString3.equalsIgnoreCase("checkIdList")) {
            QZoneFacadeJsHandleLogic.c(this.mRuntime, new String[0]);
          }
        }
      } while (!paramString2.equals("QzFloat"));
      if (paramString3.equals("downloadFloat"))
      {
        QZoneFloatJsHandleLogic.a(this.mRuntime, paramVarArgs);
        return true;
      }
    } while (!paramString3.equals("setFloat"));
    QZoneFloatJsHandleLogic.b(this.mRuntime, paramVarArgs);
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\personalize\QZonePersonalizePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */