package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MoodEntryContent
  extends JceStruct
{
  public String content;
  
  public MoodEntryContent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.content = "";
  }
  
  public MoodEntryContent(String paramString)
  {
    this.content = "";
    this.content = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_COVER_DATE\MoodEntryContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */