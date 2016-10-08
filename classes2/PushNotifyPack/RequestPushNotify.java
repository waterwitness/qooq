package PushNotifyPack;

import OnlinePushPack.MsgInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestPushNotify
  extends JceStruct
{
  static MsgInfo cache_stMsgInfo = new MsgInfo();
  static byte[] cache_vNotifyCookie;
  public byte cType;
  public long lBindedUin;
  public long lUin;
  public MsgInfo stMsgInfo;
  public String strCmd = "";
  public String strService = "";
  public int usMsgType;
  public byte[] vNotifyCookie;
  public int wGeneralFlag;
  public int wUserActive;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vNotifyCookie = (byte[])new byte[1];
    ((byte[])cache_vNotifyCookie)[0] = 0;
  }
  
  public RequestPushNotify() {}
  
  public RequestPushNotify(long paramLong1, byte paramByte, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong2, MsgInfo paramMsgInfo)
  {
    this.lUin = paramLong1;
    this.cType = paramByte;
    this.strService = paramString1;
    this.strCmd = paramString2;
    this.vNotifyCookie = paramArrayOfByte;
    this.usMsgType = paramInt1;
    this.wUserActive = paramInt2;
    this.wGeneralFlag = paramInt3;
    this.lBindedUin = paramLong2;
    this.stMsgInfo = paramMsgInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.strService = paramJceInputStream.readString(2, true);
    this.strCmd = paramJceInputStream.readString(3, true);
    this.vNotifyCookie = ((byte[])paramJceInputStream.read(cache_vNotifyCookie, 4, false));
    this.usMsgType = paramJceInputStream.read(this.usMsgType, 5, false);
    this.wUserActive = paramJceInputStream.read(this.wUserActive, 6, false);
    this.wGeneralFlag = paramJceInputStream.read(this.wGeneralFlag, 7, false);
    this.lBindedUin = paramJceInputStream.read(this.lBindedUin, 8, false);
    this.stMsgInfo = ((MsgInfo)paramJceInputStream.read(cache_stMsgInfo, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.strService, 2);
    paramJceOutputStream.write(this.strCmd, 3);
    if (this.vNotifyCookie != null) {
      paramJceOutputStream.write(this.vNotifyCookie, 4);
    }
    paramJceOutputStream.write(this.usMsgType, 5);
    paramJceOutputStream.write(this.wUserActive, 6);
    paramJceOutputStream.write(this.wGeneralFlag, 7);
    paramJceOutputStream.write(this.lBindedUin, 8);
    if (this.stMsgInfo != null) {
      paramJceOutputStream.write(this.stMsgInfo, 9);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PushNotifyPack\RequestPushNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */