package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

public class DraweeView<DH extends DraweeHierarchy>
  extends ImageView
{
  private DraweeHolder<DH> mDraweeHolder;
  private boolean mInitialised = false;
  
  public DraweeView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    if (this.mInitialised) {
      return;
    }
    this.mInitialised = true;
    this.mDraweeHolder = DraweeHolder.create(null, paramContext);
  }
  
  @Nullable
  public DraweeController getController()
  {
    return this.mDraweeHolder.getController();
  }
  
  public DH getHierarchy()
  {
    return this.mDraweeHolder.getHierarchy();
  }
  
  @Nullable
  public Drawable getTopLevelDrawable()
  {
    return this.mDraweeHolder.getTopLevelDrawable();
  }
  
  public boolean hasController()
  {
    return this.mDraweeHolder.getController() != null;
  }
  
  public boolean hasHierarchy()
  {
    return this.mDraweeHolder.hasHierarchy();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mDraweeHolder.onAttach();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mDraweeHolder.onDetach();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    this.mDraweeHolder.onAttach();
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    this.mDraweeHolder.onDetach();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mDraweeHolder.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setController(@Nullable DraweeController paramDraweeController)
  {
    this.mDraweeHolder.setController(paramDraweeController);
    super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
  }
  
  public void setHierarchy(DH paramDH)
  {
    this.mDraweeHolder.setHierarchy(paramDH);
    super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
  }
  
  @Deprecated
  public void setImageBitmap(Bitmap paramBitmap)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageBitmap(paramBitmap);
  }
  
  @Deprecated
  public void setImageDrawable(Drawable paramDrawable)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setImageResource(int paramInt)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageResource(paramInt);
  }
  
  @Deprecated
  public void setImageURI(Uri paramUri)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageURI(paramUri);
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    if (this.mDraweeHolder != null) {}
    for (String str = this.mDraweeHolder.toString();; str = "<no holder set>") {
      return localToStringHelper.add("holder", str).toString();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\view\DraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */