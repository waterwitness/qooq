package com.tencent.mobileqq.apollo.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class ApolloDress$Dress
  implements Cloneable
{
  public int a;
  public long a;
  public ArrayList a;
  
  public ApolloDress$Dress()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      Dress localDress = (Dress)super.clone();
      localObject = localDress;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.a != null) {
      ((Dress)localObject).a = ((ArrayList)this.a.clone());
    }
    return localObject;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\data\ApolloDress$Dress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */