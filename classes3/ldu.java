import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class ldu
  implements Comparator
{
  public ldu(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    int n = 4096;
    int m = 1;
    int j;
    label61:
    int k;
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      if (paramRecentBaseData1.a.showUpTime > 0L)
      {
        i = 1;
        if (paramRecentBaseData2.a.showUpTime <= 0L) {
          break label81;
        }
        j = 1;
        if ((i == 0) || (j != 0)) {
          break label87;
        }
        k = -1;
      }
      label81:
      label87:
      do
      {
        return k;
        i = 0;
        break;
        j = 0;
        break label61;
        if (i != 0) {
          break label100;
        }
        k = m;
      } while (j != 0);
      label100:
      if ((i == 0) && (j == 0)) {
        if ((paramRecentBaseData1.H > 0) && (paramRecentBaseData1.a.type == 0) && (QvipSpecialCareManager.a(this.a.a.a() + paramRecentBaseData1.a.uin)) && (!Conversation.a(this.a, paramRecentBaseData1.a.uin, 0)))
        {
          i = 1;
          if (i == 0) {
            break label431;
          }
        }
      }
    }
    label270:
    label317:
    label410:
    label425:
    label431:
    for (int i = 4096;; i = 0)
    {
      if ((paramRecentBaseData2.H > 0) && (paramRecentBaseData2.a.type == 0) && (QvipSpecialCareManager.a(this.a.a.a() + paramRecentBaseData2.a.uin)) && (!Conversation.a(this.a, paramRecentBaseData2.a.uin, 0)))
      {
        j = 1;
        if (j == 0) {
          break label425;
        }
      }
      for (j = n;; j = 0)
      {
        long l2 = Math.max(paramRecentBaseData1.a.lastmsgtime, paramRecentBaseData1.a.lastmsgdrafttime);
        long l1 = Math.max(paramRecentBaseData2.a.lastmsgtime, paramRecentBaseData2.a.lastmsgdrafttime);
        if (l2 > l1) {
          l1 = 3L;
        }
        for (;;)
        {
          l1 = (int)(l1 | i) - (int)(j | 0x2);
          if (l1 != 0L) {
            break label410;
          }
          return 0;
          i = 0;
          break;
          j = 0;
          break label270;
          l2 = paramRecentBaseData1.b;
          l1 = paramRecentBaseData2.b;
          j = 0;
          i = 0;
          break label317;
          if (l2 < l1) {
            l1 = 1L;
          } else {
            l1 = 2L;
          }
        }
        k = m;
        if (l1 < 0L) {
          break;
        }
        return -1;
        return 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */