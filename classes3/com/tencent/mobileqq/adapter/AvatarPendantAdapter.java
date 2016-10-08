package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AvatarPendantAdapter
  extends BaseAdapter
{
  static LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(15);
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  final int b;
  final int c = 1;
  final int d = 2;
  int e;
  int f;
  int g;
  int h;
  int i = 4;
  int j;
  int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AvatarPendantAdapter(Context paramContext, View.OnClickListener paramOnClickListener, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.e = paramInt2;
    this.h = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.f = ((this.jdField_a_of_type_Int - this.h * (this.i + 1)) / this.i);
    this.g = (this.f * 176 / 150);
    this.j = (this.f - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.k = (this.g - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_JavaLangString);
    if (paramList != null) {
      this.jdField_a_of_type_Long = paramList.pendantId;
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int n = 1;
    Object localObject1 = paramView;
    if (paramInt < getCount())
    {
      if (paramInt < 0) {
        localObject1 = paramView;
      }
    }
    else {
      return (View)localObject1;
    }
    int m = getItemViewType(paramInt);
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new AvatarPendantAdapter.ViewHolder(this);
      if (m == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904532, paramViewGroup, false);
        paramViewGroup = paramView.findViewById(2131303080);
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.e;
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramViewGroup = paramView.findViewById(2131303081);
        localObject2 = paramView.findViewById(2131303084);
        if (AvatarPendantManager.c)
        {
          paramViewGroup.setVisibility(0);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject2).setVisibility(0);
          paramView.setTag(localObject1);
          paramViewGroup = (ViewGroup)localObject1;
        }
      }
    }
    for (;;)
    {
      label145:
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      localObject1 = paramView;
      if (m != 1) {
        break;
      }
      AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo = (AvatarPendantShopSeriesInfo)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.setTag(localAvatarPendantShopSeriesInfo);
      if (localAvatarPendantShopSeriesInfo.c != null)
      {
        if (localAvatarPendantShopSeriesInfo.c.equals("1"))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841871));
        }
      }
      else
      {
        label226:
        if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int));
        switch (localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int)
        {
        default: 
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          label321:
          if ((localAvatarPendantShopSeriesInfo.e != null) && (localAvatarPendantShopSeriesInfo.e.equals("actLiTpl")))
          {
            if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString == null) {
              break label1510;
            }
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          break;
        }
      }
      label448:
      label1453:
      label1476:
      label1497:
      label1510:
      for (m = 1;; m = 0)
      {
        if (localAvatarPendantShopSeriesInfo.jdField_b_of_type_JavaLangString != null)
        {
          paramViewGroup.d.setText(localAvatarPendantShopSeriesInfo.jdField_b_of_type_JavaLangString);
          paramViewGroup.d.setVisibility(0);
          m = n;
        }
        for (;;)
        {
          if (m != 0)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((AvatarPendantAdapter.PendantGridAdapter)paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.a()).a(localAvatarPendantShopSeriesInfo);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
            if ((localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localAvatarPendantShopSeriesInfo.e != null) && (!localAvatarPendantShopSeriesInfo.e.equals("")))) {
              break label1476;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
              break label1453;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131370906);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842966);
          }
          for (;;)
          {
            if (paramInt != getCount() - 1) {
              break label1497;
            }
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
            return paramView;
            paramViewGroup.setVisibility(8);
            ((View)localObject2).setVisibility(8);
            break;
            if (m != 1) {
              break label1516;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904531, paramViewGroup, false);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131303070));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303071));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303072));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303073));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131303077));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303078));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303079));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131303074));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303075));
            ((AvatarPendantAdapter.ViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131303076));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298459);
            paramViewGroup = new AvatarPendantAdapter.PendantGridAdapter(this);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(paramViewGroup);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.i);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.f);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.h);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.h);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            paramViewGroup = (ViewGroup)localObject1;
            break label145;
            paramViewGroup = (AvatarPendantAdapter.ViewHolder)paramView.getTag();
            break label145;
            if (localAvatarPendantShopSeriesInfo.c.equals("3"))
            {
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841870));
              break label226;
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label226;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841107));
            break label321;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841101));
            break label321;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841872));
            break label321;
            File localFile = new File(AvatarPendantUtil.c + "/free.png");
            if (localFile.exists())
            {
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject2 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_free.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_free.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              break label321;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label321;
            localFile = new File(AvatarPendantUtil.c + "/rare.png");
            if (localFile.exists())
            {
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject2 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              break label321;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label321;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label448;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label448;
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131371064);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842968);
            continue;
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return paramView;
        }
      }
      label1516:
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\AvatarPendantAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */