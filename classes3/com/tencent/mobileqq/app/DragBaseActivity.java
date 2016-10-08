package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import pxh;

public class DragBaseActivity
  extends BaseActivity
{
  protected float a;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  protected ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected TextView a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  
  public DragBaseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new pxh(this);
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetTextView);
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public String a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b != null)
    {
      localObject1 = localObject2;
      if ((this.b instanceof TextView))
      {
        CharSequence localCharSequence = this.b.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return (String)localObject1;
  }
  
  public void a(int paramInt)
  {
    setContentView(paramInt);
    try
    {
      findViewById(2131296896).setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.c.setVisibility(0);
    this.c.setText(paramInt);
    this.c.setEnabled(true);
    if (paramOnClickListener != null) {
      this.c.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      super.setContentView(2130903646);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131299567);
      localFrameLayout.setForeground(getResources().getDrawable(2130843153));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297082));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidViewViewGroup);
      a();
      b();
      c();
      b(paramIntent);
    }
  }
  
  public void a(CharSequence paramCharSequence, String paramString)
  {
    if ((this.b != null) && ((this.b instanceof TextView)))
    {
      this.b.setText(paramCharSequence);
      super.setTitle(paramString);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838325);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.b.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.b.getCompoundDrawablePadding();
      this.b.setCompoundDrawablePadding(10);
      this.b.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  protected View b()
  {
    this.b = ((TextView)findViewById(2131297139));
    return this.b;
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)))
    {
      String str2 = getString(paramInt);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = getString(2131367975);
      }
      localTextView.setText(str1);
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131367975);
      }
      localTextView.setText(paramIntent);
    }
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.b.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.b.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  protected View c()
  {
    this.c = ((TextView)findViewById(2131297183));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297392));
    IphoneTitleBarActivity.setLayerType(this.c);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.c;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().requestFeature(1);
    super.onCreate(paramBundle);
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(getLayoutInflater().inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(2130903646);
    a(getIntent());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  protected String setLastActivityName()
  {
    if ((this.b == null) || (this.b.getText() == null) || (this.b.getText().length() == 0)) {
      return getString(2131367975);
    }
    return this.b.getText().toString();
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.b != null) && ((this.b instanceof TextView)))
    {
      this.b.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DragBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */