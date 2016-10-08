package cooperation.qzone;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.util.NetworkState;
import ykx;

public class QZoneLiveVideoDownLoadActivtyV2
  extends QZoneLiveVideoBaseDownLoadActivty
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  private static final String c = "QZoneLiveVideoDownLoadActivtyV2";
  public IQZonePluginManager a;
  
  public QZoneLiveVideoDownLoadActivtyV2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private PluginBaseInfo a(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return null;
    }
    PluginBaseInfo localPluginBaseInfo = new PluginBaseInfo();
    localPluginBaseInfo.mState = paramPluginRecord.jdField_e_of_type_Int;
    localPluginBaseInfo.mDownloadProgress = paramPluginRecord.a;
    localPluginBaseInfo.mVersion = String.valueOf(paramPluginRecord.jdField_e_of_type_JavaLangString);
    localPluginBaseInfo.mID = paramPluginRecord.g;
    return localPluginBaseInfo;
  }
  
  protected PluginBaseInfo a(String paramString)
  {
    return a(this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramString));
  }
  
  protected void a(PluginBaseInfo paramPluginBaseInfo)
  {
    super.a(paramPluginBaseInfo);
    if (paramPluginBaseInfo.mState == 2)
    {
      if (QZonePluginUtils.a())
      {
        RemoteHandleManager.a().a("cmd.killLiveVideo", new Bundle(), false);
        new Handler().postDelayed(new ykx(this, paramPluginBaseInfo), 500L);
      }
    }
    else {
      return;
    }
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramPluginBaseInfo.mID, null);
      return;
    }
    catch (RemoteException paramPluginBaseInfo)
    {
      paramPluginBaseInfo.printStackTrace();
    }
  }
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null)
    {
      QZonePluginMangerHelper.a(this, this);
      return;
    }
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = paramIQZonePluginManager;
    paramIQZonePluginManager = this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk");
    if (paramIQZonePluginManager != null)
    {
      if (paramIQZonePluginManager.jdField_e_of_type_Int == 4)
      {
        e();
        return;
      }
      if (paramIQZonePluginManager.jdField_e_of_type_Int == 2) {
        try
        {
          this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk", null);
          return;
        }
        catch (RemoteException paramIQZonePluginManager)
        {
          paramIQZonePluginManager.printStackTrace();
          return;
        }
      }
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "QZoneLiveVideo has not installed");
      if (!NetworkUtil.h(getApplicationContext()))
      {
        QLog.w("QZoneLiveVideoDownLoadActivtyV2", 1, "onPluginManagerLoaded, no network available");
        QQToast.a(this, "网络无连接，请检查你的网络连接", 0).a();
      }
      if ((3 == this.j) && (!TextUtils.isEmpty(this.b)) && (HttpUtil.a(this.b)))
      {
        paramIQZonePluginManager = this.b + "&stayin=1";
        QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "not wifi connection, jump to H5, " + paramIQZonePluginManager);
        QZoneHelper.a(this, paramIQZonePluginManager, -1, null, null);
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
      paramIQZonePluginManager = Message.obtain();
      paramIQZonePluginManager.what = 1000;
      paramIQZonePluginManager.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIQZonePluginManager);
      return;
    }
    b();
    ToastUtil.a().a("正在查询插件信息，请稍后重试");
    a();
  }
  
  protected boolean a(PluginBaseInfo paramPluginBaseInfo)
  {
    boolean bool = super.a(paramPluginBaseInfo);
    if (!bool)
    {
      b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
    }
    return bool;
  }
  
  protected void b()
  {
    super.b();
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk", null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  protected void c()
  {
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "installPluginSilence");
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk", null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.b("qzone_live_video_plugin_hack.apk");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 4, "oncreate");
    if (!a()) {
      return;
    }
    QZonePluginMangerHelper.a(this, this);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneLiveVideoDownLoadActivtyV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */