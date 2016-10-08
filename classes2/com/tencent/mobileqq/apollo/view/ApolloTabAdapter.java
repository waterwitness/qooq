package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;

public class ApolloTabAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  
  public ApolloTabAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131428137);
  }
  
  public Drawable a(ApolloActionPackage paramApolloActionPackage)
  {
    URLDrawable localURLDrawable2 = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable1;
    if (!TextUtils.isEmpty(paramApolloActionPackage.mIconSelectedUrl))
    {
      localURLDrawable1 = ApolloImageDownloader.a("" + paramApolloActionPackage.mIconSelectedUrl.hashCode(), null, paramApolloActionPackage.mIconSelectedUrl);
      localURLDrawable1.startDownload();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramApolloActionPackage.mIconUnselectedUrl))
      {
        localURLDrawable2 = ApolloImageDownloader.a("" + paramApolloActionPackage.mIconUnselectedUrl.hashCode(), null, paramApolloActionPackage.mIconUnselectedUrl);
        localURLDrawable2.startDownload();
      }
      if (localURLDrawable1 != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, localURLDrawable1);
      }
      if (localURLDrawable2 != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, localURLDrawable2);
      }
      return localStateListDrawable;
      localURLDrawable1 = null;
    }
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    return (ApolloActionPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903101, paramViewGroup, false);
      paramViewGroup = new ApolloTabAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131297092));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setActivated(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setEnabled(true);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131296964);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297093));
      paramView.setTag(paramViewGroup);
      float f2 = getCount();
      if (f2 > 0.0F)
      {
        float f1 = f2;
        if (f2 > 4.0F) {
          f1 = 4.5F;
        }
        i = (int)((float)(DeviceInfoUtil.h() - AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / f1);
        localObject = paramView.getLayoutParams();
        if (localObject != null) {
          ((ViewGroup.LayoutParams)localObject).width = i;
        }
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt == getCount() - 1) {
        break label262;
      }
    }
    label262:
    for (int i = 0;; i = 4)
    {
      ((View)localObject).setVisibility(i);
      localObject = a(paramInt);
      if (localObject != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a((ApolloActionPackage)localObject));
        if (((ApolloActionPackage)localObject).isUpdate) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      return paramView;
      paramViewGroup = (ApolloTabAdapter.ViewHolder)paramView.getTag();
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloTabAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */