import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;

public class wag
{
  public static DBUtils a = new DBUtils(null);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */