package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AddGroupResp
  extends JceStruct
{
  public byte cGroupId;
  public byte cSortId;
  public long dwSequence;
  public long dwToUin;
  
  public AddGroupResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AddGroupResp(long paramLong1, long paramLong2, byte paramByte1, byte paramByte2)
  {
    this.dwToUin = paramLong1;
    this.dwSequence = paramLong2;
    this.cGroupId = paramByte1;
    this.cSortId = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.dwSequence = paramJceInputStream.read(this.dwSequence, 1, true);
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 2, true);
    this.cSortId = paramJceInputStream.read(this.cSortId, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.dwSequence, 1);
    paramJceOutputStream.write(this.cGroupId, 2);
    paramJceOutputStream.write(this.cSortId, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\AddGroupResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */