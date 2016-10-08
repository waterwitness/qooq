package ActionMsg;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MsgBody
  extends JceStruct
{
  public String actMsgContentValue;
  public String action;
  public String msg;
  public long shareAppID;
  
  public MsgBody()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
    this.action = "";
    this.actMsgContentValue = "";
  }
  
  public MsgBody(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.msg = "";
    this.action = "";
    this.actMsgContentValue = "";
    this.msg = paramString1;
    this.action = paramString2;
    this.shareAppID = paramLong;
    this.actMsgContentValue = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.msg = paramJceInputStream.readString(0, true);
    this.action = paramJceInputStream.readString(1, true);
    this.shareAppID = paramJceInputStream.read(this.shareAppID, 2, false);
    this.actMsgContentValue = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.msg, 0);
    paramJceOutputStream.write(this.action, 1);
    paramJceOutputStream.write(this.shareAppID, 2);
    if (this.actMsgContentValue != null) {
      paramJceOutputStream.write(this.actMsgContentValue, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ActionMsg\MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */