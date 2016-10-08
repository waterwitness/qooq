package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SignatureRes
  extends JceStruct
{
  public long dwSeq;
  public String strLongNick;
  public long uin;
  
  public SignatureRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strLongNick = "";
  }
  
  public SignatureRes(long paramLong1, long paramLong2, String paramString)
  {
    this.strLongNick = "";
    this.uin = paramLong1;
    this.dwSeq = paramLong2;
    this.strLongNick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.dwSeq = paramJceInputStream.read(this.dwSeq, 1, true);
    this.strLongNick = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.dwSeq, 1);
    paramJceOutputStream.write(this.strLongNick, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\SignatureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */