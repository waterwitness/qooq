import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public class qim
  implements Comparator
{
  private boolean a;
  
  public qim(boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBoolean;
  }
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    long l5 = 2L;
    paramEntity1 = (RecentUser)paramEntity1;
    paramEntity2 = (RecentUser)paramEntity2;
    long l1 = Math.max(paramEntity1.lastmsgtime, paramEntity1.lastmsgdrafttime);
    long l2 = Math.max(paramEntity2.lastmsgtime, paramEntity2.lastmsgdrafttime);
    if (l1 > l2) {
      l1 = 3L;
    }
    long l3;
    long l4;
    for (;;)
    {
      l3 = l1;
      l4 = l5;
      if (this.a)
      {
        l2 = l1;
        if (paramEntity1.showUpTime > 0L) {
          l2 = l1 | 0x1000;
        }
        l3 = l2;
        l4 = l5;
        if (paramEntity2.showUpTime > 0L)
        {
          l4 = 0x2 | 0x1000;
          l3 = l2;
        }
      }
      if (l3 >= l4) {
        break;
      }
      return 1;
      if (l1 < l2) {
        l1 = 1L;
      } else {
        l1 = 2L;
      }
    }
    if (l3 == l4) {
      return 0;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */