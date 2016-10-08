package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RenameGroup
  extends JceStruct
{
  public byte cGroupId;
  public byte cLen;
  public String sGroupName;
  
  public RenameGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sGroupName = "";
  }
  
  public RenameGroup(byte paramByte1, byte paramByte2, String paramString)
  {
    this.sGroupName = "";
    this.cGroupId = paramByte1;
    this.cLen = paramByte2;
    this.sGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 0, true);
    this.cLen = paramJceInputStream.read(this.cLen, 1, true);
    this.sGroupName = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cGroupId, 0);
    paramJceOutputStream.write(this.cLen, 1);
    paramJceOutputStream.write(this.sGroupName, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\RenameGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */