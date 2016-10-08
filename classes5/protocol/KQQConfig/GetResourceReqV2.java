package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetResourceReqV2
  extends JceStruct
{
  static ArrayList cache_vecResReqInfo;
  public int iPluginType;
  public ArrayList vecResReqInfo;
  
  public GetResourceReqV2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iPluginType = 64;
  }
  
  public GetResourceReqV2(ArrayList paramArrayList, int paramInt)
  {
    this.iPluginType = 64;
    this.vecResReqInfo = paramArrayList;
    this.iPluginType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResReqInfo == null)
    {
      cache_vecResReqInfo = new ArrayList();
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      cache_vecResReqInfo.add(localGetResourceReqInfoV2);
    }
    this.vecResReqInfo = ((ArrayList)paramJceInputStream.read(cache_vecResReqInfo, 1, true));
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResReqInfo, 1);
    paramJceOutputStream.write(this.iPluginType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\GetResourceReqV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */