package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RealSyncRes
  extends JceStruct
{
  static ArrayList cache_vecResPkg;
  public byte result;
  public ArrayList vecResPkg;
  
  public RealSyncRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RealSyncRes(byte paramByte, ArrayList paramArrayList)
  {
    this.result = paramByte;
    this.vecResPkg = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    if (cache_vecResPkg == null)
    {
      cache_vecResPkg = new ArrayList();
      InfoItem localInfoItem = new InfoItem();
      cache_vecResPkg.add(localInfoItem);
    }
    this.vecResPkg = ((ArrayList)paramJceInputStream.read(cache_vecResPkg, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.vecResPkg, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\RealSyncRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */