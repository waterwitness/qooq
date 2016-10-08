package com.tencent.av.utils;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TintDrawableStateDrawable
  extends StateListDrawable
{
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  
  public TintDrawableStateDrawable(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static TintDrawableStateDrawable a(Resources paramResources, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    TintDrawableStateDrawable localTintDrawableStateDrawable = new TintDrawableStateDrawable(paramInt);
    try
    {
      localTintDrawableStateDrawable.inflate(paramResources, localXmlResourceParser, Xml.asAttributeSet(localXmlResourceParser));
      return localTintDrawableStateDrawable;
    }
    catch (XmlPullParserException paramResources)
    {
      paramResources.printStackTrace();
      return localTintDrawableStateDrawable;
    }
    catch (IOException paramResources)
    {
      paramResources.printStackTrace();
    }
    return localTintDrawableStateDrawable;
  }
  
  private void a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    int i4 = paramXmlPullParser.getDepth() + 1;
    int[][] arrayOfInt = new int[20][];
    int[] arrayOfInt1 = new int[arrayOfInt.length];
    HashMap localHashMap = new HashMap();
    int n = 0;
    int i;
    int j;
    int m;
    int k;
    Object localObject;
    int[] arrayOfInt2;
    int i1;
    int i2;
    for (;;)
    {
      i = paramXmlPullParser.next();
      if (i == 1) {
        break label485;
      }
      j = paramXmlPullParser.getDepth();
      if ((j < i4) && (i == 3)) {
        break label485;
      }
      if ((i == 2) && (j <= i4) && (paramXmlPullParser.getName().equals("item")))
      {
        m = 0;
        i = 0;
        k = 0;
        localObject = null;
        j = 0;
        int i5 = paramAttributeSet.getAttributeCount();
        arrayOfInt2 = new int[i5];
        i1 = 0;
        if (i1 < i5)
        {
          i2 = paramAttributeSet.getAttributeNameResource(i1);
          if (i2 != 0) {
            break;
          }
        }
        arrayOfInt2 = StateSet.trimStateSet(arrayOfInt2, j);
        if (m == 0) {
          break label474;
        }
        i = paramResources.getColor(m);
        label174:
        arrayOfInt1 = a(arrayOfInt1, n, i);
        arrayOfInt = a(arrayOfInt, n, arrayOfInt2);
        super.addState(arrayOfInt2, (Drawable)localObject);
        n += 1;
      }
    }
    if (i2 == 16842960)
    {
      i2 = j;
      j = k;
      k = i;
      i = i2;
    }
    for (;;)
    {
      i2 = i1 + 1;
      i1 = k;
      k = j;
      j = i;
      i = i1;
      i1 = i2;
      break;
      if (i2 == 2130772236)
      {
        m = paramAttributeSet.getAttributeResourceValue(i1, 0);
        if (m == 0)
        {
          k = paramAttributeSet.getAttributeIntValue(i1, i);
          i2 = 1;
          i = j;
          j = i2;
        }
      }
      else
      {
        if (i2 == 16843161)
        {
          i2 = paramAttributeSet.getAttributeResourceValue(i1, 0);
          if (localHashMap.containsKey(Integer.valueOf(i2))) {
            localObject = (Drawable)localHashMap.get(Integer.valueOf(i2));
          }
          for (;;)
          {
            i2 = i;
            i = j;
            j = k;
            k = i2;
            break;
            localObject = new BitmapDrawable(paramResources, paramResources.openRawResource(paramAttributeSet.getAttributeResourceValue(i1, 0)));
            localHashMap.put(Integer.valueOf(i2), localObject);
          }
        }
        int i3 = j + 1;
        if (paramAttributeSet.getAttributeBooleanValue(i1, false)) {}
        for (;;)
        {
          arrayOfInt2[j] = i2;
          j = k;
          k = i;
          i = i3;
          break;
          i2 = -i2;
        }
        label474:
        if (k != 0) {
          break label174;
        }
        i = 0;
        break label174;
        label485:
        paramResources = new int[n];
        paramXmlPullParser = new int[n][];
        System.arraycopy(arrayOfInt1, 0, paramResources, 0, n);
        System.arraycopy(arrayOfInt, 0, paramXmlPullParser, 0, n);
        this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(paramXmlPullParser, paramResources);
        return;
      }
      i2 = i;
      i = j;
      j = k;
      k = i2;
    }
  }
  
  int a(int paramInt)
  {
    if (paramInt <= 4) {
      return 8;
    }
    return paramInt * 2;
  }
  
  int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 + 1 > paramArrayOfInt.length)
    {
      arrayOfInt = new int[a(paramInt1)];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
    }
    arrayOfInt[paramInt1] = paramInt2;
    return arrayOfInt;
  }
  
  int[][] a(int[][] paramArrayOfInt, int paramInt, int[] paramArrayOfInt1)
  {
    int[][] arrayOfInt = paramArrayOfInt;
    if (paramInt + 1 > paramArrayOfInt.length)
    {
      arrayOfInt = new int[a(paramInt)][];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt);
    }
    arrayOfInt[paramInt] = paramArrayOfInt1;
    return arrayOfInt;
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    paramXmlPullParser = paramResources.getXml(this.jdField_a_of_type_Int);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    a(paramResources, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
    onStateChange(getState());
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
    {
      int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramArrayOfInt, 0);
      if (i == 0) {
        break label39;
      }
      setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }
    for (;;)
    {
      invalidateSelf();
      return super.onStateChange(paramArrayOfInt);
      label39:
      clearColorFilter();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\TintDrawableStateDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */