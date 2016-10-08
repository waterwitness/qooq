package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ContactSearchModelTool;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import ulo;
import ulp;

public class ContactSearchResultPresenter
  extends SearchResultPresenter
{
  private ContactSearchResultPresenter.OnActionListener a;
  
  public ContactSearchResultPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ContactSearchResultPresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramFaceDecoder);
    this.a = paramOnActionListener;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    TextView localTextView;
    if (((paramISearchResultModel instanceof ContactSearchModelTool)) && (paramISearchResultModel.c() == null))
    {
      if (paramISearchResultView.g() != null) {
        paramISearchResultView.g().setVisibility(8);
      }
      if (paramISearchResultView.e() != null) {
        paramISearchResultView.e().setVisibility(8);
      }
      if (paramISearchResultView.f() != null) {
        paramISearchResultView.f().setVisibility(8);
      }
      localTextView = ((ContactSearchResultView)paramISearchResultView).a();
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setText(paramISearchResultModel.a());
      }
      if ((SearchUtils.a) && (paramISearchResultView.a() != null) && ((paramISearchResultModel instanceof IContactSearchModel))) {
        paramISearchResultView.a().setOnLongClickListener(new ulo(this, paramISearchResultModel));
      }
      return;
    }
    if ((paramISearchResultView.g() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c()))) {
      paramISearchResultView.g().setVisibility(0);
    }
    for (;;)
    {
      if (paramISearchResultView.e() != null) {
        paramISearchResultView.e().setVisibility(0);
      }
      if ((paramISearchResultView.f() != null) && (paramISearchResultModel.b() != null)) {
        paramISearchResultView.f().setVisibility(0);
      }
      localTextView = ((ContactSearchResultView)paramISearchResultView).a();
      if (localTextView == null) {
        break;
      }
      localTextView.setVisibility(8);
      break;
      paramISearchResultView.g().setVisibility(8);
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if (paramISearchResultModel.a() == 103)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setImageDrawable(SearchUtils.a(paramBitmap));
      }
      return;
    }
    super.a(paramISearchResultModel, paramISearchResultView, paramBitmap);
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.a != null)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setOnClickListener(new ulp(this));
      }
      return;
    }
    super.c(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\ContactSearchResultPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */