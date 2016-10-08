package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SelfInfo
  extends JceStruct
{
  public byte cSex;
  
  public SelfInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SelfInfo(byte paramByte)
  {
    this.cSex = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cSex = paramJceInputStream.read(this.cSex, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cSex, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\SelfInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */