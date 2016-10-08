package cooperation.qqpim;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import yiq;
import yir;

public class QQPimGetTipsInfoIPC
{
  private static final int jdField_a_of_type_Int = -1;
  private static QQPimGetTipsInfoIPC jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC;
  private static final int jdField_b_of_type_Int = 0;
  private static final int c = 1;
  private static int d = -1;
  private long jdField_a_of_type_Long;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new yir(this, QQPimDefineList.c);
  private QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack;
  QQPimPluginLoadRunnable.IPluginLoadListener jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener = new yiq(this);
  private QQPimPluginLoadRunnable jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable;
  public QQPimTipsInfo a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static QQPimGetTipsInfoIPC a()
  {
    if (jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC == null) {
        jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC = new QQPimGetTipsInfoIPC();
      }
      return jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack = null;
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null)
    {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack paramIGetQQPimTipsCallBack, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.jdField_a_of_type_JavaLangString, 2, "QQPimGetTipsInfoIPC.getContactTipsIpc()" + paramIGetQQPimTipsCallBack.hashCode());
    }
    d = 0;
    this.jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack = paramIGetQQPimTipsCallBack;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        QIPCServerHelper.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule);
        this.jdField_a_of_type_Boolean = true;
      }
      b();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener);
    ThreadManager.a(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.jdField_a_of_type_JavaLangString, 2, "QQPimGetTipsInfoIPC.noticeClickTipsIPC()");
    }
    d = 1;
    QQPimPluginProxyService.a(a());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqpim\QQPimGetTipsInfoIPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */