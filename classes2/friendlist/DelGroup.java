package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DelGroup
  extends JceStruct
{
  public byte cGroupId;
  
  public DelGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DelGroup(byte paramByte)
  {
    this.cGroupId = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cGroupId, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\DelGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */