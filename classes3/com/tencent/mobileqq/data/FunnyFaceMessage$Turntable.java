package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FunnyFaceMessage$Turntable
  implements Externalizable
{
  public String hitNickName;
  public String hitUin;
  public List uinList;
  
  public FunnyFaceMessage$Turntable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uinList = new ArrayList();
  }
  
  public FunnyFaceMessage$Turntable(ObjectInput paramObjectInput)
  {
    this.uinList = new ArrayList();
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
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      this.uinList.add(paramObjectInput.readUTF());
      i += 1;
    }
    this.hitUin = paramObjectInput.readUTF();
    this.hitNickName = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.uinList.size());
    Iterator localIterator = this.uinList.iterator();
    while (localIterator.hasNext()) {
      paramObjectOutput.writeUTF((String)localIterator.next());
    }
    paramObjectOutput.writeUTF(this.hitUin);
    paramObjectOutput.writeUTF(this.hitNickName);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\FunnyFaceMessage$Turntable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */