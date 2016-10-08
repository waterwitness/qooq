import com.tencent.mobileqq.app.message.HCTopicMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class qlr
  implements Comparator
{
  public qlr(HCTopicMessageProcessor paramHCTopicMessageProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */