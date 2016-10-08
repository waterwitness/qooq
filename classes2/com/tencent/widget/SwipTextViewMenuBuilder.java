package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class SwipTextViewMenuBuilder
  extends SwipRightMenuBuilder
{
  public static final int a = -1;
  public static final String a = "tag_swip_icon_menu_item";
  public static final int b = -2;
  protected final int[] a;
  protected final int[] b;
  protected final int c;
  protected final int[] c;
  protected final int[] d;
  
  public SwipTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = paramArrayOfInt1;
    this.jdField_c_of_type_Int = paramInt3;
    this.a = paramArrayOfInt2;
    this.b = paramArrayOfInt3;
    this.jdField_c_of_type_ArrayOfInt = paramArrayOfInt4;
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
      if ((paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView instanceof SimpleTextView)) {
        paramObject = (SimpleTextView)paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView;
      }
      i = this.b[paramSwipRightMenuItem.b];
      j = this.jdField_c_of_type_ArrayOfInt[paramSwipRightMenuItem.b];
      k = this.a[paramSwipRightMenuItem.b];
      localObject1 = paramObject;
    } while (paramObject == null);
    ((SimpleTextView)paramObject).setVisibility(0);
    ((SimpleTextView)paramObject).setText(((SimpleTextView)paramObject).getContext().getResources().getString(i));
    ((SimpleTextView)paramObject).setBackgroundResource(j);
    ((SimpleTextView)paramObject).setId(k);
    ((SimpleTextView)paramObject).setTag("tag_swip_icon_menu_item");
    ((SimpleTextView)paramObject).setTag(-2, Integer.valueOf(i));
    ((SimpleTextView)paramObject).setTag(-1, Integer.valueOf(paramInt));
    ((SimpleTextView)paramObject).setContentDescription(((SimpleTextView)paramObject).getResources().getString(i));
    ((SimpleTextView)paramObject).setOnClickListener(paramOnClickListener);
    paramSwipRightMenuItem.jdField_c_of_type_Int = this.d[paramSwipRightMenuItem.jdField_a_of_type_Int];
    paramSwipRightMenuItem.d = this.jdField_c_of_type_Int;
    return (View)paramObject;
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.d[paramInt], this.jdField_c_of_type_Int));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SwipTextViewMenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */