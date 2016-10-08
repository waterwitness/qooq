package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import vtc;
import vtd;
import vte;

public class MessageSubtitleView
  extends RelativeLayout
{
  protected static final float a = 3.0F;
  protected static final int a = 200;
  protected static final float b = 3.0F;
  protected static final int b = 8000;
  protected static final float c = 3.0F;
  protected static final int c = 3;
  protected static final float d = 0.2F;
  protected static final int e = 18;
  protected static int f = 1;
  public static int g = 2;
  protected static int h = 3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new vtc(this);
  protected ArrayList a;
  public Queue a;
  private final Runnable b = new vtd(this);
  int d = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageSubtitleView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    a(paramContext);
  }
  
  public MessageSubtitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    a(paramContext);
  }
  
  private AnimatorSet a(TextView paramTextView)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(a(paramTextView)).with(b(paramTextView));
    return localAnimatorSet;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "alpha", new float[] { 0.0F, 1.0F });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label91:
    label126:
    for (;;)
    {
      return;
      Object localObject = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        if (paramInt2 != f) {
          break label91;
        }
        localObject = a((TextView)localObject);
      }
      for (;;)
      {
        if (localObject == null) {
          break label126;
        }
        ((Animator)localObject).setInterpolator(new AccelerateInterpolator(0.2F));
        ((Animator)localObject).addListener(new vte(this, bool, paramInt2));
        ((Animator)localObject).start();
        return;
        bool = false;
        break;
        if (paramInt2 == g) {
          localObject = b((TextView)localObject);
        } else if (paramInt2 == h) {
          localObject = a((TextView)localObject);
        } else {
          localObject = null;
        }
      }
    }
  }
  
  private ObjectAnimator b(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "translationY", new float[] { paramTextView.getTranslationY(), paramTextView.getTranslationY() - this.d });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 3)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.b);
      d();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.b);
        d();
      }
      a();
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() != 1);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.b);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.b, 8000L);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(i, g);
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 3))
    {
      Object localObject = getContext();
      CharSequence localCharSequence = (CharSequence)this.jdField_a_of_type_JavaUtilQueue.poll();
      TextView localTextView = new TextView((Context)localObject);
      localTextView.setShadowLayer(3.0F, 3.0F, 3.0F, 2131427357);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine(true);
      localTextView.setTextSize(18.0F);
      localTextView.setTextColor(-1);
      localTextView.setTag(Long.valueOf(System.currentTimeMillis()));
      localTextView.setTranslationY(0.0F);
      localTextView.setText(localCharSequence);
      localObject = new RelativeLayout.LayoutParams(((Context)localObject).getResources().getDimensionPixelSize(2131493286), ((Context)localObject).getResources().getDimensionPixelSize(2131493288));
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.jdField_a_of_type_JavaUtilArrayList.size() * this.d);
      addView(localTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(localTextView);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 4) {
        a(this.jdField_a_of_type_JavaUtilArrayList.size() - 1, f);
      }
    }
    else
    {
      return;
    }
    a(this.jdField_a_of_type_JavaUtilArrayList.size() - 1, h);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext.getMainLooper());
    this.d = paramContext.getResources().getDimensionPixelSize(2131493288);
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence2);
    int k = getContext().getResources().getColor(2131427538);
    int j = paramCharSequence1.length() + 1;
    int i = j;
    if (j > paramCharSequence2.length()) {
      i = paramCharSequence2.length();
    }
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(k), 0, i, 33);
    this.jdField_a_of_type_JavaUtilQueue.add(localSpannableStringBuilder);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    label20:
    float f1;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      f1 = localTextView.getY();
      if (f1 >= 0.0F) {
        break label81;
      }
      removeView(localTextView);
      this.jdField_a_of_type_JavaUtilArrayList.remove(localTextView);
      j = i - 1;
    }
    for (;;)
    {
      i = j + 1;
      break label20;
      break;
      label81:
      j = i;
      if (f1 == 0.0F)
      {
        long l2 = 8200L - (System.currentTimeMillis() - ((Long)((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(0)).getTag()).longValue());
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 1000L;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.b);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.b, l1);
        j = i;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\MessageSubtitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */