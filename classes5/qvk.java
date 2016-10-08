import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qvk
  extends ContentObserver
{
  public qvk(BusinessCardEditActivity paramBusinessCardEditActivity, Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_EditActivity", 2, "Contact changed selfChange=" + paramBoolean);
    }
    if (BusinessCardEditActivity.a(this.a))
    {
      this.a.a(2131371257, 2);
      BusinessCardEditActivity.a(this.a, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */