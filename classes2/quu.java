import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

class quu
  implements Runnable
{
  quu(qut paramqut)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.b = this.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.c = true;
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.d = false;
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.e = false;
    Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WordMatchManager.MatcherCallback localMatcherCallback = (WordMatchManager.MatcherCallback)localIterator.next();
      if (localMatcherCallback != null) {
        localMatcherCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher);
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\quu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */