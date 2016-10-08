package com.facebook.react.views.textinput;

import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.csslayout.Spacing;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import javax.annotation.Nullable;

@VisibleForTesting
public class ReactTextInputShadowNode
  extends ReactTextShadowNode
  implements CSSNode.MeasureFunction
{
  private static final int MEASURE_SPEC = View.MeasureSpec.makeMeasureSpec(-2, 0);
  @Nullable
  private float[] mComputedPadding;
  @Nullable
  private EditText mEditText;
  private int mJsEventCount = -1;
  
  public ReactTextInputShadowNode()
  {
    super(false);
    setMeasureFunction(this);
  }
  
  private static float[] spacingToFloatArray(Spacing paramSpacing)
  {
    return new float[] { paramSpacing.get(0), paramSpacing.get(1), paramSpacing.get(2), paramSpacing.get(3) };
  }
  
  public void measure(CSSNode paramCSSNode, float paramFloat, MeasureOutput paramMeasureOutput)
  {
    paramCSSNode = null;
    if (this.mEditText != null) {
      paramCSSNode = (EditText)Assertions.assertNotNull(this.mEditText);
    }
    paramMeasureOutput.width = paramFloat;
    if (paramCSSNode != null)
    {
      if (this.mFontSize == -1) {}
      for (paramFloat = (int)Math.ceil(PixelUtil.toPixelFromSP(14.0F));; paramFloat = this.mFontSize)
      {
        paramCSSNode.setTextSize(0, paramFloat);
        this.mComputedPadding = spacingToFloatArray(getPadding());
        paramCSSNode.setPadding((int)Math.ceil(getPadding().get(0)), (int)Math.ceil(getPadding().get(1)), (int)Math.ceil(getPadding().get(2)), (int)Math.ceil(getPadding().get(3)));
        if (this.mNumberOfLines != -1) {
          paramCSSNode.setLines(this.mNumberOfLines);
        }
        paramCSSNode.measure(MEASURE_SPEC, MEASURE_SPEC);
        paramMeasureOutput.height = paramCSSNode.getMeasuredHeight();
        return;
      }
    }
    paramMeasureOutput.height = 100.0F;
  }
  
  public void onBeforeLayout() {}
  
  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    super.onCollectExtraUpdates(paramUIViewOperationQueue);
    if (this.mComputedPadding != null)
    {
      paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), this.mComputedPadding);
      this.mComputedPadding = null;
    }
    if (this.mJsEventCount != -1)
    {
      ReactTextUpdate localReactTextUpdate = new ReactTextUpdate(fromTextCSSNode(this), this.mJsEventCount, this.mContainsImages);
      paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), localReactTextUpdate);
    }
  }
  
  @ReactProp(name="mostRecentEventCount")
  public void setMostRecentEventCount(int paramInt)
  {
    this.mJsEventCount = paramInt;
  }
  
  public void setPadding(int paramInt, float paramFloat)
  {
    super.setPadding(paramInt, paramFloat);
    this.mComputedPadding = spacingToFloatArray(getPadding());
    markUpdated();
  }
  
  protected void setThemedContext(ThemedReactContext paramThemedReactContext)
  {
    super.setThemedContext(paramThemedReactContext);
    try
    {
      this.mEditText = new EditText(getThemedContext());
      if (this.mEditText != null)
      {
        this.mEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        setDefaultPadding(0, this.mEditText.getPaddingLeft());
        setDefaultPadding(1, this.mEditText.getPaddingTop());
        setDefaultPadding(2, this.mEditText.getPaddingRight());
        setDefaultPadding(3, this.mEditText.getPaddingBottom());
      }
      this.mComputedPadding = spacingToFloatArray(getPadding());
      return;
    }
    catch (Throwable paramThemedReactContext)
    {
      for (;;)
      {
        paramThemedReactContext.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\textinput\ReactTextInputShadowNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */