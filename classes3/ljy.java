import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ljy
  extends TroopObserver
{
  public ljy(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.profilecard.FrdProfileCard", 2, "onGetExtShowTroopList");
    }
    if ((!paramBoolean) || (paramList1 == null) || (paramList1.size() == 0) || (paramInt != 0))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0))
        {
          paramList1 = new ShowExternalTroop();
          paramList1.strFaceUrl = null;
          FriendProfileCardActivity.a(this.a, paramList1);
        }
      }
      else {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.removeBuisEntry(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      }
      FriendProfileCardActivity.a(this.a);
      return;
    }
    paramList1 = (ShowExternalTroop)paramList1.get(0);
    FriendProfileCardActivity.a(this.a, paramList1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ljy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */