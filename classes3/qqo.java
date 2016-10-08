import com.tencent.ark.ark;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class qqo
  implements Runnable
{
  public qqo(ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(ark.arkCheckAppVersion(this.jdField_a_of_type_JavaLangString)));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */