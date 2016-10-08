import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class qlt
  implements Comparator
{
  public qlt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.longMsgIndex > paramMessageRecord2.longMsgIndex) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */