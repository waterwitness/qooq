package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.freshnews.data.FNHotChatItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.StaticLayoutView;
import com.tencent.widget.TintableImageView;

public class FNHotChatItemBuilder
  extends FNBaseItemBuilder
{
  public static Bitmap a;
  private static Drawable a;
  public static final int b = 69;
  
  public FNHotChatItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap a(FNHotChatItemData paramFNHotChatItemData, FaceDecoder paramFaceDecoder)
  {
    Object localObject;
    if ((paramFNHotChatItemData == null) || (paramFaceDecoder == null)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      if (!paramFNHotChatItemData.jdField_c_of_type_Boolean) {
        break;
      }
      localBitmap = paramFaceDecoder.a(32, paramFNHotChatItemData.jdField_a_of_type_JavaLangString, 200, (byte)3);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!paramFaceDecoder.b())
    {
      if (!paramFNHotChatItemData.jdField_c_of_type_Boolean) {
        break label112;
      }
      paramFaceDecoder.a(paramFNHotChatItemData.jdField_a_of_type_JavaLangString, 200, true, 32, false, (byte)1, 3);
    }
    for (;;)
    {
      if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
        jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      return jdField_a_of_type_AndroidGraphicsBitmap;
      localBitmap = paramFaceDecoder.a(32, String.valueOf(paramFNHotChatItemData.jdField_a_of_type_Long), 202, (byte)3);
      break;
      label112:
      paramFaceDecoder.a(String.valueOf(paramFNHotChatItemData.jdField_a_of_type_Long), 202, true, 32, false, (byte)1, 3);
    }
  }
  
  public View a(int paramInt, Object paramObject, FaceDecoder paramFaceDecoder, boolean paramBoolean, View paramView1, View paramView2, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if ((paramView1 != null) && ((paramView1.getTag() instanceof FNHotChatItemBuilder.FNHotChatItemHolder))) {}
    for (paramView2 = (FNHotChatItemBuilder.FNHotChatItemHolder)paramView1.getTag();; paramView2 = null)
    {
      Object localObject = paramView2;
      if (paramView2 == null)
      {
        paramView1 = LayoutInflater.from(paramContext).inflate(2130904176, null);
        localObject = new FNHotChatItemBuilder.FNHotChatItemHolder();
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_a_of_type_ComTencentWidgetTintableImageView = ((TintableImageView)paramView1.findViewById(2131297019));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_a_of_type_ComTencentWidgetStaticLayoutView = ((StaticLayoutView)paramView1.findViewById(2131296932));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView1.findViewById(2131301664));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_b_of_type_ComTencentWidgetStaticLayoutView = ((StaticLayoutView)paramView1.findViewById(2131298722));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView1.findViewById(2131301668));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).c = ((TextView)paramView1.findViewById(2131301669));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView1.findViewById(2131301663));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView1.findViewById(2131301715));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).d = ((TextView)paramView1.findViewById(2131301717));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).e = ((TextView)paramView1.findViewById(2131301718));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_a_of_type_ComTencentWidgetTintableImageView.setOnClickListener(paramOnClickListener);
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).c.setOnClickListener(paramOnClickListener);
        paramView1.setOnClickListener(paramOnClickListener);
        paramView1.setTag(localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby.freshNews", 4, "FNHotChatItemBuilder|getView inflate View");
        }
      }
      if (paramBoolean) {
        paramView1.setBackgroundResource(2130838349);
      }
      for (;;)
      {
        if ((paramObject instanceof FNHotChatItemData))
        {
          paramObject = (FNHotChatItemData)paramObject;
          a(paramView1, paramContext, paramObject, a((FNHotChatItemData)paramObject, paramFaceDecoder));
        }
        paramView1.setTag(-1, Integer.valueOf(paramInt));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).jdField_a_of_type_ComTencentWidgetTintableImageView.setTag(-1, Integer.valueOf(paramInt));
        ((FNHotChatItemBuilder.FNHotChatItemHolder)localObject).c.setTag(-1, Integer.valueOf(paramInt));
        return paramView1;
        paramView1.setBackgroundResource(2130840682);
      }
    }
  }
  
  public void a(Context paramContext, View paramView, FNBaseItemData paramFNBaseItemData)
  {
    if ((!(paramView.getTag() instanceof FNHotChatItemBuilder.FNHotChatItemHolder)) || (!(paramFNBaseItemData instanceof FNHotChatItemData))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "FNHotChatItemBuilder|updatePic return");
      }
    }
    do
    {
      return;
      paramView = (FNHotChatItemBuilder.FNHotChatItemHolder)paramView.getTag();
      paramFNBaseItemData = (FNHotChatItemData)paramFNBaseItemData;
    } while (paramFNBaseItemData.jdField_a_of_type_JavaNetURL == null);
    int i = AIOUtils.a(69.0F, paramContext.getResources());
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e9e9e9"));
    }
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mRequestWidth = i;
    paramContext.mRequestHeight = i;
    paramContext.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramContext.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    try
    {
      paramContext = URLDrawable.getDrawable(paramFNBaseItemData.jdField_a_of_type_JavaNetURL, paramContext);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void a(View paramView, Context paramContext, Object paramObject, Bitmap paramBitmap)
  {
    if ((paramObject == null) || (!(paramObject instanceof FNHotChatItemData))) {
      return;
    }
    FNHotChatItemData localFNHotChatItemData = (FNHotChatItemData)paramObject;
    paramObject = paramView.getTag();
    if ((paramObject instanceof FNHotChatItemBuilder.FNHotChatItemHolder)) {}
    for (paramObject = (FNHotChatItemBuilder.FNHotChatItemHolder)paramObject;; paramObject = null)
    {
      if (paramObject == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.nearby.freshNews", 2, "FNHotChatItemBuilder|bindView holder is null");
        return;
      }
      if (paramBitmap != null) {
        ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).jdField_a_of_type_ComTencentWidgetTintableImageView.setImageBitmap(paramBitmap);
      }
      a(paramContext, paramView, localFNHotChatItemData);
      ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).jdField_a_of_type_ComTencentWidgetStaticLayoutView.setLayout(localFNHotChatItemData.jdField_a_of_type_AndroidTextStaticLayout);
      if (localFNHotChatItemData.jdField_b_of_type_Boolean) {
        a(((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).jdField_a_of_type_AndroidWidgetImageView, 0);
      }
      for (;;)
      {
        ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).jdField_a_of_type_AndroidWidgetTextView.setText(localFNHotChatItemData.jdField_b_of_type_JavaLangString);
        ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).jdField_b_of_type_ComTencentWidgetStaticLayoutView.setLayout(localFNHotChatItemData.jdField_b_of_type_AndroidTextStaticLayout);
        ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).jdField_b_of_type_AndroidWidgetTextView.setText(localFNHotChatItemData.jdField_c_of_type_JavaLangString);
        ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).d.setText(localFNHotChatItemData.jdField_c_of_type_JavaLangCharSequence);
        ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).e.setText(localFNHotChatItemData.d);
        if ((!localFNHotChatItemData.jdField_c_of_type_Boolean) || (localFNHotChatItemData.jdField_a_of_type_Int != 1)) {
          break;
        }
        a(((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).c, 0);
        ((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).c.setText(2131372598);
        return;
        a(((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).jdField_a_of_type_AndroidWidgetImageView, 8);
      }
      a(((FNHotChatItemBuilder.FNHotChatItemHolder)paramObject).c, 8);
      return;
    }
  }
  
  public void a(View paramView, Bitmap paramBitmap)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FNHotChatItemBuilder.FNHotChatItemHolder)) {}
    for (paramView = (FNHotChatItemBuilder.FNHotChatItemHolder)paramView;; paramView = null)
    {
      if (paramView == null) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "FNHotChatItemBuilder|updateFaceBmp holder is null");
        }
      }
      while (paramView.jdField_a_of_type_ComTencentWidgetTintableImageView == null) {
        return;
      }
      paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setImageBitmap(paramBitmap);
      return;
    }
  }
  
  public void a(View paramView, FNBaseItemData paramFNBaseItemData, FaceDecoder paramFaceDecoder)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FNHotChatItemBuilder.FNHotChatItemHolder)) {}
    for (paramView = (FNHotChatItemBuilder.FNHotChatItemHolder)paramView;; paramView = null)
    {
      if ((paramView == null) || (!(paramFNBaseItemData instanceof FNHotChatItemData))) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "FNHotChatItemBuilder|updateFaceBmp cache holder is null or itemData isn't instanof FNHotChatItemData");
        }
      }
      do
      {
        do
        {
          return;
        } while (paramView.jdField_a_of_type_ComTencentWidgetTintableImageView == null);
        paramFNBaseItemData = a((FNHotChatItemData)paramFNBaseItemData, paramFaceDecoder);
      } while (paramFNBaseItemData == null);
      paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setImageBitmap(paramFNBaseItemData);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\feed\FNHotChatItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */