package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stAlbumAbiInfo
  extends JceStruct
{
  public long dwFriendUin;
  
  public stAlbumAbiInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public stAlbumAbiInfo(long paramLong)
  {
    this.dwFriendUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwFriendUin = paramJceInputStream.read(this.dwFriendUin, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwFriendUin, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\stAlbumAbiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */