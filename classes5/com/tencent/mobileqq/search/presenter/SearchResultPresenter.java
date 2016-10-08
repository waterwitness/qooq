package com.tencent.mobileqq.search.presenter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticleItem;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import ult;

public class SearchResultPresenter
  implements IFacePresenter
{
  private FaceDecoder a;
  
  public SearchResultPresenter(FaceDecoder paramFaceDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramFaceDecoder;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    a(paramISearchResultView, paramISearchResultModel);
    if (paramISearchResultView.f() != null) {
      paramISearchResultView.f().setText(paramISearchResultModel.b());
    }
    if (paramISearchResultView.g() != null) {
      paramISearchResultView.g().setText(paramISearchResultModel.c());
    }
    if (paramISearchResultView.h() != null) {
      paramISearchResultView.h().setText(paramISearchResultModel.d());
    }
    if (paramISearchResultView.b() != null)
    {
      if (!paramISearchResultModel.a()) {
        break label451;
      }
      paramISearchResultView.b().setVisibility(0);
    }
    for (;;)
    {
      c(paramISearchResultModel, paramISearchResultView);
      if (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) {
        break;
      }
      try
      {
        Object localObject = (ImageView)paramISearchResultView.a().findViewById(2131302342);
        ImageView localImageView = (ImageView)paramISearchResultView.a().findViewById(2131298138);
        TextView localTextView = (TextView)paramISearchResultView.a().findViewById(2131302343);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)paramISearchResultModel;
        int i = paramISearchResultView.a().getResources().getDimensionPixelSize(2131493586);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localGroupNetSearchModelArticleItem.c(), i, i);
        paramISearchResultView.a().setImageDrawable(localURLDrawable);
        if ((localGroupNetSearchModelArticleItem.a() != null) && (localGroupNetSearchModelArticleItem.a().video_article.has()) && (localGroupNetSearchModelArticleItem.a().video_article.get() == SearchUtils.e) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((GroupNetSearchModelArticleItem)paramISearchResultModel).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramISearchResultView.e() != null) {
            paramISearchResultView.e().setMaxWidth(AIOUtils.a(190.0F, paramISearchResultView.a().getResources()));
          }
          if ((localGroupNetSearchModelArticleItem != null) && (localGroupNetSearchModelArticleItem.a() != null))
          {
            localObject = localGroupNetSearchModelArticleItem.a().hotword.get();
            i = localGroupNetSearchModelArticleItem.a().hotword_type.get();
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localGroupNetSearchModelArticleItem.b(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramISearchResultModel.c() == null) {
          paramISearchResultView.g().setVisibility(8);
        }
        return;
      }
      catch (Exception paramISearchResultModel)
      {
        label451:
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramISearchResultModel.toString());
        return;
      }
      paramISearchResultView.b().setVisibility(8);
    }
    b(paramISearchResultModel, paramISearchResultView);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if ((paramISearchResultView.a() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem))) {
      paramISearchResultView.a().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(ISearchResultView paramISearchResultView, ISearchResultModel paramISearchResultModel)
  {
    if ((paramISearchResultView.e() != null) && (paramISearchResultModel != null)) {
      paramISearchResultView.e().setText(paramISearchResultModel.a());
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView.a() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) && ((paramISearchResultModel instanceof IFaceModel))) {
      paramISearchResultView.a().setImageDrawable(SearchUtils.a(this.a, paramISearchResultModel));
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (paramISearchResultView.a() != null) {
      paramISearchResultView.a().setOnClickListener(new ult(this, paramISearchResultModel));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\SearchResultPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */