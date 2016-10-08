package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPeople;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupView;

public class SearchResultNetGroupContactsPresenter
  implements IPresenter
{
  public SearchResultNetGroupContactsPresenter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramISearchResultGroupModel = (GroupNetSearchModelPeople)paramISearchResultGroupModel;
    ((SearchResultGroupView)paramISearchResultGroupView).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\SearchResultNetGroupContactsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */