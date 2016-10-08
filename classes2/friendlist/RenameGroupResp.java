package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RenameGroupResp
  extends JceStruct
{
  public byte cLen;
  public long dwSequence;
  public long dwToUin;
  public String sGroupName;
  
  public RenameGroupResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sGroupName = "";
  }
  
  public RenameGroupResp(long paramLong1, long paramLong2, byte paramByte, String paramString)
  {
    this.sGroupName = "";
    this.dwToUin = paramLong1;
    this.dwSequence = paramLong2;
    this.cLen = paramByte;
    this.sGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.dwSequence = paramJceInputStream.read(this.dwSequence, 1, true);
    this.cLen = paramJceInputStream.read(this.cLen, 2, true);
    this.sGroupName = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.dwSequence, 1);
    paramJceOutputStream.write(this.cLen, 2);
    paramJceOutputStream.write(this.sGroupName, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\RenameGroupResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */