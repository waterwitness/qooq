package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Timer;
import wko;
import wkp;
import wkq;

public class AntiphingToast
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 1;
  public static final int f = 700;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int g;
  
  public AntiphingToast()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "AntiPhing";
    this.jdField_a_of_type_AndroidOsHandler = new wko(this, Looper.getMainLooper());
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 2130841634;
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, paramFloat1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setStartOffset(20L);
    if (paramBoolean == true) {
      localTranslateAnimation.setAnimationListener(new wkp(this));
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(localTranslateAnimation);
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, FrameLayout paramFrameLayout)
  {
    a(paramFrameLayout);
    b(paramInt1);
    c(paramInt2);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_AndroidContentResResources = paramFrameLayout.getContext().getResources();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904523, null);
    if (localView != null)
    {
      TextView localTextView = (TextView)localView.findViewById(2131303036);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
    paramContext = new Toast(paramContext.getApplicationContext());
    paramContext.setGravity(55, 0, paramInt);
    paramContext.setView(localView);
    paramContext.setDuration(1);
    paramContext.show();
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViewsInLayout();
    if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904523, null);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303036);
        if ((localTextView != null) && (paramString != null)) {
          localTextView.setText(paramString);
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.bringToFront();
    a(-80.0F, 0.0F, false);
    new Timer().schedule(new wkq(this), this.g + 700);
    return true;
  }
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\AntiphingToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */