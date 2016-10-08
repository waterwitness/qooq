package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import wlr;
import wls;
import wlt;

public abstract class CustomScaleType
  implements AnyScaleTypeImageView.DisplayRuleDef
{
  public static final AnyScaleTypeImageView.DisplayRuleDef a = new wlr();
  public static final AnyScaleTypeImageView.DisplayRuleDef b = new wls();
  public static final AnyScaleTypeImageView.DisplayRuleDef c = new wlt();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\CustomScaleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */