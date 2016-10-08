import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iei
  implements Runnable
{
  public iei(SubscriptRecommendController paramSubscriptRecommendController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_Boolean = SubscriptRecommendController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.a.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */