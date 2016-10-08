package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PanSocialInfo
  extends JceStruct
{
  public long uCharm;
  public long uCharmLevel;
  public long uCharmRank;
  public long uChatflag;
  public long uChatupCount;
  public long uCurLevelCharm;
  public long uNextLevelCharm;
  
  public PanSocialInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PanSocialInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    this.uCharmRank = paramLong1;
    this.uChatflag = paramLong2;
    this.uChatupCount = paramLong3;
    this.uCharm = paramLong4;
    this.uCharmLevel = paramLong5;
    this.uNextLevelCharm = paramLong6;
    this.uCurLevelCharm = paramLong7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCharmRank = paramJceInputStream.read(this.uCharmRank, 0, false);
    this.uChatflag = paramJceInputStream.read(this.uChatflag, 1, false);
    this.uChatupCount = paramJceInputStream.read(this.uChatupCount, 2, false);
    this.uCharm = paramJceInputStream.read(this.uCharm, 3, false);
    this.uCharmLevel = paramJceInputStream.read(this.uCharmLevel, 4, false);
    this.uNextLevelCharm = paramJceInputStream.read(this.uNextLevelCharm, 5, false);
    this.uCurLevelCharm = paramJceInputStream.read(this.uCurLevelCharm, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCharmRank, 0);
    paramJceOutputStream.write(this.uChatflag, 1);
    paramJceOutputStream.write(this.uChatupCount, 2);
    paramJceOutputStream.write(this.uCharm, 3);
    paramJceOutputStream.write(this.uCharmLevel, 4);
    paramJceOutputStream.write(this.uNextLevelCharm, 5);
    paramJceOutputStream.write(this.uCurLevelCharm, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\PanSocialInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */