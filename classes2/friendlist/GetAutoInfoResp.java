package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetAutoInfoResp
  extends JceStruct
{
  static int cache_result;
  public byte cGroupID;
  public short errorCode;
  public int result;
  public String strGroupName;
  public String strRemark;
  
  public GetAutoInfoResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strRemark = "";
    this.strGroupName = "";
  }
  
  public GetAutoInfoResp(int paramInt, short paramShort, String paramString1, byte paramByte, String paramString2)
  {
    this.strRemark = "";
    this.strGroupName = "";
    this.result = paramInt;
    this.errorCode = paramShort;
    this.strRemark = paramString1;
    this.cGroupID = paramByte;
    this.strGroupName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 1, true);
    this.strRemark = paramJceInputStream.readString(2, true);
    this.cGroupID = paramJceInputStream.read(this.cGroupID, 3, true);
    this.strGroupName = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.errorCode, 1);
    paramJceOutputStream.write(this.strRemark, 2);
    paramJceOutputStream.write(this.cGroupID, 3);
    paramJceOutputStream.write(this.strGroupName, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetAutoInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */