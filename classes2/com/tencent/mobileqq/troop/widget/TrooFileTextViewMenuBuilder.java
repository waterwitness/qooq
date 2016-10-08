package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

public abstract class TrooFileTextViewMenuBuilder
  extends SwipRightMenuBuilder
{
  protected final int a;
  protected final int[] a;
  protected final int[] b;
  protected final int[] c;
  protected final int[] d;
  
  public TrooFileTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = paramArrayOfInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt2;
    this.b = paramArrayOfInt3;
    this.c = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length != 2) || (!(paramObject[1] instanceof TroopFileInfo))) {
        break label229;
      }
    }
    label90:
    label229:
    for (TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramObject[1];; localTroopFileInfo = null)
    {
      localObject1 = localObject2;
      if (paramSwipRightMenuItem != null)
      {
        localObject1 = localObject2;
        if (paramSwipRightMenuItem.jdField_a_of_type_Int >= 0)
        {
          localObject1 = localObject2;
          if (paramSwipRightMenuItem.b >= 0)
          {
            if (localTroopFileInfo != null) {
              break label90;
            }
            localObject1 = localObject2;
          }
        }
      }
      do
      {
        return (View)localObject1;
        paramObject = localObject3;
        if ((paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView instanceof SimpleTextView)) {
          paramObject = (SimpleTextView)paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView;
        }
        localObject1 = paramObject;
      } while (paramObject == null);
      paramInt = this.b[paramSwipRightMenuItem.b];
      int i = this.c[paramSwipRightMenuItem.b];
      int j = this.jdField_a_of_type_ArrayOfInt[paramSwipRightMenuItem.b];
      ((SimpleTextView)paramObject).setVisibility(0);
      ((SimpleTextView)paramObject).setText(((SimpleTextView)paramObject).getContext().getResources().getString(paramInt));
      ((SimpleTextView)paramObject).setBackgroundResource(i);
      ((SimpleTextView)paramObject).setId(j);
      ((SimpleTextView)paramObject).setTag(localTroopFileInfo);
      ((SimpleTextView)paramObject).setContentDescription(((SimpleTextView)paramObject).getResources().getString(paramInt));
      ((SimpleTextView)paramObject).setOnClickListener(paramOnClickListener);
      paramSwipRightMenuItem.c = this.d[paramSwipRightMenuItem.jdField_a_of_type_Int];
      paramSwipRightMenuItem.d = this.jdField_a_of_type_Int;
      return (View)paramObject;
    }
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.d[paramInt], this.jdField_a_of_type_Int));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TrooFileTextViewMenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */