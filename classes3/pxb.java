import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class pxb
  implements Comparator
{
  public pxb(DiscussionIconHelper paramDiscussionIconHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (l1 == l2) {
        return 0;
      }
      if (l1 > l2) {
        return 2;
      }
      return -1;
    }
    catch (Exception paramString1) {}
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */