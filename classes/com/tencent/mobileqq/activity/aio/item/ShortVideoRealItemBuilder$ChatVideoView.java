package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.net.URL;

public class ShortVideoRealItemBuilder$ChatVideoView
  extends BubbleImageView
{
  URLDrawable a;
  public URLDrawable b;
  
  public ShortVideoRealItemBuilder$ChatVideoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(String paramString)
  {
    return (this.b == null) || (!this.b.getURL().getPath().equals(paramString));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.a)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.a) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null)
    {
      this.a.setURLDrawableListener(null);
      this.a = null;
    }
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.b != paramURLDrawable) {
      this.b = paramURLDrawable;
    }
  }
  
  public void setVideoDrawable(URLDrawable paramURLDrawable)
  {
    if (this.a != null) {
      this.a.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.a = paramURLDrawable;
    paramURLDrawable.startDownload();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ShortVideoRealItemBuilder$ChatVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */