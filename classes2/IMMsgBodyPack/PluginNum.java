package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PluginNum
  extends JceStruct
{
  public byte cFlag;
  public long dwID;
  public long dwNUm;
  
  public PluginNum()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PluginNum(long paramLong1, long paramLong2, byte paramByte)
  {
    this.dwID = paramLong1;
    this.dwNUm = paramLong2;
    this.cFlag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwID = paramJceInputStream.read(this.dwID, 0, false);
    this.dwNUm = paramJceInputStream.read(this.dwNUm, 1, false);
    this.cFlag = paramJceInputStream.read(this.cFlag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwID, 0);
    paramJceOutputStream.write(this.dwNUm, 1);
    paramJceOutputStream.write(this.cFlag, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\PluginNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */