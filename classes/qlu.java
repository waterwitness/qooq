import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class qlu
  implements Comparator
{
  public qlu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */