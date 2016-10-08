package cooperation.plugin;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.BounceScrollView;
import ydy;

public class PluginIphoneTitleBarActivity
  extends PluginBaseActivity
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  protected float b;
  protected ViewGroup b;
  protected View.OnClickListener c;
  protected ImageView f;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  
  public PluginIphoneTitleBarActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = new ydy(this);
  }
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(1, null);
  }
  
  public View a()
  {
    this.h = ((TextView)findViewById(2131297083));
    this.h.setOnClickListener(this.c);
    setLayerType(this.h);
    return this.h;
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.h.setVisibility(8);
    this.h = ((TextView)findViewById(2131297391));
    setLayerType(this.h);
    this.h.setVisibility(0);
    this.h.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.h.setOnClickListener(this.c);
      return;
    }
    this.h.setOnClickListener(paramOnClickListener);
  }
  
  public void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130843153));
    if (this.h == null)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297082));
      setLayerType(this.jdField_b_of_type_AndroidViewViewGroup);
      a();
      d();
      b();
      b(paramIntent);
    }
  }
  
  public boolean a()
  {
    finish();
    return false;
  }
  
  public View b()
  {
    this.j = ((TextView)findViewById(2131297183));
    this.f = ((ImageView)findViewById(2131297392));
    setLayerType(this.j);
    setLayerType(this.f);
    return this.j;
  }
  
  protected String b()
  {
    if ((this.i == null) || (this.i.getText() == null) || (this.i.getText().length() == 0)) {
      return getString(2131367975);
    }
    return this.i.getText().toString();
  }
  
  protected void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.j.setVisibility(0);
    this.j.setText(paramInt);
    this.j.setEnabled(false);
    this.k = ((TextView)getLayoutInflater().inflate(2130903234, null));
    setLayerType(this.k);
    this.k.setText(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    localLayoutParams.rightMargin = ((int)(8.0F * this.jdField_b_of_type_Float));
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.k, localLayoutParams);
    this.k.setVisibility(8);
    if (paramOnClickListener != null) {
      this.k.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    if ((this.h != null) && ((this.h instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.h;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131367975);
      }
      localTextView.setText(paramIntent);
    }
  }
  
  public void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.j.setVisibility(0);
    this.j.setText(getString(paramInt));
    this.j.setEnabled(true);
    if (paramOnClickListener != null) {
      this.j.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void c(View paramView)
  {
    super.setContentView(paramView);
  }
  
  protected View d()
  {
    this.i = ((TextView)findViewById(2131297139));
    return this.i;
  }
  
  protected void f(boolean paramBoolean)
  {
    if ((this.k == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (paramBoolean)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      return;
    }
    this.j.setVisibility(0);
    this.k.setVisibility(8);
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838325);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.i.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.i.getCompoundDrawablePadding();
      this.i.setCompoundDrawablePadding(10);
      this.i.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  protected void g(int paramInt)
  {
    if ((this.h != null) && ((this.h instanceof TextView)))
    {
      String str2 = getString(paramInt);
      TextView localTextView = this.h;
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
  
  protected boolean g()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.i.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.i.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public String getTextTitle()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.i != null)
    {
      localObject1 = localObject2;
      if ((this.i instanceof TextView))
      {
        CharSequence localCharSequence = this.i.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return (String)localObject1;
  }
  
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.jdField_b_of_type_AndroidViewViewGroup.setLayerType(0, null);
    }
  }
  
  public void setContentView(int paramInt)
  {
    boolean bool = true;
    Intent localIntent = getIntent();
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("showTitleBar", true);
    }
    if (bool) {
      requestWindowFeature(7);
    }
    super.setContentView(paramInt);
    if (bool) {
      getWindow().setFeatureInt(7, 2130903231);
    }
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    if (bool) {
      a(getIntent());
    }
  }
  
  public void setContentView(View paramView)
  {
    setContentView(paramView, true);
  }
  
  public void setContentView(View paramView, boolean paramBoolean)
  {
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    if (paramBoolean)
    {
      requestWindowFeature(7);
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2130903231);
      a(getIntent());
      return;
    }
    requestWindowFeature(1);
    super.setContentView(paramView);
  }
  
  public View setContentViewB(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130903151, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  public void setContentViewCallSuper(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public void setContentViewNoTitle(int paramInt)
  {
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    requestWindowFeature(1);
    super.setContentView(paramInt);
    a(getIntent());
  }
  
  public void setContentViewOriginal(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  public void setContentViewOriginal(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.i != null) && ((this.i instanceof TextView)))
    {
      this.i.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    if ((this.i != null) && ((this.i instanceof TextView)))
    {
      this.i.setText(paramCharSequence);
      super.setTitle(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginIphoneTitleBarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */