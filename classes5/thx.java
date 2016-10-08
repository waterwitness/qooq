import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyIconDecoder;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import java.util.List;

public class thx
  extends NearbyProcObserver
{
  public thx(NearbyIconDecoder paramNearbyIconDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null) || (paramList1.size() == 0) || (paramList1.size() != paramList2.size())) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList1.size())
      {
        this.a.a((String)paramList1.get(i), (String)paramList2.get(i));
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */