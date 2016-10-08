import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class vra
  extends TroopGiftCallback
{
  public vra(TroopGiftManager paramTroopGiftManager, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ContactUtils.f((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);; this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_ComTencentCommonAppAppInterface.a(1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin + ""))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "playGiftBigAnimation getGrabBagInfo onError. errorCode:" + paramInt + " errorMsg:" + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_AndroidOsHandler.post(new vrc(this));
      return;
    }
  }
  
  public void a(TroopGiftBagInfo paramTroopGiftBagInfo)
  {
    if (paramTroopGiftBagInfo.myGrabResult == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton = true;
      if (!(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label105;
      }
    }
    label105:
    for (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ContactUtils.f((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);; this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_ComTencentCommonAppAppInterface.a(1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin + ""))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.jdField_a_of_type_AndroidOsHandler.post(new vrb(this));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */