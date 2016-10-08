import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import java.util.Comparator;

public class tbz
  implements Comparator
{
  public tbz(TroopAssistantManager paramTroopAssistantManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopAssistantData paramTroopAssistantData1, TroopAssistantData paramTroopAssistantData2)
  {
    long l1 = Math.max(paramTroopAssistantData1.lastmsgtime, paramTroopAssistantData1.lastdrafttime);
    long l2 = Math.max(paramTroopAssistantData2.lastmsgtime, paramTroopAssistantData2.lastdrafttime);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */