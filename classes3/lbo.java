import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lbo
  extends CardObserver
{
  private lbo(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.a(1400L, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */