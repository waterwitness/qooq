import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import java.util.Observable;
import java.util.Observer;

class umq
  implements Observer
{
  umq(ump paramump)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(MessageSearchEngine.a(this.a.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine, this.a.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.b, (FullMessageSearchResult)paramObject));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */