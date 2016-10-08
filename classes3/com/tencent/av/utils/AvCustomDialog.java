package com.tencent.av.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hav;
import haw;

public class AvCustomDialog
  extends Dialog
{
  public AvCustomDialog(Context paramContext)
  {
    super(paramContext, 2131558973);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2130903620);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131299476);
    localFrameLayout.setOnClickListener(new hav(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131299475).setOnClickListener(new haw(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\AvCustomDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */