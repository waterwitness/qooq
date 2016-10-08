package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetAllBgMusicListReq
  extends JceStruct
{
  public long host_uin;
  
  public GetAllBgMusicListReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetAllBgMusicListReq(long paramLong)
  {
    this.host_uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.host_uin = paramJceInputStream.read(this.host_uin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.host_uin, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MUSIC\GetAllBgMusicListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */