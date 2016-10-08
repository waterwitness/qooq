package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XPanelContainer;

public class EmotionDownloadOrInvalidAdapter
  extends EmotionDownloadOrUpdateAdapter
  implements View.OnClickListener
{
  public static final String b;
  protected int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = EmotionDownloadOrInvalidAdapter.class.getSimpleName();
  }
  
  public EmotionDownloadOrInvalidAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    this.jdField_b_of_type_Boolean = false;
    this.h = (XPanelContainer.c - (int)paramContext.getResources().getDimension(2131493138));
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder = ((EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder)paramViewHolder);
    if (paramView == null)
    {
      paramViewHolder = EmotionPanelViewPool.a().a(this.e);
      paramView = new AbsListView.LayoutParams(-1, this.h);
      if (paramViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904539, null);
        paramViewHolder.setLayoutParams(paramView);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewHolder.findViewById(2131298138));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131298143));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramViewHolder.findViewById(2131298144));
        a(this.e, paramViewHolder);
        paramViewHolder.setTag(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder);
      return paramViewHolder;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramViewHolder = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public int getCount()
  {
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionDownloadOrInvalidAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */