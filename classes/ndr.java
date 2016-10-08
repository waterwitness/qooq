import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;

public class ndr
  implements Runnable
{
  public ndr(PlusPanel paramPlusPanel, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopAppMgr localTroopAppMgr = (TroopAppMgr)PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).getManager(108);
    if (localTroopAppMgr != null) {
      localTroopAppMgr.c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAIOAppInfo.appid);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */