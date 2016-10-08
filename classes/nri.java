import android.view.View;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.DownloadGftData;
import com.tencent.qphone.base.util.QLog;

class nri
  implements Runnable
{
  nri(nrh paramnrh, TroopGiftManager.DownloadGftData paramDownloadGftData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager$DownloadGftData.a)
    {
      this.jdField_a_of_type_Nrh.a.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d(ChatItemBuilder.a, 2, "GONE uniseq = " + this.jdField_a_of_type_Nrh.a.uniseq);
      }
      ((TroopGiftManager)nrh.a(this.jdField_a_of_type_Nrh).getManager(112)).b(this.jdField_a_of_type_Nrh);
      this.jdField_a_of_type_Nrh.c.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "VISIBLE uniseq = " + this.jdField_a_of_type_Nrh.a.uniseq);
    }
    this.jdField_a_of_type_Nrh.a.isLoading = true;
    this.jdField_a_of_type_Nrh.c.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */