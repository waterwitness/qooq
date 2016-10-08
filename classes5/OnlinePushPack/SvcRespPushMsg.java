package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SvcRespPushMsg
  extends JceStruct
{
  static ArrayList cache_vDelInfos;
  public long lUin;
  public int svrip;
  public ArrayList vDelInfos;
  
  public SvcRespPushMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRespPushMsg(long paramLong, ArrayList paramArrayList, int paramInt)
  {
    this.lUin = paramLong;
    this.vDelInfos = paramArrayList;
    this.svrip = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_vDelInfos == null)
    {
      cache_vDelInfos = new ArrayList();
      DelMsgInfo localDelMsgInfo = new DelMsgInfo();
      cache_vDelInfos.add(localDelMsgInfo);
    }
    this.vDelInfos = ((ArrayList)paramJceInputStream.read(cache_vDelInfos, 1, true));
    this.svrip = paramJceInputStream.read(this.svrip, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vDelInfos, 1);
    paramJceOutputStream.write(this.svrip, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\OnlinePushPack\SvcRespPushMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */