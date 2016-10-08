import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import java.util.List;

public class ygn
  implements Runnable
{
  public ISearchListener a;
  public SearchRequest a;
  
  private ygn(FavoriteSearchEngine paramFavoriteSearchEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SearchRequest localSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
    String str = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a;
    List localList = this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine.a(localSearchRequest);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (localSearchRequest == this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a))) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */