import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class jhk
  implements AsyncBack
{
  public jhk(OfflinePlugin paramOfflinePlugin, JsBridgeListener paramJsBridgeListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", -1);
        paramString.put("msg", "error");
        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.f, new String[] { paramString.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramString);
        return;
      }
    }
    Message localMessage = Message.obtain();
    localMessage.what = 121;
    localMessage.obj = new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, paramString };
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */