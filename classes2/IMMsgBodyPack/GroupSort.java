package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GroupSort
  extends JceStruct
{
  public long dwGroupID;
  public long dwSortID;
  
  public GroupSort()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GroupSort(long paramLong1, long paramLong2)
  {
    this.dwGroupID = paramLong1;
    this.dwSortID = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
    this.dwSortID = paramJceInputStream.read(this.dwSortID, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
    paramJceOutputStream.write(this.dwSortID, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\GroupSort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */