package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class FunnyFaceMessage$Bomb
  implements Externalizable
{
  public boolean isBurst;
  
  public FunnyFaceMessage$Bomb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FunnyFaceMessage$Bomb(ObjectInput paramObjectInput)
  {
    try
    {
      readExternal(paramObjectInput);
      return;
    }
    catch (IOException paramObjectInput)
    {
      paramObjectInput.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramObjectInput)
    {
      paramObjectInput.printStackTrace();
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.isBurst = paramObjectInput.readBoolean();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeBoolean(this.isBurst);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\FunnyFaceMessage$Bomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */