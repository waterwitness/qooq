import com.tencent.mobileqq.app.fms.FullMessageSearchTask;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public class qkj
  implements Comparator
{
  public qkj(FullMessageSearchTask paramFullMessageSearchTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    int j = -1;
    paramEntity1 = (RecentUser)paramEntity1;
    paramEntity2 = (RecentUser)paramEntity2;
    long l1 = Math.max(paramEntity1.lastmsgtime, paramEntity1.lastmsgdrafttime);
    long l2 = Math.max(paramEntity2.lastmsgtime, paramEntity2.lastmsgdrafttime);
    int i;
    if (l1 < l2)
    {
      i = 1;
      if (paramEntity1.type != paramEntity2.type) {
        break label80;
      }
    }
    label80:
    do
    {
      do
      {
        return i;
        if (l1 == l2)
        {
          i = 0;
          break;
        }
        i = -1;
        break;
        i = j;
      } while (paramEntity1.type == 0);
      if (paramEntity2.type == 0) {
        return 1;
      }
      i = j;
    } while (paramEntity1.type - paramEntity2.type > 0);
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */