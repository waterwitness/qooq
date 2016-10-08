import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.List;

public class ule
  implements Runnable
{
  public ule(FTSMessageSearchEngine paramFTSMessageSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SQLiteFTSUtils.f(FTSMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsmsgFTSMessageSearchEngine)) == 1) {}
    for (List localList = this.jdField_a_of_type_ComTencentMobileqqSearchFtsmsgFTSMessageSearchEngine.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, false);; localList = this.jdField_a_of_type_ComTencentMobileqqSearchFtsmsgFTSMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, false))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */