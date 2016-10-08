package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class CheckUpdateResp
  extends JceStruct
{
  static ArrayList cache_vecResPkg;
  public long dwSsoSeq;
  public boolean isEnd;
  public byte result;
  public ArrayList vecResPkg;
  
  public CheckUpdateResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.isEnd = true;
  }
  
  public CheckUpdateResp(byte paramByte, ArrayList paramArrayList, boolean paramBoolean, long paramLong)
  {
    this.isEnd = true;
    this.result = paramByte;
    this.vecResPkg = paramArrayList;
    this.isEnd = paramBoolean;
    this.dwSsoSeq = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    if (cache_vecResPkg == null)
    {
      cache_vecResPkg = new ArrayList();
      RespItem localRespItem = new RespItem();
      cache_vecResPkg.add(localRespItem);
    }
    this.vecResPkg = ((ArrayList)paramJceInputStream.read(cache_vecResPkg, 1, true));
    this.isEnd = paramJceInputStream.read(this.isEnd, 2, false);
    this.dwSsoSeq = paramJceInputStream.read(this.dwSsoSeq, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.vecResPkg, 1);
    paramJceOutputStream.write(this.isEnd, 2);
    paramJceOutputStream.write(this.dwSsoSeq, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\CheckUpdateResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */