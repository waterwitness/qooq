import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

public final class uxi
  extends SubAccountObserver
{
  public uxi(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() thread.name=" + Thread.currentThread().getName());
    }
    paramString1 = (SubAccountManager)this.a.getManager(60);
    int j;
    if ((paramString3 != null) && (paramString3.length() > 0))
    {
      j = 1;
      i = j;
      if (paramString1 != null) {
        paramString1.a(paramString2, paramString3, false);
      }
    }
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        paramString1.e(paramString2);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */