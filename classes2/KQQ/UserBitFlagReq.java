package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserBitFlagReq
  extends JceStruct
{
  public byte cAccout2Dis;
  public byte cEmotionMall;
  public byte cMyWallet;
  public byte cPtt2Text;
  
  public UserBitFlagReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cEmotionMall = -1;
    this.cMyWallet = -1;
    this.cPtt2Text = -1;
    this.cAccout2Dis = -1;
  }
  
  public UserBitFlagReq(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.cEmotionMall = -1;
    this.cMyWallet = -1;
    this.cPtt2Text = -1;
    this.cAccout2Dis = -1;
    this.cEmotionMall = paramByte1;
    this.cMyWallet = paramByte2;
    this.cPtt2Text = paramByte3;
    this.cAccout2Dis = paramByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
    this.cMyWallet = paramJceInputStream.read(this.cMyWallet, 1, false);
    this.cPtt2Text = paramJceInputStream.read(this.cPtt2Text, 2, false);
    this.cAccout2Dis = paramJceInputStream.read(this.cAccout2Dis, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
    paramJceOutputStream.write(this.cMyWallet, 1);
    paramJceOutputStream.write(this.cPtt2Text, 2);
    paramJceOutputStream.write(this.cAccout2Dis, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\UserBitFlagReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */