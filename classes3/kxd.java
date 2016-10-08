import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class kxd
  extends AccountObserver
{
  kxd(kxc paramkxc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 != null) {
        break label70;
      }
    }
    label70:
    for (int i = 0;; i = paramString2.length())
    {
      QLog.e("ChatHistoryForC2C", 2, i);
      this.a.a.runOnUiThread(new kxe(this, paramBoolean));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */