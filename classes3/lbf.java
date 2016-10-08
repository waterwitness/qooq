import com.tencent.device.devicemgr.SmartDeviceObserver;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class lbf
  extends SmartDeviceObserver
{
  public lbf(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a = ((ArrayList)paramArrayList.clone());
    } while (!this.a.jdField_a_of_type_Boolean);
    this.a.a(1400L, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */