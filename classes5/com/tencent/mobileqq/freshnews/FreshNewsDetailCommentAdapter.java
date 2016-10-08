package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class FreshNewsDetailCommentAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  View jdField_a_of_type_AndroidViewView;
  private FreshNewsDetailCommentItem.IFreshNewsDetailCommentItemCallback jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  
  public FreshNewsDetailCommentAdapter(Context paramContext, XListView paramXListView, FaceDecoder paramFaceDecoder, FreshNewsDetailCommentItem.IFreshNewsDetailCommentItemCallback paramIFreshNewsDetailCommentItemCallback, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback = paramIFreshNewsDetailCommentItemCallback;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public FreshNewsComment a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (FreshNewsComment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    int j = 0;
    try
    {
      while ((i < this.jdField_a_of_type_JavaUtilList.size()) && (((FreshNewsComment)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int == 1))
      {
        j += 1;
        i += 1;
      }
      if ((j > 0) && (j <= this.jdField_a_of_type_JavaUtilList.size()))
      {
        FreshNewsComment localFreshNewsComment = new FreshNewsComment();
        localFreshNewsComment.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilList.add(j, localFreshNewsComment);
        ((FreshNewsComment)this.jdField_a_of_type_JavaUtilList.get(j - 1)).jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return 1;
      }
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt).jdField_b_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramView = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = this.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
        paramView.height = this.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramView);
        return this.jdField_a_of_type_AndroidViewView;
        paramView = new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
      }
    }
    if (getItemViewType(paramInt) == 1) {
      return new FreshNewsDetailCommentDivider(this.jdField_a_of_type_AndroidContentContext);
    }
    if ((paramView == null) || (!(paramView instanceof FreshNewsDetailCommentItem)))
    {
      paramView = new FreshNewsDetailCommentItem(this.jdField_a_of_type_AndroidContentContext);
      paramView.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      paramView.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback, paramInt);
      paramView.a((FreshNewsComment)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      FreshNewsComment localFreshNewsComment = (FreshNewsComment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, String.valueOf(localFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.a), 202);
      if (paramViewGroup != null) {
        break label291;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(String.valueOf(localFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.a), 202, true, false);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      paramViewGroup = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    label291:
    for (;;)
    {
      paramView.a(paramViewGroup);
      return paramView;
      paramView = (FreshNewsDetailCommentItem)paramView;
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsDetailCommentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */