package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class EntranceContent
  extends JceStruct
{
  static byte[] cache_content_buff;
  public byte[] content_buff;
  public int type;
  
  public EntranceContent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EntranceContent(int paramInt, byte[] paramArrayOfByte)
  {
    this.type = paramInt;
    this.content_buff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    if (cache_content_buff == null)
    {
      cache_content_buff = (byte[])new byte[1];
      ((byte[])cache_content_buff)[0] = 0;
    }
    this.content_buff = ((byte[])paramJceInputStream.read(cache_content_buff, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.content_buff, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\EntranceContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */