import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qcl
  extends ContentObserver
{
  public qcl(PhoneContactManagerImp paramPhoneContactManagerImp, Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "Contact changed.");
    }
    this.a.g = true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */