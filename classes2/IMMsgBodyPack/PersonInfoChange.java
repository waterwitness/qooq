package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class PersonInfoChange
  extends JceStruct
{
  static ArrayList cache_vChgField;
  public byte cType;
  public ArrayList vChgField;
  
  public PersonInfoChange()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PersonInfoChange(byte paramByte, ArrayList paramArrayList)
  {
    this.cType = paramByte;
    this.vChgField = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cType = paramJceInputStream.read(this.cType, 0, false);
    if (cache_vChgField == null)
    {
      cache_vChgField = new ArrayList();
      PersonInfoField localPersonInfoField = new PersonInfoField();
      cache_vChgField.add(localPersonInfoField);
    }
    this.vChgField = ((ArrayList)paramJceInputStream.read(cache_vChgField, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cType, 0);
    if (this.vChgField != null) {
      paramJceOutputStream.write(this.vChgField, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\PersonInfoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */