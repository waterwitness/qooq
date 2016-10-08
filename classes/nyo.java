import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.qphone.base.util.QLog;

public class nyo
  implements HotchatSCHelper.OnShowNoteListener
{
  public nyo(HotChatPie paramHotChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(HotchatSCMng.HotchatNote paramHotchatNote)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("Q.aio.BaseTroopChatPie", "onShowHotchatNote", new Object[] { paramHotchatNote });
    }
    if (paramHotchatNote == null)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HotChatPie.a(this.a), HotChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.a.L);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramHotchatNote.a, paramHotchatNote.b);
    this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b = true;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */