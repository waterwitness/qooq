import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.CreateDiscussionSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class ulw
  implements Runnable
{
  public ulw(ContactSearchEngine paramContactSearchEngine, SearchRequest paramSearchRequest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList1 = ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    ISearchListener localISearchListener = ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine);
    if ((localISearchListener != null) && (localList1 != null))
    {
      if (ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine) == null) {
        localISearchListener.a(localList1, 1);
      }
    }
    else {
      return;
    }
    localISearchListener.a(localList1);
    List localList2 = ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine).a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localISearchListener.a(localList1, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */