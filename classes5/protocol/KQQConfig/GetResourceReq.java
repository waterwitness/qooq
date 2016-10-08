package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetResourceReq
  extends JceStruct
{
  static ArrayList cache_vecResReqInfo;
  public short sLanCodeType;
  public ArrayList vecResReqInfo;
  
  public GetResourceReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetResourceReq(ArrayList paramArrayList, short paramShort)
  {
    this.vecResReqInfo = paramArrayList;
    this.sLanCodeType = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResReqInfo == null)
    {
      cache_vecResReqInfo = new ArrayList();
      GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
      cache_vecResReqInfo.add(localGetResourceReqInfo);
    }
    this.vecResReqInfo = ((ArrayList)paramJceInputStream.read(cache_vecResReqInfo, 1, true));
    this.sLanCodeType = paramJceInputStream.read(this.sLanCodeType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResReqInfo, 1);
    paramJceOutputStream.write(this.sLanCodeType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\GetResourceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */