package com.tencent.biz.qqstory.pgc.view;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.view.widget.StrokeTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import ima;
import imb;
import imc;
import imd;
import ime;

public class DiscoverItem
  extends RelativeLayout
{
  public static final float a = 0.3F;
  public static final int a = 22;
  public static final float b = 0.6F;
  public static final int b = 22;
  public static final int c = 36;
  public static final int e = 1;
  public static final int f = 2;
  public AnimatorListenerAdapter a;
  public View a;
  public StrokeTextView a;
  URLDrawable.URLDrawableListener a;
  public URLImageView a;
  public View b;
  public URLImageView b;
  public float c;
  public URLImageView c;
  public int d;
  public int g = 2;
  public int h = 22;
  
  public DiscoverItem(Context paramContext, int paramInt1, int paramInt2, AdapterView.OnItemClickListener paramOnItemClickListener, AdapterView.OnItemLongClickListener paramOnItemLongClickListener, DiscoverItem.OnItemTouchListener paramOnItemTouchListener)
  {
    super(paramContext);
    this.jdField_c_of_type_Float = 0.3F;
    this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new ima(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new ime(this);
    this.g = paramInt2;
    this.h = paramInt1;
    switch (paramInt2)
    {
    default: 
      this.jdField_c_of_type_Float = 0.3F;
      LayoutInflater.from(getContext()).inflate(2130904440, this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView = ((StrokeTextView)findViewById(2131302750));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302748));
      this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302751));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302749));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131302752);
      if (paramInt2 == 1) {
        this.jdField_b_of_type_AndroidViewView = findViewById(2131302753);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setStrokeColor(Color.argb(127, 0, 0, 0));
      if (paramInt2 == 2)
      {
        paramContext = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramContext.height = DisplayUtil.a(getContext(), paramInt1);
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams(paramContext);
      }
      setMaskAlpha(this.jdField_c_of_type_Float);
      super.setOnClickListener(new imb(this, paramOnItemClickListener));
      super.setOnLongClickListener(new imc(this, paramOnItemLongClickListener));
      super.setOnTouchListener(new imd(this, paramOnItemTouchListener));
      return;
      this.jdField_c_of_type_Float = 0.3F;
      LayoutInflater.from(getContext()).inflate(2130904440, this);
      continue;
      this.jdField_c_of_type_Float = 0.6F;
      LayoutInflater.from(getContext()).inflate(2130904441, this);
    }
  }
  
  public DiscoverItem(Context paramContext, int paramInt, AdapterView.OnItemClickListener paramOnItemClickListener, AdapterView.OnItemLongClickListener paramOnItemLongClickListener, DiscoverItem.OnItemTouchListener paramOnItemTouchListener)
  {
    this(paramContext, paramInt, 2, paramOnItemClickListener, paramOnItemLongClickListener, paramOnItemTouchListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Drawable a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(2130841513);
    if (Build.VERSION.SDK_INT <= 10) {}
    for (localDrawable = localDrawable.getConstantState().newDrawable(getResources());; localDrawable = localDrawable.getConstantState().newDrawable(getResources()).mutate())
    {
      localDrawable.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      localDrawable.setAlpha(paramInt >>> 24);
      return localDrawable;
    }
  }
  
  public void setMaskAlpha(float paramFloat)
  {
    this.jdField_b_of_type_ComTencentImageURLImageView.setAlpha(paramFloat);
  }
  
  public void setRecommendItem(int paramInt, RecommendItem paramRecommendItem)
  {
    super.setVisibility(0);
    this.d = paramInt;
    Object localObject1;
    Object localObject2;
    if (paramRecommendItem != null)
    {
      localObject1 = paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setText(((Story)localObject1).title);
        localObject2 = paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo;
        if (localObject2 != null)
        {
          if (this.g != 1) {
            break label429;
          }
          this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(a(((UserInfo)localObject2).themeColor));
          setMaskAlpha(this.jdField_c_of_type_Float);
          if (TextUtils.isEmpty(((UserInfo)localObject2).logoURL)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
        paramRecommendItem = ((UserInfo)localObject2).logoURL;
        if (this.g != 1) {
          continue;
        }
        paramRecommendItem = ThumbnailUrlHelper.a(paramRecommendItem);
        paramRecommendItem = URLDrawable.getDrawable(paramRecommendItem, (URLDrawable.URLDrawableOptions)localObject3);
        if (paramRecommendItem.getStatus() == 2) {
          paramRecommendItem.restartDownload();
        }
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramRecommendItem);
      }
      catch (Exception paramRecommendItem)
      {
        Object localObject3;
        label429:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.pgc", 2, "图片加载异常");
        continue;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        continue;
        paramRecommendItem = (RecommendItem)localObject1;
        if (this.g != 2) {
          continue;
        }
        if ((this.h != 22) && (this.h != 22)) {
          continue;
        }
        paramRecommendItem = ThumbnailUrlHelper.c(getContext(), ((StoryCoverInfo)localObject3).coverUrl);
        continue;
        paramRecommendItem = (RecommendItem)localObject1;
        if (this.h != 36) {
          continue;
        }
        paramRecommendItem = ThumbnailUrlHelper.b(getContext(), ((StoryCoverInfo)localObject3).coverUrl);
        continue;
      }
      if (((UserInfo)localObject2).type != 2) {
        continue;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!((UserInfo)localObject2).isSubscribe) {
          continue;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      localObject3 = ((Story)localObject1).recommendCoverInfo;
      if ((localObject3 != null) && (!TextUtils.isEmpty(((StoryCoverInfo)localObject3).coverUrl))) {}
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredHeight();
        localObject1 = ((StoryCoverInfo)localObject3).coverUrl;
        if (this.g != 1) {
          continue;
        }
        paramRecommendItem = ThumbnailUrlHelper.a(((StoryCoverInfo)localObject3).coverUrl);
        paramRecommendItem = URLDrawable.getDrawable(paramRecommendItem, (URLDrawable.URLDrawableOptions)localObject2);
        paramRecommendItem.setFadeInImage(true);
        if (paramRecommendItem.getStatus() == 2) {
          paramRecommendItem.restartDownload();
        }
        if (this.g == 1)
        {
          paramRecommendItem.setTag(URLDrawableDecodeHandler.a(DisplayUtil.a(getContext(), 83.0F), DisplayUtil.a(getContext(), 134.0F), DisplayUtil.a(getContext(), 4.0F)));
          paramRecommendItem.setDecodeHandler(URLDrawableDecodeHandler.b);
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramRecommendItem);
        paramRecommendItem.setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
        return;
      }
      catch (Exception paramRecommendItem)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("View", 2, QLog.getStackTraceString(paramRecommendItem));
      }
      this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundColor(((UserInfo)localObject2).themeColor);
      break;
      paramRecommendItem = ThumbnailUrlHelper.d(getContext(), paramRecommendItem);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\DiscoverItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */