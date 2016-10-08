package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PersonInfoField
  extends JceStruct
{
  public long uField;
  
  public PersonInfoField()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PersonInfoField(long paramLong)
  {
    this.uField = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uField = paramJceInputStream.read(this.uField, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uField, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\PersonInfoField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */