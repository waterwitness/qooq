package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SvcResponsePullDisMsgSeq
  extends JceStruct
{
  static ArrayList cache_vConfNumInfo;
  public byte cReplyCode;
  public String strResult;
  public ArrayList vConfNumInfo;
  
  public SvcResponsePullDisMsgSeq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strResult = "";
  }
  
  public SvcResponsePullDisMsgSeq(byte paramByte, String paramString, ArrayList paramArrayList)
  {
    this.strResult = "";
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.vConfNumInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, true);
    if (cache_vConfNumInfo == null)
    {
      cache_vConfNumInfo = new ArrayList();
      stConfNumInfo localstConfNumInfo = new stConfNumInfo();
      cache_vConfNumInfo.add(localstConfNumInfo);
    }
    this.vConfNumInfo = ((ArrayList)paramJceInputStream.read(cache_vConfNumInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cReplyCode, 0);
    paramJceOutputStream.write(this.strResult, 1);
    paramJceOutputStream.write(this.vConfNumInfo, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcResponsePullDisMsgSeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */