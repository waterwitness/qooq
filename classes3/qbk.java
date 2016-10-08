import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class qbk
  implements Comparator
{
  public qbk(NearbyGrayTipsManager paramNearbyGrayTipsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.time < paramMessageRecord2.time) {
      return 1;
    }
    if (paramMessageRecord1.time > paramMessageRecord2.time) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */