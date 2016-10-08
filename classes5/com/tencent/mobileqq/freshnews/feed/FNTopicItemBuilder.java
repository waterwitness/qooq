package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.freshnews.data.FNTopicItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TintableImageView;

public class FNTopicItemBuilder
  extends FNBaseItemBuilder
{
  private ColorDrawable a;
  private int b;
  private int c;
  
  public FNTopicItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, FaceDecoder paramFaceDecoder, boolean paramBoolean, View paramView1, View paramView2, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if ((paramView1 != null) && ((paramView1.getTag() instanceof FNTopicItemBuilder.FNTopicItemHolder))) {}
    for (paramFaceDecoder = (FNTopicItemBuilder.FNTopicItemHolder)paramView1.getTag();; paramFaceDecoder = null)
    {
      paramView2 = paramFaceDecoder;
      if (paramFaceDecoder == null)
      {
        paramView1 = LayoutInflater.from(paramContext).inflate(2130904177, null);
        paramView2 = new FNTopicItemBuilder.FNTopicItemHolder();
        paramView2.jdField_a_of_type_ComTencentWidgetTintableImageView = ((TintableImageView)paramView1.findViewById(2131301697));
        paramView2.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView1.findViewById(2131301719));
        paramView2.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView1.findViewById(2131301720));
        paramView2.jdField_b_of_type_ComTencentWidgetTintableImageView = ((TintableImageView)paramView1.findViewById(2131301721));
        paramView2.c = ((TextView)paramView1.findViewById(2131301722));
        paramView2.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView1.findViewById(2131301710));
        paramView2.jdField_b_of_type_ComTencentWidgetTintableImageView.setOnClickListener(paramOnClickListener);
        paramView1.setOnClickListener(paramOnClickListener);
        paramView1.setTag(paramView2);
      }
      if (paramBoolean) {
        paramView1.setBackgroundResource(2130838349);
      }
      for (;;)
      {
        if ((paramObject instanceof FNTopicItemData)) {
          a(paramView1, paramContext, (FNTopicItemData)paramObject, null);
        }
        paramView1.setTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_b_of_type_ComTencentWidgetTintableImageView.setTag(-1, Integer.valueOf(paramInt));
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby.freshNews", 4, "FNTopicItemBuilder|getView inflate View");
        }
        return paramView1;
        paramView1.setBackgroundResource(2130840682);
      }
    }
  }
  
  public void a(View paramView, Context paramContext, Object paramObject, Bitmap paramBitmap)
  {
    if ((paramObject == null) || (!(paramObject instanceof FNTopicItemData))) {}
    do
    {
      return;
      paramBitmap = (FNTopicItemData)paramObject;
      paramObject = null;
      Object localObject = paramView.getTag();
      paramView = (View)paramObject;
      if ((localObject instanceof FNTopicItemBuilder.FNTopicItemHolder)) {
        paramView = (FNTopicItemBuilder.FNTopicItemHolder)localObject;
      }
      if (paramView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby.freshNews", 2, "FNTopicItemBuilder|bindView holder is null");
    return;
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramBitmap.a);
    if (paramBitmap.jdField_b_of_type_Boolean)
    {
      a(paramView.jdField_a_of_type_AndroidWidgetImageView, 0);
      if (!TextUtils.isEmpty(paramBitmap.f)) {
        break label302;
      }
      a(paramView.jdField_b_of_type_AndroidWidgetTextView, 8);
      if (!TextUtils.isEmpty(paramBitmap.jdField_b_of_type_JavaLangString)) {
        break label421;
      }
      a(paramView.c, 8);
      label132:
      if (this.a == null) {
        this.a = new ColorDrawable(Color.parseColor("#282b32"));
      }
      if (TextUtils.isEmpty(paramBitmap.jdField_c_of_type_JavaLangString)) {
        break label445;
      }
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
      }
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131493553);
      }
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = this.jdField_b_of_type_Int;
      paramContext.mRequestHeight = this.jdField_c_of_type_Int;
      paramContext.mLoadingDrawable = this.a;
      paramContext.mFailedDrawable = this.a;
      paramContext = URLDrawable.getDrawable(paramBitmap.jdField_c_of_type_JavaLangString, paramContext);
      paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setImageDrawable(paramContext);
    }
    for (;;)
    {
      if (paramBitmap.jdField_b_of_type_Int != 1) {
        break label459;
      }
      a(paramView.jdField_b_of_type_ComTencentWidgetTintableImageView, 0);
      paramView.jdField_b_of_type_ComTencentWidgetTintableImageView.setBackgroundResource(2130840958);
      return;
      a(paramView.jdField_a_of_type_AndroidWidgetImageView, 8);
      break;
      label302:
      a(paramView.jdField_b_of_type_AndroidWidgetTextView, 0);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramBitmap.f);
      paramObject = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (QLog.isColorLevel()) {
        QLog.d("FNTopicItemBuilder", 2, "bindView  foreWordLines = " + paramBitmap.jdField_c_of_type_Int);
      }
      if (paramBitmap.jdField_c_of_type_Int > 1) {}
      for (((RelativeLayout.LayoutParams)paramObject).topMargin = ((int)paramContext.getResources().getDimension(2131493438));; ((RelativeLayout.LayoutParams)paramObject).topMargin = ((int)paramContext.getResources().getDimension(2131493437)))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)paramObject);
        break;
      }
      label421:
      a(paramView.c, 0);
      paramView.c.setText(paramBitmap.jdField_b_of_type_JavaLangString);
      break label132;
      label445:
      paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setImageDrawable(this.a);
    }
    label459:
    if ((paramBitmap.jdField_b_of_type_Int == 2) && (!TextUtils.isEmpty(paramBitmap.d)))
    {
      paramContext = URLDrawable.getDrawable(paramBitmap.d);
      paramView.jdField_b_of_type_ComTencentWidgetTintableImageView.setBackgroundDrawable(paramContext);
      if (paramContext.getStatus() == 1)
      {
        a(paramView.jdField_b_of_type_ComTencentWidgetTintableImageView, 0);
        return;
      }
      paramContext.startDownload();
      a(paramView.jdField_b_of_type_ComTencentWidgetTintableImageView, 8);
      return;
    }
    a(paramView.jdField_b_of_type_ComTencentWidgetTintableImageView, 8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\feed\FNTopicItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */