package AvatarInfo;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class QQHeadUrlReq
  extends JceStruct
{
  static ArrayList cache_destUserInfo;
  public ArrayList destUserInfo;
  public byte dstUsrType;
  public long myUin;
  
  public QQHeadUrlReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQHeadUrlReq(long paramLong, ArrayList paramArrayList, byte paramByte)
  {
    this.myUin = paramLong;
    this.destUserInfo = paramArrayList;
    this.dstUsrType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.myUin = paramJceInputStream.read(this.myUin, 0, true);
    if (cache_destUserInfo == null)
    {
      cache_destUserInfo = new ArrayList();
      DestQQHeadInfo localDestQQHeadInfo = new DestQQHeadInfo();
      cache_destUserInfo.add(localDestQQHeadInfo);
    }
    this.destUserInfo = ((ArrayList)paramJceInputStream.read(cache_destUserInfo, 1, true));
    this.dstUsrType = paramJceInputStream.read(this.dstUsrType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.myUin, 0);
    paramJceOutputStream.write(this.destUserInfo, 1);
    paramJceOutputStream.write(this.dstUsrType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AvatarInfo\QQHeadUrlReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */