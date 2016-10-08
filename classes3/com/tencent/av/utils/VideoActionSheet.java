package com.tencent.av.utils;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class VideoActionSheet
  extends ActionSheet
{
  public static boolean a;
  boolean b;
  
  protected VideoActionSheet(Context paramContext)
  {
    super(paramContext);
    this.b = false;
  }
  
  protected VideoActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = false;
  }
  
  public static VideoActionSheet a(Context paramContext)
  {
    paramContext = new VideoActionSheet(paramContext, false, false);
    paramContext.getWindow().setWindowAnimations(2131559022);
    return paramContext;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public void dismiss()
  {
    a = false;
    this.b = false;
    super.dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    if (this.b)
    {
      a = false;
      this.b = false;
    }
    super.onDetachedFromWindow();
  }
  
  public void onStop()
  {
    if (this.b)
    {
      a = false;
      this.b = false;
    }
    super.onStop();
  }
  
  public void show()
  {
    if (a == true) {
      return;
    }
    a = true;
    this.b = true;
    super.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\VideoActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */