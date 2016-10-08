package com.tencent.mobileqq.search.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.filemanager.data.search.FileSearchResultGroupPresenter;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticle;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPeople;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.GroupNetSearchModelTroop;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.PublicAcntSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMorePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter;
import com.tencent.mobileqq.search.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.view.IFaceView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultGroupFTSMessageView;
import com.tencent.mobileqq.search.view.SearchResultGroupMessageView;
import com.tencent.mobileqq.search.view.SearchResultGroupMoreItemView;
import com.tencent.mobileqq.search.view.SearchResultGroupTitleView;
import com.tencent.mobileqq.search.view.SearchResultGroupView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchResultGroupPresenter;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;

public class GroupSearchAdapter
  extends BaseMvpAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = 15;
  public static final int q = 16;
  public static final int r = 17;
  public static final int s = 18;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  protected int t;
  private int u;
  
  public GroupSearchAdapter(ListView paramListView, FaceDecoder paramFaceDecoder, AbsListView.OnScrollListener paramOnScrollListener, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.t = 0;
    this.u = -1;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    paramFaceDecoder.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    this.u = paramInt;
  }
  
  protected IPresenter a(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 3: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, false);
    case 12: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, true);
    case 0: 
      return new SearchResultGroupTitlePresenter();
    case 15: 
      return new SearchResultGroupTitlePresenter();
    case 2: 
    case 8: 
      return new PublicAcntSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 9: 
      return new SearchResultGroupMorePresenter();
    case 14: 
      return new SearchResultGroupMorePresenter();
    case 10: 
      return new FavoriteSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 11: 
      return new FileSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 13: 
      return new ContactSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    }
    return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (getItemViewType(paramInt))
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    default: 
      return new SearchResultGroupView(paramViewGroup, 2130904939);
    case 3: 
      return new SearchResultGroupMessageView(paramViewGroup);
    case 12: 
      return new SearchResultGroupFTSMessageView(paramViewGroup);
    case 0: 
      if (paramInt != 0) {}
      for (;;)
      {
        return new SearchResultGroupTitleView(paramViewGroup, bool1);
        bool1 = false;
      }
    case 15: 
      if (paramInt != 0) {}
      for (bool1 = bool2;; bool1 = false) {
        return new SearchResultGroupTitleView(paramViewGroup, bool1);
      }
    case 2: 
      return new SearchResultGroupView(paramViewGroup, 2130903490);
    case 9: 
      return new SearchResultGroupMoreItemView(paramViewGroup, 2130904954, 2130841257, -1);
    case 14: 
      return new SearchResultGroupMoreItemView(paramViewGroup, 2130904954, 2130841257, 12);
    case 11: 
      return new SearchResultGroupView(paramViewGroup, 2130904938);
    case 1: 
    case 13: 
      return new ContactSearchResultGroupView(paramViewGroup, 2130904943);
    case 16: 
      return new SearchResultGroupView(paramViewGroup, 2130904940);
    }
    return new SearchResultGroupView(paramViewGroup, 2130904945);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) && ((this.t == 0) || (this.t == 1)))
    {
      int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i2)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        if ((localView instanceof ViewGroup))
        {
          int i1 = 0;
          while (i1 < ((ViewGroup)localView).getChildCount())
          {
            IFaceModel localIFaceModel = (IFaceModel)((ViewGroup)localView).getChildAt(i1).getTag(2131296489);
            if ((localIFaceModel != null) && (localIFaceModel.a() == paramInt2) && (paramString.equals(localIFaceModel.a())))
            {
              IFacePresenter localIFacePresenter = (IFacePresenter)((ViewGroup)localView).getChildAt(i1).getTag(2131296487);
              IFaceView localIFaceView = (IFaceView)((ViewGroup)localView).getChildAt(i1).getTag(2131296488);
              if ((localIFacePresenter != null) && (localIFaceView != null)) {
                localIFacePresenter.a(localIFaceModel, localIFaceView, paramBitmap);
              }
            }
            i1 += 1;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    do
    {
      return;
      this.t = paramInt;
      int i3;
      int i1;
      if ((paramInt == 0) || (paramInt == 1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        }
        i3 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        i1 = 0;
      }
      while (i1 < i3)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1);
        if ((localView instanceof ViewGroup))
        {
          int i2 = 0;
          while (i2 < ((ViewGroup)localView).getChildCount())
          {
            IFaceModel localIFaceModel = (IFaceModel)((ViewGroup)localView).getChildAt(i2).getTag(2131296489);
            IFacePresenter localIFacePresenter = (IFacePresenter)((ViewGroup)localView).getChildAt(i2).getTag(2131296487);
            IFaceView localIFaceView = (IFaceView)((ViewGroup)localView).getChildAt(i2).getTag(2131296488);
            if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
              localIFacePresenter.a(localIFaceModel, localIFaceView);
            }
            i2 += 1;
          }
        }
        i1 += 1;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      }
    } while (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener == null);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    int i1 = 12;
    if ((super.a(paramInt) instanceof GroupSearchModelMessage)) {
      i1 = 3;
    }
    while ((super.a(paramInt) instanceof FTSGroupSearchModelMessage)) {
      return i1;
    }
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.u != 12)) {
      return 0;
    }
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.u == 12)) {
      return 15;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelPublicAcnt)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelPeople)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelTroop)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelPublicAcnt)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelArticle)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof GroupSearchModelMoreItem)) && (this.u != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof GroupSearchModelMoreItem)) && (this.u == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof GroupSearchModelFavorite)) {
      return 10;
    }
    if ((a(paramInt) instanceof GroupSearchModelFileEntity)) {
      return 11;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelLocalContact)) {
      return 13;
    }
    if ((a(paramInt) instanceof GroupSearchModelMultiChat)) {
      return 17;
    }
    return 4;
  }
  
  public int getViewTypeCount()
  {
    return 18;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\adapter\GroupSearchAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */