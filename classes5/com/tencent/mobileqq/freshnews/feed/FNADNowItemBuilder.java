package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.freshnews.ad.UserInfo;
import com.tencent.mobileqq.freshnews.data.FNADNowItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import srs;

public class FNADNowItemBuilder
  extends FNBaseItemBuilder
{
  public static final String a = "http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif";
  private ColorDrawable a;
  public View.OnClickListener a;
  
  public FNADNowItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new srs(this);
  }
  
  public View a(int paramInt, Object paramObject, FaceDecoder paramFaceDecoder, boolean paramBoolean, View paramView1, View paramView2, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if ((paramView2 != null) && ((paramView2.getTag() instanceof FNADNowItemBuilder.FNADNowItemHolder))) {}
    for (paramFaceDecoder = (FNADNowItemBuilder.FNADNowItemHolder)paramView2.getTag();; paramFaceDecoder = null)
    {
      if (paramFaceDecoder == null)
      {
        paramView2 = LayoutInflater.from(paramContext).inflate(2130904172, null);
        paramFaceDecoder = new FNADNowItemBuilder.FNADNowItemHolder();
        paramFaceDecoder.jdField_a_of_type_AndroidViewView = paramView2.findViewById(2131296515);
        paramFaceDecoder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView2.findViewById(2131301685));
        paramFaceDecoder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView2.findViewById(2131301686));
        paramFaceDecoder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView2.findViewById(2131301687));
        paramFaceDecoder.c = ((TextView)paramView2.findViewById(2131301688));
        paramFaceDecoder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView2.findViewById(2131301690));
        paramFaceDecoder.d = ((TextView)paramView2.findViewById(2131301689));
        paramFaceDecoder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView2.findViewById(2131301691));
        paramFaceDecoder.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFaceDecoder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView2.findViewById(2131301692));
        paramFaceDecoder.e = ((TextView)paramView2.findViewById(2131301694));
        paramFaceDecoder.f = ((TextView)paramView2.findViewById(2131301695));
        paramFaceDecoder.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView2.findViewById(2131299516));
      }
      try
      {
        paramView1 = NearbyImgDownloader.a("http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
        paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnClickListener.mPlayGifImage = true;
        paramView1 = URLDrawable.getDrawable(paramView1, paramOnClickListener);
        paramFaceDecoder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramView1);
        paramView2.setTag(paramFaceDecoder);
        paramView2.setClickable(false);
        paramView2.setTag(-1, Integer.valueOf(paramInt));
        if (paramBoolean)
        {
          paramView2.setBackgroundResource(2130838349);
          if ((paramObject instanceof FNADNowItemData)) {
            a(paramView2, paramContext, (FNADNowItemData)paramObject, null);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.nearby.freshNews", 4, "FNADNowItemBuilder|getView inflate View");
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
            QLog.d("Q.nearby.freshNews", 2, "FNADNowItemBuilder getview get nowBoardcastGif error, " + paramView1);
            continue;
            paramView2.setBackgroundResource(2130840682);
          }
        }
      }
    }
  }
  
  public void a(View paramView, Context paramContext, Object paramObject, Bitmap paramBitmap)
  {
    if ((paramObject == null) || (!(paramObject instanceof FNADNowItemData))) {}
    do
    {
      return;
      paramObject = (FNADNowItemData)paramObject;
      if (((FNADNowItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemBuilder|bindView item doesn't has userInfo.");
    return;
    paramView = paramView.getTag();
    if ((paramView instanceof FNADNowItemBuilder.FNADNowItemHolder))
    {
      paramBitmap = (FNADNowItemBuilder.FNADNowItemHolder)paramView;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#282b32"));
      }
      if (TextUtils.isEmpty(((FNADNowItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo.jdField_b_of_type_JavaLangString)) {
        break label533;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = AIOUtils.a(40.0F, paramContext.getResources());
      paramView.mRequestHeight = AIOUtils.a(40.0F, paramContext.getResources());
      paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramView.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramContext = URLDrawable.getDrawable(((FNADNowItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo.jdField_b_of_type_JavaLangString, paramView);
      paramContext.setTag(URLDrawableDecodeHandler.a(paramView.mRequestWidth, paramView.mRequestHeight, 6));
      paramContext.setDecodeHandler(URLDrawableDecodeHandler.a);
      paramBitmap.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
      label184:
      paramBitmap.jdField_a_of_type_AndroidWidgetTextView.setText(((FNADNowItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo.jdField_a_of_type_JavaLangString);
      paramView = "未知";
      if (((FNADNowItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo.jdField_b_of_type_Int != 1) {
        break label548;
      }
      paramView = "男";
      label218:
      paramBitmap.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
      paramBitmap.c.setVisibility(8);
      if (TextUtils.isEmpty(((FNADNowItemData)paramObject).jdField_a_of_type_JavaLangString)) {
        break label566;
      }
      paramBitmap.d.setText(((FNADNowItemData)paramObject).jdField_a_of_type_JavaLangString);
      a(paramBitmap.d, 0);
      label269:
      if (TextUtils.isEmpty(((FNADNowItemData)paramObject).jdField_b_of_type_JavaLangString)) {
        break label591;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = paramBitmap.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth();
      paramView.mRequestHeight = paramBitmap.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredHeight();
      paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramView.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramView = URLDrawable.getDrawable(((FNADNowItemData)paramObject).jdField_b_of_type_JavaLangString, paramView);
      paramBitmap.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      a(paramBitmap.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
      paramBitmap.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramObject);
      paramBitmap.jdField_a_of_type_AndroidViewView.setTag(paramObject);
      paramBitmap.jdField_b_of_type_AndroidWidgetImageView.setTag(paramObject);
      label378:
      paramBitmap.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBitmap.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBitmap.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (TextUtils.isEmpty(((FNADNowItemData)paramObject).c)) {
        break label617;
      }
      paramBitmap.e.setText(((FNADNowItemData)paramObject).c);
      a(paramBitmap.e, 0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemBuilder|bindView itemData:" + paramObject);
      }
      paramBitmap.f.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBitmap.f.setTag(paramObject);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemBuilder|bindView holder is not valid ." + null);
      return;
      label533:
      paramBitmap.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      break label184;
      label548:
      if (((FNADNowItemData)paramObject).jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo.jdField_b_of_type_Int != 2) {
        break label218;
      }
      paramView = "女";
      break label218;
      label566:
      paramBitmap.d.setText("");
      a(paramBitmap.d, 8);
      break label269;
      label591:
      paramBitmap.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      a(paramBitmap.jdField_a_of_type_AndroidWidgetRelativeLayout, 8);
      break label378;
      label617:
      paramBitmap.e.setText("");
      a(paramBitmap.e, 8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\feed\FNADNowItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */