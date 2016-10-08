import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Sentence;
import java.util.Comparator;

public class szq
  implements Comparator
{
  private szq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Sentence paramSentence1, Sentence paramSentence2)
  {
    if (paramSentence1.a >= paramSentence2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */