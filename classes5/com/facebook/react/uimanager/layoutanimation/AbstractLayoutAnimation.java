package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Map;
import javax.annotation.Nullable;

abstract class AbstractLayoutAnimation
{
  private static final Map<InterpolatorType, Interpolator> INTERPOLATOR = MapBuilder.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator(), InterpolatorType.SPRING, new SimpleSpringInterpolator());
  private static final boolean SLOWDOWN_ANIMATION_MODE = false;
  @Nullable
  protected AnimatedPropertyType mAnimatedProperty;
  private int mDelayMs;
  protected int mDurationMs;
  @Nullable
  private Interpolator mInterpolator;
  
  private static Interpolator getInterpolator(InterpolatorType paramInterpolatorType)
  {
    Interpolator localInterpolator = (Interpolator)INTERPOLATOR.get(paramInterpolatorType);
    if (localInterpolator == null) {
      throw new IllegalArgumentException("Missing interpolator for type : " + paramInterpolatorType);
    }
    return localInterpolator;
  }
  
  @Nullable
  public final Animation createAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!isValid()) {
      paramView = null;
    }
    Animation localAnimation;
    do
    {
      return paramView;
      localAnimation = createAnimationImpl(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      paramView = localAnimation;
    } while (localAnimation == null);
    localAnimation.setDuration(this.mDurationMs * 1);
    localAnimation.setStartOffset(this.mDelayMs * 1);
    localAnimation.setInterpolator(this.mInterpolator);
    return localAnimation;
  }
  
  @Nullable
  abstract Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void initializeFromConfig(ReadableMap paramReadableMap, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramReadableMap.hasKey("property"))
    {
      localObject1 = AnimatedPropertyType.fromString(paramReadableMap.getString("property"));
      this.mAnimatedProperty = ((AnimatedPropertyType)localObject1);
      if (paramReadableMap.hasKey("duration")) {
        paramInt = paramReadableMap.getInt("duration");
      }
      this.mDurationMs = paramInt;
      if (!paramReadableMap.hasKey("delay")) {
        break label154;
      }
    }
    label154:
    for (paramInt = paramReadableMap.getInt("delay");; paramInt = 0)
    {
      this.mDelayMs = paramInt;
      localObject1 = localObject2;
      if (paramReadableMap.hasKey("type")) {
        localObject1 = getInterpolator(InterpolatorType.fromString(paramReadableMap.getString("type")));
      }
      this.mInterpolator = ((Interpolator)localObject1);
      if (isValid()) {
        return;
      }
      throw new IllegalViewOperationException("Invalid layout animation : " + paramReadableMap);
      localObject1 = null;
      break;
    }
  }
  
  abstract boolean isValid();
  
  public void reset()
  {
    this.mAnimatedProperty = null;
    this.mDurationMs = 0;
    this.mDelayMs = 0;
    this.mInterpolator = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\AbstractLayoutAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */