package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetServerListReq
  extends JceStruct
{
  static ArrayList cache_vUin;
  public byte bLinkType;
  public int iLastTime;
  public int netType;
  public String sImsi;
  public ArrayList vUin;
  
  public GetServerListReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bLinkType = 1;
    this.sImsi = "46000";
  }
  
  public GetServerListReq(ArrayList paramArrayList, int paramInt1, byte paramByte, String paramString, int paramInt2)
  {
    this.bLinkType = 1;
    this.sImsi = "46000";
    this.vUin = paramArrayList;
    this.iLastTime = paramInt1;
    this.bLinkType = paramByte;
    this.sImsi = paramString;
    this.netType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vUin == null)
    {
      cache_vUin = new ArrayList();
      cache_vUin.add("");
    }
    this.vUin = ((ArrayList)paramJceInputStream.read(cache_vUin, 1, true));
    this.iLastTime = paramJceInputStream.read(this.iLastTime, 2, true);
    this.bLinkType = paramJceInputStream.read(this.bLinkType, 3, false);
    this.sImsi = paramJceInputStream.readString(4, false);
    this.netType = paramJceInputStream.read(this.netType, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vUin, 1);
    paramJceOutputStream.write(this.iLastTime, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    if (this.sImsi != null) {
      paramJceOutputStream.write(this.sImsi, 4);
    }
    paramJceOutputStream.write(this.netType, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\GetServerListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */