package AvatarInfo;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class QQHeadUrlResp
  extends JceStruct
{
  static ArrayList cache_UserHeadInfoList;
  public ArrayList UserHeadInfoList;
  public long myUin;
  public int result;
  
  public QQHeadUrlResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQHeadUrlResp(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    this.myUin = paramLong;
    this.result = paramInt;
    this.UserHeadInfoList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.myUin = paramJceInputStream.read(this.myUin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    if (cache_UserHeadInfoList == null)
    {
      cache_UserHeadInfoList = new ArrayList();
      QQHeadInfo localQQHeadInfo = new QQHeadInfo();
      cache_UserHeadInfoList.add(localQQHeadInfo);
    }
    this.UserHeadInfoList = ((ArrayList)paramJceInputStream.read(cache_UserHeadInfoList, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.myUin, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.UserHeadInfoList, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AvatarInfo\QQHeadUrlResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */