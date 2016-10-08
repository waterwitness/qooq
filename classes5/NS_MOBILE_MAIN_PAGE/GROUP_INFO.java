package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GROUP_INFO
  extends JceStruct
{
  public short friendCount;
  public String groupName;
  public byte seqId;
  
  public GROUP_INFO()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.groupName = "";
  }
  
  public GROUP_INFO(byte paramByte, String paramString, short paramShort)
  {
    this.groupName = "";
    this.seqId = paramByte;
    this.groupName = paramString;
    this.friendCount = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.seqId = paramJceInputStream.read(this.seqId, 0, true);
    this.groupName = paramJceInputStream.readString(1, true);
    this.friendCount = paramJceInputStream.read(this.friendCount, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seqId, 0);
    paramJceOutputStream.write(this.groupName, 1);
    paramJceOutputStream.write(this.friendCount, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\GROUP_INFO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */