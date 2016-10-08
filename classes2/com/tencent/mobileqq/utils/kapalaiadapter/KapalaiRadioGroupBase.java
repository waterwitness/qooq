package com.tencent.mobileqq.utils.kapalaiadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class KapalaiRadioGroupBase
  extends RadioGroup
{
  public KapalaiRadioGroupBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public KapalaiRadioGroupBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\kapalaiadapter\KapalaiRadioGroupBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */