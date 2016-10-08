import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.ShuayishuaConfig;
import java.util.Comparator;

public final class tqy
  implements Comparator
{
  public tqy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(ShuayishuaConfig paramShuayishuaConfig1, ShuayishuaConfig paramShuayishuaConfig2)
  {
    long l = paramShuayishuaConfig1.realBegin - paramShuayishuaConfig2.realBegin;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */