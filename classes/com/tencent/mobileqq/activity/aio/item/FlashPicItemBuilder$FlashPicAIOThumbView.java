package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import njs;

public class FlashPicItemBuilder$FlashPicAIOThumbView
  extends ChatThumbView
{
  public boolean b;
  
  public FlashPicItemBuilder$FlashPicAIOThumbView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    ThreadManager.a(new njs(this, paramURLDrawable), null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\FlashPicItemBuilder$FlashPicAIOThumbView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */