package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import mlg;
import mlh;
import mli;
import mlj;
import mqq.util.NativeUtil;

public class SnapScreenActivity
  extends Activity
{
  public static final String a;
  static final int b = -16847;
  public int a;
  public Context a;
  public Bitmap a;
  public Drawable a;
  private ViewGroup a;
  public Window a;
  public Button a;
  public mlj a;
  public Bitmap b;
  public Drawable b;
  public Button b;
  public Bitmap c;
  public Button c;
  public Button d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AppConstants.bh + "/QQ_Screenshot/";
  }
  
  private void a(Context paramContext, Window paramWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      for (paramWindow = (Activity)this.jdField_a_of_type_AndroidContentContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
    }
    for (this.jdField_a_of_type_AndroidViewWindow = paramWindow.getWindow();; this.jdField_a_of_type_AndroidViewWindow = paramWindow)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842893);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842892);
      paramContext = (LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater");
      this.jdField_a_of_type_Mlj = new mlj(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Mlj, 0);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304826));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304827));
      this.d = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297867));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304825));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new mlg(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new mlh(this));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new mli(this));
      return;
    }
  }
  
  private void d() {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation;
    this.jdField_a_of_type_Mlj.k = 0;
    this.jdField_a_of_type_Mlj.a.setEmpty();
    Bitmap localBitmap = NativeUtil.screenshot(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_c_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    a(false);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      d();
    }
    while (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    d();
  }
  
  public void c()
  {
    a();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130904931);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131296895));
    a(this, getWindow());
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SnapScreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */