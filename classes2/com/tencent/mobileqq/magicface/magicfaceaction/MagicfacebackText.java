package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.math.BigDecimal;

public class MagicfacebackText
{
  public String a;
  public String b;
  public String c;
  
  public MagicfacebackText()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a(int paramInt, float paramFloat)
  {
    String str = null;
    if (this.c != null)
    {
      str = this.c.replaceFirst("%param%", "" + paramInt);
      paramFloat = new BigDecimal(paramFloat).setScale(1, 4).floatValue();
      str = str.replaceFirst("%param%", "" + paramFloat);
    }
    return str;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\magicfaceaction\MagicfacebackText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */