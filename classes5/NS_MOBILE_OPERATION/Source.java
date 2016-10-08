package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Source
  extends JceStruct
{
  public int apptype;
  public int subtype;
  public int termtype;
  
  public Source()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Source(int paramInt1, int paramInt2)
  {
    this.subtype = paramInt1;
    this.termtype = paramInt2;
  }
  
  public Source(int paramInt1, int paramInt2, int paramInt3)
  {
    this.subtype = paramInt1;
    this.termtype = paramInt2;
    this.apptype = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subtype = paramJceInputStream.read(this.subtype, 0, false);
    this.termtype = paramJceInputStream.read(this.termtype, 1, false);
    this.apptype = paramJceInputStream.read(this.apptype, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subtype, 0);
    paramJceOutputStream.write(this.termtype, 1);
    paramJceOutputStream.write(this.apptype, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\Source.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */