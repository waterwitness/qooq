package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqHeader
  extends JceStruct
{
  public int guid;
  public int mask;
  public long qq;
  public String qua;
  public String sid;
  public int version;
  
  public ReqHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.qua = "";
    this.sid = "";
  }
  
  public ReqHeader(int paramInt1, String paramString1, long paramLong, int paramInt2, String paramString2, int paramInt3)
  {
    this.qua = "";
    this.sid = "";
    this.version = paramInt1;
    this.qua = paramString1;
    this.qq = paramLong;
    this.guid = paramInt2;
    this.sid = paramString2;
    this.mask = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.version = paramJceInputStream.read(this.version, 0, true);
    this.qua = paramJceInputStream.readString(1, true);
    this.qq = paramJceInputStream.read(this.qq, 2, true);
    this.guid = paramJceInputStream.read(this.guid, 3, true);
    this.sid = paramJceInputStream.readString(4, false);
    this.mask = paramJceInputStream.read(this.mask, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.version, 0);
    paramJceOutputStream.write(this.qua, 1);
    paramJceOutputStream.write(this.qq, 2);
    paramJceOutputStream.write(this.guid, 3);
    if (this.sid != null) {
      paramJceOutputStream.write(this.sid, 4);
    }
    paramJceOutputStream.write(this.mask, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\acs\ReqHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */