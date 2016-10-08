import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;

public final class xrj
  implements Runnable
{
  public xrj(int paramInt1, Context paramContext, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BadgeUtilImpl.setLimitCount(this.jdField_a_of_type_Int);
    BadgeUtilImpl.setBadge(this.jdField_a_of_type_AndroidContentContext, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */