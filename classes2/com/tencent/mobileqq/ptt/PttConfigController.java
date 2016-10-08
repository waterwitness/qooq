package com.tencent.mobileqq.ptt;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.RecordParams;
import mqq.manager.Manager;

public class PttConfigController
  implements DeviceProfileManager.DPCObserver, Manager
{
  public static final String a = "ptt_stream_slice_cfg";
  public static final String b = "ptt_optimize_cfg_v2";
  public static final String c = "ptt_pre_download";
  private QQAppInterface a;
  
  public PttConfigController(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
    String str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      RecordParams.a(paramQQAppInterface, str);
      RecordParams.a(paramQQAppInterface, true);
      str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label96;
      }
      StreamParams.a(paramQQAppInterface, str);
      StreamParams.a(paramQQAppInterface, true);
    }
    for (;;)
    {
      DeviceProfileManager.a(this);
      return;
      RecordParams.a(paramQQAppInterface, false);
      break;
      label96:
      StreamParams.a(paramQQAppInterface, false);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    NetworkCenter.a();
    if (localQQAppInterface != null)
    {
      StreamParams.b(localQQAppInterface, paramString);
      StreamParams.b(localQQAppInterface, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.a;
    if ((localQQAppInterface != null) && (paramBoolean))
    {
      RecordParams.a(localQQAppInterface, DeviceProfileManager.a(localQQAppInterface).a(DeviceProfileManager.DpcNames.SilkCfg.name(), ""));
      RecordParams.a(localQQAppInterface, true);
      StreamParams.a(localQQAppInterface, DeviceProfileManager.a(localQQAppInterface).a(DeviceProfileManager.DpcNames.StreamCfg.name(), ""));
      StreamParams.a(localQQAppInterface, true);
    }
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      PttOptimizeParams.a(localQQAppInterface, paramString);
      PttOptimizeParams.a(localQQAppInterface, true);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    NetworkCenter.a();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      PreDownloadParams.a(localQQAppInterface, paramString);
      PreDownloadParams.a(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    PreDownloadParams.a();
    DeviceProfileManager.b(this);
    RecordParams.a();
    StreamParams.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\PttConfigController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */