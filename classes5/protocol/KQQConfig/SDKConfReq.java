package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SDKConfReq
  extends JceStruct
{
  static ArrayList cache_sUin;
  public int iConfVersion;
  public int iGetEspLastTime;
  public int iGetSdkLastTime;
  public ArrayList sUin;
  
  public SDKConfReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SDKConfReq(int paramInt1, int paramInt2, ArrayList paramArrayList, int paramInt3)
  {
    this.iConfVersion = paramInt1;
    this.iGetSdkLastTime = paramInt2;
    this.sUin = paramArrayList;
    this.iGetEspLastTime = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iConfVersion = paramJceInputStream.read(this.iConfVersion, 1, false);
    this.iGetSdkLastTime = paramJceInputStream.read(this.iGetSdkLastTime, 2, false);
    if (cache_sUin == null)
    {
      cache_sUin = new ArrayList();
      cache_sUin.add("");
    }
    this.sUin = ((ArrayList)paramJceInputStream.read(cache_sUin, 3, false));
    this.iGetEspLastTime = paramJceInputStream.read(this.iGetEspLastTime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iConfVersion, 1);
    paramJceOutputStream.write(this.iGetSdkLastTime, 2);
    if (this.sUin != null) {
      paramJceOutputStream.write(this.sUin, 3);
    }
    paramJceOutputStream.write(this.iGetEspLastTime, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\SDKConfReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */