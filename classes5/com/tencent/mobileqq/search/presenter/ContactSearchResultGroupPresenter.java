package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;

public class ContactSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public ContactSearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new ContactSearchResultPresenter(paramFaceDecoder);
  }
  
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    super.a(paramISearchResultGroupModel, paramISearchResultGroupView);
    paramISearchResultGroupModel = ((GroupSearchModelLocalContact)paramISearchResultGroupModel).a();
    paramISearchResultGroupView = ((ContactSearchResultGroupView)paramISearchResultGroupView).a();
    if (paramISearchResultGroupView != null)
    {
      if (paramISearchResultGroupModel != null)
      {
        paramISearchResultGroupView.a().setVisibility(0);
        this.a.a(paramISearchResultGroupModel, paramISearchResultGroupView);
      }
    }
    else {
      return;
    }
    paramISearchResultGroupView.a().setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\ContactSearchResultGroupPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */