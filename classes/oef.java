import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;

public class oef
  implements TroopFileError.TroopFileErrorFilter
{
  public String a;
  
  public oef(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public long a()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */