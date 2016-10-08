import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import eipc.EIPCResult;

public class yir
  extends QIPCModule
{
  public yir(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.onCall()" + paramString);
    }
    if (QQPimDefineList.g.equals(paramString)) {
      if (QQPimGetTipsInfoIPC.a() != -1) {}
    }
    while ((!QQPimDefineList.h.equals(paramString)) || (System.currentTimeMillis() - QQPimGetTipsInfoIPC.a(this.a) < 500L))
    {
      do
      {
        do
        {
          return null;
        } while (System.currentTimeMillis() - QQPimGetTipsInfoIPC.a(this.a) < 500L);
        QQPimGetTipsInfoIPC.a(this.a, System.currentTimeMillis());
        if (QQPimGetTipsInfoIPC.a() == 0)
        {
          QQPimGetTipsInfoIPC.a(-1);
          ThreadManager.a(new yis(this.a, QQPimGetTipsInfoIPC.a(this.a), QQPimGetTipsInfoIPC.b(this.a)), null, true);
          return null;
        }
      } while (QQPimGetTipsInfoIPC.a() != 1);
      QQPimGetTipsInfoIPC.a(-1);
      ThreadManager.a(new yiu(this.a, null), null, true);
      return null;
    }
    QQPimGetTipsInfoIPC.a(this.a, System.currentTimeMillis());
    paramString = new QQPimTipsInfo();
    paramString.f = 0;
    QQPimGetTipsInfoIPC.a(this.a).a(paramString);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */