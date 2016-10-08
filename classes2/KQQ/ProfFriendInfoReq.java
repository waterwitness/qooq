package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ProfFriendInfoReq
  extends JceStruct
{
  static ArrayList cache_vFieldIdList;
  public byte cDataCode;
  public long uFriendUin;
  public ArrayList vFieldIdList;
  
  public ProfFriendInfoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfFriendInfoReq(long paramLong, byte paramByte, ArrayList paramArrayList)
  {
    this.uFriendUin = paramLong;
    this.cDataCode = paramByte;
    this.vFieldIdList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFriendUin = paramJceInputStream.read(this.uFriendUin, 0, true);
    this.cDataCode = paramJceInputStream.read(this.cDataCode, 1, true);
    if (cache_vFieldIdList == null)
    {
      cache_vFieldIdList = new ArrayList();
      cache_vFieldIdList.add(Short.valueOf((short)0));
    }
    this.vFieldIdList = ((ArrayList)paramJceInputStream.read(cache_vFieldIdList, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFriendUin, 0);
    paramJceOutputStream.write(this.cDataCode, 1);
    paramJceOutputStream.write(this.vFieldIdList, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfFriendInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */