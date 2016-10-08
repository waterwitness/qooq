package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class SwipIconMenuBuilder
  extends SwipRightMenuBuilder
{
  public static final int a = -1;
  public static final String a = "tag_swip_icon_menu_item";
  public static final int b = -2;
  protected final int[] a;
  protected final int[] b;
  protected final int c;
  protected final int[] c;
  protected final int d;
  
  public SwipIconMenuBuilder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    super(paramInt1, paramInt2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.a = paramArrayOfInt1;
    this.b = paramArrayOfInt2;
    this.jdField_c_of_type_ArrayOfInt = paramArrayOfInt3;
  }
  
  public View a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = null;
    paramObject = null;
    Object localObject1 = paramObject;
    if (paramSwipRightMenuItem != null)
    {
      localObject1 = paramObject;
      if (paramSwipRightMenuItem.jdField_a_of_type_Int >= 0)
      {
        if (paramSwipRightMenuItem.b >= 0) {
          break label35;
        }
        localObject1 = paramObject;
      }
    }
    label35:
    int i;
    int j;
    int k;
    do
    {
      return (View)localObject1;
      paramObject = localObject2;
      if ((paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView instanceof ImageView)) {
        paramObject = (ImageView)paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView;
      }
      i = this.b[paramSwipRightMenuItem.b];
      j = this.jdField_c_of_type_ArrayOfInt[paramSwipRightMenuItem.b];
      k = this.a[paramSwipRightMenuItem.b];
      localObject1 = paramObject;
    } while (paramObject == null);
    ((ImageView)paramObject).setVisibility(0);
    ((ImageView)paramObject).setImageResource(i);
    ((ImageView)paramObject).setBackgroundResource(j);
    ((ImageView)paramObject).setTag("tag_swip_icon_menu_item");
    ((ImageView)paramObject).setTag(-2, Integer.valueOf(k));
    ((ImageView)paramObject).setTag(-1, Integer.valueOf(paramInt));
    ((ImageView)paramObject).setContentDescription(((ImageView)paramObject).getResources().getString(k));
    ((ImageView)paramObject).setOnClickListener(paramOnClickListener);
    paramSwipRightMenuItem.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
    paramSwipRightMenuItem.d = this.d;
    return (View)paramObject;
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.jdField_c_of_type_Int, this.d));
    paramContext.setScaleType(ImageView.ScaleType.CENTER);
    return paramContext;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SwipIconMenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */