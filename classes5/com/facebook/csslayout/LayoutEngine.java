package com.facebook.csslayout;

public class LayoutEngine
{
  private static final int CSS_FLEX_DIRECTION_COLUMN = CSSFlexDirection.COLUMN.ordinal();
  private static final int CSS_FLEX_DIRECTION_COLUMN_REVERSE = CSSFlexDirection.COLUMN_REVERSE.ordinal();
  private static final int CSS_FLEX_DIRECTION_ROW = CSSFlexDirection.ROW.ordinal();
  private static final int CSS_FLEX_DIRECTION_ROW_REVERSE = CSSFlexDirection.ROW_REVERSE.ordinal();
  private static final int CSS_POSITION_ABSOLUTE;
  private static final int CSS_POSITION_RELATIVE = CSSPositionType.RELATIVE.ordinal();
  private static final int[] dim = { 1, 1, 0, 0 };
  private static final int[] leading;
  private static final int[] leadingSpacing = { 1, 3, 6, 6 };
  private static final int[] pos;
  private static final int[] trailing;
  private static final int[] trailingSpacing = { 3, 1, 7, 7 };
  
  static
  {
    CSS_POSITION_ABSOLUTE = CSSPositionType.ABSOLUTE.ordinal();
    leading = new int[] { 1, 3, 0, 2 };
    trailing = new int[] { 3, 1, 2, 0 };
    pos = new int[] { 1, 3, 0, 2 };
  }
  
  private static float boundAxis(CSSNode paramCSSNode, int paramInt, float paramFloat)
  {
    float f1 = NaN.0F;
    float f2 = NaN.0F;
    if ((paramInt == CSS_FLEX_DIRECTION_COLUMN) || (paramInt == CSS_FLEX_DIRECTION_COLUMN_REVERSE)) {
      f1 = paramCSSNode.style.minHeight;
    }
    for (f2 = paramCSSNode.style.maxHeight;; f2 = paramCSSNode.style.maxWidth)
    {
      do
      {
        float f3 = paramFloat;
        paramFloat = f3;
        if (!Float.isNaN(f2))
        {
          paramFloat = f3;
          if (f2 >= 0.0D)
          {
            paramFloat = f3;
            if (f3 > f2) {
              paramFloat = f2;
            }
          }
        }
        f2 = paramFloat;
        if (!Float.isNaN(f1))
        {
          f2 = paramFloat;
          if (f1 >= 0.0D)
          {
            f2 = paramFloat;
            if (paramFloat < f1) {
              f2 = f1;
            }
          }
        }
        return f2;
      } while ((paramInt != CSS_FLEX_DIRECTION_ROW) && (paramInt != CSS_FLEX_DIRECTION_ROW_REVERSE));
      f1 = paramCSSNode.style.minWidth;
    }
  }
  
  private static CSSAlign getAlignItem(CSSNode paramCSSNode1, CSSNode paramCSSNode2)
  {
    if (paramCSSNode2.style.alignSelf != CSSAlign.AUTO) {
      return paramCSSNode2.style.alignSelf;
    }
    return paramCSSNode1.style.alignItems;
  }
  
  private static int getCrossFlexDirection(int paramInt, CSSDirection paramCSSDirection)
  {
    if ((paramInt == CSS_FLEX_DIRECTION_COLUMN) || (paramInt == CSS_FLEX_DIRECTION_COLUMN_REVERSE)) {
      return resolveAxis(CSS_FLEX_DIRECTION_ROW, paramCSSDirection);
    }
    return CSS_FLEX_DIRECTION_COLUMN;
  }
  
  private static int getFlexDirection(CSSNode paramCSSNode)
  {
    return paramCSSNode.style.flexDirection.ordinal();
  }
  
  private static float getRelativePosition(CSSNode paramCSSNode, int paramInt)
  {
    float f = paramCSSNode.style.position[leading[paramInt]];
    if (!Float.isNaN(f)) {
      return f;
    }
    f = paramCSSNode.style.position[trailing[paramInt]];
    if (Float.isNaN(f)) {}
    for (f = 0.0F;; f = -f) {
      return f;
    }
  }
  
  private static boolean isMeasureDefined(CSSNode paramCSSNode)
  {
    return paramCSSNode.isMeasureDefined();
  }
  
  static void layoutNode(CSSLayoutContext paramCSSLayoutContext, CSSNode paramCSSNode, float paramFloat, CSSDirection paramCSSDirection)
  {
    if (needsRelayout(paramCSSNode, paramFloat))
    {
      paramCSSNode.lastLayout.requestedWidth = paramCSSNode.layout.dimensions[0];
      paramCSSNode.lastLayout.requestedHeight = paramCSSNode.layout.dimensions[1];
      paramCSSNode.lastLayout.parentMaxWidth = paramFloat;
      layoutNodeImpl(paramCSSLayoutContext, paramCSSNode, paramFloat, paramCSSDirection);
      paramCSSNode.lastLayout.copy(paramCSSNode.layout);
    }
    for (;;)
    {
      paramCSSNode.markHasNewLayout();
      return;
      paramCSSNode.layout.copy(paramCSSNode.lastLayout);
    }
  }
  
  private static void layoutNodeImpl(CSSLayoutContext paramCSSLayoutContext, CSSNode paramCSSNode, float paramFloat, CSSDirection paramCSSDirection)
  {
    int i = 0;
    int j = paramCSSNode.getChildCount();
    while (i < j)
    {
      paramCSSNode.getChildAt(i).layout.resetResult();
      i += 1;
    }
    CSSDirection localCSSDirection = resolveDirection(paramCSSNode, paramCSSDirection);
    int i15 = resolveAxis(getFlexDirection(paramCSSNode), localCSSDirection);
    int i16 = getCrossFlexDirection(i15, localCSSDirection);
    int i17 = resolveAxis(CSS_FLEX_DIRECTION_ROW, localCSSDirection);
    setDimensionFromStyle(paramCSSNode, i15);
    setDimensionFromStyle(paramCSSNode, i16);
    paramCSSNode.layout.direction = localCSSDirection;
    paramCSSDirection = paramCSSNode.layout.position;
    i = leading[i15];
    paramCSSDirection[i] += paramCSSNode.style.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + getRelativePosition(paramCSSNode, i15);
    paramCSSDirection = paramCSSNode.layout.position;
    i = trailing[i15];
    paramCSSDirection[i] += paramCSSNode.style.margin.getWithFallback(trailingSpacing[i15], trailing[i15]) + getRelativePosition(paramCSSNode, i15);
    paramCSSDirection = paramCSSNode.layout.position;
    i = leading[i16];
    paramCSSDirection[i] += paramCSSNode.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + getRelativePosition(paramCSSNode, i16);
    paramCSSDirection = paramCSSNode.layout.position;
    i = trailing[i16];
    paramCSSDirection[i] += paramCSSNode.style.margin.getWithFallback(trailingSpacing[i16], trailing[i16]) + getRelativePosition(paramCSSNode, i16);
    int i5 = paramCSSNode.getChildCount();
    float f15 = paramCSSNode.style.padding.getWithFallback(leadingSpacing[i17], leading[i17]) + paramCSSNode.style.border.getWithFallback(leadingSpacing[i17], leading[i17]) + (paramCSSNode.style.padding.getWithFallback(trailingSpacing[i17], trailing[i17]) + paramCSSNode.style.border.getWithFallback(trailingSpacing[i17], trailing[i17]));
    float f1;
    if (isMeasureDefined(paramCSSNode)) {
      if (!Float.isNaN(paramCSSNode.layout.dimensions[dim[i17]]))
      {
        i = 1;
        if ((Float.isNaN(paramCSSNode.style.dimensions[dim[i17]])) || (paramCSSNode.style.dimensions[dim[i17]] < 0.0D)) {
          break label780;
        }
        f1 = paramCSSNode.style.dimensions[0];
        label491:
        if (((!Float.isNaN(paramCSSNode.style.dimensions[dim[i17]])) && (paramCSSNode.style.dimensions[dim[i17]] >= 0.0D)) || (i != 0)) {
          break label856;
        }
        i = 1;
        label539:
        if (((!Float.isNaN(paramCSSNode.style.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]])) && (paramCSSNode.style.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]] >= 0.0D)) || (!Float.isNaN(paramCSSNode.layout.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]]))) {
          break label862;
        }
        j = 1;
        label605:
        if ((i != 0) || (j != 0))
        {
          paramCSSDirection = paramCSSNode.measure(paramCSSLayoutContext.measureOutput, f1 - f15);
          if (i != 0) {
            paramCSSNode.layout.dimensions[0] = (paramCSSDirection.width + f15);
          }
          if (j != 0) {
            paramCSSNode.layout.dimensions[1] = (paramCSSDirection.height + (paramCSSNode.style.padding.getWithFallback(leadingSpacing[CSS_FLEX_DIRECTION_COLUMN], leading[CSS_FLEX_DIRECTION_COLUMN]) + paramCSSNode.style.border.getWithFallback(leadingSpacing[CSS_FLEX_DIRECTION_COLUMN], leading[CSS_FLEX_DIRECTION_COLUMN]) + (paramCSSNode.style.padding.getWithFallback(trailingSpacing[CSS_FLEX_DIRECTION_COLUMN], trailing[CSS_FLEX_DIRECTION_COLUMN]) + paramCSSNode.style.border.getWithFallback(trailingSpacing[CSS_FLEX_DIRECTION_COLUMN], trailing[CSS_FLEX_DIRECTION_COLUMN]))));
          }
        }
        if (i5 != 0) {
          break label868;
        }
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label780:
      if (i != 0)
      {
        f1 = paramCSSNode.layout.dimensions[dim[i17]];
        break label491;
      }
      f1 = paramFloat - (paramCSSNode.style.margin.getWithFallback(leadingSpacing[i17], leading[i17]) + paramCSSNode.style.margin.getWithFallback(trailingSpacing[i17], trailing[i17]));
      break label491;
      label856:
      i = 0;
      break label539;
      label862:
      j = 0;
      break label605;
      label868:
      int i9;
      CSSJustify localCSSJustify;
      float f16;
      float f17;
      float f7;
      float f13;
      float f14;
      int i6;
      label1197:
      int i7;
      label1220:
      int i10;
      label1239:
      Object localObject2;
      Object localObject4;
      float f8;
      int i3;
      float f6;
      float f5;
      int i8;
      if (paramCSSNode.style.flexWrap == CSSWrap.WRAP)
      {
        i9 = 1;
        localCSSJustify = paramCSSNode.style.justifyContent;
        f16 = paramCSSNode.style.padding.getWithFallback(leadingSpacing[i15], leading[i15]);
        f17 = paramCSSNode.style.border.getWithFallback(leadingSpacing[i15], leading[i15]);
        f7 = paramCSSNode.style.padding.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSNode.style.border.getWithFallback(leadingSpacing[i16], leading[i16]);
        f13 = paramCSSNode.style.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + paramCSSNode.style.border.getWithFallback(leadingSpacing[i15], leading[i15]) + (paramCSSNode.style.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + paramCSSNode.style.border.getWithFallback(trailingSpacing[i15], trailing[i15]));
        f14 = paramCSSNode.style.padding.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSNode.style.border.getWithFallback(leadingSpacing[i16], leading[i16]) + (paramCSSNode.style.padding.getWithFallback(trailingSpacing[i16], trailing[i16]) + paramCSSNode.style.border.getWithFallback(trailingSpacing[i16], trailing[i16]));
        if (Float.isNaN(paramCSSNode.layout.dimensions[dim[i15]])) {
          break label2216;
        }
        i6 = 1;
        if (Float.isNaN(paramCSSNode.layout.dimensions[dim[i16]])) {
          break label2222;
        }
        i7 = 1;
        if ((i15 != CSS_FLEX_DIRECTION_ROW) && (i15 != CSS_FLEX_DIRECTION_ROW_REVERSE)) {
          break label2228;
        }
        i10 = 1;
        localObject2 = null;
        localObject4 = null;
        f8 = NaN.0F;
        if (i6 != 0) {
          f8 = paramCSSNode.layout.dimensions[dim[i15]] - f13;
        }
        i = 0;
        k = 0;
        i3 = 0;
        f6 = 0.0F;
        f5 = 0.0F;
        i8 = 0;
      }
      label1339:
      label1348:
      float f4;
      label1394:
      float f3;
      label1725:
      float f2;
      for (;;)
      {
        if (k >= i5) {
          break label5297;
        }
        float f10 = 0.0F;
        int i4 = 0;
        f1 = 0.0F;
        int i1 = 0;
        int n;
        int i11;
        int m;
        Object localObject7;
        float f9;
        int i2;
        int i12;
        Object localObject5;
        Object localObject3;
        Object localObject1;
        int i14;
        int i13;
        CSSAlign localCSSAlign;
        Object localObject6;
        float f11;
        float f12;
        if (((i6 != 0) && (localCSSJustify == CSSJustify.FLEX_START)) || ((i6 == 0) && (localCSSJustify != CSSJustify.CENTER)))
        {
          j = 1;
          if (j == 0) {
            break label2240;
          }
          n = i5;
          i11 = 1;
          m = i5;
          paramCSSDirection = null;
          localObject7 = null;
          f9 = f16 + f17;
          f4 = 0.0F;
          i2 = i;
          i12 = j;
          j = i2;
          i2 = i4;
          localObject5 = localObject4;
          i4 = i3;
          i3 = i4;
          localObject4 = localObject5;
          localObject3 = localObject2;
          localObject1 = paramCSSDirection;
          i14 = i2;
          i13 = i1;
          f3 = f1;
          if (j < i5)
          {
            localObject1 = paramCSSNode.getChildAt(j);
            ((CSSNode)localObject1).lineIndex = i8;
            ((CSSNode)localObject1).nextAbsoluteChild = null;
            ((CSSNode)localObject1).nextFlexChild = null;
            localCSSAlign = getAlignItem(paramCSSNode, (CSSNode)localObject1);
            if ((localCSSAlign != CSSAlign.STRETCH) || (((CSSNode)localObject1).style.positionType != CSSPositionType.RELATIVE) || (i7 == 0) || ((!Float.isNaN(localObject1.style.dimensions[dim[i16]])) && (localObject1.style.dimensions[dim[i16]] >= 0.0D))) {
              break label2247;
            }
            ((CSSNode)localObject1).layout.dimensions[dim[i16]] = Math.max(boundAxis((CSSNode)localObject1, i16, paramCSSNode.layout.dimensions[dim[i16]] - f14 - (((CSSNode)localObject1).style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + ((CSSNode)localObject1).style.margin.getWithFallback(trailingSpacing[i16], trailing[i16]))), ((CSSNode)localObject1).style.padding.getWithFallback(leadingSpacing[i16], leading[i16]) + ((CSSNode)localObject1).style.border.getWithFallback(leadingSpacing[i16], leading[i16]) + (((CSSNode)localObject1).style.padding.getWithFallback(trailingSpacing[i16], trailing[i16]) + ((CSSNode)localObject1).style.border.getWithFallback(trailingSpacing[i16], trailing[i16])));
            localObject3 = localObject2;
            localObject4 = localObject5;
            f3 = 0.0F;
            if ((i6 == 0) || (((CSSNode)localObject1).style.positionType != CSSPositionType.RELATIVE) || (((CSSNode)localObject1).style.flex <= 0.0F)) {
              break label2850;
            }
            i3 = i2 + 1;
            f2 = f1 + ((CSSNode)localObject1).style.flex;
            localObject6 = paramCSSDirection;
            if (paramCSSDirection == null) {
              localObject6 = localObject1;
            }
            if (localObject7 != null) {
              ((CSSNode)localObject7).nextFlexChild = ((CSSNode)localObject1);
            }
            localObject2 = localObject1;
            f3 = ((CSSNode)localObject1).style.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + ((CSSNode)localObject1).style.border.getWithFallback(leadingSpacing[i15], leading[i15]) + (((CSSNode)localObject1).style.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + ((CSSNode)localObject1).style.border.getWithFallback(trailingSpacing[i15], trailing[i15])) + (((CSSNode)localObject1).style.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + ((CSSNode)localObject1).style.margin.getWithFallback(trailingSpacing[i15], trailing[i15]));
            i13 = i1;
            if ((i9 == 0) || (i6 == 0) || (f10 + f3 <= f8) || (j == i)) {
              break label3110;
            }
            i13 -= 1;
            i = 1;
            f3 = f2;
            i14 = i3;
            localObject1 = localObject6;
            i3 = i;
          }
          f11 = 0.0F;
          f12 = 0.0F;
          if (i6 == 0) {
            break label3696;
          }
          f2 = f8 - f10;
        }
        for (;;)
        {
          label2026:
          if (i14 != 0)
          {
            float f18 = f2 / f3;
            paramCSSDirection = (CSSDirection)localObject1;
            for (;;)
            {
              if (paramCSSDirection != null)
              {
                float f19 = paramCSSDirection.style.flex * f18 + (paramCSSDirection.style.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + paramCSSDirection.style.border.getWithFallback(leadingSpacing[i15], leading[i15]) + (paramCSSDirection.style.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + paramCSSDirection.style.border.getWithFallback(trailingSpacing[i15], trailing[i15])));
                float f20 = boundAxis(paramCSSDirection, i15, f19);
                f10 = f2;
                f1 = f3;
                if (f19 != f20)
                {
                  f10 = f2 - f20;
                  f1 = f3 - paramCSSDirection.style.flex;
                }
                paramCSSDirection = paramCSSDirection.nextFlexChild;
                f2 = f10;
                f3 = f1;
                continue;
                i9 = 0;
                break;
                label2216:
                i6 = 0;
                break label1197;
                label2222:
                i7 = 0;
                break label1220;
                label2228:
                i10 = 0;
                break label1239;
                j = 0;
                break label1339;
                label2240:
                n = i;
                break label1348;
                label2247:
                localObject4 = localObject5;
                localObject3 = localObject2;
                if (((CSSNode)localObject1).style.positionType != CSSPositionType.ABSOLUTE) {
                  break label1725;
                }
                localObject6 = localObject2;
                if (localObject2 == null) {
                  localObject6 = localObject1;
                }
                if (localObject5 != null) {
                  ((CSSNode)localObject5).nextAbsoluteChild = ((CSSNode)localObject1);
                }
                localObject2 = localObject1;
                i3 = 0;
                localObject4 = localObject2;
                localObject3 = localObject6;
                if (i3 >= 2) {
                  break label1725;
                }
                label2325:
                float f21;
                float f22;
                if (i3 != 0)
                {
                  i13 = CSS_FLEX_DIRECTION_ROW;
                  if ((!Float.isNaN(paramCSSNode.layout.dimensions[dim[i13]])) && ((Float.isNaN(localObject1.style.dimensions[dim[i13]])) || (localObject1.style.dimensions[dim[i13]] < 0.0D)) && (!Float.isNaN(localObject1.style.position[leading[i13]])) && (!Float.isNaN(localObject1.style.position[trailing[i13]])))
                  {
                    localObject3 = ((CSSNode)localObject1).layout.dimensions;
                    i14 = dim[i13];
                    f11 = paramCSSNode.layout.dimensions[dim[i13]];
                    f12 = paramCSSNode.style.padding.getWithFallback(leadingSpacing[i13], leading[i13]);
                    f18 = paramCSSNode.style.border.getWithFallback(leadingSpacing[i13], leading[i13]);
                    f19 = paramCSSNode.style.padding.getWithFallback(trailingSpacing[i13], trailing[i13]);
                    f20 = paramCSSNode.style.border.getWithFallback(trailingSpacing[i13], trailing[i13]);
                    f21 = ((CSSNode)localObject1).style.margin.getWithFallback(leadingSpacing[i13], leading[i13]);
                    f22 = ((CSSNode)localObject1).style.margin.getWithFallback(trailingSpacing[i13], trailing[i13]);
                    if (!Float.isNaN(localObject1.style.position[leading[i13]])) {
                      break label2810;
                    }
                    f2 = 0.0F;
                    label2633:
                    if (!Float.isNaN(localObject1.style.position[trailing[i13]])) {
                      break label2830;
                    }
                  }
                }
                label2810:
                label2830:
                for (f3 = 0.0F;; f3 = localObject1.style.position[trailing[i13]])
                {
                  localObject3[i14] = Math.max(boundAxis((CSSNode)localObject1, i13, f11 - (f12 + f18 + (f19 + f20)) - (f21 + f22) - f2 - f3), ((CSSNode)localObject1).style.padding.getWithFallback(leadingSpacing[i13], leading[i13]) + ((CSSNode)localObject1).style.border.getWithFallback(leadingSpacing[i13], leading[i13]) + (((CSSNode)localObject1).style.padding.getWithFallback(trailingSpacing[i13], trailing[i13]) + ((CSSNode)localObject1).style.border.getWithFallback(trailingSpacing[i13], trailing[i13])));
                  i3 += 1;
                  break;
                  i13 = CSS_FLEX_DIRECTION_COLUMN;
                  break label2325;
                  f2 = localObject1.style.position[leading[i13]];
                  break label2633;
                }
                label2850:
                f2 = NaN.0F;
                if (i10 == 0) {
                  if ((Float.isNaN(paramCSSNode.style.dimensions[dim[i17]])) || (paramCSSNode.style.dimensions[dim[i17]] < 0.0D)) {
                    break label3055;
                  }
                }
                label3055:
                for (f2 = paramCSSNode.layout.dimensions[dim[i17]] - f15;; f2 = paramFloat - (paramCSSNode.style.margin.getWithFallback(leadingSpacing[i17], leading[i17]) + paramCSSNode.style.margin.getWithFallback(trailingSpacing[i17], trailing[i17])) - f15)
                {
                  if (i4 == 0) {
                    layoutNode(paramCSSLayoutContext, (CSSNode)localObject1, f2, localCSSDirection);
                  }
                  localObject2 = localObject7;
                  localObject6 = paramCSSDirection;
                  i3 = i2;
                  i13 = i1;
                  f2 = f1;
                  if (((CSSNode)localObject1).style.positionType != CSSPositionType.RELATIVE) {
                    break;
                  }
                  i13 = i1 + 1;
                  f3 = localObject1.layout.dimensions[dim[i15]] + ((CSSNode)localObject1).style.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + ((CSSNode)localObject1).style.margin.getWithFallback(trailingSpacing[i15], trailing[i15]);
                  localObject2 = localObject7;
                  localObject6 = paramCSSDirection;
                  i3 = i2;
                  f2 = f1;
                  break;
                }
                label3110:
                i2 = n;
                i1 = i12;
                if (i12 != 0) {
                  if (((CSSNode)localObject1).style.positionType == CSSPositionType.RELATIVE)
                  {
                    i2 = n;
                    i1 = i12;
                    if (((CSSNode)localObject1).style.positionType == CSSPositionType.RELATIVE)
                    {
                      i2 = n;
                      i1 = i12;
                      if (((CSSNode)localObject1).style.flex <= 0.0F) {}
                    }
                  }
                  else
                  {
                    i1 = 0;
                    i2 = j;
                  }
                }
                n = m;
                i12 = i11;
                if (i11 != 0) {
                  if ((((CSSNode)localObject1).style.positionType == CSSPositionType.RELATIVE) && ((localCSSAlign == CSSAlign.STRETCH) || (localCSSAlign == CSSAlign.FLEX_START)))
                  {
                    n = m;
                    i12 = i11;
                    if (!Float.isNaN(localObject1.layout.dimensions[dim[i16]])) {}
                  }
                  else
                  {
                    i12 = 0;
                    n = j;
                  }
                }
                f11 = f4;
                f1 = f9;
                if (i1 != 0)
                {
                  paramCSSDirection = ((CSSNode)localObject1).layout.position;
                  k = pos[i15];
                  paramCSSDirection[k] += f9;
                  if (i6 != 0) {
                    ((CSSNode)localObject1).layout.position[trailing[i15]] = (paramCSSNode.layout.dimensions[dim[i15]] - localObject1.layout.dimensions[dim[i15]] - localObject1.layout.position[pos[i15]]);
                  }
                  f1 = f9 + (localObject1.layout.dimensions[dim[i15]] + ((CSSNode)localObject1).style.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + ((CSSNode)localObject1).style.margin.getWithFallback(trailingSpacing[i15], trailing[i15]));
                  f11 = Math.max(f4, boundAxis((CSSNode)localObject1, i16, localObject1.layout.dimensions[dim[i16]] + ((CSSNode)localObject1).style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + ((CSSNode)localObject1).style.margin.getWithFallback(trailingSpacing[i16], trailing[i16])));
                }
                if (i12 != 0)
                {
                  paramCSSDirection = ((CSSNode)localObject1).layout.position;
                  k = pos[i16];
                  paramCSSDirection[k] += f6 + f7;
                  if (i7 != 0) {
                    ((CSSNode)localObject1).layout.position[trailing[i16]] = (paramCSSNode.layout.dimensions[dim[i16]] - localObject1.layout.dimensions[dim[i16]] - localObject1.layout.position[pos[i16]]);
                  }
                }
                i4 = 0;
                f10 += f3;
                k = j + 1;
                j += 1;
                f4 = f11;
                localObject5 = localObject4;
                localObject7 = localObject2;
                localObject2 = localObject3;
                m = n;
                n = i2;
                paramCSSDirection = (CSSDirection)localObject6;
                i2 = i3;
                i11 = i12;
                i12 = i1;
                f9 = f1;
                i1 = i13;
                f1 = f2;
                break label1394;
                label3696:
                f2 = Math.max(f10, 0.0F) - f10;
                break label2026;
              }
            }
            f1 = f2 / f3;
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            paramCSSDirection = (CSSDirection)localObject1;
            f1 = f12;
            f3 = f11;
            if (paramCSSDirection == null) {
              break label4051;
            }
            paramCSSDirection.layout.dimensions[dim[i15]] = boundAxis(paramCSSDirection, i15, paramCSSDirection.style.flex * f2 + (paramCSSDirection.style.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + paramCSSDirection.style.border.getWithFallback(leadingSpacing[i15], leading[i15]) + (paramCSSDirection.style.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + paramCSSDirection.style.border.getWithFallback(trailingSpacing[i15], trailing[i15]))));
            f1 = NaN.0F;
            if ((!Float.isNaN(paramCSSNode.style.dimensions[dim[i17]])) && (paramCSSNode.style.dimensions[dim[i17]] >= 0.0D)) {
              f1 = paramCSSNode.layout.dimensions[dim[i17]] - f15;
            }
            for (;;)
            {
              layoutNode(paramCSSLayoutContext, paramCSSDirection, f1, localCSSDirection);
              localObject1 = paramCSSDirection.nextFlexChild;
              paramCSSDirection.nextFlexChild = null;
              paramCSSDirection = (CSSDirection)localObject1;
              break;
              if (i10 == 0) {
                f1 = paramFloat - (paramCSSNode.style.margin.getWithFallback(leadingSpacing[i17], leading[i17]) + paramCSSNode.style.margin.getWithFallback(trailingSpacing[i17], trailing[i17])) - f15;
              }
            }
          }
        }
        f1 = f12;
        f3 = f11;
        if (localCSSJustify != CSSJustify.FLEX_START)
        {
          if (localCSSJustify == CSSJustify.CENTER)
          {
            f3 = f2 / 2.0F;
            f1 = f12;
          }
        }
        else
        {
          label4051:
          f2 = f9 + f3;
          i = n;
          label4062:
          if (i >= k) {
            break label4615;
          }
          paramCSSDirection = paramCSSNode.getChildAt(i);
          if ((paramCSSDirection.style.positionType != CSSPositionType.ABSOLUTE) || (Float.isNaN(paramCSSDirection.style.position[leading[i15]]))) {
            break label4357;
          }
          localObject1 = paramCSSDirection.layout.position;
          j = pos[i15];
          if (!Float.isNaN(paramCSSDirection.style.position[leading[i15]])) {
            break label4338;
          }
          f3 = 0.0F;
          label4149:
          localObject1[j] = (f3 + paramCSSNode.style.border.getWithFallback(leadingSpacing[i15], leading[i15]) + paramCSSDirection.style.margin.getWithFallback(leadingSpacing[i15], leading[i15]));
          f9 = f2;
          f3 = f4;
        }
        for (;;)
        {
          i += 1;
          f4 = f3;
          f2 = f9;
          break label4062;
          if (localCSSJustify == CSSJustify.FLEX_END)
          {
            f1 = f12;
            f3 = f2;
            break;
          }
          if (localCSSJustify == CSSJustify.SPACE_BETWEEN)
          {
            f1 = Math.max(f2, 0.0F);
            if (i14 + i13 - 1 != 0)
            {
              f1 /= (i14 + i13 - 1);
              f3 = f11;
              break;
            }
            f1 = 0.0F;
            f3 = f11;
            break;
          }
          f1 = f12;
          f3 = f11;
          if (localCSSJustify != CSSJustify.SPACE_AROUND) {
            break;
          }
          f1 = f2 / (i14 + i13);
          f3 = f1 / 2.0F;
          break;
          label4338:
          f3 = paramCSSDirection.style.position[leading[i15]];
          break label4149;
          label4357:
          localObject1 = paramCSSDirection.layout.position;
          j = pos[i15];
          localObject1[j] += f2;
          if (i6 != 0) {
            paramCSSDirection.layout.position[trailing[i15]] = (paramCSSNode.layout.dimensions[dim[i15]] - paramCSSDirection.layout.dimensions[dim[i15]] - paramCSSDirection.layout.position[pos[i15]]);
          }
          f3 = f4;
          f9 = f2;
          if (paramCSSDirection.style.positionType == CSSPositionType.RELATIVE)
          {
            f9 = f2 + (paramCSSDirection.layout.dimensions[dim[i15]] + paramCSSDirection.style.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + paramCSSDirection.style.margin.getWithFallback(trailingSpacing[i15], trailing[i15]) + f1);
            f3 = Math.max(f4, boundAxis(paramCSSDirection, i16, paramCSSDirection.layout.dimensions[dim[i16]] + paramCSSDirection.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSDirection.style.margin.getWithFallback(trailingSpacing[i16], trailing[i16])));
          }
        }
        label4615:
        f3 = paramCSSNode.layout.dimensions[dim[i16]];
        if (i7 == 0) {
          f3 = Math.max(boundAxis(paramCSSNode, i16, f4 + f14), f14);
        }
        i = m;
        if (i < k)
        {
          paramCSSDirection = paramCSSNode.getChildAt(i);
          if ((paramCSSDirection.style.positionType == CSSPositionType.ABSOLUTE) && (!Float.isNaN(paramCSSDirection.style.position[leading[i16]])))
          {
            localObject1 = paramCSSDirection.layout.position;
            j = pos[i16];
            if (Float.isNaN(paramCSSDirection.style.position[leading[i16]])) {}
            for (f1 = 0.0F;; f1 = paramCSSDirection.style.position[leading[i16]])
            {
              localObject1[j] = (f1 + paramCSSNode.style.border.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSDirection.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]));
              i += 1;
              break;
            }
          }
          f9 = f7;
          f1 = f9;
          if (paramCSSDirection.style.positionType == CSSPositionType.RELATIVE)
          {
            localObject1 = getAlignItem(paramCSSNode, paramCSSDirection);
            if (localObject1 != CSSAlign.STRETCH) {
              break label5154;
            }
            f1 = f9;
            if (Float.isNaN(paramCSSDirection.layout.dimensions[dim[i16]]))
            {
              paramCSSDirection.layout.dimensions[dim[i16]] = Math.max(boundAxis(paramCSSDirection, i16, f3 - f14 - (paramCSSDirection.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSDirection.style.margin.getWithFallback(trailingSpacing[i16], trailing[i16]))), paramCSSDirection.style.padding.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSDirection.style.border.getWithFallback(leadingSpacing[i16], leading[i16]) + (paramCSSDirection.style.padding.getWithFallback(trailingSpacing[i16], trailing[i16]) + paramCSSDirection.style.border.getWithFallback(trailingSpacing[i16], trailing[i16])));
              f1 = f9;
            }
          }
          for (;;)
          {
            localObject1 = paramCSSDirection.layout.position;
            j = pos[i16];
            localObject1[j] += f6 + f1;
            if (i7 == 0) {
              break;
            }
            paramCSSDirection.layout.position[trailing[i16]] = (paramCSSNode.layout.dimensions[dim[i16]] - paramCSSDirection.layout.dimensions[dim[i16]] - paramCSSDirection.layout.position[pos[i16]]);
            break;
            label5154:
            f1 = f9;
            if (localObject1 != CSSAlign.FLEX_START)
            {
              f1 = f3 - f14 - (paramCSSDirection.layout.dimensions[dim[i16]] + paramCSSDirection.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSDirection.style.margin.getWithFallback(trailingSpacing[i16], trailing[i16]));
              if (localObject1 == CSSAlign.CENTER) {
                f1 = f9 + f1 / 2.0F;
              } else {
                f1 = f9 + f1;
              }
            }
          }
        }
        f6 += f4;
        f5 = Math.max(f5, f2);
        i8 += 1;
        i = k;
        localObject2 = localObject3;
      }
      label5297:
      if ((i8 > 1) && (i7 != 0))
      {
        f3 = paramCSSNode.layout.dimensions[dim[i16]] - f14;
        f4 = f3 - f6;
        f2 = 0.0F;
        paramCSSLayoutContext = paramCSSNode.style.alignContent;
        if (paramCSSLayoutContext == CSSAlign.FLEX_END)
        {
          paramFloat = f7 + f4;
          f1 = f2;
          i = 0;
          k = 0;
        }
        for (;;)
        {
          if (k >= i8) {
            break label5872;
          }
          f2 = 0.0F;
          j = i;
          for (;;)
          {
            if (j < i5)
            {
              paramCSSLayoutContext = paramCSSNode.getChildAt(j);
              if (paramCSSLayoutContext.style.positionType != CSSPositionType.RELATIVE)
              {
                f3 = f2;
                j += 1;
                f2 = f3;
                continue;
                if (paramCSSLayoutContext == CSSAlign.CENTER)
                {
                  paramFloat = f7 + f4 / 2.0F;
                  f1 = f2;
                  break;
                }
                f1 = f2;
                paramFloat = f7;
                if (paramCSSLayoutContext != CSSAlign.STRETCH) {
                  break;
                }
                f1 = f2;
                paramFloat = f7;
                if (f3 <= f6) {
                  break;
                }
                f1 = f4 / i8;
                paramFloat = f7;
                break;
              }
              if (paramCSSLayoutContext.lineIndex == k) {
                break label5543;
              }
            }
          }
          f2 += f1;
          label5507:
          if (i < j)
          {
            paramCSSLayoutContext = paramCSSNode.getChildAt(i);
            if (paramCSSLayoutContext.style.positionType != CSSPositionType.RELATIVE) {}
            for (;;)
            {
              i += 1;
              break label5507;
              label5543:
              f3 = f2;
              if (Float.isNaN(paramCSSLayoutContext.layout.dimensions[dim[i16]])) {
                break;
              }
              f3 = Math.max(f2, paramCSSLayoutContext.layout.dimensions[dim[i16]] + (paramCSSLayoutContext.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramCSSLayoutContext.style.margin.getWithFallback(trailingSpacing[i16], trailing[i16])));
              break;
              paramCSSDirection = getAlignItem(paramCSSNode, paramCSSLayoutContext);
              if (paramCSSDirection == CSSAlign.FLEX_START)
              {
                paramCSSLayoutContext.layout.position[pos[i16]] = (paramCSSLayoutContext.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramFloat);
              }
              else if (paramCSSDirection == CSSAlign.FLEX_END)
              {
                paramCSSLayoutContext.layout.position[pos[i16]] = (paramFloat + f2 - paramCSSLayoutContext.style.margin.getWithFallback(trailingSpacing[i16], trailing[i16]) - paramCSSLayoutContext.layout.dimensions[dim[i16]]);
              }
              else if (paramCSSDirection == CSSAlign.CENTER)
              {
                f3 = paramCSSLayoutContext.layout.dimensions[dim[i16]];
                paramCSSLayoutContext.layout.position[pos[i16]] = ((f2 - f3) / 2.0F + paramFloat);
              }
              else if (paramCSSDirection == CSSAlign.STRETCH)
              {
                paramCSSLayoutContext.layout.position[pos[i16]] = (paramCSSLayoutContext.style.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramFloat);
              }
            }
          }
          paramFloat += f2;
          k += 1;
          i = j;
        }
      }
      label5872:
      j = 0;
      int k = 0;
      i = j;
      if (i6 == 0)
      {
        paramCSSNode.layout.dimensions[dim[i15]] = Math.max(boundAxis(paramCSSNode, i15, paramCSSNode.style.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + paramCSSNode.style.border.getWithFallback(trailingSpacing[i15], trailing[i15]) + f5), f13);
        if (i15 != CSS_FLEX_DIRECTION_ROW_REVERSE)
        {
          i = j;
          if (i15 != CSS_FLEX_DIRECTION_COLUMN_REVERSE) {}
        }
        else
        {
          i = 1;
        }
      }
      j = k;
      if (i7 == 0)
      {
        paramCSSNode.layout.dimensions[dim[i16]] = Math.max(boundAxis(paramCSSNode, i16, f6 + f14), f14);
        if (i16 != CSS_FLEX_DIRECTION_ROW_REVERSE)
        {
          j = k;
          if (i16 != CSS_FLEX_DIRECTION_COLUMN_REVERSE) {}
        }
        else
        {
          j = 1;
        }
      }
      if ((i != 0) || (j != 0))
      {
        k = 0;
        while (k < i5)
        {
          paramCSSLayoutContext = paramCSSNode.getChildAt(k);
          if (i != 0) {
            paramCSSLayoutContext.layout.position[trailing[i15]] = (paramCSSNode.layout.dimensions[dim[i15]] - paramCSSLayoutContext.layout.dimensions[dim[i15]] - paramCSSLayoutContext.layout.position[pos[i15]]);
          }
          if (j != 0) {
            paramCSSLayoutContext.layout.position[trailing[i16]] = (paramCSSNode.layout.dimensions[dim[i16]] - paramCSSLayoutContext.layout.dimensions[dim[i16]] - paramCSSLayoutContext.layout.position[pos[i16]]);
          }
          k += 1;
        }
      }
      for (paramCSSLayoutContext = (CSSLayoutContext)localObject2; paramCSSLayoutContext != null; paramCSSLayoutContext = paramCSSDirection)
      {
        i = 0;
        if (i < 2)
        {
          if (i != 0)
          {
            j = CSS_FLEX_DIRECTION_ROW;
            label6233:
            if ((!Float.isNaN(paramCSSNode.layout.dimensions[dim[j]])) && ((Float.isNaN(paramCSSLayoutContext.style.dimensions[dim[j]])) || (paramCSSLayoutContext.style.dimensions[dim[j]] < 0.0D)) && (!Float.isNaN(paramCSSLayoutContext.style.position[leading[j]])) && (!Float.isNaN(paramCSSLayoutContext.style.position[trailing[j]])))
            {
              paramCSSDirection = paramCSSLayoutContext.layout.dimensions;
              k = dim[j];
              f2 = paramCSSNode.layout.dimensions[dim[j]];
              f3 = paramCSSNode.style.border.getWithFallback(leadingSpacing[j], leading[j]);
              f4 = paramCSSNode.style.border.getWithFallback(trailingSpacing[j], trailing[j]);
              f5 = paramCSSLayoutContext.style.margin.getWithFallback(leadingSpacing[j], leading[j]);
              f6 = paramCSSLayoutContext.style.margin.getWithFallback(trailingSpacing[j], trailing[j]);
              if (!Float.isNaN(paramCSSLayoutContext.style.position[leading[j]])) {
                break label6767;
              }
              paramFloat = 0.0F;
              label6483:
              if (!Float.isNaN(paramCSSLayoutContext.style.position[trailing[j]])) {
                break label6785;
              }
              f1 = 0.0F;
              label6506:
              paramCSSDirection[k] = Math.max(boundAxis(paramCSSLayoutContext, j, f2 - (f3 + f4) - (f5 + f6) - paramFloat - f1), paramCSSLayoutContext.style.padding.getWithFallback(leadingSpacing[j], leading[j]) + paramCSSLayoutContext.style.border.getWithFallback(leadingSpacing[j], leading[j]) + (paramCSSLayoutContext.style.padding.getWithFallback(trailingSpacing[j], trailing[j]) + paramCSSLayoutContext.style.border.getWithFallback(trailingSpacing[j], trailing[j])));
            }
            if ((!Float.isNaN(paramCSSLayoutContext.style.position[trailing[j]])) && (Float.isNaN(paramCSSLayoutContext.style.position[leading[j]])))
            {
              paramCSSDirection = paramCSSLayoutContext.layout.position;
              k = leading[j];
              f1 = paramCSSNode.layout.dimensions[dim[j]];
              f2 = paramCSSLayoutContext.layout.dimensions[dim[j]];
              if (!Float.isNaN(paramCSSLayoutContext.style.position[trailing[j]])) {
                break label6804;
              }
            }
          }
          label6767:
          label6785:
          label6804:
          for (paramFloat = 0.0F;; paramFloat = paramCSSLayoutContext.style.position[trailing[j]])
          {
            paramCSSDirection[k] = (f1 - f2 - paramFloat);
            i += 1;
            break;
            j = CSS_FLEX_DIRECTION_COLUMN;
            break label6233;
            paramFloat = paramCSSLayoutContext.style.position[leading[j]];
            break label6483;
            f1 = paramCSSLayoutContext.style.position[trailing[j]];
            break label6506;
          }
        }
        paramCSSDirection = paramCSSLayoutContext.nextAbsoluteChild;
        paramCSSLayoutContext.nextAbsoluteChild = null;
      }
    }
  }
  
  static boolean needsRelayout(CSSNode paramCSSNode, float paramFloat)
  {
    boolean bool = false;
    if ((paramCSSNode.isDirty()) || (!FloatUtil.floatsEqual(paramCSSNode.lastLayout.requestedHeight, paramCSSNode.layout.dimensions[1])) || (!FloatUtil.floatsEqual(paramCSSNode.lastLayout.requestedWidth, paramCSSNode.layout.dimensions[0])) || (!FloatUtil.floatsEqual(paramCSSNode.lastLayout.parentMaxWidth, paramFloat))) {
      bool = true;
    }
    return bool;
  }
  
  private static int resolveAxis(int paramInt, CSSDirection paramCSSDirection)
  {
    int i = paramInt;
    if (paramCSSDirection == CSSDirection.RTL)
    {
      if (paramInt != CSS_FLEX_DIRECTION_ROW) {
        break label22;
      }
      i = CSS_FLEX_DIRECTION_ROW_REVERSE;
    }
    label22:
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != CSS_FLEX_DIRECTION_ROW_REVERSE);
    return CSS_FLEX_DIRECTION_ROW;
  }
  
  private static CSSDirection resolveDirection(CSSNode paramCSSNode, CSSDirection paramCSSDirection)
  {
    CSSDirection localCSSDirection = paramCSSNode.style.direction;
    paramCSSNode = localCSSDirection;
    if (localCSSDirection == CSSDirection.INHERIT)
    {
      if (paramCSSDirection == null) {
        paramCSSNode = CSSDirection.LTR;
      }
    }
    else {
      return paramCSSNode;
    }
    return paramCSSDirection;
  }
  
  private static void setDimensionFromStyle(CSSNode paramCSSNode, int paramInt)
  {
    if (!Float.isNaN(paramCSSNode.layout.dimensions[dim[paramInt]])) {}
    while ((Float.isNaN(paramCSSNode.style.dimensions[dim[paramInt]])) || (paramCSSNode.style.dimensions[dim[paramInt]] <= 0.0D)) {
      return;
    }
    float f = Math.max(boundAxis(paramCSSNode, paramInt, paramCSSNode.style.dimensions[dim[paramInt]]), paramCSSNode.style.padding.getWithFallback(leadingSpacing[paramInt], leading[paramInt]) + paramCSSNode.style.padding.getWithFallback(trailingSpacing[paramInt], trailing[paramInt]) + paramCSSNode.style.border.getWithFallback(leadingSpacing[paramInt], leading[paramInt]) + paramCSSNode.style.border.getWithFallback(trailingSpacing[paramInt], trailing[paramInt]));
    paramCSSNode.layout.dimensions[dim[paramInt]] = f;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\csslayout\LayoutEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */