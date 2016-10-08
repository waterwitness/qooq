import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.mobileqq.webprocess.PreloadService.PreloadImpl;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class wgt
  implements Runnable
{
  public wgt(PreloadService.PreloadImpl paramPreloadImpl, Context paramContext, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!PreloadService.a)
    {
      PreloadService.a = true;
      for (;;)
      {
        try
        {
          PreloadService.PreloadImpl.a(this.jdField_a_of_type_ComTencentMobileqqWebprocessPreloadService$PreloadImpl);
          Object localObject = (MobileQQ)this.jdField_a_of_type_AndroidContentContext.getApplicationContext();
          if (localObject == null) {
            break label309;
          }
          localObject = ((MobileQQ)localObject).waitAppRuntime(null);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PreloadService", 2, "app runtime:" + localObject.getClass().getName() + ",account:" + ((AppRuntime)localObject).getAccount());
            }
            PreloadService.PreloadImpl.a(this.jdField_a_of_type_ComTencentMobileqqWebprocessPreloadService$PreloadImpl, this.jdField_a_of_type_AndroidContentContext, (AppRuntime)localObject);
            ((AppRuntime)localObject).getManager(2);
            if (QLog.isColorLevel()) {
              QLog.d("PreloadService", 2, "app:" + ((AppRuntime)localObject).getApplication().getProcessName());
            }
            this.jdField_a_of_type_ComTencentMobileqqWebprocessPreloadService$PreloadImpl.a((AppRuntime)localObject, this.jdField_a_of_type_Long);
            com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.l = true;
            if ((WebProcessReceiver.jdField_a_of_type_Long <= 0L) || (WebProcessReceiver.b <= 0L)) {
              break;
            }
            int i = (int)(WebProcessReceiver.b - WebProcessReceiver.jdField_a_of_type_Long);
            int j = (int)(System.currentTimeMillis() - WebProcessReceiver.b);
            if (QLog.isColorLevel()) {
              QLog.d("PreloadService", 2, "WebProcessReceiver.onReceive cost: " + i + ", preload cost: " + j);
            }
            VasWebviewUtil.reportVasStatus("Preload_Web_Process", "", "", i, j);
            WebProcessReceiver.jdField_a_of_type_Long = 0L;
            WebProcessReceiver.b = 0L;
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PreloadService", 2, "-->No app runtime.");
          continue;
          QLog.d("PreloadService", 2, "preload error:" + localException.toString());
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        return;
        label309:
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "-->Could not get MobileQQ!");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "async preload:already inited.");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */