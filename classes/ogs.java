import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ogs
  extends Handler
{
  public ogs(AddContactsActivity paramAddContactsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.b();
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    PADetailReportUtil.a().a(300);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */