package com.tencent.mobileqq.shortvideo.mediaplay;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class TMMCoverView
  extends FrameLayout
{
  private ImageView a;
  
  public TMMCoverView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public TMMCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TMMCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.a = new ImageView(getContext());
    addView(this.a, localLayoutParams);
    setBackgroundColor(-16777216);
  }
  
  public void setImage(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        if (paramString == null) {
          continue;
        }
        this.a.setImageBitmap(paramString);
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TMMCoverView", 2, null, paramString);
        }
        return;
      }
      finally
      {
        if (0 != 0) {
          this.a.setImageBitmap(null);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediaplay\TMMCoverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */