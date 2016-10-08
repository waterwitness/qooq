import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class kin
  extends BusinessCardObserver
{
  public kin(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_BusinessCard_observer", 2, "onGetCardInfo " + paramBoolean + " cardId:" + paramString);
    }
    this.a.a();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (paramInt != 3)) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */