package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ModifyGroupCardResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList cache_vecUin;
  public long dwGroupCode;
  public long dwGroupUin;
  public int result;
  public ArrayList vecUin;
  
  public ModifyGroupCardResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ModifyGroupCardResp(int paramInt, long paramLong1, long paramLong2, ArrayList paramArrayList)
  {
    this.result = paramInt;
    this.dwGroupUin = paramLong1;
    this.dwGroupCode = paramLong2;
    this.vecUin = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.dwGroupUin = paramJceInputStream.read(this.dwGroupUin, 1, true);
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 2, true);
    if (cache_vecUin == null)
    {
      cache_vecUin = new ArrayList();
      cache_vecUin.add(Long.valueOf(0L));
    }
    this.vecUin = ((ArrayList)paramJceInputStream.read(cache_vecUin, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.dwGroupUin, 1);
    paramJceOutputStream.write(this.dwGroupCode, 2);
    paramJceOutputStream.write(this.vecUin, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\ModifyGroupCardResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */