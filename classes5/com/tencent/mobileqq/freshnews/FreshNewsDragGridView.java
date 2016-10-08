package com.tencent.mobileqq.freshnews;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import spm;
import spn;
import spo;

public class FreshNewsDragGridView
  extends GridView
{
  public int a;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private FreshNewsDragGridView.OnItemOrderChangedListener jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView$OnItemOrderChangedListener;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public FreshNewsDragGridView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 500L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new spm(this);
    a(paramContext);
  }
  
  public FreshNewsDragGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 500L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new spm(this);
    a(paramContext);
  }
  
  public FreshNewsDragGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Long = 500L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new spm(this);
    a(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    int m = getChildCount() - 1;
    while (m >= 0)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 0)
      {
        localView.getHitRect(localRect);
        if (localRect.contains(paramInt1, paramInt2))
        {
          paramInt1 = m + getFirstVisiblePosition();
          if (paramInt1 == this.jdField_a_of_type_Int) {
            break;
          }
          return paramInt1;
        }
      }
      m -= 1;
    }
    return -1;
  }
  
  private static int a(Context paramContext)
  {
    Object localObject1 = new Rect();
    ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int n = ((Rect)localObject1).top;
    int m = n;
    if (n == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      m = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      m = paramContext.getResources().getDimensionPixelSize(m);
      return m;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return n;
  }
  
  private AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    return localAnimatorSet;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = (paramInt1 - this.h + this.j);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (paramInt2 - this.g + this.i - this.k);
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    b(paramInt1, paramInt2);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.k = a(paramContext);
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = ((int)(paramBitmap.getWidth() * 1.2F));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = ((int)(paramBitmap.getHeight() * 1.2F));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.alpha = 0.5F;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = (paramInt1 - (int)(this.h * 1.2F) + this.j);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (paramInt2 - (int)(this.g * 1.2F) + this.i - this.k);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 24;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return false;
    }
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    return localRect.contains(paramInt1, paramInt2);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, paramInt2);
    if ((paramInt1 != this.f) && (paramInt1 != -1) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView$OnItemOrderChangedListener.a(this.f, paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView$OnItemOrderChangedListener.a(paramInt1);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
        localViewTreeObserver.addOnPreDrawListener(new spn(this, localViewTreeObserver, paramInt1));
      }
    }
    else
    {
      return;
    }
    this.f = paramInt1;
  }
  
  private void c()
  {
    View localView = getChildAt(this.f - getFirstVisiblePosition());
    if (localView != null) {
      localView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView$OnItemOrderChangedListener.a(-1);
    b();
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int m;
    LinkedList localLinkedList;
    int n;
    if (paramInt2 > paramInt1)
    {
      m = 1;
      localLinkedList = new LinkedList();
      n = paramInt1;
      if (m == 0) {
        break label125;
      }
      label24:
      if (paramInt1 >= paramInt2) {
        break label229;
      }
      localObject = getChildAt(paramInt1 - getFirstVisiblePosition());
      if ((paramInt1 + 1) % this.l != 0) {
        break label100;
      }
      localLinkedList.add(a((View)localObject, -((View)localObject).getWidth() * (this.l - 1), 0.0F, ((View)localObject).getHeight(), 0.0F));
    }
    for (;;)
    {
      paramInt1 += 1;
      break label24;
      m = 0;
      break;
      label100:
      localLinkedList.add(a((View)localObject, ((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
    }
    label125:
    if (n > paramInt2)
    {
      localObject = getChildAt(n - getFirstVisiblePosition());
      if ((this.l + n) % this.l == 0) {
        localLinkedList.add(a((View)localObject, ((View)localObject).getWidth() * (this.l - 1), 0.0F, -((View)localObject).getHeight(), 0.0F));
      }
      for (;;)
      {
        n -= 1;
        break;
        localLinkedList.add(a((View)localObject, -((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
      }
    }
    label229:
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(localLinkedList);
    ((AnimatorSet)localObject).setDuration(300L);
    ((AnimatorSet)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject).addListener(new spo(this));
    ((AnimatorSet)localObject).start();
  }
  
  public FreshNewsDragGridView.OnItemOrderChangedListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView$OnItemOrderChangedListener;
  }
  
  public void a()
  {
    View localView = getChildAt(this.f - getFirstVisiblePosition());
    if (localView != null) {
      localView.setVisibility(0);
    }
    b();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getX());
      this.c = ((int)paramMotionEvent.getY());
      b();
      this.f = pointToPosition(this.jdField_b_of_type_Int, this.c);
      if ((this.f == this.jdField_a_of_type_Int) || (this.f == -1)) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidViewView = getChildAt(this.f - getFirstVisiblePosition());
      this.g = (this.c - this.jdField_a_of_type_AndroidViewView.getTop());
      this.h = (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidViewView.getLeft());
      this.i = ((int)(paramMotionEvent.getRawY() - this.c));
      this.j = ((int)(paramMotionEvent.getRawX() - this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidViewView.getDrawingCache());
      this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
      continue;
      int m = (int)paramMotionEvent.getX();
      int n = (int)paramMotionEvent.getY();
      if (!a(this.jdField_a_of_type_AndroidViewView, m, n)) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        a(m, n);
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          c();
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  public void setListener(FreshNewsDragGridView.OnItemOrderChangedListener paramOnItemOrderChangedListener)
  {
    if (paramOnItemOrderChangedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView$OnItemOrderChangedListener = paramOnItemOrderChangedListener;
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    super.setNumColumns(paramInt);
    this.l = paramInt;
  }
  
  public void setOnItemOrderChangedListener(FreshNewsDragGridView.OnItemOrderChangedListener paramOnItemOrderChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView$OnItemOrderChangedListener = paramOnItemOrderChangedListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsDragGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */