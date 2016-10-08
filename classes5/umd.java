import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class umd
  extends GroupSearchEngine.SearchEngineEntity
{
  public umd(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ISearchResultGroupModel a(List paramList, String paramString)
  {
    return null;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    int i = 1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      paramSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    long l;
    List localList;
    if (SearchUtils.a(paramSearchRequest.jdField_a_of_type_JavaLangString))
    {
      if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 0) != 64536)
      {
        l = System.currentTimeMillis();
        paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 6);
        paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
        localList = GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).a(paramSearchRequest);
        if (localList == null) {
          break label189;
        }
        localArrayList.addAll(localList);
      }
      label189:
      for (this.jdField_a_of_type_Int = localList.size();; this.jdField_a_of_type_Int = 0)
      {
        this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
        paramSearchRequest = new GroupSearchModelMoreItem(paramSearchRequest.jdField_a_of_type_JavaLangString, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
        localArrayList.add(new GroupSearchModeTitle(paramSearchRequest.a().toString()));
        localArrayList.add(paramSearchRequest);
        SearchStatisticsConstants.a(0);
        return localArrayList;
      }
    }
    int k;
    int j;
    label236:
    int m;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0) <= SearchUtils.f) {
      if (paramSearchRequest.jdField_a_of_type_JavaLangString.length() > 2)
      {
        k = paramSearchRequest.jdField_a_of_type_JavaLangString.length();
        j = 0;
        k -= 1;
        i = j;
        if (k >= 0)
        {
          m = paramSearchRequest.jdField_a_of_type_JavaLangString.charAt(k);
          if (m >= 48)
          {
            i = j;
            if (m <= 57) {}
          }
          else
          {
            i = 0;
            label283:
            if (i >= SearchUtils.a.length) {
              break label589;
            }
            if (m != SearchUtils.a[i]) {
              break label425;
            }
          }
        }
      }
    }
    label393:
    label425:
    label448:
    label516:
    label577:
    label580:
    label583:
    label589:
    for (i = 0;; i = 1)
    {
      j = i;
      if (i == 0) {
        break label236;
      }
      for (;;)
      {
        if (i != 0)
        {
          l = System.currentTimeMillis();
          paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
          paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
          localList = GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).a(paramSearchRequest);
          if (localList != null)
          {
            localArrayList.addAll(localList);
            this.jdField_a_of_type_Int = localList.size();
            this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
            i = 0;
            ReportController.b(null, "CliOper", "", "", "0X800664A", "0X800664A", 0, 0, "", String.valueOf(i), paramSearchRequest.jdField_a_of_type_JavaLangString, "");
            break;
            i += 1;
            break label283;
            if (paramSearchRequest.jdField_a_of_type_JavaLangString.length() != 2) {
              break label583;
            }
            j = 0;
            if (j >= 2) {
              break label580;
            }
            m = paramSearchRequest.jdField_a_of_type_JavaLangString.charAt(j);
            if (((m >= 48) && (m <= 57)) || ((m >= 97) && (m <= 122)) || ((m >= 65) && (m <= 90)))
            {
              i = 0;
              continue;
            }
            k = 0;
            if (k >= SearchUtils.a.length) {
              break label577;
            }
            if (m == SearchUtils.a[k]) {
              i = 0;
            }
          }
        }
        for (;;)
        {
          j += 1;
          break label448;
          k += 1;
          break label516;
          this.jdField_a_of_type_Int = 0;
          break;
          i = 1;
          break label393;
          i = 2;
          break label393;
        }
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */