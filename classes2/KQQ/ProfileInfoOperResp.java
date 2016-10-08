package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ProfileInfoOperResp
  extends JceStruct
{
  static ArrayList cache_vecInfo;
  public byte cResult;
  public long uin;
  public ArrayList vecInfo;
  
  public ProfileInfoOperResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileInfoOperResp(long paramLong, byte paramByte, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.cResult = paramByte;
    this.vecInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    if (cache_vecInfo == null)
    {
      cache_vecInfo = new ArrayList();
      ProfileInfoResp localProfileInfoResp = new ProfileInfoResp();
      cache_vecInfo.add(localProfileInfoResp);
    }
    this.vecInfo = ((ArrayList)paramJceInputStream.read(cache_vecInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.cResult, 1);
    paramJceOutputStream.write(this.vecInfo, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfileInfoOperResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */