import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class qus
  implements Runnable
{
  public qus(WordMatchManager paramWordMatchManager, WordMatchManager.MatcherCallback paramMatcherCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a.remove(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */