package com.facebook.csslayout;

import java.util.Arrays;

public class CSSLayout
{
  public static final int DIMENSION_HEIGHT = 1;
  public static final int DIMENSION_WIDTH = 0;
  public static final int POSITION_BOTTOM = 3;
  public static final int POSITION_LEFT = 0;
  public static final int POSITION_RIGHT = 2;
  public static final int POSITION_TOP = 1;
  public float[] dimensions = new float[2];
  public CSSDirection direction = CSSDirection.LTR;
  public float[] position = new float[4];
  
  public void copy(CSSLayout paramCSSLayout)
  {
    this.position[0] = paramCSSLayout.position[0];
    this.position[1] = paramCSSLayout.position[1];
    this.position[2] = paramCSSLayout.position[2];
    this.position[3] = paramCSSLayout.position[3];
    this.dimensions[0] = paramCSSLayout.dimensions[0];
    this.dimensions[1] = paramCSSLayout.dimensions[1];
    this.direction = paramCSSLayout.direction;
  }
  
  public void resetResult()
  {
    Arrays.fill(this.position, 0.0F);
    Arrays.fill(this.dimensions, NaN.0F);
    this.direction = CSSDirection.LTR;
  }
  
  public String toString()
  {
    return "layout: {left: " + this.position[0] + ", " + "top: " + this.position[1] + ", " + "width: " + this.dimensions[0] + ", " + "height: " + this.dimensions[1] + ", " + "direction: " + this.direction + "}";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\csslayout\CSSLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */