import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public class qdl
  implements Comparator
{
  public qdl(PublicAccountDataManager paramPublicAccountDataManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    long l1 = ((PublicAccountInfo)paramEntity1).lastAIOReadTime;
    long l2 = ((PublicAccountInfo)paramEntity2).lastAIOReadTime;
    if (l1 > l2) {
      return 1;
    }
    if (l1 < l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */