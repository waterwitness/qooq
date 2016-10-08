import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class umv
  implements ISearchListener
{
  public umv(NetSearchEngine paramNetSearchEngine, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList) {}
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    SearchUtils.a();
    NetSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).a.countDown();
  }
  
  public void b(String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */