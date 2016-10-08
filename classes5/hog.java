import com.tencent.biz.pubaccount.DynamicMsgProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class hog
  implements Comparator
{
  public hog(DynamicMsgProcessor paramDynamicMsgProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */