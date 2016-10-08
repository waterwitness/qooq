import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class hxk
  implements Comparator
{
  public hxk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    Object localObject = ReadInJoyUtils.a();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      localObject = (QQAppInterface)localObject;
      if ((!(paramRecentBaseData1 instanceof RecentUserBaseData)) || (!(paramRecentBaseData2 instanceof RecentUserBaseData))) {
        break label423;
      }
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      if (paramRecentBaseData1.a.showUpTime <= 0L) {
        break label88;
      }
      i = 1;
      if (paramRecentBaseData2.a.showUpTime <= 0L) {
        break label94;
      }
    }
    label88:
    label94:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j != 0)) {
        break label100;
      }
      return -1;
      return 0;
      i = 0;
      break;
    }
    label100:
    if ((i == 0) && (j != 0)) {
      return 1;
    }
    if ((i == 0) && (j == 0)) {
      if ((paramRecentBaseData1.H > 0) && (paramRecentBaseData1.a.type == 0) && (QvipSpecialCareManager.a(((QQAppInterface)localObject).a() + paramRecentBaseData1.a.uin)) && (!ReadInJoyUtils.a((QQAppInterface)localObject, paramRecentBaseData1.a.uin, 0)))
      {
        i = 1;
        if (i == 0) {
          break label431;
        }
      }
    }
    label268:
    label316:
    label412:
    label423:
    label425:
    label431:
    for (int i = 4096;; i = 0)
    {
      if ((paramRecentBaseData2.H > 0) && (paramRecentBaseData2.a.type == 0) && (QvipSpecialCareManager.a(((QQAppInterface)localObject).a() + paramRecentBaseData2.a.uin)) && (!ReadInJoyUtils.a((QQAppInterface)localObject, paramRecentBaseData2.a.uin, 0)))
      {
        j = 1;
        if (j == 0) {
          break label425;
        }
      }
      for (j = 4096;; j = 0)
      {
        long l1 = Math.max(paramRecentBaseData1.a.lastmsgtime, paramRecentBaseData1.a.lastmsgdrafttime);
        long l2 = Math.max(paramRecentBaseData2.a.lastmsgtime, paramRecentBaseData2.a.lastmsgdrafttime);
        if (l1 > l2) {
          l1 = 3L;
        }
        for (;;)
        {
          l1 = (int)(l1 | i) - (int)(j | 0x2);
          if (l1 != 0L) {
            break label412;
          }
          return 0;
          i = 0;
          break;
          j = 0;
          break label268;
          l1 = paramRecentBaseData1.b;
          l2 = paramRecentBaseData2.b;
          j = 0;
          i = 0;
          break label316;
          if (l1 < l2) {
            l1 = 1L;
          } else {
            l1 = 2L;
          }
        }
        if (l1 < 0L) {
          return 1;
        }
        return -1;
        return 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */