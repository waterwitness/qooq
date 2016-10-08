package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqCommon
  extends JceStruct
{
  public byte cByte;
  public int cInt;
  public long cLong;
  public String cString;
  
  public ReqCommon()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cString = "";
  }
  
  public ReqCommon(byte paramByte, int paramInt, long paramLong, String paramString)
  {
    this.cString = "";
    this.cByte = paramByte;
    this.cInt = paramInt;
    this.cLong = paramLong;
    this.cString = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cByte = paramJceInputStream.read(this.cByte, 0, false);
    this.cInt = paramJceInputStream.read(this.cInt, 1, false);
    this.cLong = paramJceInputStream.read(this.cLong, 2, false);
    this.cString = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cByte, 0);
    paramJceOutputStream.write(this.cInt, 1);
    paramJceOutputStream.write(this.cLong, 2);
    if (this.cString != null) {
      paramJceOutputStream.write(this.cString, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\acs\ReqCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */