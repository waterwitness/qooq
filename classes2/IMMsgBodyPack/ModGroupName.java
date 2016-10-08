package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ModGroupName
  extends JceStruct
{
  public long dwGroupID;
  public String strGroupName;
  
  public ModGroupName()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strGroupName = "";
  }
  
  public ModGroupName(long paramLong, String paramString)
  {
    this.strGroupName = "";
    this.dwGroupID = paramLong;
    this.strGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
    this.strGroupName = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
    if (this.strGroupName != null) {
      paramJceOutputStream.write(this.strGroupName, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\ModGroupName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */