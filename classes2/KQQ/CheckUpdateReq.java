package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class CheckUpdateReq
  extends JceStruct
{
  static ArrayList cache_vecReqPkg;
  public boolean isSupportSubPack;
  public ArrayList vecReqPkg;
  
  public CheckUpdateReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CheckUpdateReq(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.vecReqPkg = paramArrayList;
    this.isSupportSubPack = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecReqPkg == null)
    {
      cache_vecReqPkg = new ArrayList();
      ReqItem localReqItem = new ReqItem();
      cache_vecReqPkg.add(localReqItem);
    }
    this.vecReqPkg = ((ArrayList)paramJceInputStream.read(cache_vecReqPkg, 0, true));
    this.isSupportSubPack = paramJceInputStream.read(this.isSupportSubPack, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReqPkg, 0);
    paramJceOutputStream.write(this.isSupportSubPack, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\CheckUpdateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */