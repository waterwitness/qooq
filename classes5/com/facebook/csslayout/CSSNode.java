package com.facebook.csslayout;

import com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class CSSNode
{
  final CachedCSSLayout lastLayout = new CachedCSSLayout();
  final CSSLayout layout = new CSSLayout();
  public int lineIndex = 0;
  @Nullable
  private ArrayList<CSSNode> mChildren;
  private LayoutState mLayoutState = LayoutState.DIRTY;
  @Nullable
  private MeasureFunction mMeasureFunction = null;
  @Nullable
  private CSSNode mParent;
  CSSNode nextAbsoluteChild;
  CSSNode nextFlexChild;
  final CSSStyle style = new CSSStyle();
  
  private void toStringWithIndentation(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append("__");
      i += 1;
    }
    paramStringBuilder.append(localStringBuilder.toString());
    paramStringBuilder.append(this.layout.toString());
    if (getChildCount() == 0) {
      return;
    }
    paramStringBuilder.append(", children: [\n");
    i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).toStringWithIndentation(paramStringBuilder, paramInt + 1);
      paramStringBuilder.append("\n");
      i += 1;
    }
    paramStringBuilder.append(localStringBuilder + "]");
  }
  
  public void addChildAt(CSSNode paramCSSNode, int paramInt)
  {
    if (paramCSSNode.mParent != null) {
      throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList(4);
    }
    this.mChildren.add(paramInt, paramCSSNode);
    paramCSSNode.mParent = this;
    dirty();
  }
  
  public void calculateLayout(CSSLayoutContext paramCSSLayoutContext)
  {
    this.layout.resetResult();
    LayoutEngine.layoutNode(paramCSSLayoutContext, this, NaN.0F, null);
  }
  
  protected void dirty()
  {
    if (this.mLayoutState == LayoutState.DIRTY) {}
    do
    {
      return;
      if (this.mLayoutState == LayoutState.HAS_NEW_LAYOUT) {
        throw new IllegalStateException("Previous layout was ignored! markLayoutSeen() never called");
      }
      this.mLayoutState = LayoutState.DIRTY;
    } while (this.mParent == null);
    this.mParent.dirty();
  }
  
  public CSSAlign getAlignItems()
  {
    return this.style.alignItems;
  }
  
  public CSSAlign getAlignSelf()
  {
    return this.style.alignSelf;
  }
  
  public Spacing getBorder()
  {
    return this.style.border;
  }
  
  public CSSNode getChildAt(int paramInt)
  {
    Assertions.assertNotNull(this.mChildren);
    return (CSSNode)this.mChildren.get(paramInt);
  }
  
  public int getChildCount()
  {
    if (this.mChildren == null) {
      return 0;
    }
    return this.mChildren.size();
  }
  
  public float getFlex()
  {
    return this.style.flex;
  }
  
  public CSSFlexDirection getFlexDirection()
  {
    return this.style.flexDirection;
  }
  
  public CSSJustify getJustifyContent()
  {
    return this.style.justifyContent;
  }
  
  public CSSDirection getLayoutDirection()
  {
    return this.layout.direction;
  }
  
  public float getLayoutHeight()
  {
    return this.layout.dimensions[1];
  }
  
  public float getLayoutWidth()
  {
    return this.layout.dimensions[0];
  }
  
  public float getLayoutX()
  {
    return this.layout.position[0];
  }
  
  public float getLayoutY()
  {
    return this.layout.position[1];
  }
  
  public Spacing getMargin()
  {
    return this.style.margin;
  }
  
  public Spacing getPadding()
  {
    return this.style.padding;
  }
  
  @Nullable
  public CSSNode getParent()
  {
    return this.mParent;
  }
  
  public float getPositionBottom()
  {
    return this.style.position[3];
  }
  
  public float getPositionLeft()
  {
    return this.style.position[0];
  }
  
  public float getPositionRight()
  {
    return this.style.position[2];
  }
  
  public float getPositionTop()
  {
    return this.style.position[1];
  }
  
  public CSSPositionType getPositionType()
  {
    return this.style.positionType;
  }
  
  public CSSDirection getStyleDirection()
  {
    return this.style.direction;
  }
  
  public float getStyleHeight()
  {
    return this.style.dimensions[1];
  }
  
  public float getStyleWidth()
  {
    return this.style.dimensions[0];
  }
  
  public boolean hasNewLayout()
  {
    return this.mLayoutState == LayoutState.HAS_NEW_LAYOUT;
  }
  
  public int indexOf(CSSNode paramCSSNode)
  {
    Assertions.assertNotNull(this.mChildren);
    return this.mChildren.indexOf(paramCSSNode);
  }
  
  protected boolean isDirty()
  {
    return this.mLayoutState == LayoutState.DIRTY;
  }
  
  public boolean isMeasureDefined()
  {
    return this.mMeasureFunction != null;
  }
  
  void markHasNewLayout()
  {
    this.mLayoutState = LayoutState.HAS_NEW_LAYOUT;
  }
  
  public void markLayoutSeen()
  {
    if (!hasNewLayout()) {
      throw new IllegalStateException("Expected node to have a new layout to be seen!");
    }
    this.mLayoutState = LayoutState.UP_TO_DATE;
  }
  
  MeasureOutput measure(MeasureOutput paramMeasureOutput, float paramFloat)
  {
    if (!isMeasureDefined()) {
      throw new RuntimeException("Measure function isn't defined!");
    }
    paramMeasureOutput.height = NaN.0F;
    paramMeasureOutput.width = NaN.0F;
    ((MeasureFunction)Assertions.assertNotNull(this.mMeasureFunction)).measure(this, paramFloat, paramMeasureOutput);
    return paramMeasureOutput;
  }
  
  public CSSNode removeChildAt(int paramInt)
  {
    Assertions.assertNotNull(this.mChildren);
    CSSNode localCSSNode = (CSSNode)this.mChildren.remove(paramInt);
    localCSSNode.mParent = null;
    dirty();
    return localCSSNode;
  }
  
  public void reset()
  {
    if ((this.mParent != null) || ((this.mChildren != null) && (this.mChildren.size() > 0))) {
      throw new IllegalStateException("You should not reset an attached CSSNode");
    }
    this.style.reset();
    this.layout.resetResult();
    this.lineIndex = 0;
    this.mLayoutState = LayoutState.DIRTY;
  }
  
  public void setAlignItems(CSSAlign paramCSSAlign)
  {
    if (this.style.alignItems != paramCSSAlign)
    {
      this.style.alignItems = paramCSSAlign;
      dirty();
    }
  }
  
  public void setAlignSelf(CSSAlign paramCSSAlign)
  {
    if (this.style.alignSelf != paramCSSAlign)
    {
      this.style.alignSelf = paramCSSAlign;
      dirty();
    }
  }
  
  public void setBorder(int paramInt, float paramFloat)
  {
    if (this.style.border.set(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setDefaultPadding(int paramInt, float paramFloat)
  {
    if (this.style.padding.setDefault(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setDirection(CSSDirection paramCSSDirection)
  {
    if (this.style.direction != paramCSSDirection)
    {
      this.style.direction = paramCSSDirection;
      dirty();
    }
  }
  
  public void setFlex(float paramFloat)
  {
    if (!valuesEqual(this.style.flex, paramFloat))
    {
      this.style.flex = paramFloat;
      dirty();
    }
  }
  
  public void setFlexDirection(CSSFlexDirection paramCSSFlexDirection)
  {
    if (this.style.flexDirection != paramCSSFlexDirection)
    {
      this.style.flexDirection = paramCSSFlexDirection;
      dirty();
    }
  }
  
  public void setJustifyContent(CSSJustify paramCSSJustify)
  {
    if (this.style.justifyContent != paramCSSJustify)
    {
      this.style.justifyContent = paramCSSJustify;
      dirty();
    }
  }
  
  public void setMargin(int paramInt, float paramFloat)
  {
    if (this.style.margin.set(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setMeasureFunction(MeasureFunction paramMeasureFunction)
  {
    if (this.mMeasureFunction != paramMeasureFunction)
    {
      this.mMeasureFunction = paramMeasureFunction;
      dirty();
    }
  }
  
  public void setPadding(int paramInt, float paramFloat)
  {
    if (this.style.padding.set(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setPositionBottom(float paramFloat)
  {
    if (!valuesEqual(this.style.position[3], paramFloat))
    {
      this.style.position[3] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionLeft(float paramFloat)
  {
    if (!valuesEqual(this.style.position[0], paramFloat))
    {
      this.style.position[0] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionRight(float paramFloat)
  {
    if (!valuesEqual(this.style.position[2], paramFloat))
    {
      this.style.position[2] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionTop(float paramFloat)
  {
    if (!valuesEqual(this.style.position[1], paramFloat))
    {
      this.style.position[1] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionType(CSSPositionType paramCSSPositionType)
  {
    if (this.style.positionType != paramCSSPositionType)
    {
      this.style.positionType = paramCSSPositionType;
      dirty();
    }
  }
  
  public void setStyleHeight(float paramFloat)
  {
    if (!valuesEqual(this.style.dimensions[1], paramFloat))
    {
      this.style.dimensions[1] = paramFloat;
      dirty();
    }
  }
  
  public void setStyleWidth(float paramFloat)
  {
    if (!valuesEqual(this.style.dimensions[0], paramFloat))
    {
      this.style.dimensions[0] = paramFloat;
      dirty();
    }
  }
  
  public void setWrap(CSSWrap paramCSSWrap)
  {
    if (this.style.flexWrap != paramCSSWrap)
    {
      this.style.flexWrap = paramCSSWrap;
      dirty();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    toStringWithIndentation(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  protected boolean valuesEqual(float paramFloat1, float paramFloat2)
  {
    return FloatUtil.floatsEqual(paramFloat1, paramFloat2);
  }
  
  private static enum LayoutState
  {
    DIRTY,  HAS_NEW_LAYOUT,  UP_TO_DATE;
    
    private LayoutState() {}
  }
  
  public static abstract interface MeasureFunction
  {
    public abstract void measure(CSSNode paramCSSNode, float paramFloat, MeasureOutput paramMeasureOutput);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\csslayout\CSSNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */