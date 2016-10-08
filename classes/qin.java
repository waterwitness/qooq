import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;
import java.util.Map.Entry;

public class qin
  implements Comparator
{
  public qin(RoamDateCache paramRoamDateCache)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Map.Entry paramEntry1, Map.Entry paramEntry2)
  {
    paramEntry1 = ((String)paramEntry1.getKey()).split("&")[1];
    int i = Integer.parseInt(paramEntry1.split("-")[0]);
    int j = Integer.parseInt(paramEntry1.split("-")[1]);
    paramEntry1 = ((String)paramEntry2.getKey()).split("&")[1];
    int k = Integer.parseInt(paramEntry1.split("-")[0]);
    int m = Integer.parseInt(paramEntry1.split("-")[1]);
    if (i > k) {
      return 1;
    }
    if (i == k) {
      return j - m;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */