package cooperation.qzone;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;

public class QZoneLiveVideoDownloadActivity
  extends QZoneLiveVideoBaseDownLoadActivty
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public static final String c = "QZoneLiveVideoDownloadActivity";
  public PluginManagerClient a;
  
  public QZoneLiveVideoDownloadActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected PluginBaseInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(paramString);
  }
  
  protected String a()
  {
    return "qzone_live_video_plugin.apk";
  }
  
  protected boolean a(PluginBaseInfo paramPluginBaseInfo)
  {
    boolean bool = super.a(paramPluginBaseInfo);
    if ((!bool) && ((this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isReady()))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
    }
    return bool;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qzone_live_video_plugin.apk");
  }
  
  protected void c()
  {
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "installPluginSilence");
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qzone_live_video_plugin.apk");
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.cancelInstall("qzone_live_video_plugin.apk");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!a()) {
      return;
    }
    PluginManagerHelper.getPluginInterface(this, this);
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneLiveVideoDownloadActivity", 4, "support network!");
    }
    paramPluginManagerClient = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("qzone_live_video_plugin.apk");
    if (paramPluginManagerClient != null)
    {
      if (paramPluginManagerClient.mState == 4)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneLiveVideoDownloadActivity", 4, "QZoneLiveVideo has installed, start directly");
        }
        e();
        return;
      }
      QLog.d("QZoneLiveVideoDownloadActivity", 1, "QZoneLiveVideo has not installed");
      if (!NetworkUtil.h(getApplicationContext()))
      {
        QLog.w("QZoneLiveVideoDownloadActivity", 1, "onPluginManagerLoaded, no network available");
        QQToast.a(this, "网络无连接，请检查你的网络连接", 0).a();
      }
      if ((3 == this.j) && (!TextUtils.isEmpty(this.b)) && (HttpUtil.a(this.b)))
      {
        paramPluginManagerClient = this.b + "&stayin=1";
        QLog.d("QZoneLiveVideoDownloadActivity", 1, "not installed, jump to H5, " + paramPluginManagerClient);
        QZoneHelper.a(this, paramPluginManagerClient, -1, null, null);
        if (NetworkState.c()) {
          c();
        }
        a();
        return;
      }
      int i = NetworkState.b();
      if ((1 == i) || (4 == i) || (2 == i))
      {
        b();
        return;
      }
      paramPluginManagerClient = Message.obtain();
      paramPluginManagerClient.what = 1000;
      paramPluginManagerClient.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramPluginManagerClient);
      return;
    }
    if (QLog.isDevelopLevel())
    {
      QQToast.a(this, "没有获取到插件信息", 0).a();
      QLog.d("QZoneLiveVideoDownloadActivity", 4, "pluginInfo is null");
    }
    if ((3 == this.j) && (!TextUtils.isEmpty(this.b)) && (HttpUtil.a(this.b)))
    {
      paramPluginManagerClient = this.b + "&stayin=1";
      QLog.d("QZoneLiveVideoDownloadActivity", 1, "no plugin info, jump to H5, " + paramPluginManagerClient);
      QZoneHelper.a(this, paramPluginManagerClient, -1, null, null);
      a();
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneLiveVideoDownloadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */