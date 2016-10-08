package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class GroupSearchEngine$SearchEngineEntity
{
  public int a;
  public long a;
  public final ISearchEngine a;
  public String a;
  public int b;
  private int c;
  
  public GroupSearchEngine$SearchEngineEntity(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine = paramISearchEngine;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    paramGroupSearchEngine = (Integer)SearchConfigManager.searchEngineOrder.get(paramString);
    if (paramGroupSearchEngine != null)
    {
      this.c = paramGroupSearchEngine.intValue();
      return;
    }
    this.c = 0;
  }
  
  protected abstract ISearchResultGroupModel a(List paramList, String paramString);
  
  public List a(SearchRequest paramSearchRequest)
  {
    long l = System.currentTimeMillis();
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      paramSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a(paramSearchRequest);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramSearchRequest = a(localList, paramSearchRequest.jdField_a_of_type_JavaLangString);
      if (SQLiteFTSUtils.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
        localArrayList.add(new GroupSearchModeTitle(paramSearchRequest.a().toString() + " " + this.jdField_a_of_type_Long + "ms"));
      }
      for (;;)
      {
        localArrayList.add(paramSearchRequest);
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        if ((paramSearchRequest instanceof FTSGroupSearchModelMessage)) {
          localArrayList.add(new GroupSearchModeTitle("聊天记录"));
        } else {
          localArrayList.add(new GroupSearchModeTitle(paramSearchRequest.a().toString()));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\searchengine\GroupSearchEngine$SearchEngineEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */