import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rjb
{
  public int a;
  public Bundle a;
  public Runnable a;
  
  public rjb(int paramInt, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    paramBundle.putInt("seq", paramInt);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */