package com.tencent.biz.pubaccount.imageCollection;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver.PhotoItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import hvu;
import hvv;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ImageCollectionPagerAdapter
  extends BaseAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "ImageCollectionPagerAdapter";
  private static final int jdField_b_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageCollectionRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  public ImageCollectionPagerAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter = new ImageCollectionRecommendAdapter(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(URLImageView paramURLImageView, ImageProgressCircle paramImageProgressCircle, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ImageCollectionPagerAdapter", 2, "loadImage->path:" + paramString);
      }
      try
      {
        paramString = new URL(paramString);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.e;
        localURLDrawableOptions.mPlayGifImage = true;
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
        paramURLImageView.setURLDrawableDownListener(new hvu(this, paramImageProgressCircle, paramURLImageView));
        return;
      }
      catch (MalformedURLException paramURLImageView) {}
    } while (!QLog.isColorLevel());
    QLog.i("ImageCollectionPagerAdapter", 2, paramURLImageView.toString());
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      notifyDataSetChanged();
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.b = paramArrayList;
      if (this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter.a(this.b);
      }
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.b.size() > 0) {
      i = 1;
    }
    return i + this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.b.size() > 0) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0) {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903467, null);
        paramViewGroup = new hvv(this);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296303));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)paramView.findViewById(2131296302));
        paramView.setTag(paramViewGroup);
        a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        a(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, ((PublicAccountArticleObserver.PhotoItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a);
        localView = paramView;
      }
    }
    do
    {
      return localView;
      paramViewGroup = (hvv)paramView.getTag();
      break;
      localView = paramView;
    } while (paramView != null);
    paramView = paramViewGroup.getResources();
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903468, null);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131298713);
    int i = paramViewGroup.getMeasuredWidth();
    int j = paramViewGroup.getMeasuredHeight() - 2;
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(i, j));
    paramViewGroup = (GridView)localView.findViewById(2131298714);
    paramViewGroup.setNumColumns(2);
    paramViewGroup.setColumnWidth(i / 2 - 100);
    paramViewGroup.setStretchMode(2);
    paramViewGroup.setHorizontalSpacing(0);
    paramInt = AIOUtils.a(20.0F, paramView);
    if (FontSettingManager.a() == 18.0F) {
      paramInt = AIOUtils.a(15.0F, paramView);
    }
    paramViewGroup.setVerticalSpacing(paramInt);
    paramViewGroup.setFocusable(false);
    paramInt = paramView.getDimensionPixelSize(2131492908);
    int k = paramView.getDimensionPixelSize(2131493691);
    this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter.a(i);
    this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter.b(j - paramInt - k);
    paramViewGroup.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\imageCollection\ImageCollectionPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */