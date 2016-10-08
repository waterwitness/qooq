package cooperation.qqpim;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class QQPimPluginLoadRunnable
  implements Runnable
{
  private static final long b = 30000L;
  private long jdField_a_of_type_Long;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  private QQPimPluginLoadRunnable.IPluginLoadListener jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener;
  private boolean jdField_a_of_type_Boolean;
  
  public QQPimPluginLoadRunnable(QQPimPluginLoadRunnable.IPluginLoadListener paramIPluginLoadListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener = paramIPluginLoadListener;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    label114:
    label182:
    label249:
    label333:
    label460:
    label555:
    do
    {
      do
      {
        do
        {
          PluginInfo localPluginInfo;
          do
          {
            do
            {
              do
              {
                return;
                this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)localQQAppInterface.getManager(26));
              } while (this.jdField_a_of_type_CooperationPluginIPluginManager == null);
              localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqpim_plugin.apk");
              if (localPluginInfo != null)
              {
                if (localPluginInfo.mState != 4) {
                  break label182;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.i(QQPimDefineList.a, 1, "onPluginManagerLoaded has installed");
                }
                ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006716", "0X8006716", 0, 0, "", "", "", "");
                if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener != null) {
                  this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a();
                }
              }
              do
              {
                for (;;)
                {
                  if (this.jdField_a_of_type_Boolean) {
                    break label460;
                  }
                  if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 30000L) {
                    break label249;
                  }
                  ReportController.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                  if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener == null) {
                    break;
                  }
                  this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(-5);
                  return;
                  if (QLog.isDevelopLevel()) {
                    QLog.i(QQPimDefineList.a, 1, "onPluginManagerLoaded start down or install...");
                  }
                  ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006717", "0X8006717", 0, 0, "", "", "", "");
                  this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqpim_plugin.apk");
                  if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener != null) {
                    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.b();
                  }
                }
                localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqpim_plugin.apk");
                if (localPluginInfo != null) {
                  break label333;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d(QQPimDefineList.a, 4, "null == pluginInfo");
                }
              } while (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady());
              ReportController.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
            } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener == null);
            this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(-1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d(QQPimDefineList.a, 4, "queryPluginInfo mState : " + localPluginInfo.mState + " progress:" + localPluginInfo.mDownloadProgress);
            }
            if (localPluginInfo.mState != 4) {
              break;
            }
            ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006718", "0X8006718", 0, 0, "", "", "", "");
          } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener == null);
          this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a();
          return;
          if (localPluginInfo.mState == 0) {
            this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqpim_plugin.apk");
          }
          for (;;)
          {
            try
            {
              Thread.sleep(500L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            break label114;
            break;
            if (localInterruptedException.mState == 3)
            {
              if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener != null) {
                this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(localInterruptedException.mDownloadProgress);
              }
            }
            else if (localInterruptedException.mState == 1)
            {
              if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener != null) {
                this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(localInterruptedException.mDownloadProgress);
              }
            }
            else
            {
              if (localInterruptedException.mState != 2) {
                break label555;
              }
              if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener != null) {
                this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(localInterruptedException.mDownloadProgress);
              }
            }
          }
          if (localInterruptedException.mState != -1) {
            break;
          }
          ReportController.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
        } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener == null);
        this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(-6);
        return;
        if (localInterruptedException.mState != -2) {
          break;
        }
        ReportController.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
      } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener == null);
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(-3);
      return;
      ReportController.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
    } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener == null);
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener.a(-2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqpim\QQPimPluginLoadRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */