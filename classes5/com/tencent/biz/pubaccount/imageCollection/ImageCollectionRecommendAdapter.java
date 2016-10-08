package com.tencent.biz.pubaccount.imageCollection;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver.RecommendItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import hvw;
import hvx;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ImageCollectionRecommendAdapter
  extends BaseAdapter
{
  public static final String a = "ImageCollectionRecommendAdapter";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private int b;
  private int c;
  private int d;
  
  public ImageCollectionRecommendAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, hvx paramhvx)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramhvx.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramhvx.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicAccountArticleObserver.RecommendItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b);
      a(paramhvx.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      a(paramhvx.jdField_a_of_type_ComTencentImageURLImageView, paramhvx.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, ((PublicAccountArticleObserver.RecommendItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a);
      return;
    }
    paramhvx.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(URLImageView paramURLImageView, ImageProgressCircle paramImageProgressCircle, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ImageCollectionRecommendAdapter", 2, "loadImage->path:" + paramString);
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
        paramURLImageView.setURLDrawableDownListener(new hvw(this, paramImageProgressCircle, paramURLImageView));
        return;
      }
      catch (MalformedURLException paramURLImageView) {}
    } while (!QLog.isColorLevel());
    QLog.i("ImageCollectionRecommendAdapter", 2, paramURLImageView.toString());
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      notifyDataSetChanged();
    }
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int getCount()
  {
    return 6;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      Resources localResources = paramViewGroup.getResources();
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903469, null);
      paramView = new hvx(this);
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131297886);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131296844));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131296302));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298715));
      localView.setTag(paramView);
      int i = AIOUtils.a(20.0F, localResources);
      if (FontSettingManager.a() == 18.0F) {
        i = AIOUtils.a(15.0F, localResources);
      }
      if ((this.c <= 0) || (this.d <= 0))
      {
        this.c = ((this.jdField_a_of_type_Int - AIOUtils.a(2.0F, localResources)) / 2);
        this.d = ((this.b - i * 2) / 3);
      }
      paramViewGroup = new AbsListView.LayoutParams(-1, this.d);
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramInt, paramViewGroup);
      return localView;
      paramViewGroup = (hvx)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\imageCollection\ImageCollectionRecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */