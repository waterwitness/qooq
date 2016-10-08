package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.statistics.ReportController;
import ulr;

public class SearchResultGroupMorePresenter
  implements IPresenter
{
  public SearchResultGroupMorePresenter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramISearchResultGroupView.b().setText(paramISearchResultGroupModel.b());
    paramISearchResultGroupView.a().setOnClickListener(new ulr(this, paramISearchResultGroupModel));
    if ((paramISearchResultGroupModel instanceof GroupSearchModelMoreItem)) {
      ReportController.b(null, "CliOper", "", "", "0X80061B6", "0X80061B6", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\SearchResultGroupMorePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */