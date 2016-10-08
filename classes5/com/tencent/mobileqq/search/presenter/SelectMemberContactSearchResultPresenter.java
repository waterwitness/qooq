package com.tencent.mobileqq.search.presenter;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.Set;

public class SelectMemberContactSearchResultPresenter
  extends ContactSearchResultPresenter
{
  private Set a;
  private Set b;
  
  public SelectMemberContactSearchResultPresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set paramSet1, Set paramSet2)
  {
    super(paramFaceDecoder, paramOnActionListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramSet1;
    this.b = paramSet2;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.g() != null)
    {
      String str = paramISearchResultModel.a();
      if ((this.a != null) && (this.a.contains(str))) {
        paramISearchResultView.g().setText("已选择");
      }
      if ((this.b != null) && (this.b.contains(str))) {
        paramISearchResultView.g().setText("已加入");
      }
    }
    if (paramISearchResultView.b() != null)
    {
      if (((paramISearchResultModel instanceof ContactSearchModelTroop)) || ((paramISearchResultModel instanceof ContactSearchModelDiscussion)))
      {
        if (paramISearchResultView.g() != null) {
          paramISearchResultView.g().setVisibility(8);
        }
        paramISearchResultView.b().setVisibility(0);
      }
    }
    else {
      return;
    }
    if (paramISearchResultView.g() != null) {
      paramISearchResultView.g().setVisibility(0);
    }
    paramISearchResultView.b().setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\SelectMemberContactSearchResultPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */