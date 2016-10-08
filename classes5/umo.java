import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class umo
  implements Runnable
{
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private SearchRequest jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public umo(GroupSearchEngine paramGroupSearchEngine, SearchRequest paramSearchRequest, ArrayList paramArrayList, ISearchListener paramISearchListener, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
  }
  
  public void run()
  {
    int m = 0;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, begin local search at :" + l);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine))) {}
    label621:
    label636:
    for (;;)
    {
      return;
      int i = 0;
      if (i < GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).size()) {
        if (!(((GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).get(i)).a instanceof ContactSearchEngine)) {}
      }
      for (Object localObject1 = (ContactSearchEngine)((GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).get(i)).a;; localObject1 = null)
      {
        if ((this.jdField_a_of_type_Boolean) || (localObject1 == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
          break label636;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, start search");
        }
        Object localObject3 = ((ContactSearchEngine)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
        if ((this.jdField_a_of_type_Boolean) || (localObject3 == null) || (((List)localObject3).isEmpty())) {
          break;
        }
        Object localObject2 = new ArrayList();
        ((List)localObject2).addAll((Collection)localObject3);
        int j;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          i = -1;
          ISearchResultGroupModel localISearchResultGroupModel;
          do
          {
            k = m;
            j = i;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localISearchResultGroupModel = (ISearchResultGroupModel)((Iterator)localObject3).next();
            j = i + 1;
            i = j;
          } while (!(localISearchResultGroupModel instanceof GroupSearchModelLocalContact));
          localObject3 = ((GroupSearchModelLocalContact)localISearchResultGroupModel).a.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              ((List)localObject2).add((IContactSearchModel)((Iterator)localObject3).next());
              continue;
              i += 1;
              break;
            }
          }
        }
        for (int k = 1;; k = m)
        {
          localObject3 = new ArrayList();
          ((ContactSearchEngine)localObject1).a((List)localObject2, (List)localObject3, null, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
          if ((this.jdField_a_of_type_Boolean) || (((List)localObject3).isEmpty())) {
            break;
          }
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((List)localObject1).add((IContactSearchModel)((Iterator)localObject2).next());
          }
          localObject1 = new GroupSearchModelLocalContact((List)localObject1, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine), GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
          if (k == 0)
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(new GroupSearchModeTitle(((ISearchResultGroupModel)localObject1).a().toString()));
            ((ArrayList)localObject2).add(localObject1);
            localObject1 = localObject2;
            if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
              ((ArrayList)localObject2).addAll(this.jdField_a_of_type_JavaUtilArrayList);
            }
          }
          for (localObject1 = localObject2;; localObject1 = this.jdField_a_of_type_JavaUtilArrayList)
          {
            if ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaLangString.equals(GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)))) {
              break label621;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!((ArrayList)localObject1).isEmpty())) {
              this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a((List)localObject1, 1);
            }
            GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, System.currentTimeMillis() - l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, end search, cost: " + GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
            return;
            this.jdField_a_of_type_JavaUtilArrayList.remove(j);
            this.jdField_a_of_type_JavaUtilArrayList.add(j, localObject1);
          }
          break;
          j = -1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */