package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SvcRequestGetGroupMsgNum
  extends JceStruct
{
  static ArrayList cache_vGroupInfo;
  public byte cVerifyType;
  public long lUin;
  public ArrayList vGroupInfo;
  
  public SvcRequestGetGroupMsgNum()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRequestGetGroupMsgNum(long paramLong, ArrayList paramArrayList, byte paramByte)
  {
    this.lUin = paramLong;
    this.vGroupInfo = paramArrayList;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      SvcRequestGroupInfo localSvcRequestGroupInfo = new SvcRequestGroupInfo();
      cache_vGroupInfo.add(localSvcRequestGroupInfo);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 1, true));
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vGroupInfo, 1);
    paramJceOutputStream.write(this.cVerifyType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcRequestGetGroupMsgNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */