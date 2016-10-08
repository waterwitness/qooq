package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ttv;

public class FormalView
  extends RelativeLayout
  implements Handler.Callback
{
  private static final int jdField_a_of_type_Int = 30;
  private static final String jdField_a_of_type_JavaLangString = "刷一刷抢红包";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130840765, 2130840766, 2130840767, 2130840768, 2130840769, 2130840770, 2130840771, 2130840772, 2130840773, 2130840774, 2130840775, 2130840776, 2130840777, 2130840778, 2130840779, 2130840780, 2130840781, 2130840782, 2130840783, 2130840784, 2130840785, 2130840786, 2130840787, 2130840788, 2130840789, 2130840790, 2130840791, 2130840792, 2130840793, 2130840794, 2130840795, 2130840796, 2130840797, 2130840798, 2130840799, 2130840800, 2130840801 };
  private static final int jdField_b_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FlakeView jdField_a_of_type_ComTencentMobileqqPortalFlakeView;
  private TimeDownTextView jdField_a_of_type_ComTencentMobileqqPortalTimeDownTextView;
  public boolean a;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FormalView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LayoutInflater.from(paramContext).inflate(2130904187, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301745));
    this.d = ((TextView)findViewById(2131301753));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301751));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301754));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301749));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301750));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301752));
    this.f = ((TextView)findViewById(2131301748));
    this.e = ((TextView)findViewById(2131301746));
    this.jdField_a_of_type_ComTencentMobileqqPortalTimeDownTextView = ((TimeDownTextView)findViewById(2131301747));
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView = new FlakeView(this.jdField_a_of_type_AndroidContentContext, false);
    addView(this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView, 0, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      int i = 0;
      try
      {
        while (i < jdField_a_of_type_ArrayOfInt.length)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(getResources().getDrawable(jdField_a_of_type_ArrayOfInt[i]), 30);
          i += 1;
        }
        this.d.clearAnimation();
      }
      catch (Throwable localThrowable)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
      }
    }
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a();
    b(false);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(81.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    b(false);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      paramString = Typeface.createFromAsset(getContext().getAssets(), "fonts/icomoon.ttf");
      this.d.setTypeface(paramString);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      paramString = new AlphaAnimation(0.0F, 1.0F);
      localObject = new ScaleAnimation(2.4F, 1.0F, 2.4F, 1.0F, 1, 0.5F, 1, 0.5F);
      OvershootInterpolator localOvershootInterpolator = new OvershootInterpolator(1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(localOvershootInterpolator);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(paramString);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.d.setVisibility(0);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.reset();
    if (paramInt == 1) {
      this.d.setText("继续刷！");
    }
    for (;;)
    {
      this.d.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
      this.jdField_a_of_type_Boolean = true;
      return;
      if (paramInt < 10) {
        this.d.setText(paramInt + "连刷");
      } else {
        this.d.setText("x" + paramInt);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.f.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalTimeDownTextView.setVisibility(8);
    this.d.clearAnimation();
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    b(false);
    this.e.setVisibility(0);
    SpannableString localSpannableString = new SpannableString("本轮已刷" + paramInt + "次");
    if (paramInt < 10)
    {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FEF900")), 4, 5, 33);
      this.e.setText(localSpannableString);
      if (TextUtils.isEmpty(paramString2)) {
        break label334;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramString2 = new SpannableString("下轮时间：" + paramString2);
      paramString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FEF900")), 5, paramString2.length(), 33);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_Boolean = false;
      return;
      if (paramInt < 100)
      {
        localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FEF900")), 4, 6, 33);
        break;
      }
      if (paramInt < 1000)
      {
        localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FEF900")), 4, 7, 33);
        break;
      }
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FEF900")), 4, 8, 33);
      break;
      label334:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.e.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalTimeDownTextView.setVisibility(0);
    this.f.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPortalTimeDownTextView.setText(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.d.clearAnimation();
    this.d.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if ("网络不给力，请检查网络是否可用！".equals(paramString))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.topMargin = AIOUtils.a(64.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_Boolean = false;
      b(false);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.topMargin = AIOUtils.a(81.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalTimeDownTextView.setVisibility(8);
    this.f.setVisibility(8);
    this.e.setVisibility(0);
    this.e.setText("刷一刷抢红包");
  }
  
  public void b(boolean paramBoolean)
  {
    View localView = findViewById(2131301755);
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == null)
      {
        AnimationSet localAnimationSet = new AnimationSet(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.8F, 1.0F, 1.85F, 1.0F, 1, 0.5F, 1, 0.5F);
        localAnimationSet.setInterpolator(new OvershootInterpolator(1.0F));
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setDuration(400L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setAnimationListener(new ttv(this, localView));
        this.jdField_b_of_type_AndroidViewAnimationAnimationSet = localAnimationSet;
      }
      localView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
      return;
    }
    localView.clearAnimation();
    localView.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Boolean) {
        d();
      }
    }
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap1 != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable == null) || (!(localDrawable instanceof BitmapDrawable)) || (((BitmapDrawable)localDrawable).getBitmap() != paramBitmap1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
      }
    }
    while (paramBitmap2 != null)
    {
      paramBitmap1 = getBackground();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap2))
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840754);
      }
      else
      {
        super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap2));
        return;
      }
    }
    super.setBackgroundResource(2130840753);
  }
  
  public void setHBSpeed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setHonhBaoSpeed(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\FormalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */