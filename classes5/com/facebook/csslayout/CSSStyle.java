package com.facebook.csslayout;

import java.util.Arrays;

public class CSSStyle
{
  public CSSAlign alignContent;
  public CSSAlign alignItems;
  public CSSAlign alignSelf;
  public Spacing border = new Spacing();
  public float[] dimensions = new float[2];
  public CSSDirection direction;
  public float flex;
  public CSSFlexDirection flexDirection;
  public CSSWrap flexWrap;
  public CSSJustify justifyContent;
  public Spacing margin = new Spacing();
  public float maxHeight = NaN.0F;
  public float maxWidth = NaN.0F;
  public float minHeight = NaN.0F;
  public float minWidth = NaN.0F;
  public Spacing padding = new Spacing();
  public float[] position = new float[4];
  public CSSPositionType positionType;
  
  CSSStyle()
  {
    reset();
  }
  
  void reset()
  {
    this.direction = CSSDirection.INHERIT;
    this.flexDirection = CSSFlexDirection.COLUMN;
    this.justifyContent = CSSJustify.FLEX_START;
    this.alignContent = CSSAlign.FLEX_START;
    this.alignItems = CSSAlign.STRETCH;
    this.alignSelf = CSSAlign.AUTO;
    this.positionType = CSSPositionType.RELATIVE;
    this.flexWrap = CSSWrap.NOWRAP;
    this.flex = 0.0F;
    this.margin.reset();
    this.padding.reset();
    this.border.reset();
    Arrays.fill(this.position, NaN.0F);
    Arrays.fill(this.dimensions, NaN.0F);
    this.minWidth = NaN.0F;
    this.minHeight = NaN.0F;
    this.maxWidth = NaN.0F;
    this.maxHeight = NaN.0F;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\csslayout\CSSStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */