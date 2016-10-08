package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stLevelRankPair
  extends JceStruct
{
  public long dwLevel;
  public String strRank;
  
  public stLevelRankPair()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strRank = "";
  }
  
  public stLevelRankPair(long paramLong, String paramString)
  {
    this.strRank = "";
    this.dwLevel = paramLong;
    this.strRank = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwLevel = paramJceInputStream.read(this.dwLevel, 0, false);
    this.strRank = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwLevel, 0);
    if (this.strRank != null) {
      paramJceOutputStream.write(this.strRank, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\stLevelRankPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */