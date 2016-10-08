package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;
import uls;

public class SearchResultGroupPresenter
  implements IPresenter
{
  private static final int jdField_a_of_type_Int = 3;
  protected IFacePresenter a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  
  public SearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramFaceDecoder);
  }
  
  public SearchResultGroupPresenter(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramFaceDecoder, paramBoolean);
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new SearchResultPresenter(paramFaceDecoder);
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramFaceDecoder);
    }
    return new FTSMessageSearchResultPresenter(paramFaceDecoder);
  }
  
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    a(paramISearchResultGroupView, paramISearchResultGroupModel);
    int n = paramISearchResultGroupModel.b();
    List localList1 = paramISearchResultGroupView.a();
    if ((localList1 != null) && (localList1 != null))
    {
      List localList2 = paramISearchResultGroupModel.a();
      if (localList2 != null)
      {
        i = 0;
        int j;
        label59:
        int k;
        if (i < localList1.size())
        {
          j = 1;
          if (i >= localList2.size()) {
            break label272;
          }
          k = 1;
          label74:
          if (i >= n) {
            break label278;
          }
        }
        label272:
        label278:
        for (int m = 1;; m = 0)
        {
          if ((m & k & j) == 0) {
            break label284;
          }
          ((ISearchResultView)localList1.get(i)).a().setVisibility(0);
          ((ISearchResultView)localList1.get(i)).a().setTag(2131296489, localList2.get(i));
          ((ISearchResultView)localList1.get(i)).a().setTag(2131296488, localList1.get(i));
          ((ISearchResultView)localList1.get(i)).a().setTag(2131296490, Integer.valueOf(i));
          ((ISearchResultView)localList1.get(i)).a().setTag(2131296487, this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter);
          this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter.a((IModel)localList2.get(i), (IView)localList1.get(i));
          i += 1;
          break;
          j = 0;
          break label59;
          k = 0;
          break label74;
        }
        label284:
        i = Math.min(localList2.size(), n);
        while (i < localList1.size())
        {
          ((ISearchResultView)localList1.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      int i = 0;
      while (i < localList1.size())
      {
        ((ISearchResultView)localList1.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramISearchResultGroupView.b() != null)
    {
      paramISearchResultGroupView.b().setTag(2131296490, Integer.valueOf(-1));
      localList1 = paramISearchResultGroupModel.a();
      if ((localList1 != null) && (localList1.size() > n)) {
        break label459;
      }
      paramISearchResultGroupView.b().setVisibility(8);
    }
    for (;;)
    {
      paramISearchResultGroupView.b().setOnClickListener(new uls(this, paramISearchResultGroupModel));
      return;
      label459:
      paramISearchResultGroupView.b().setVisibility(0);
    }
  }
  
  protected void a(ISearchResultGroupView paramISearchResultGroupView, ISearchResultGroupModel paramISearchResultGroupModel)
  {
    if (paramISearchResultGroupView.a() != null) {
      paramISearchResultGroupView.a().setText(paramISearchResultGroupModel.a());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\SearchResultGroupPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */