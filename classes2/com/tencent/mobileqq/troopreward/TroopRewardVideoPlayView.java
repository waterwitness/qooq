package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager.OnPlayListener;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager.OnSeekListener;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaControllerListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

public class TroopRewardVideoPlayView
  extends RelativeLayout
  implements View.OnClickListener, TVKTroopVideoManager.OnPlayListener, TVKTroopVideoManager.OnSeekListener, MediaControllerX.MediaControllerListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener
{
  protected static final String a;
  private static final int jdField_b_of_type_Int = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  protected int a;
  protected Context a;
  protected View a;
  protected RelativeLayout a;
  protected URLImageView a;
  protected TVKTroopVideoManager a;
  protected MediaControllerX a;
  protected TroopRewardInfo a;
  protected boolean a;
  View jdField_b_of_type_AndroidViewView;
  protected String b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopRewardVideoPlayView.class.getSimpleName();
  }
  
  public TroopRewardVideoPlayView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TroopRewardVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TroopRewardVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, -1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      if (paramInt != 1) {
        break label173;
      }
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839289);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
      ((Animatable)localObject2).start();
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, -1, -1);
      break;
      label173:
      Object localObject3;
      if (paramInt == 2)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839281);
        localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(13);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject3).setId(2131296440);
        if (this.jdField_b_of_type_JavaLangString == null) {}
        for (localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365286);; localObject1 = this.jdField_b_of_type_JavaLangString)
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          ((TextView)localObject3).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365286));
          ((RelativeLayout)localObject2).addView((View)localObject3, -2, -2);
          break;
        }
      }
      if (paramInt == 3)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839281);
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setId(2131296442);
        ((ImageView)localObject2).setImageResource(2130839285);
        ((ImageView)localObject2).setOnClickListener(this);
        ((ImageView)localObject2).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131364745));
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(14);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      a(2);
      return;
    }
    if (this.c)
    {
      a(3);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.d) || (this.e))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  private void g()
  {
    int j;
    if (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2)
    {
      j = (int)DeviceInfoUtil.g();
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.f();
        }
      }
    }
    for (int i = j;; i = (int)(180.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density + 0.5F))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = i;
      setLayoutParams(localLayoutParams);
      requestLayout();
      return;
    }
  }
  
  public void a()
  {
    f();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager = new TVKTroopVideoManager((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.k = 2;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_AndroidViewView;
    addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(true);
    this.c = true;
    f();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = new MediaControllerX(this.jdField_a_of_type_AndroidContentContext, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, "");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setMediaControllerListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setOutLinkBtnVisible(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnErrorListener = this;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener = this;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager$OnPlayListener = this;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnInfoListener = this;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager$OnSeekListener = this;
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_Boolean = true;
    this.c = false;
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    f();
  }
  
  public void b()
  {
    f();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.e();
      this.c = true;
      f();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (this.jdField_a_of_type_Int != 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a(this.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.vid != null))
    {
      this.jdField_a_of_type_Boolean = false;
      this.c = false;
      this.d = false;
      this.jdField_b_of_type_Boolean = false;
      this.e = false;
      if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.vid);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    this.d = true;
    f();
  }
  
  public void l()
  {
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    f();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364741), 1).a();
      return;
    }
    e();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.c = true;
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
    }
    f();
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.jdField_b_of_type_Boolean = true;
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.d = false;
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    f();
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (paramInt == 701) {
      this.e = true;
    }
    for (;;)
    {
      f();
      return false;
      if (paramInt == 702) {
        this.e = false;
      }
    }
  }
  
  public void setOutTitleBar(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
  }
  
  public void setTroopRewardInfo(TroopRewardInfo paramTroopRewardInfo)
  {
    if (paramTroopRewardInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo = paramTroopRewardInfo;
      if (paramTroopRewardInfo.rewardId != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.d = paramTroopRewardInfo.rewardId;
      }
      if (!TextUtils.isEmpty(paramTroopRewardInfo.clearPicUrl))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        paramTroopRewardInfo = URLDrawable.getDrawable(paramTroopRewardInfo.clearPicUrl, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramTroopRewardInfo);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopreward\TroopRewardVideoPlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */