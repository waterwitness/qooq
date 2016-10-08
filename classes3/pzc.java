import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Comparator;

public class pzc
  implements Comparator
{
  public pzc(IndividualRedPacketManager paramIndividualRedPacketManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    long l2 = 0L;
    if (paramFile1 != null) {}
    for (long l1 = paramFile1.lastModified();; l1 = 0L)
    {
      if (paramFile2 != null) {
        l2 = paramFile2.lastModified();
      }
      if (l2 >= l1) {
        break;
      }
      return -1;
    }
    if (l2 > l1) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */