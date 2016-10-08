import android.os.Message;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;

public class ooy
  extends MqqHandler
{
  private WeakReference a;
  
  public ooy(ContactListView paramContactListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramContactListView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ContactListView localContactListView = (ContactListView)this.a.get();
    if (localContactListView == null) {
      if (QLog.isColorLevel()) {
        QLog.i(ContactListView.a(), 2, "UiHandler() handleMessage a == null");
      }
    }
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 3: 
        default: 
          throw new RuntimeException("Unknown message: " + paramMessage.what);
        case 1: 
          if ((ContactListView.a(localContactListView)) && (!localContactListView.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()))
          {
            localContactListView.g();
            ContactListView.a(localContactListView, false);
          }
          localContactListView.j();
          return;
        case 2: 
          localContactListView.j();
        }
      } while (NetworkUtil.e(localContactListView.getContext()));
      localContactListView.i();
      localContactListView.a("网络不可用，请稍候重试.");
      return;
      localContactListView.b = ((List)paramMessage.obj);
      localContactListView.jdField_a_of_type_Oou.notifyDataSetChanged();
      return;
      paramMessage = ContactListView.a(localContactListView).getAccount();
      localObject = (TicketManagerImpl)ContactListView.a(localContactListView).getManager(2);
    } while (localObject == null);
    Object localObject = ((TicketManagerImpl)localObject).getA2(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.i(ContactListView.a(), 2, "a2 = " + (String)localObject);
    }
    QQPimGetTipsInfoIPC.a().a(ContactListView.a(localContactListView), ContactListView.a(localContactListView), paramMessage, (String)localObject);
    return;
    ContactListView.a(localContactListView, (QQPimTipsInfo)paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ooy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */