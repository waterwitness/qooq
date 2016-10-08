package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GroupInfo
  extends JceStruct
{
  public byte cGroupId;
  public String strGroupName;
  
  public GroupInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strGroupName = "";
  }
  
  public GroupInfo(byte paramByte, String paramString)
  {
    this.strGroupName = "";
    this.cGroupId = paramByte;
    this.strGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 0, true);
    this.strGroupName = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cGroupId, 0);
    paramJceOutputStream.write(this.strGroupName, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NeighborSvc\GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */