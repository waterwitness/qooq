import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.struct.AdData;
import java.util.Comparator;

public class ran
  implements Comparator
{
  public ran(NearbyDataManager paramNearbyDataManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(AdData paramAdData1, AdData paramAdData2)
  {
    return paramAdData1.position - paramAdData2.position;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ran.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */