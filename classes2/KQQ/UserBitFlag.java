package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserBitFlag
  extends JceStruct
{
  public byte cEmotionMall;
  public byte cSyncShuoShuo;
  
  public UserBitFlag()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cEmotionMall = -1;
    this.cSyncShuoShuo = -1;
  }
  
  public UserBitFlag(byte paramByte1, byte paramByte2)
  {
    this.cEmotionMall = -1;
    this.cSyncShuoShuo = -1;
    this.cEmotionMall = paramByte1;
    this.cSyncShuoShuo = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
    this.cSyncShuoShuo = paramJceInputStream.read(this.cSyncShuoShuo, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
    paramJceOutputStream.write(this.cSyncShuoShuo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\UserBitFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */