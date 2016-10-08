package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GROUP_RIGHT_INFO
  extends JceStruct
{
  public int flag;
  public byte groupId;
  public String groupName;
  public byte seqId;
  
  public GROUP_RIGHT_INFO()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.groupName = "";
  }
  
  public GROUP_RIGHT_INFO(byte paramByte1, byte paramByte2, String paramString, int paramInt)
  {
    this.groupName = "";
    this.groupId = paramByte1;
    this.seqId = paramByte2;
    this.groupName = paramString;
    this.flag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.groupId = paramJceInputStream.read(this.groupId, 0, true);
    this.seqId = paramJceInputStream.read(this.seqId, 1, true);
    this.groupName = paramJceInputStream.readString(2, true);
    this.flag = paramJceInputStream.read(this.flag, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.groupId, 0);
    paramJceOutputStream.write(this.seqId, 1);
    paramJceOutputStream.write(this.groupName, 2);
    paramJceOutputStream.write(this.flag, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\GROUP_RIGHT_INFO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */