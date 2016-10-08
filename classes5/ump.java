import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class ump
  implements Runnable
{
  public ump(MessageSearchEngine paramMessageSearchEngine, ISearchListener paramISearchListener, SearchRequest paramSearchRequest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    umq localumq = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null)
    {
      localumq = new umq(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.addObserver(localumq);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if (localumq != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.deleteObserver(localumq);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */