import com.tencent.mobileqq.activity.qqcard.NearByQQCardFragment;
import com.tencent.mobileqq.app.QQCardHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.qcard.QQCardService;

public class osr
  implements Runnable
{
  public osr(NearByQQCardFragment paramNearByQQCardFragment, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment, 0L);
      NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment, null);
      NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment, QQCardService.a());
    }
    if (NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment) == 0) {}
    for (int i = 2;; i = 3)
    {
      NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment).a(NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment), i, 1, NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment), NearByQQCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardNearByQQCardFragment));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */