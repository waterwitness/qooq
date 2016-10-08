package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class FireCrackerInfo
  extends JceStruct
{
  static Margin cache_stMargin = new Margin();
  public boolean bShow;
  public Margin stMargin;
  public String strFireCrackerUrl = "";
  public String strFontColor = "";
  public String strJumpUrl = "";
  public long uiFontSize;
  public long uiFrameIntervalMs;
  public long uiLevel;
  public long uiLikeCount;
  public long uiLoopIntervalMs;
  public long uiReason;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FireCrackerInfo() {}
  
  public FireCrackerInfo(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, String paramString2, Margin paramMargin, long paramLong3, long paramLong4, String paramString3, long paramLong5, long paramLong6)
  {
    this.bShow = paramBoolean;
    this.uiLikeCount = paramLong1;
    this.uiLevel = paramLong2;
    this.strJumpUrl = paramString1;
    this.strFireCrackerUrl = paramString2;
    this.stMargin = paramMargin;
    this.uiFrameIntervalMs = paramLong3;
    this.uiLoopIntervalMs = paramLong4;
    this.strFontColor = paramString3;
    this.uiFontSize = paramLong5;
    this.uiReason = paramLong6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bShow = paramJceInputStream.read(this.bShow, 0, false);
    this.uiLikeCount = paramJceInputStream.read(this.uiLikeCount, 1, false);
    this.uiLevel = paramJceInputStream.read(this.uiLevel, 2, false);
    this.strJumpUrl = paramJceInputStream.readString(3, false);
    this.strFireCrackerUrl = paramJceInputStream.readString(4, false);
    this.stMargin = ((Margin)paramJceInputStream.read(cache_stMargin, 5, false));
    this.uiFrameIntervalMs = paramJceInputStream.read(this.uiFrameIntervalMs, 6, false);
    this.uiLoopIntervalMs = paramJceInputStream.read(this.uiLoopIntervalMs, 7, false);
    this.strFontColor = paramJceInputStream.readString(8, false);
    this.uiFontSize = paramJceInputStream.read(this.uiFontSize, 9, false);
    this.uiReason = paramJceInputStream.read(this.uiReason, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bShow, 0);
    paramJceOutputStream.write(this.uiLikeCount, 1);
    paramJceOutputStream.write(this.uiLevel, 2);
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 3);
    }
    if (this.strFireCrackerUrl != null) {
      paramJceOutputStream.write(this.strFireCrackerUrl, 4);
    }
    if (this.stMargin != null) {
      paramJceOutputStream.write(this.stMargin, 5);
    }
    paramJceOutputStream.write(this.uiFrameIntervalMs, 6);
    paramJceOutputStream.write(this.uiLoopIntervalMs, 7);
    if (this.strFontColor != null) {
      paramJceOutputStream.write(this.strFontColor, 8);
    }
    paramJceOutputStream.write(this.uiFontSize, 9);
    paramJceOutputStream.write(this.uiReason, 10);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MOBILE_QZMALL_PROTOCOL\FireCrackerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */