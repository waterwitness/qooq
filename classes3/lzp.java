import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class lzp
  extends ContactBindObserver
{
  public lzp(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      PhoneUnityBindInfoActivity.a(this.a, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, 1, 2);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this);
      this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
      return;
      PhoneUnityBindInfoActivity.a(this.a, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, 3, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */