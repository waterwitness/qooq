package com.facebook.drawee.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.BaseActivityListener;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

public class DraweeHolder<DH extends DraweeHierarchy>
  implements VisibilityCallback
{
  private final ActivityListener mActivityListener;
  private DraweeController mController = null;
  private final DraweeEventTracker mEventTracker = new DraweeEventTracker();
  private DH mHierarchy;
  private boolean mIsActivityStarted = true;
  private boolean mIsControllerAttached = false;
  private boolean mIsHolderAttached = false;
  private boolean mIsVisible = true;
  
  public DraweeHolder(@Nullable DH paramDH)
  {
    if (paramDH != null) {
      setHierarchy(paramDH);
    }
    this.mActivityListener = new BaseActivityListener()
    {
      public void onStart(Activity paramAnonymousActivity)
      {
        DraweeHolder.this.setActivityStarted(true);
      }
      
      public void onStop(Activity paramAnonymousActivity)
      {
        DraweeHolder.this.setActivityStarted(false);
      }
    };
  }
  
  private void attachController()
  {
    if (this.mIsControllerAttached) {}
    do
    {
      return;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
      this.mIsControllerAttached = true;
    } while ((this.mController == null) || (this.mController.getHierarchy() == null));
    this.mController.onAttach();
  }
  
  private void attachOrDetachController()
  {
    if ((this.mIsHolderAttached) && (this.mIsVisible) && (this.mIsActivityStarted))
    {
      attachController();
      return;
    }
    detachController();
  }
  
  public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(@Nullable DH paramDH, Context paramContext)
  {
    paramDH = new DraweeHolder(paramDH);
    paramDH.registerWithContext(paramContext);
    return paramDH;
  }
  
  private void detachController()
  {
    if (!this.mIsControllerAttached) {}
    do
    {
      return;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
      this.mIsControllerAttached = false;
    } while (this.mController == null);
    this.mController.onDetach();
  }
  
  private void setActivityStarted(boolean paramBoolean)
  {
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramBoolean) {}
    for (DraweeEventTracker.Event localEvent = DraweeEventTracker.Event.ON_ACTIVITY_START;; localEvent = DraweeEventTracker.Event.ON_ACTIVITY_STOP)
    {
      localDraweeEventTracker.recordEvent(localEvent);
      this.mIsActivityStarted = paramBoolean;
      attachOrDetachController();
      return;
    }
  }
  
  private void setVisibilityCallback(@Nullable VisibilityCallback paramVisibilityCallback)
  {
    Drawable localDrawable = getTopLevelDrawable();
    if ((localDrawable instanceof VisibilityAwareDrawable)) {
      ((VisibilityAwareDrawable)localDrawable).setVisibilityCallback(paramVisibilityCallback);
    }
  }
  
  @Nullable
  public DraweeController getController()
  {
    return this.mController;
  }
  
  public DH getHierarchy()
  {
    return (DraweeHierarchy)Preconditions.checkNotNull(this.mHierarchy);
  }
  
  public Drawable getTopLevelDrawable()
  {
    if (this.mHierarchy == null) {
      return null;
    }
    return this.mHierarchy.getTopLevelDrawable();
  }
  
  public boolean hasHierarchy()
  {
    return this.mHierarchy != null;
  }
  
  public void onAttach()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
    this.mIsHolderAttached = true;
    attachOrDetachController();
  }
  
  public void onDetach()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
    this.mIsHolderAttached = false;
    attachOrDetachController();
  }
  
  public void onDraw()
  {
    if (this.mIsControllerAttached) {
      return;
    }
    FLog.wtf(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", new Object[] { Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mController)), toString() });
    this.mIsHolderAttached = true;
    this.mIsVisible = true;
    this.mIsActivityStarted = true;
    attachOrDetachController();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mController == null) {
      return false;
    }
    return this.mController.onTouchEvent(paramMotionEvent);
  }
  
  public void onVisibilityChange(boolean paramBoolean)
  {
    if (this.mIsVisible == paramBoolean) {
      return;
    }
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramBoolean) {}
    for (DraweeEventTracker.Event localEvent = DraweeEventTracker.Event.ON_DRAWABLE_SHOW;; localEvent = DraweeEventTracker.Event.ON_DRAWABLE_HIDE)
    {
      localDraweeEventTracker.recordEvent(localEvent);
      this.mIsVisible = paramBoolean;
      attachOrDetachController();
      return;
    }
  }
  
  public void registerWithContext(Context paramContext) {}
  
  public void setController(@Nullable DraweeController paramDraweeController)
  {
    boolean bool = this.mIsControllerAttached;
    if (bool) {
      detachController();
    }
    if (this.mController != null)
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
      this.mController.setHierarchy(null);
    }
    this.mController = paramDraweeController;
    if (this.mController != null)
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
      this.mController.setHierarchy(this.mHierarchy);
    }
    for (;;)
    {
      if (bool) {
        attachController();
      }
      return;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
    }
  }
  
  public void setHierarchy(DH paramDH)
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
    setVisibilityCallback(null);
    this.mHierarchy = ((DraweeHierarchy)Preconditions.checkNotNull(paramDH));
    onVisibilityChange(this.mHierarchy.getTopLevelDrawable().isVisible());
    setVisibilityCallback(this);
    if (this.mController != null) {
      this.mController.setHierarchy(paramDH);
    }
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("activityStarted", this.mIsActivityStarted).add("events", this.mEventTracker.toString()).toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\view\DraweeHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */