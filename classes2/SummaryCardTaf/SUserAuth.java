package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SUserAuth
  extends JceStruct
{
  static int cache_keytype;
  public String keystr;
  public int keytype;
  
  public SUserAuth()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.keystr = "";
  }
  
  public SUserAuth(int paramInt, String paramString)
  {
    this.keystr = "";
    this.keytype = paramInt;
    this.keystr = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.keytype = paramJceInputStream.read(this.keytype, 0, true);
    this.keystr = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.keytype, 0);
    paramJceOutputStream.write(this.keystr, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\SUserAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */