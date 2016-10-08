package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ProfileInfoOperReq
  extends JceStruct
{
  static ArrayList cache_vecInfo;
  public long uin;
  public ArrayList vecInfo;
  
  public ProfileInfoOperReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileInfoOperReq(long paramLong, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.vecInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_vecInfo == null)
    {
      cache_vecInfo = new ArrayList();
      ProfileInfoReq localProfileInfoReq = new ProfileInfoReq();
      cache_vecInfo.add(localProfileInfoReq);
    }
    this.vecInfo = ((ArrayList)paramJceInputStream.read(cache_vecInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.vecInfo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfileInfoOperReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */