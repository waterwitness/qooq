package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class BigEmotionDownloadedAdapter
  extends BaseEmotionAdapter
{
  public static final String b = BigEmotionDownloadedAdapter.class.getSimpleName();
  private EmoticonPackage a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BigEmotionDownloadedAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    paramViewGroup = (BigEmotionDownloadedAdapter.BigEmotionHolder)paramViewHolder;
    int i;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.a().a(this.e);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmotionPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        for (;;)
        {
          i = 0;
          for (;;)
          {
            paramViewHolder = paramView;
            if (i >= this.c) {
              break;
            }
            paramViewHolder = super.a();
            paramViewHolder.setVisibility(8);
            paramViewHolder.setFocusable(true);
            paramViewHolder.setFocusableInTouchMode(true);
            paramView.addView(paramViewHolder);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d(b, 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmotionPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      a(this.e, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.a = new RelativeLayout[this.c];
      i = 0;
      while (i < this.c)
      {
        paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
    }
    for (;;)
    {
      i = 0;
      if (i < this.c)
      {
        int j = this.c * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.a[i].setTag(null);
          paramViewGroup.a[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = paramViewGroup.a[i];
          EmotionPanelData localEmotionPanelData = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(j);
          long l2 = System.currentTimeMillis();
          super.a(paramView, localEmotionPanelData);
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "updateUi cost = " + (System.currentTimeMillis() - l2));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "getEmotionView cost = " + (System.currentTimeMillis() - l1));
      }
      return paramViewHolder;
      paramViewHolder = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new BigEmotionDownloadedAdapter.BigEmotionHolder();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\BigEmotionDownloadedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */