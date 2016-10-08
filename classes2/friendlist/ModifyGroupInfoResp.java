package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ModifyGroupInfoResp
  extends JceStruct
{
  static int cache_result;
  public long dwGroupCode;
  public int result;
  
  public ModifyGroupInfoResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ModifyGroupInfoResp(int paramInt, long paramLong)
  {
    this.result = paramInt;
    this.dwGroupCode = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.dwGroupCode, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\ModifyGroupInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */