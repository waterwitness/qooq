import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import java.util.Comparator;

public class vqw
  implements Comparator
{
  public vqw(TroopGiftManager paramTroopGiftManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips1, MessageForDeliverGiftTips paramMessageForDeliverGiftTips2)
  {
    int j = -1;
    int i;
    if ((paramMessageForDeliverGiftTips1.isToAll()) && (paramMessageForDeliverGiftTips2.isToAll())) {
      i = (int)(paramMessageForDeliverGiftTips1.time - paramMessageForDeliverGiftTips2.time);
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramMessageForDeliverGiftTips1.isToAll());
      if (paramMessageForDeliverGiftTips2.isToAll()) {
        return 1;
      }
      if ((paramMessageForDeliverGiftTips1.receiverUin == this.a.a.getLongAccountUin()) && (paramMessageForDeliverGiftTips2.receiverUin == this.a.a.getLongAccountUin())) {
        return (int)(paramMessageForDeliverGiftTips1.time - paramMessageForDeliverGiftTips2.time);
      }
      i = j;
    } while (paramMessageForDeliverGiftTips1.receiverUin == this.a.a.getLongAccountUin());
    if (paramMessageForDeliverGiftTips2.receiverUin == this.a.a.getLongAccountUin()) {
      return 1;
    }
    return (int)(paramMessageForDeliverGiftTips1.time - paramMessageForDeliverGiftTips2.time);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */