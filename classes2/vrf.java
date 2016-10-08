import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class vrf
  implements FrameSprite.OnFrameEndListener
{
  public vrf(TroopGiftManager paramTroopGiftManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.o = 1;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) && (this.a.jdField_a_of_type_AndroidAppActivity == null)) {}
    List localList;
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
        break;
      }
      String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.a;
      localList = (List)this.a.b.get(str);
    } while ((TroopGiftUtil.a(localList)) || (localList == null));
    if (localList != null) {}
    for (;;)
    {
      try
      {
        MessageForDeliverGiftTips localMessageForDeliverGiftTips = (MessageForDeliverGiftTips)localList.remove(0);
        localMessageForDeliverGiftTips.hasFetchButFailed = false;
        if (QLog.isColorLevel()) {
          QLog.d(".troop.send_gift", 2, "onMagicPlayEnd id:" + TroopGiftUtil.a(localMessageForDeliverGiftTips));
        }
        if (localList.size() == 0) {
          break label193;
        }
        Collections.sort(localList, this.a.jdField_a_of_type_JavaUtilComparator);
        this.a.jdField_a_of_type_AndroidOsHandler.post(new vrg(this));
        return;
      }
      finally {}
      Object localObject2 = this.a.d;
      break;
      label193:
      this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(null);
      localObject2 = ChatActivityUtils.a((String)localObject2, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
      if ((TroopGiftManager.jdField_a_of_type_Boolean) && (localObject2 != null) && (-1 == ((Integer)localObject2).intValue()) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null))
      {
        TroopGiftManager.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_AndroidOsHandler.post(new vrh(this));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */