package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetResourceResp
  extends JceStruct
{
  static ArrayList cache_vecResRespInfo;
  public ArrayList vecResRespInfo;
  
  public GetResourceResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetResourceResp(ArrayList paramArrayList)
  {
    this.vecResRespInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResRespInfo == null)
    {
      cache_vecResRespInfo = new ArrayList();
      GetResourceRespInfo localGetResourceRespInfo = new GetResourceRespInfo();
      cache_vecResRespInfo.add(localGetResourceRespInfo);
    }
    this.vecResRespInfo = ((ArrayList)paramJceInputStream.read(cache_vecResRespInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResRespInfo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\GetResourceResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */