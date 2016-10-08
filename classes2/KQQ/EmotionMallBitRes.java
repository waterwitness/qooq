package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class EmotionMallBitRes
  extends JceStruct
{
  public byte cEmotionMall;
  
  public EmotionMallBitRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cEmotionMall = -1;
  }
  
  public EmotionMallBitRes(byte paramByte)
  {
    this.cEmotionMall = -1;
    this.cEmotionMall = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\EmotionMallBitRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */