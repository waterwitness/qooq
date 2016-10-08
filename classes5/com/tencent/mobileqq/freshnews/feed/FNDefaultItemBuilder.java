package com.tencent.mobileqq.freshnews.feed;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.flat.async.AsyncFlatView;
import com.tencent.mobileqq.nearby.flat.canvas.AbstractUIElement.OnClickListener;
import com.tencent.mobileqq.nearby.flat.canvas.ImageElement;
import com.tencent.mobileqq.nearby.flat.widget.FreshElement;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.List;
import srt;
import sru;

public class FNDefaultItemBuilder
  extends FNBaseItemBuilder
{
  public static final String a = "FNDefaultItemBuilder";
  public static int b;
  public static int c;
  public static int d;
  public Bitmap a;
  public Drawable a;
  StringBuilder a;
  public Drawable b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = ((WindowManager)localBaseApplication.getSystemService("window")).getDefaultDisplay().getWidth();
    c = (i - AIOUtils.a(23.0F, localBaseApplication.getResources())) / 2;
    if (c > AIOUtils.a(159.0F, localBaseApplication.getResources())) {}
    for (jdField_b_of_type_Int = c;; jdField_b_of_type_Int = AIOUtils.a(159.0F, localBaseApplication.getResources()))
    {
      d = (i - AIOUtils.a(26.0F, localBaseApplication.getResources())) / 3;
      return;
    }
  }
  
  public Bitmap a(FNDefaultItemData paramFNDefaultItemData, FaceDecoder paramFaceDecoder)
  {
    Object localObject;
    if ((paramFNDefaultItemData == null) || (paramFaceDecoder == null)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      if (!paramFNDefaultItemData.jdField_b_of_type_Boolean) {
        break;
      }
      localBitmap = paramFaceDecoder.a(32, paramFNDefaultItemData.jdField_a_of_type_JavaLangString, 200, (byte)3);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!paramFaceDecoder.b())
    {
      if (!paramFNDefaultItemData.jdField_b_of_type_Boolean) {
        break label115;
      }
      paramFaceDecoder.a(paramFNDefaultItemData.jdField_a_of_type_JavaLangString, 200, true, 32, false, (byte)1, 3);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      localBitmap = paramFaceDecoder.a(32, String.valueOf(paramFNDefaultItemData.jdField_a_of_type_Long), 202, (byte)3);
      break;
      label115:
      paramFaceDecoder.a(String.valueOf(paramFNDefaultItemData.jdField_a_of_type_Long), 202, true, 32, false, (byte)1, 3);
    }
  }
  
  public View a(int paramInt, Object paramObject, FaceDecoder paramFaceDecoder, boolean paramBoolean, View paramView1, View paramView2, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    View localView = null;
    paramView2 = localView;
    if (paramView1 != null)
    {
      paramView2 = localView;
      if ((paramView1.getTag() instanceof FNDefaultItemBuilder.FNDefaultItemViewHolder)) {
        paramView2 = (FNDefaultItemBuilder.FNDefaultItemViewHolder)paramView1.getTag();
      }
    }
    int i;
    if (paramView2 == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2130904174, null);
      FNDefaultItemBuilder.FNDefaultItemViewHolder localFNDefaultItemViewHolder = new FNDefaultItemBuilder.FNDefaultItemViewHolder();
      localFNDefaultItemViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView = ((AsyncFlatView)localView.findViewById(2131301701));
      if ((paramOnClickListener instanceof AbstractUIElement.OnClickListener)) {
        localFNDefaultItemViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.setOnElementClickListener((AbstractUIElement.OnClickListener)paramOnClickListener);
      }
      localFNDefaultItemViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301668));
      localFNDefaultItemViewHolder.jdField_a_of_type_AndroidViewView = localView.findViewById(2131301703);
      localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301669));
      localFNDefaultItemViewHolder.jdField_b_of_type_AndroidViewView = localView.findViewById(2131301708);
      localFNDefaultItemViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301709));
      localFNDefaultItemViewHolder.jdField_c_of_type_AndroidViewView = localView.findViewById(2131301704);
      localFNDefaultItemViewHolder.d = ((TextView)localView.findViewById(2131301675));
      localFNDefaultItemViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301674));
      localFNDefaultItemViewHolder.e = ((TextView)localView.findViewById(2131301705));
      paramView1 = paramContext.getResources();
      localFNDefaultItemViewHolder.e.setCompoundDrawablePadding(AIOUtils.a(5.0F, paramView1));
      paramView2 = paramView1.getDrawable(2130840677);
      i = AIOUtils.a(16.0F, paramView1);
      paramView2.setBounds(0, 0, i, i);
      localFNDefaultItemViewHolder.e.setCompoundDrawables(paramView2, null, null, null);
      localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301706));
      localFNDefaultItemViewHolder.f = ((TextView)localView.findViewById(2131301707));
      localFNDefaultItemViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      localFNDefaultItemViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      localFNDefaultItemViewHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      localFNDefaultItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      localFNDefaultItemViewHolder.e.setOnClickListener(paramOnClickListener);
      localView.setOnClickListener(paramOnClickListener);
      localView.setTag(localFNDefaultItemViewHolder);
      paramView2 = localFNDefaultItemViewHolder;
      paramView1 = localView;
      if (QLog.isDevelopLevel())
      {
        QLog.d("Q.nearby.freshNews", 4, "FNDefaultItemBuilder|getView inflate View");
        paramView1 = localView;
        paramView2 = localFNDefaultItemViewHolder;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        paramView1.setBackgroundResource(2130838349);
      }
      for (;;)
      {
        if ((paramObject instanceof FNDefaultItemData))
        {
          paramOnClickListener = (FNDefaultItemData)paramObject;
          a(paramView1, paramContext, paramOnClickListener, a(paramOnClickListener, paramFaceDecoder));
          if ((paramOnClickListener.jdField_a_of_type_Boolean) && (FreshNewsFeedAdapter.b()))
          {
            i = AIOUtils.a(255.0F, paramContext.getResources());
            paramFaceDecoder = paramView1.getLayoutParams();
            paramObject = paramFaceDecoder;
            if (paramFaceDecoder == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("FNDefaultItemBuilder", 2, "getView anim lp is null");
              }
              paramObject = new AbsListView.LayoutParams(-1, -2);
            }
            paramFaceDecoder = ValueAnimator.ofInt(new int[] { 1, i });
            paramFaceDecoder.addUpdateListener(new srt(this, (ViewGroup.LayoutParams)paramObject, paramView1));
            paramFaceDecoder.addListener(new sru(this, paramOnClickListener, paramView1));
            paramFaceDecoder.setTarget(paramView1);
            paramFaceDecoder.setDuration(1000L);
            paramFaceDecoder.start();
          }
        }
        paramView1.setTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_b_of_type_AndroidViewView.setTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_a_of_type_AndroidViewView.setTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.setChildTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_c_of_type_AndroidViewView.setTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_b_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_b_of_type_AndroidWidgetTextView.setTag(-1, Integer.valueOf(paramInt));
        paramView2.jdField_c_of_type_AndroidWidgetTextView.setTag(-1, Integer.valueOf(paramInt));
        paramView2.e.setTag(-1, Integer.valueOf(paramInt));
        return paramView1;
        paramView1.setBackgroundResource(2130840682);
      }
    }
  }
  
  public URLDrawable.URLDrawableOptions a(Context paramContext, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e9e9e9"));
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840689);
    }
    if (paramInt == 1) {
      paramInt = jdField_b_of_type_Int;
    }
    for (;;)
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = paramInt;
      paramContext.mRequestHeight = paramInt;
      paramContext.mFailedDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      paramContext.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      return paramContext;
      if (paramInt == 2) {
        paramInt = c;
      } else {
        paramInt = d;
      }
    }
  }
  
  public void a(Context paramContext, View paramView, FNBaseItemData paramFNBaseItemData)
  {
    if ((!(paramView.getTag() instanceof FNDefaultItemBuilder.FNDefaultItemViewHolder)) || (!(paramFNBaseItemData instanceof FNDefaultItemData))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "FNDefaultItemBuilder|updatePic return");
      }
    }
    FNDefaultItemData localFNDefaultItemData;
    do
    {
      ImageElement localImageElement2;
      ImageElement localImageElement1;
      do
      {
        do
        {
          do
          {
            return;
            paramView = (FNDefaultItemBuilder.FNDefaultItemViewHolder)paramView.getTag();
            localFNDefaultItemData = (FNDefaultItemData)paramFNBaseItemData;
            localImageElement2 = ((FreshElement)paramView.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a()).c;
            localImageElement1 = ((FreshElement)paramView.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a()).d;
            paramView = ((FreshElement)paramView.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a()).e;
            if (paramFNBaseItemData.jdField_a_of_type_Int != 1) {
              break;
            }
          } while ((localFNDefaultItemData.jdField_f_of_type_Int > 0) && ((localFNDefaultItemData.jdField_a_of_type_JavaUtilList == null) || (localFNDefaultItemData.jdField_a_of_type_JavaUtilList.size() == 0)));
          if (localFNDefaultItemData.jdField_f_of_type_Int > 0)
          {
            paramFNBaseItemData = a(paramContext, localFNDefaultItemData.jdField_f_of_type_Int);
            paramFNBaseItemData = URLDrawable.getDrawable((URL)localFNDefaultItemData.jdField_c_of_type_JavaUtilList.get(0), paramFNBaseItemData);
            paramFNBaseItemData.setDownloadListener(new ImgDownloadListener(paramContext));
            localImageElement2.b(paramFNBaseItemData);
          }
          if (localFNDefaultItemData.jdField_f_of_type_Int > 1)
          {
            paramFNBaseItemData = a(paramContext, localFNDefaultItemData.jdField_f_of_type_Int);
            paramFNBaseItemData = URLDrawable.getDrawable((URL)localFNDefaultItemData.jdField_c_of_type_JavaUtilList.get(1), paramFNBaseItemData);
            paramFNBaseItemData.setDownloadListener(new ImgDownloadListener(paramContext));
            localImageElement1.b(paramFNBaseItemData);
          }
        } while (localFNDefaultItemData.jdField_f_of_type_Int <= 2);
        paramFNBaseItemData = a(paramContext, localFNDefaultItemData.jdField_f_of_type_Int);
        paramFNBaseItemData = URLDrawable.getDrawable((URL)localFNDefaultItemData.jdField_c_of_type_JavaUtilList.get(2), paramFNBaseItemData);
        paramFNBaseItemData.setDownloadListener(new ImgDownloadListener(paramContext));
        paramView.b(paramFNBaseItemData);
        return;
      } while ((localFNDefaultItemData.jdField_f_of_type_Int > 0) && ((localFNDefaultItemData.d == null) || (localFNDefaultItemData.d.size() == 0)));
      if (localFNDefaultItemData.jdField_f_of_type_Int > 0)
      {
        paramFNBaseItemData = a(paramContext, localFNDefaultItemData.jdField_f_of_type_Int);
        paramFNBaseItemData = URLDrawable.getDrawable(new File((String)localFNDefaultItemData.d.get(0)), paramFNBaseItemData);
        paramFNBaseItemData.setDownloadListener(new ImgDownloadListener(paramContext));
        localImageElement2.b(paramFNBaseItemData);
      }
      if (localFNDefaultItemData.jdField_f_of_type_Int > 1)
      {
        paramFNBaseItemData = a(paramContext, localFNDefaultItemData.jdField_f_of_type_Int);
        paramFNBaseItemData = URLDrawable.getDrawable(new File((String)localFNDefaultItemData.d.get(1)), paramFNBaseItemData);
        paramFNBaseItemData.setDownloadListener(new ImgDownloadListener(paramContext));
        localImageElement1.b(paramFNBaseItemData);
      }
    } while (localFNDefaultItemData.jdField_f_of_type_Int <= 2);
    paramFNBaseItemData = a(paramContext, localFNDefaultItemData.jdField_f_of_type_Int);
    paramFNBaseItemData = URLDrawable.getDrawable(new File((String)localFNDefaultItemData.d.get(2)), paramFNBaseItemData);
    paramFNBaseItemData.setDownloadListener(new ImgDownloadListener(paramContext));
    paramView.b(paramFNBaseItemData);
  }
  
  public void a(View paramView, Context paramContext, Object paramObject, Bitmap paramBitmap)
  {
    if ((paramObject == null) || (!(paramObject instanceof FNDefaultItemData))) {}
    for (;;)
    {
      return;
      FNDefaultItemData localFNDefaultItemData = (FNDefaultItemData)paramObject;
      Object localObject = paramView.getTag();
      FNDefaultItemBuilder.FNDefaultItemViewHolder localFNDefaultItemViewHolder = null;
      if ((localObject instanceof FNDefaultItemBuilder.FNDefaultItemViewHolder)) {
        localFNDefaultItemViewHolder = (FNDefaultItemBuilder.FNDefaultItemViewHolder)localObject;
      }
      if (localFNDefaultItemViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "FNDefaultItemBuilder|bindView holder is null");
        }
      }
      else
      {
        localFNDefaultItemViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a(paramContext, (FNDefaultItemData)paramObject, paramBitmap, this);
        if (localFNDefaultItemData.jdField_a_of_type_Int == 3)
        {
          a(localFNDefaultItemViewHolder.jdField_a_of_type_AndroidWidgetTextView, 8);
          a(localFNDefaultItemViewHolder.jdField_a_of_type_AndroidViewView, 8);
          a(localFNDefaultItemViewHolder.jdField_c_of_type_AndroidViewView, 8);
          a(localFNDefaultItemViewHolder.e, 8);
          a(localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetImageView, 0);
          a(localFNDefaultItemViewHolder.f, 0);
          a(localFNDefaultItemViewHolder.jdField_b_of_type_AndroidViewView, 0);
          localFNDefaultItemViewHolder.f.setText(localFNDefaultItemData.jdField_g_of_type_JavaLangString);
        }
        while (AppSetting.j)
        {
          if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
            this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
          }
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).jdField_a_of_type_JavaLangCharSequence).append(" ");
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).jdField_b_of_type_JavaLangString).append(" ");
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).jdField_c_of_type_JavaLangString).append(" ");
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).jdField_c_of_type_JavaLangCharSequence).append(" ");
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).jdField_f_of_type_Int).append("张图片  ");
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).jdField_f_of_type_JavaLangString).append(" ");
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).jdField_g_of_type_Int).append("个人赞过 ");
          this.jdField_a_of_type_JavaLangStringBuilder.append(((FNDefaultItemData)paramObject).h).append("条评论 ");
          paramView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          this.jdField_a_of_type_JavaLangStringBuilder.append("赞按钮 ").append(",").append(((FNDefaultItemData)paramObject).jdField_g_of_type_Int).append("人赞过");
          localFNDefaultItemViewHolder.jdField_c_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          this.jdField_a_of_type_JavaLangStringBuilder.append("评论按钮 ").append(",").append(((FNDefaultItemData)paramObject).h).append("人评论过");
          localFNDefaultItemViewHolder.e.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          return;
          a(localFNDefaultItemViewHolder.jdField_a_of_type_AndroidWidgetTextView, 0);
          localFNDefaultItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFNDefaultItemData.jdField_f_of_type_JavaLangString);
          a(localFNDefaultItemViewHolder.jdField_c_of_type_AndroidViewView, 0);
          a(localFNDefaultItemViewHolder.e, 0);
          a(localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetImageView, 8);
          a(localFNDefaultItemViewHolder.f, 8);
          a(localFNDefaultItemViewHolder.jdField_b_of_type_AndroidViewView, 8);
          if (localFNDefaultItemData.jdField_b_of_type_Boolean) {
            if (localFNDefaultItemData.jdField_a_of_type_Int == 1)
            {
              a(localFNDefaultItemViewHolder.jdField_a_of_type_AndroidViewView, 0);
              localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131372598);
              label613:
              if (!localFNDefaultItemData.jdField_f_of_type_Boolean) {
                break label734;
              }
              localFNDefaultItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840691);
              localFNDefaultItemViewHolder.d.setTextColor(localFNDefaultItemData.j);
              label645:
              if (localFNDefaultItemData.jdField_g_of_type_Int <= 0) {
                break label761;
              }
              localFNDefaultItemViewHolder.d.setText(FreshNewsUtil.a(localFNDefaultItemData.jdField_g_of_type_Int));
            }
          }
          for (;;)
          {
            if (localFNDefaultItemData.h <= 0) {
              break label775;
            }
            localFNDefaultItemViewHolder.e.setText(FreshNewsUtil.a(localFNDefaultItemData.h));
            break;
            a(localFNDefaultItemViewHolder.jdField_a_of_type_AndroidViewView, 8);
            break label613;
            a(localFNDefaultItemViewHolder.jdField_a_of_type_AndroidViewView, 0);
            localFNDefaultItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131372597);
            break label613;
            label734:
            localFNDefaultItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840687);
            localFNDefaultItemViewHolder.d.setTextColor(localFNDefaultItemData.i);
            break label645;
            label761:
            localFNDefaultItemViewHolder.d.setText("赞");
          }
          label775:
          localFNDefaultItemViewHolder.e.setText("评论");
        }
      }
    }
  }
  
  public void a(View paramView, Bitmap paramBitmap)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FNDefaultItemBuilder.FNDefaultItemViewHolder)) {}
    for (paramView = (FNDefaultItemBuilder.FNDefaultItemViewHolder)paramView;; paramView = null)
    {
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "FNDefaultItemBuilder|updateFaceBmp holder is null");
        }
        return;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a(paramBitmap);
      return;
    }
  }
  
  public void a(View paramView, FNBaseItemData paramFNBaseItemData, FaceDecoder paramFaceDecoder)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FNDefaultItemBuilder.FNDefaultItemViewHolder)) {}
    for (paramView = (FNDefaultItemBuilder.FNDefaultItemViewHolder)paramView;; paramView = null)
    {
      if ((paramView == null) || (!(paramFNBaseItemData instanceof FNDefaultItemData))) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.freshNews", 2, "FNDefaultItemBuilder|updateFaceBmp cache holder is null or itemData isn't instanof FNDefaultItemData");
        }
      }
      do
      {
        return;
        paramFNBaseItemData = a((FNDefaultItemData)paramFNBaseItemData, paramFaceDecoder);
      } while (paramFNBaseItemData == null);
      paramView.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a(paramFNBaseItemData);
      return;
    }
  }
  
  public void a(FNDefaultItemBuilder.FNDefaultItemViewHolder paramFNDefaultItemViewHolder, FNDefaultItemData paramFNDefaultItemData)
  {
    ImageElement localImageElement1 = ((FreshElement)paramFNDefaultItemViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a()).c;
    ImageElement localImageElement2 = ((FreshElement)paramFNDefaultItemViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a()).d;
    paramFNDefaultItemViewHolder = ((FreshElement)paramFNDefaultItemViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncAsyncFlatView.a()).e;
    ViewGroup.LayoutParams localLayoutParams1 = localImageElement1.a();
    ViewGroup.LayoutParams localLayoutParams2 = localImageElement2.a();
    ViewGroup.LayoutParams localLayoutParams3 = paramFNDefaultItemViewHolder.a();
    if (paramFNDefaultItemData.jdField_f_of_type_Int == 0)
    {
      localImageElement1.a(8);
      localImageElement2.a(8);
      paramFNDefaultItemViewHolder.a(8);
      return;
    }
    if (paramFNDefaultItemData.jdField_f_of_type_Int == 1)
    {
      localImageElement1.a(0);
      localImageElement2.a(8);
      paramFNDefaultItemViewHolder.a(8);
      localLayoutParams1.width = jdField_b_of_type_Int;
      localLayoutParams1.height = jdField_b_of_type_Int;
      localImageElement1.a(localLayoutParams1);
      return;
    }
    if (paramFNDefaultItemData.jdField_f_of_type_Int == 2)
    {
      localImageElement1.a(0);
      localImageElement2.a(0);
      paramFNDefaultItemViewHolder.a(8);
      i = c;
      localLayoutParams2.width = i;
      localLayoutParams1.width = i;
      i = c;
      localLayoutParams2.height = i;
      localLayoutParams1.height = i;
      localImageElement1.a(localLayoutParams1);
      localImageElement2.a(localLayoutParams2);
      return;
    }
    if (paramFNDefaultItemData.jdField_f_of_type_Int == 3)
    {
      localImageElement1.a(0);
      localImageElement2.a(0);
      paramFNDefaultItemViewHolder.a(0);
      i = d;
      localLayoutParams3.width = i;
      localLayoutParams2.width = i;
      localLayoutParams1.width = i;
      i = d;
      localLayoutParams3.height = i;
      localLayoutParams2.height = i;
      localLayoutParams1.height = i;
      localImageElement1.a(localLayoutParams1);
      localImageElement2.a(localLayoutParams2);
      paramFNDefaultItemViewHolder.a(localLayoutParams3);
      return;
    }
    localImageElement1.a(0);
    localImageElement2.a(0);
    paramFNDefaultItemViewHolder.a(0);
    int i = d;
    localLayoutParams3.width = i;
    localLayoutParams2.width = i;
    localLayoutParams1.width = i;
    i = d;
    localLayoutParams3.height = i;
    localLayoutParams2.height = i;
    localLayoutParams1.height = i;
    localImageElement1.a(localLayoutParams1);
    localImageElement2.a(localLayoutParams2);
    paramFNDefaultItemViewHolder.a(localLayoutParams3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\feed\FNDefaultItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */