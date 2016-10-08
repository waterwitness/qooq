import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class sbe
  implements Runnable
{
  public ISearchListener a;
  public SearchRequest a;
  
  private sbe(FileManagerSearchEngine paramFileManagerSearchEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SearchRequest localSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
    String str = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a;
    List localList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileManagerSearchEngine.a(localSearchRequest);
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */