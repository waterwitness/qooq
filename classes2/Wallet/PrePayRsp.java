package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PrePayRsp
  extends JceStruct
  implements Cloneable
{
  public byte careFlag;
  public String mchId;
  public String msg;
  public String pubUin;
  public int ret;
  public String subscribeInfo;
  public String tokenId;
  
  public PrePayRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
    this.tokenId = "";
    this.mchId = "";
    this.pubUin = "";
    this.subscribeInfo = "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.tokenId = paramJceInputStream.readString(2, true);
    this.mchId = paramJceInputStream.readString(3, true);
    this.pubUin = paramJceInputStream.readString(4, true);
    this.subscribeInfo = paramJceInputStream.readString(5, true);
    this.careFlag = paramJceInputStream.read(this.careFlag, 6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.tokenId, 2);
    paramJceOutputStream.write(this.mchId, 3);
    paramJceOutputStream.write(this.pubUin, 4);
    paramJceOutputStream.write(this.subscribeInfo, 5);
    paramJceOutputStream.write(this.careFlag, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\PrePayRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */