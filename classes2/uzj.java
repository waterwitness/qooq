import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import java.util.Comparator;

public class uzj
  implements Comparator
{
  public uzj(QzoneTextBuilder paramQzoneTextBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = this.a.getSpanStart(paramObject1);
    int j = this.a.getSpanStart(paramObject2);
    if (i == j) {
      return 0;
    }
    if (i > j) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */