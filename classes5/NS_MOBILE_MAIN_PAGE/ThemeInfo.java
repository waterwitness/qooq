package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ThemeInfo
  extends JceStruct
{
  static CoverItem cache_stCoverItem;
  static ThemeItem cache_stThemeItem;
  public CoverItem stCoverItem;
  public ThemeItem stThemeItem;
  public long uTotalSize;
  
  public ThemeInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ThemeInfo(ThemeItem paramThemeItem, CoverItem paramCoverItem, long paramLong)
  {
    this.stThemeItem = paramThemeItem;
    this.stCoverItem = paramCoverItem;
    this.uTotalSize = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stThemeItem == null) {
      cache_stThemeItem = new ThemeItem();
    }
    this.stThemeItem = ((ThemeItem)paramJceInputStream.read(cache_stThemeItem, 0, false));
    if (cache_stCoverItem == null) {
      cache_stCoverItem = new CoverItem();
    }
    this.stCoverItem = ((CoverItem)paramJceInputStream.read(cache_stCoverItem, 1, false));
    this.uTotalSize = paramJceInputStream.read(this.uTotalSize, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stThemeItem != null) {
      paramJceOutputStream.write(this.stThemeItem, 0);
    }
    if (this.stCoverItem != null) {
      paramJceOutputStream.write(this.stCoverItem, 1);
    }
    paramJceOutputStream.write(this.uTotalSize, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\ThemeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */