package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.widget.ProgressBar;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactProp;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class ProgressBarShadowNode
  extends LayoutShadowNode
  implements CSSNode.MeasureFunction
{
  private final SparseIntArray mHeight = new SparseIntArray();
  private final Set<Integer> mMeasured = new HashSet();
  private String mStyle = "Large";
  private final SparseIntArray mWidth = new SparseIntArray();
  
  public ProgressBarShadowNode()
  {
    setMeasureFunction(this);
  }
  
  @Nullable
  public String getStyle()
  {
    return this.mStyle;
  }
  
  public void measure(CSSNode paramCSSNode, float paramFloat, MeasureOutput paramMeasureOutput)
  {
    int i = ReactProgressBarViewManager.getStyleFromString(getStyle());
    if (!this.mMeasured.contains(Integer.valueOf(i)))
    {
      paramCSSNode = new ProgressBar(getThemedContext(), null, i);
      int j = View.MeasureSpec.makeMeasureSpec(-2, 0);
      paramCSSNode.measure(j, j);
      this.mHeight.put(i, paramCSSNode.getMeasuredHeight());
      this.mWidth.put(i, paramCSSNode.getMeasuredWidth());
      this.mMeasured.add(Integer.valueOf(i));
    }
    paramMeasureOutput.height = this.mHeight.get(i);
    paramMeasureOutput.width = this.mWidth.get(i);
  }
  
  @ReactProp(name="styleAttr")
  public void setStyle(@Nullable String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "Large";
    }
    this.mStyle = str;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\progressbar\ProgressBarShadowNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */