package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupTitleView;

public class SearchResultGroupTitlePresenter
  implements IPresenter
{
  public SearchResultGroupTitlePresenter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    GroupSearchModeTitle localGroupSearchModeTitle = (GroupSearchModeTitle)paramISearchResultGroupModel;
    paramISearchResultGroupModel = (SearchResultGroupTitleView)paramISearchResultGroupView;
    paramISearchResultGroupModel.a().setText(localGroupSearchModeTitle.a());
    paramISearchResultGroupView = paramISearchResultGroupView.a().getTag(2131296490);
    if ((paramISearchResultGroupView instanceof Integer)) {}
    for (int i = ((Integer)paramISearchResultGroupView).intValue();; i = -1)
    {
      if (i > 0) {
        paramISearchResultGroupModel.a(true);
      }
      while (i != 0) {
        return;
      }
      paramISearchResultGroupModel.a(false);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\SearchResultGroupTitlePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */