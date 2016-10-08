import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class ieq
  implements Comparator
{
  public ieq(TroopBarAssistantManager paramTroopBarAssistantManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopBarData paramTroopBarData1, TroopBarData paramTroopBarData2)
  {
    long l1 = Math.max(paramTroopBarData1.mLastMsgTime, paramTroopBarData1.mLastDraftTime);
    long l2 = Math.max(paramTroopBarData2.mLastMsgTime, paramTroopBarData2.mLastDraftTime);
    if ((paramTroopBarData2.mIsSticky) && (!paramTroopBarData1.mIsSticky)) {}
    do
    {
      do
      {
        return 1;
        if ((!paramTroopBarData2.mIsSticky) && (paramTroopBarData1.mIsSticky)) {
          return -1;
        }
        if ((!paramTroopBarData2.mIsSticky) || (!paramTroopBarData1.mIsSticky)) {
          break;
        }
      } while (paramTroopBarData2.mLastStickyTime > paramTroopBarData1.mLastStickyTime);
      if (paramTroopBarData2.mLastStickyTime == paramTroopBarData1.mLastStickyTime) {
        return 0;
      }
      return -1;
    } while (l1 < l2);
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ieq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */