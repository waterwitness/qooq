import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ohm
  implements Runnable
{
  public ohm(ClassificationSearchFragment paramClassificationSearchFragment, SearchResult paramSearchResult)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ClassificationSearchFragment localClassificationSearchFragment;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult != null)
    {
      localClassificationSearchFragment = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.a) {
        break label30;
      }
    }
    label30:
    for (int i = 1;; i = 0)
    {
      ClassificationSearchFragment.a(localClassificationSearchFragment, i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */