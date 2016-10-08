package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;

public class TouchTargetHelper
{
  private static final float[] mEventCoords = new float[2];
  private static final Matrix mInverseMatrix = new Matrix();
  private static final float[] mMatrixTransformCoords;
  private static final PointF mTempPoint = new PointF();
  
  static
  {
    mMatrixTransformCoords = new float[2];
  }
  
  private static View findClosestReactAncestor(View paramView)
  {
    while ((paramView != null) && (paramView.getId() <= 0)) {
      paramView = (View)paramView.getParent();
    }
    return paramView;
  }
  
  public static int findTargetTagAndCoordinatesForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, float[] paramArrayOfFloat)
  {
    UiThreadUtil.assertOnUiThread();
    int j = paramViewGroup.getId();
    paramArrayOfFloat[0] = paramFloat1;
    paramArrayOfFloat[1] = paramFloat2;
    paramViewGroup = findTouchTargetView(paramArrayOfFloat, paramViewGroup);
    int i = j;
    if (paramViewGroup != null)
    {
      paramViewGroup = findClosestReactAncestor(paramViewGroup);
      i = j;
      if (paramViewGroup != null) {
        i = getTouchTargetForView(paramViewGroup, paramArrayOfFloat[0], paramArrayOfFloat[1]);
      }
    }
    return i;
  }
  
  public static int findTargetTagForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    return findTargetTagAndCoordinatesForTouch(paramFloat1, paramFloat2, paramViewGroup, mEventCoords);
  }
  
  private static View findTouchTargetView(float[] paramArrayOfFloat, ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      PointF localPointF = mTempPoint;
      if (isTransformedTouchPointInView(paramArrayOfFloat[0], paramArrayOfFloat[1], paramViewGroup, localView, localPointF))
      {
        float f1 = paramArrayOfFloat[0];
        float f2 = paramArrayOfFloat[1];
        paramArrayOfFloat[0] = localPointF.x;
        paramArrayOfFloat[1] = localPointF.y;
        localView = findTouchTargetViewWithPointerEvents(paramArrayOfFloat, localView);
        if (localView != null) {
          return localView;
        }
        paramArrayOfFloat[0] = f1;
        paramArrayOfFloat[1] = f2;
      }
      i -= 1;
    }
    return paramViewGroup;
  }
  
  @Nullable
  private static View findTouchTargetViewWithPointerEvents(float[] paramArrayOfFloat, View paramView)
  {
    PointerEvents localPointerEvents;
    if ((paramView instanceof ReactPointerEventsView))
    {
      localPointerEvents = ((ReactPointerEventsView)paramView).getPointerEvents();
      if (localPointerEvents != PointerEvents.NONE) {
        break label33;
      }
    }
    label33:
    do
    {
      return null;
      localPointerEvents = PointerEvents.AUTO;
      break;
      if (localPointerEvents == PointerEvents.BOX_ONLY) {
        return paramView;
      }
      if (localPointerEvents != PointerEvents.BOX_NONE) {
        break label77;
      }
    } while (!(paramView instanceof ViewGroup));
    paramArrayOfFloat = findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
    if (paramArrayOfFloat != paramView) {}
    for (;;)
    {
      return paramArrayOfFloat;
      paramArrayOfFloat = null;
    }
    label77:
    if (localPointerEvents == PointerEvents.AUTO)
    {
      if ((paramView instanceof ViewGroup)) {
        return findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
      }
      return paramView;
    }
    throw new JSApplicationIllegalArgumentException("Unknown pointer event type: " + localPointerEvents.toString());
  }
  
  private static int getTouchTargetForView(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof ReactCompoundView)) {
      return ((ReactCompoundView)paramView).reactTagForTouch(paramFloat1, paramFloat2);
    }
    return paramView.getId();
  }
  
  private static boolean isTransformedTouchPointInView(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, View paramView, PointF paramPointF)
  {
    float f1 = paramViewGroup.getScrollX() + paramFloat1 - paramView.getLeft();
    float f2 = paramViewGroup.getScrollY() + paramFloat2 - paramView.getTop();
    paramViewGroup = paramView.getMatrix();
    paramFloat2 = f1;
    paramFloat1 = f2;
    if (!paramViewGroup.isIdentity())
    {
      float[] arrayOfFloat = mMatrixTransformCoords;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f2;
      Matrix localMatrix = mInverseMatrix;
      paramViewGroup.invert(localMatrix);
      localMatrix.mapPoints(arrayOfFloat);
      paramFloat2 = arrayOfFloat[0];
      paramFloat1 = arrayOfFloat[1];
    }
    if ((paramFloat2 >= 0.0F) && (paramFloat2 < paramView.getRight() - paramView.getLeft()) && (paramFloat1 >= 0.0F) && (paramFloat1 < paramView.getBottom() - paramView.getTop()))
    {
      paramPointF.set(paramFloat2, paramFloat1);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\TouchTargetHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */