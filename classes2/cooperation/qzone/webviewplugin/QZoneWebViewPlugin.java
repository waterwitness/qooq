package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.famous.QzoneFamousShareJsPlugin;
import cooperation.qzone.webviewplugin.ugcsetting.QzoneUgcSettingJsPlugin;
import java.util.Map;
import org.json.JSONObject;

public class QZoneWebViewPlugin
  extends WebViewPlugin
  implements MultiNameSpacePluginCompact
{
  public static final int a = -1;
  private boolean jdField_a_of_type_Boolean;
  private QzoneInternalWebViewPlugin[] jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
  
  public QZoneWebViewPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, int paramInt)
  {
    paramPluginRuntime = paramPluginRuntime.a();
    int i = paramInt;
    if ((paramPluginRuntime instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramPluginRuntime).switchRequestCode(paramWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private void a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin == null) || (this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin.length == 0))
    {
      this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin = new QzoneInternalWebViewPlugin[] { new QzoneUgcSettingJsPlugin(), new QzoneVipPaymentJsPlugin(), new QzoneBlogJsPlugin(), new QzonePersonalizeJsPlugin(), new QzoneMoodPlugin(), new QzoneDeviceTagJsPlugin(), new QZoneFeedActionJsPlugin(), new QzoneDynamicAlbumPlugin(), new QzonePhotoWallPlugin(), new QZoneGiftFullScreenJsPlugin(), new QzoneQunFeedJsPlugin(), new QzoneAlbumSelectJSPlugin(), new QzoneAlbumJsPlugin(), new QzoneReactMessageDeliverPlugin(), new QZoneLiveJsPlugin(), new QzoneVideoTabJsPlugin(), new QzoneFamousShareJsPlugin(), new QzoneSettingJsPlugin(), new QzoneBasicJsPlugin(), new QzoneVideoEditPlugin(), new QzoneInterActiveVideoPlugin() };
      QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
      int j = arrayOfQzoneInternalWebViewPlugin.length;
      while (i < j)
      {
        arrayOfQzoneInternalWebViewPlugin[i].a(this);
        i += 1;
      }
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "Qzone", "qzDynamicAlbum", "QZImagePicker", "qzlive" };
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    a();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfQzoneInternalWebViewPlugin[i].a(paramString, paramLong);
      if (localObject != null) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934601L) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html")) || (paramString.startsWith("http://qzs.qzone.qq.com/qzone/hybrid/module/gift/mall.html"))))
    {
      paramString = new Intent();
      this.mRuntime.a().setResult(0, paramString);
      this.mRuntime.a().finish();
      return true;
    }
    a();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label114;
      }
      if (arrayOfQzoneInternalWebViewPlugin[i].a(paramString, paramLong, paramMap)) {
        break;
      }
      i += 1;
    }
    label114:
    if ((paramLong == 8589934594L) && (this.jdField_a_of_type_Boolean))
    {
      paramString = null;
      if (this.mRuntime != null) {
        paramString = this.mRuntime.a();
      }
      if (paramString != null) {
        paramString.clearHistory();
      }
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) && (!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("QZImagePicker")) && (!paramString2.equals("qzlive"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneWebViewPlugin", 2, "handleJsRequest pkgName: " + paramString2 + ",method: " + paramString3);
    }
    a();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfQzoneInternalWebViewPlugin[i].a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs)) {
        return true;
      }
      i += 1;
    }
    return QZoneWebViewJsHandleLogic.a(this, this.mRuntime, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    a();
    Object localObject = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].a(paramIntent, paramByte, paramInt);
      i += 1;
    }
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt != -1);
      this.mRuntime.a().finish();
      return;
    } while (paramInt != -1);
    try
    {
      localObject = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("cellid");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramIntent);
      localJSONObject.put("uin", localObject);
      dispatchJsEvent("deleteMessageSuccess", localJSONObject, new JSONObject());
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      arrayOfQzoneInternalWebViewPlugin[i].a();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QZoneWebViewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */