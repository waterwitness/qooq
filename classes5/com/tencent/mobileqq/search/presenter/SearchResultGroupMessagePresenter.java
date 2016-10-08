package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupMessageView;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;
import ulq;

public class SearchResultGroupMessagePresenter
  implements IPresenter
{
  private SearchResultGroupPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  boolean jdField_a_of_type_Boolean;
  
  public SearchResultGroupMessagePresenter(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter = new SearchResultGroupPresenter(paramFaceDecoder, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    SearchResultGroupMessageView localSearchResultGroupMessageView = (SearchResultGroupMessageView)paramISearchResultGroupView;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter.a(paramISearchResultGroupModel, paramISearchResultGroupView);
    int i = paramISearchResultGroupModel.b();
    paramISearchResultGroupView = paramISearchResultGroupModel.a();
    if ((paramISearchResultGroupView == null) || (paramISearchResultGroupView.isEmpty()))
    {
      localSearchResultGroupMessageView.b().setVisibility(8);
      localSearchResultGroupMessageView.b().setVisibility(0);
      localSearchResultGroupMessageView.b().setTag(2131296490, Integer.valueOf(-1));
      localSearchResultGroupMessageView.c().setText(paramISearchResultGroupModel.b());
      localSearchResultGroupMessageView.b().setOnClickListener(new ulq(this, paramISearchResultGroupModel));
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (FTSMessageSearchEngine.a()) && (paramISearchResultGroupView.size() <= i)) {
      localSearchResultGroupMessageView.b().setVisibility(8);
    }
    for (;;)
    {
      localSearchResultGroupMessageView.b().setVisibility(8);
      return;
      localSearchResultGroupMessageView.b().setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\SearchResultGroupMessagePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */