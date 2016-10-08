package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcRequestSendFile
  extends JceStruct
{
  static stFileInfo cache_stFile;
  public byte cFileType;
  public byte cKeyType;
  public long lToAppId;
  public long lToInstanceId;
  public long lToUin;
  public stFileInfo stFile;
  
  public SvcRequestSendFile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRequestSendFile(byte paramByte1, stFileInfo paramstFileInfo, long paramLong1, long paramLong2, long paramLong3, byte paramByte2)
  {
    this.cKeyType = paramByte1;
    this.stFile = paramstFileInfo;
    this.lToUin = paramLong1;
    this.lToAppId = paramLong2;
    this.lToInstanceId = paramLong3;
    this.cFileType = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cKeyType = paramJceInputStream.read(this.cKeyType, 0, true);
    if (cache_stFile == null) {
      cache_stFile = new stFileInfo();
    }
    this.stFile = ((stFileInfo)paramJceInputStream.read(cache_stFile, 1, true));
    this.lToUin = paramJceInputStream.read(this.lToUin, 2, true);
    this.lToAppId = paramJceInputStream.read(this.lToAppId, 3, true);
    this.lToInstanceId = paramJceInputStream.read(this.lToInstanceId, 4, true);
    this.cFileType = paramJceInputStream.read(this.cFileType, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cKeyType, 0);
    paramJceOutputStream.write(this.stFile, 1);
    paramJceOutputStream.write(this.lToUin, 2);
    paramJceOutputStream.write(this.lToAppId, 3);
    paramJceOutputStream.write(this.lToInstanceId, 4);
    paramJceOutputStream.write(this.cFileType, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcRequestSendFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */