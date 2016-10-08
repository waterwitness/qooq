package cooperation.qzone.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyService;
import cooperation.qzone.ServerListProvider;
import java.util.Map;
import ypt;
import ypu;

public class QZoneDistributedAppCtrl
  implements Handler.Callback
{
  static final int jdField_a_of_type_Int = 0;
  private static final long jdField_a_of_type_Long = 1800000L;
  private static QZoneDistributedAppCtrl jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "key_upload_maxsize";
  static final int b = 1;
  public static final String b = "key_desc";
  static final int c = 2;
  public static final String c = "key_url";
  public static final int d = 1;
  public static final String d = "key_trace_baseTime";
  public static final int e = 2;
  public static final String e = "key_trace_offset";
  public static final int f = 3;
  public static final String f = "key_ctrl_cmd";
  public static final int g = 4;
  public static final String g = "key_ctrl_param_enable";
  public static final int h = 5;
  public static final String h = "key_qzcombo_protect";
  public static final int i = 6;
  public static final String i = "key_qzapp_versioncode";
  public static final int j = 7;
  public static final String j = "key_qzh5_url";
  public static final int k = 8;
  public static final String k = "key_wns_config_main";
  public static final int l = 9;
  public static final String l = "key_wns_config_second";
  public static final int m = 10;
  public static final String m = "key_upload_dbname";
  public static final int n = 11;
  public static String n;
  public static final int o = 12;
  private static final String o = "QZoneDistributedAppCtrl";
  public static final int p = 13;
  public static final int q = 14;
  public static final int r = 15;
  public static final int s = 16;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  QZoneDistributedAppCtrl(String paramString)
  {
    n = paramString;
  }
  
  public static QZoneDistributedAppCtrl a(String paramString)
  {
    if (jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl == null) {
        jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl = new QZoneDistributedAppCtrl(paramString);
      }
      return jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl;
    }
  }
  
  public static void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new ypu(paramString));
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    LocalMultiProcConfig.b("comboqz_protect_enable", paramBoolean);
    LocalMultiProcConfig.a("qzapp_vercode", paramInt);
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        LocalMultiProcConfig.a("qzh5_url", paramString);
      }
      LocalMultiProcConfig.b("qz_safe_mode_no_tip", false);
      LocalMultiProcConfig.a("comboqz_qua", QUA.a());
    }
  }
  
  private void b(QZoneDistributedAppCtrl.Control paramControl)
  {
    int i1 = paramControl.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneDistributedAppCtrl", 2, "execCtrl cmd:" + i1);
    }
    String str1;
    long l1;
    label302:
    long l2;
    switch (i1)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.w("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i1);
      }
    case 4: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
      do
      {
        return;
        a();
        return;
        QZoneHelper.b(BaseApplicationImpl.getContext(), n);
        return;
        QZoneHelper.a(BaseApplicationImpl.getContext(), n);
        return;
        a();
        paramControl = BaseApplicationImpl.a().a();
      } while (!(paramControl instanceof QQAppInterface));
      QZoneHelper.a((QQAppInterface)paramControl, "QZoneDistributedAppCtrl");
      return;
    case 6: 
      a((String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url"));
      return;
    case 7: 
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_upload_dbname");
      QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), n, paramControl);
      return;
    case 8: 
      QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), n);
      return;
    case 9: 
      str1 = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_trace_baseTime");
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_trace_offset");
      if (TextUtils.isEmpty(str1))
      {
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramControl)) {
          break label460;
        }
        l2 = 1800000L;
        label314:
        if (l1 > 0L) {
          break label936;
        }
        l1 = System.currentTimeMillis();
      }
      break;
    }
    label460:
    label759:
    label936:
    for (;;)
    {
      long l3 = l2;
      if (l2 <= 0L) {
        l3 = 1800000L;
      }
      l2 = l1 - l3;
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "trace startTime: " + l2 + "ms" + "\t offsettime: " + l3 + "\t trace endTime: " + l1 + "ms");
      }
      QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), n, l2, l1);
      return;
      try
      {
        l1 = Long.valueOf(str1).longValue();
        l1 *= 1000L;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        l1 = 0L;
      }
      break label302;
      try
      {
        l2 = Long.valueOf(paramControl).longValue();
        l2 *= 1000L;
      }
      catch (NumberFormatException paramControl)
      {
        paramControl.printStackTrace();
        l2 = 0L;
      }
      break label314;
      QZoneAppCtrlUploadFileLogic.c(BaseApplicationImpl.getContext(), n);
      return;
      i1 = 82;
      try
      {
        boolean bool = Boolean.parseBoolean((String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_qzcombo_protect"));
        int i2;
        paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      }
      catch (Throwable paramControl)
      {
        for (;;)
        {
          try
          {
            i2 = Integer.parseInt((String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_qzapp_versioncode"));
            i1 = i2;
            paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_qzh5_url");
            a(bool, i2, paramControl);
            return;
          }
          catch (Throwable paramControl)
          {
            String str2;
            continue;
          }
          paramControl = paramControl;
          i1 = 82;
          bool = false;
          QLog.e("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 1, "error: execute CMD_COMBQZ_PROTECT", paramControl);
          paramControl = "";
          i2 = i1;
        }
      }
      if (!TextUtils.isEmpty(paramControl)) {
        ServerListProvider.a(Boolean.valueOf(paramControl).booleanValue());
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_DEBUG, param：" + paramControl);
      return;
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(paramControl))
      {
        if (!Boolean.valueOf(paramControl).booleanValue()) {
          break label759;
        }
        LocalMultiProcConfig.a("LooperMonitor", System.currentTimeMillis() + "");
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_PERFORMANCE_MONITOR, param：" + paramControl);
        return;
        LocalMultiProcConfig.a("LooperMonitor", "-1");
      }
      str2 = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url");
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_upload_maxsize");
      try
      {
        l1 = Long.valueOf(paramControl).longValue();
        QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), str2, n, l1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.w("QZoneDistributedAppCtrl", 4, "CMD_UPLOAD_CUSTOM, param：" + paramControl + ",error:Not long");
          }
          l1 = 1048576L;
        }
      }
      str2 = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_wns_config_main");
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_wns_config_second");
      QzoneConfig.a().a(str2, paramControl);
      return;
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url");
      QZoneAppCtrlUploadFileLogic.b(BaseApplicationImpl.getContext(), paramControl);
      return;
    }
  }
  
  private void c(QZoneDistributedAppCtrl.Control paramControl)
  {
    int i1 = paramControl.jdField_a_of_type_Int;
    switch (i1)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i1);
      }
    case 5: 
      return;
    }
    paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url");
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserDelegationActivity.class);
    localIntent.setFlags(localIntent.getFlags() | 0x10000000);
    localIntent.putExtra("post_data", "");
    localIntent.putExtra("url", paramControl);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramControl));
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
    BaseApplicationImpl.getContext().stopService(localIntent);
    Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
  }
  
  public void a(QZoneDistributedAppCtrl.Control paramControl)
  {
    if (paramControl != null) {
      ThreadManager.d(new ypt(this, paramControl));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "recv msg " + paramMessage);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      b((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      c((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\QZoneDistributedAppCtrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */