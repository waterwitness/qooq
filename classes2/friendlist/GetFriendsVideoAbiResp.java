package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetFriendsVideoAbiResp
  extends JceStruct
{
  static ArrayList cache_finfo;
  static int cache_result;
  public short errorCode;
  public ArrayList finfo;
  public int result;
  public long uin;
  
  public GetFriendsVideoAbiResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetFriendsVideoAbiResp(long paramLong, ArrayList paramArrayList, int paramInt, short paramShort)
  {
    this.uin = paramLong;
    this.finfo = paramArrayList;
    this.result = paramInt;
    this.errorCode = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_finfo == null)
    {
      cache_finfo = new ArrayList();
      UserVideoAbi localUserVideoAbi = new UserVideoAbi();
      cache_finfo.add(localUserVideoAbi);
    }
    this.finfo = ((ArrayList)paramJceInputStream.read(cache_finfo, 1, true));
    this.result = paramJceInputStream.read(this.result, 2, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.finfo, 1);
    paramJceOutputStream.write(this.result, 2);
    paramJceOutputStream.write(this.errorCode, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetFriendsVideoAbiResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */