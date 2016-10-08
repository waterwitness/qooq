import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public final class oyg
  implements Runnable
{
  public oyg(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = TroopBarAssistantManager.a().a(this.a);
    int i;
    int j;
    label20:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localObject = (TroopBarData)localList.get(j);
      if (localObject != null) {
        break label61;
      }
    }
    for (;;)
    {
      j += 1;
      break label20;
      i = localList.size();
      break;
      label61:
      localObject = this.a.a().a(((TroopBarData)localObject).mUin, 1008);
      if (localObject != null) {
        TroopBarAssistantManager.a().a(this.a, ((QQMessageFacade.Message)localObject).time);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */