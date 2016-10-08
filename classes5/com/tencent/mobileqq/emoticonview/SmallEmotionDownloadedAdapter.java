package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SmallEmotionDownloadedAdapter
  extends BaseEmotionAdapter
{
  public static final String b = "SmallEmotionDownloadedAdapter";
  protected EmoticonPackage a;
  protected EmoticonCallback b;
  protected int h;
  
  public SmallEmotionDownloadedAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.b = paramEmoticonCallback;
    this.h = ((this.f - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7);
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)paramViewHolder;
    int i;
    Object localObject;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.a().a(this.e);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmotionPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(this.jdField_a_of_type_Float * 18.0F), 0, 0);
        i = 0;
        for (;;)
        {
          paramViewHolder = paramView;
          if (i >= this.c) {
            break;
          }
          paramViewHolder = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject = new LinearLayout.LayoutParams(this.h, this.h);
          ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Float * 18.0F));
          paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramViewHolder.setVisibility(8);
          paramViewHolder.setScaleType(ImageView.ScaleType.FIT_XY);
          paramViewHolder.setAdjustViewBounds(false);
          paramViewHolder.setFocusable(true);
          paramViewHolder.setFocusableInTouchMode(true);
          paramView.addView(paramViewHolder);
          i += 1;
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmotionPanelLinearLayout)paramViewHolder).setCallBack(this.b);
      a(this.e, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.a = new URLImageView[this.c];
      i = 0;
      while (i < this.c)
      {
        paramViewGroup.a[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
    }
    for (;;)
    {
      i = 0;
      int j;
      if (i < this.c)
      {
        j = this.c * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.a[i].setTag(null);
          paramViewGroup.a[i].setVisibility(8);
        }
      }
      label488:
      for (;;)
      {
        i += 1;
        break;
        localObject = paramViewGroup.a[i];
        paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((paramView instanceof EmoticonInfo)) {}
        for (paramView = (EmoticonInfo)paramView;; paramView = null)
        {
          if (paramView == null) {
            break label488;
          }
          paramViewGroup.a[i].setTag(paramView);
          ((URLImageView)localObject).setImageDrawable(paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
          ((URLImageView)localObject).setVisibility(0);
          break;
          return paramViewHolder;
        }
      }
      paramViewHolder = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\SmallEmotionDownloadedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */