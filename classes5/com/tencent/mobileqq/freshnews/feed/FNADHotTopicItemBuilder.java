package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.freshnews.FLowLayout;
import com.tencent.mobileqq.freshnews.ad.HotTopic;
import com.tencent.mobileqq.freshnews.data.FNADHotTopicItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TintableImageView;
import java.net.MalformedURLException;
import java.util.List;
import srr;

public class FNADHotTopicItemBuilder
  extends FNBaseItemBuilder
{
  private ColorDrawable a;
  public View.OnClickListener a;
  private int b;
  private int c;
  
  public FNADHotTopicItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new srr(this);
  }
  
  public View a(int paramInt, Object paramObject, FaceDecoder paramFaceDecoder, boolean paramBoolean, View paramView1, View paramView2, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if ((paramView2 != null) && ((paramView2.getTag() instanceof FNADHotTopicItemBuilder.FNADHotTopicItemHolder))) {}
    for (paramFaceDecoder = (FNADHotTopicItemBuilder.FNADHotTopicItemHolder)paramView2.getTag();; paramFaceDecoder = null)
    {
      if (paramFaceDecoder == null)
      {
        paramView2 = LayoutInflater.from(paramContext).inflate(2130904173, null);
        paramFaceDecoder = new FNADHotTopicItemBuilder.FNADHotTopicItemHolder();
        paramFaceDecoder.jdField_a_of_type_ComTencentWidgetTintableImageView = ((TintableImageView)paramView2.findViewById(2131301697));
        paramFaceDecoder.jdField_a_of_type_ComTencentWidgetTintableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFaceDecoder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView2.findViewById(2131301698));
        paramFaceDecoder.b = ((TextView)paramView2.findViewById(2131301699));
        paramFaceDecoder.jdField_a_of_type_ComTencentMobileqqFreshnewsFLowLayout = ((FLowLayout)paramView2.findViewById(2131301700));
        paramFaceDecoder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView2.findViewById(2131299516));
      }
      try
      {
        paramView1 = NearbyImgDownloader.a("http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
        paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnClickListener.mPlayGifImage = true;
        paramView1 = URLDrawable.getDrawable(paramView1, paramOnClickListener);
        paramFaceDecoder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView1);
        paramView2.setTag(paramFaceDecoder);
        paramView2.setClickable(false);
        paramView2.setTag(-1, Integer.valueOf(paramInt));
        if (paramBoolean)
        {
          paramView2.setBackgroundResource(2130838349);
          if ((paramObject instanceof FNADHotTopicItemData)) {
            a(paramView2, paramContext, (FNADHotTopicItemData)paramObject, null);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.nearby.freshNews", 4, "FNADHotTopicItemBuilder|getView inflate View");
          }
          return paramView2;
        }
      }
      catch (MalformedURLException paramView1)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemBuilder getview get nowBoardcastGif error, " + paramView1);
            continue;
            paramView2.setBackgroundResource(2130840682);
          }
        }
      }
    }
  }
  
  public void a(View paramView, Context paramContext, Object paramObject, Bitmap paramBitmap)
  {
    int k = 0;
    if ((paramObject == null) || (!(paramObject instanceof FNADHotTopicItemData))) {}
    label96:
    label237:
    label303:
    label570:
    label596:
    label610:
    label624:
    label631:
    do
    {
      do
      {
        return;
        paramObject = (FNADHotTopicItemData)paramObject;
        if (((FNADHotTopicItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemBuilder|bindView item doesn't has operationTopic.");
      return;
      paramView = paramView.getTag();
      int m;
      int j;
      if ((paramView instanceof FNADHotTopicItemBuilder.FNADHotTopicItemHolder))
      {
        paramView = (FNADHotTopicItemBuilder.FNADHotTopicItemHolder)paramView;
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((FNADHotTopicItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic.a);
        if (!TextUtils.isEmpty(((FNADHotTopicItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic.d)) {
          break label570;
        }
        a(paramView.b, 8);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#282b32"));
        }
        if (TextUtils.isEmpty(((FNADHotTopicItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic.b)) {
          break label596;
        }
        if (this.b == 0) {
          this.b = paramContext.getResources().getDisplayMetrics().widthPixels;
        }
        if (this.c == 0) {
          this.c = paramContext.getResources().getDimensionPixelOffset(2131493554);
        }
        paramBitmap = URLDrawable.URLDrawableOptions.obtain();
        paramBitmap.mRequestWidth = this.b;
        paramBitmap.mRequestHeight = this.c;
        paramBitmap.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBitmap.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBitmap = URLDrawable.getDrawable(((FNADHotTopicItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic.b, paramBitmap);
        paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setImageDrawable(paramBitmap);
        paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setTag(((FNADHotTopicItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic);
        paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        m = (paramContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(10.0F, paramContext.getResources()) * 2) / 2;
        paramView.jdField_a_of_type_ComTencentMobileqqFreshnewsFLowLayout.removeAllViews();
        if (((FNADHotTopicItemData)paramObject).jdField_a_of_type_JavaUtilList != null) {
          break label610;
        }
        i = 0;
        j = i;
        if (i > 4) {
          j = 4;
        }
        paramBitmap = paramView.jdField_a_of_type_ComTencentMobileqqFreshnewsFLowLayout;
        if (j <= 0) {
          break label624;
        }
      }
      for (int i = 0;; i = 8)
      {
        a(paramBitmap, i);
        if (((FNADHotTopicItemData)paramObject).jdField_a_of_type_JavaUtilList == null) {
          break label631;
        }
        i = k;
        while (i < j)
        {
          Object localObject = (HotTopic)((FNADHotTopicItemData)paramObject).jdField_a_of_type_JavaUtilList.get(i);
          if ((localObject != null) && (!TextUtils.isEmpty(((HotTopic)localObject).a)))
          {
            paramBitmap = new TextView(paramContext);
            paramBitmap.setTextColor(Color.parseColor("#3371b4"));
            paramBitmap.setSingleLine();
            paramBitmap.setEllipsize(TextUtils.TruncateAt.END);
            paramBitmap.setTextSize(1, 16.0F);
            paramBitmap.setText(((HotTopic)localObject).a);
            paramBitmap.setId(2131296516);
            paramBitmap.setTag(localObject);
            localObject = new ViewGroup.MarginLayoutParams(m, -2);
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = AIOUtils.a(16.0F, paramContext.getResources());
            if (i == j - 1) {
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = AIOUtils.a(16.0F, paramContext.getResources());
            }
            paramView.jdField_a_of_type_ComTencentMobileqqFreshnewsFLowLayout.addView(paramBitmap, (ViewGroup.LayoutParams)localObject);
            paramBitmap.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemBuilder|bindView holder is not valid ." + null);
        return;
        a(paramView.b, 0);
        paramView.b.setText(((FNADHotTopicItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic.d);
        break label96;
        paramView.jdField_a_of_type_ComTencentWidgetTintableImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        break label237;
        i = ((FNADHotTopicItemData)paramObject).jdField_a_of_type_JavaUtilList.size();
        break label303;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemBuilder|bindView itemData." + paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\feed\FNADHotTopicItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */