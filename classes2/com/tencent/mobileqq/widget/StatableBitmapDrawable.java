package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.StateSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class StatableBitmapDrawable
  extends BitmapDrawable
{
  private static final ColorMatrixColorFilter jdField_a_of_type_AndroidGraphicsColorMatrixColorFilter;
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final ColorMatrixColorFilter jdField_b_of_type_AndroidGraphicsColorMatrixColorFilter;
  private static final float[] jdField_b_of_type_ArrayOfFloat;
  private static final ColorMatrixColorFilter jdField_c_of_type_AndroidGraphicsColorMatrixColorFilter = new ColorMatrixColorFilter(jdField_c_of_type_ArrayOfFloat);
  private static final float[] jdField_c_of_type_ArrayOfFloat;
  private float jdField_a_of_type_Float = 1.0F;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private float[] d = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Float, 0.0F };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 16842919 };
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F };
    jdField_a_of_type_AndroidGraphicsColorMatrixColorFilter = new ColorMatrixColorFilter(jdField_a_of_type_ArrayOfFloat);
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    jdField_b_of_type_AndroidGraphicsColorMatrixColorFilter = new ColorMatrixColorFilter(jdField_b_of_type_ArrayOfFloat);
    jdField_c_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.0F };
  }
  
  public StatableBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public StatableBitmapDrawable(Resources paramResources, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramResources, paramBitmap);
    if (paramBoolean) {
      a(jdField_a_of_type_ArrayOfInt, jdField_c_of_type_AndroidGraphicsColorMatrixColorFilter);
    }
  }
  
  public StatableBitmapDrawable(Resources paramResources, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    super(paramResources, paramBitmap);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Float = paramFloat;
      paramResources = new ColorMatrixColorFilter(this.d);
      a(jdField_a_of_type_ArrayOfInt, paramResources);
    }
  }
  
  public StatableBitmapDrawable(Resources paramResources, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramResources, paramBitmap);
    if (paramBoolean2) {
      a(jdField_a_of_type_ArrayOfInt, jdField_a_of_type_AndroidGraphicsColorMatrixColorFilter);
    }
    if (paramBoolean1) {
      a(StateSet.WILD_CARD, jdField_b_of_type_AndroidGraphicsColorMatrixColorFilter);
    }
  }
  
  private ColorFilter a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return null;
    }
    int j = this.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (StateSet.stateSetMatches((int[])localArrayList.get(i), paramArrayOfInt)) {
        return (ColorFilter)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public int a(int[] paramArrayOfInt, ColorFilter paramColorFilter)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayOfInt);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramColorFilter);
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    paramArrayOfInt = a(paramArrayOfInt);
    if (this.jdField_a_of_type_AndroidGraphicsColorFilter != paramArrayOfInt)
    {
      this.jdField_a_of_type_AndroidGraphicsColorFilter = paramArrayOfInt;
      setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\StatableBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */