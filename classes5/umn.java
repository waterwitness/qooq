import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class umn
  implements Runnable
{
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private SearchRequest jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
  private boolean jdField_a_of_type_Boolean;
  
  public umn(GroupSearchEngine paramGroupSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "begin local search at :" + l1);
    }
    int k = 0;
    int j = 0;
    for (;;)
    {
      if (k >= GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).size()) {
        break label737;
      }
      Object localObject2 = (GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).get(k);
      if ((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof NetSearchEngine)) {}
      try
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        Thread.sleep(300L);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject3;
          localInterruptedException.printStackTrace();
          continue;
          int i = 1;
          continue;
          GroupSearchModelLocalContact localGroupSearchModelLocalContact = (GroupSearchModelLocalContact)localInterruptedException.get(1);
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "start search : " + ((GroupSearchEngine.SearchEngineEntity)localObject2).a.getClass().getSimpleName());
      }
      localObject1 = ((GroupSearchEngine.SearchEngineEntity)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "end search : " + ((GroupSearchEngine.SearchEngineEntity)localObject2).a.getClass().getSimpleName());
      }
      i = j;
      if ((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof MessageSearchEngine)) {
        if (localObject1 != null)
        {
          i = j;
          if (!((List)localObject1).isEmpty()) {}
        }
        else
        {
          if (localArrayList.isEmpty()) {
            break;
          }
          localObject3 = new GroupSearchModelMessage(null, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_JavaLangString);
          localArrayList.add(new GroupSearchModeTitle(((GroupSearchModelMessage)localObject3).a().toString()));
          localArrayList.add(localObject3);
          SearchStatisticsConstants.a(40);
          i = j;
        }
      }
      j = i;
      if (localObject1 != null)
      {
        j = i;
        if (!((List)localObject1).isEmpty())
        {
          j = i;
          if ((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof NetSearchEngine))
          {
            j = i;
            if (localArrayList.isEmpty()) {
              j = 0;
            }
          }
          i = j;
          if (j != 0)
          {
            localObject3 = new GroupSearchModelMessage(null, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_JavaLangString);
            localArrayList.add(new GroupSearchModeTitle(((GroupSearchModelMessage)localObject3).a().toString()));
            localArrayList.add(localObject3);
            SearchStatisticsConstants.a(40);
            i = 0;
          }
          localArrayList.addAll((Collection)localObject1);
          j = i;
          if (!(((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof NetSearchEngine))
          {
            SearchStatisticsConstants.a(((GroupSearchEngine.SearchEngineEntity)localObject2).b);
            j = i;
          }
        }
      }
      if ((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof ContactSearchEngine))
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!localArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", true);
        localObject2 = ((GroupSearchEngine.SearchEngineEntity)localObject2).a.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = (ISearchResultModel)((List)localObject2).get(0);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label723;
          }
          localObject3 = new ArrayList();
          localObject1 = new GroupSearchModelLocalContact(null, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine), GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
          ((List)localObject3).add(new GroupSearchModeTitle(((GroupSearchModelLocalContact)localObject1).a().toString()));
          ((List)localObject3).add(localObject1);
          localArrayList.addAll((Collection)localObject3);
          ((GroupSearchModelLocalContact)localObject1).a((ISearchResultModel)localObject2);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!localArrayList.isEmpty())) {
            this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList);
          }
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!localArrayList.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList);
      }
      k += 1;
    }
    label723:
    label737:
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList, 1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember"))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", false);
        if (GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine) == null) {
          GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1));
        }
        GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, new umo(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, (ArrayList)localArrayList.clone(), this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)));
        GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).schedule(GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine), 0L, TimeUnit.MILLISECONDS));
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        long l2 = System.currentTimeMillis();
        GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, l2 - l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "search process cost:" + GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */