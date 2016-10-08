package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FNEmptyItemBuilder
  extends FNBaseItemBuilder
{
  public FNEmptyItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, FaceDecoder paramFaceDecoder, boolean paramBoolean, View paramView1, View paramView2, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    paramOnClickListener = null;
    paramFaceDecoder = paramOnClickListener;
    if (paramView1 != null)
    {
      paramFaceDecoder = paramOnClickListener;
      if ((paramView1.getTag() instanceof FNEmptyItemBuilder.FNEmptyItemHolder)) {
        paramFaceDecoder = (FNEmptyItemBuilder.FNEmptyItemHolder)paramView1.getTag();
      }
    }
    paramOnClickListener = paramFaceDecoder;
    if (paramFaceDecoder == null)
    {
      paramOnClickListener = new FNEmptyItemBuilder.FNEmptyItemHolder();
      paramView1 = LayoutInflater.from(paramContext).inflate(2130904169, null);
      paramFaceDecoder = new AbsListView.LayoutParams(-1, -1);
      paramFaceDecoder.width = -1;
      paramFaceDecoder.height = paramView2.getHeight();
      paramView1.setLayoutParams(paramFaceDecoder);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView1.findViewById(2131297535));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView1.findViewById(2131298153));
      paramOnClickListener.b = ((TextView)paramView1.findViewById(2131298160));
      paramView1.setTag(paramOnClickListener);
    }
    if (paramBoolean) {
      paramView1.setBackgroundResource(2131427641);
    }
    for (;;)
    {
      if ((paramObject instanceof Integer))
      {
        paramInt = ((Integer)paramObject).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "FNEmptyItemBuilder|emptyFlag:" + paramInt);
        }
        if (paramInt != 0) {
          break;
        }
        paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramOnClickListener.b.setVisibility(0);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840679);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(2131372600);
        paramOnClickListener.b.setText(2131372601);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131428297));
      }
      return paramView1;
      paramView1.setBackgroundResource(2131427640);
    }
    if (paramInt == 1)
    {
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramOnClickListener.b.setVisibility(8);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838205);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131427365));
      return paramView1;
    }
    paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramOnClickListener.b.setVisibility(8);
    return paramView1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\feed\FNEmptyItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */