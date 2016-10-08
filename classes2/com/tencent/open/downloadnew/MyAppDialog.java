package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import java.lang.ref.WeakReference;
import wxk;
import wxl;

public class MyAppDialog
  extends Dialog
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected final WeakReference a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  
  public MyAppDialog(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2130903508);
  }
  
  public Activity a()
  {
    Activity localActivity2 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = null;
    }
    return localActivity1;
  }
  
  public MyAppDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new wxk(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 100;
    LogUtility.c("MyAppApi", "updateView--progress--" + paramInt1 + " state = " + paramInt2);
    Object localObject = getContext().getResources();
    switch (paramInt2)
    {
    default: 
      localObject = null;
      if (paramInt1 < 0)
      {
        i = 0;
        label113:
        if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.e.setVisibility(0);
        }
        if (paramInt2 != 3) {
          break label265;
        }
        this.c.setVisibility(0);
        this.c.setText(null);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      this.e.setText((CharSequence)localObject);
      return;
      localObject = ((Resources)localObject).getString(2131363035, new Object[] { Integer.valueOf(paramInt1) });
      break;
      localObject = ((Resources)localObject).getString(2131363036);
      break;
      localObject = ((Resources)localObject).getString(2131363037, new Object[] { Integer.valueOf(paramInt1) });
      break;
      localObject = ((Resources)localObject).getString(2131363038);
      paramInt1 = 100;
      break;
      localObject = ((Resources)localObject).getString(2131363037);
      break;
      if (paramInt1 > 100) {
        break label113;
      }
      i = paramInt1;
      break label113;
      label265:
      this.c.setVisibility(4);
    }
  }
  
  public MyAppDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new wxl(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog b(String paramString)
  {
    if (paramString != null) {
      this.b.setText(paramString);
    }
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297840));
    this.b = ((TextView)findViewById(2131296852));
    this.c = ((TextView)findViewById(2131297843));
    this.c.getPaint().setFakeBoldText(true);
    this.d = ((TextView)findViewById(2131297844));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297446));
    this.e = ((TextView)findViewById(2131298862));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\MyAppDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */