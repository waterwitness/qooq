package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SDKUpgradeRes
  extends JceStruct
{
  static ArrayList cache_vUpgradeInfo;
  public int iActionType;
  public ArrayList vUpgradeInfo;
  
  public SDKUpgradeRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SDKUpgradeRes(ArrayList paramArrayList, int paramInt)
  {
    this.vUpgradeInfo = paramArrayList;
    this.iActionType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vUpgradeInfo == null)
    {
      cache_vUpgradeInfo = new ArrayList();
      UpgradeInfo localUpgradeInfo = new UpgradeInfo();
      cache_vUpgradeInfo.add(localUpgradeInfo);
    }
    this.vUpgradeInfo = ((ArrayList)paramJceInputStream.read(cache_vUpgradeInfo, 1, true));
    this.iActionType = paramJceInputStream.read(this.iActionType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vUpgradeInfo, 1);
    paramJceOutputStream.write(this.iActionType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\SDKUpgradeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */