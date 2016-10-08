import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class pyz
  implements Comparator
{
  public pyz(HotchatSCMng paramHotchatSCMng)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(HotchatSCMng.HotchatNote paramHotchatNote1, HotchatSCMng.HotchatNote paramHotchatNote2)
  {
    if ((paramHotchatNote1 == null) || (paramHotchatNote2 == null)) {}
    do
    {
      return 0;
      if (paramHotchatNote1.a > paramHotchatNote2.a) {
        return 1;
      }
    } while (paramHotchatNote1.a >= paramHotchatNote2.a);
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */