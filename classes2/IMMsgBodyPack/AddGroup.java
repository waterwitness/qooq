package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AddGroup
  extends JceStruct
{
  public long dwGroupID;
  public long dwSortID;
  public String strGroupName;
  
  public AddGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strGroupName = "";
  }
  
  public AddGroup(long paramLong1, long paramLong2, String paramString)
  {
    this.strGroupName = "";
    this.dwGroupID = paramLong1;
    this.dwSortID = paramLong2;
    this.strGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
    this.dwSortID = paramJceInputStream.read(this.dwSortID, 1, false);
    this.strGroupName = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
    paramJceOutputStream.write(this.dwSortID, 1);
    if (this.strGroupName != null) {
      paramJceOutputStream.write(this.strGroupName, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\AddGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */