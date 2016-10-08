package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Tips
  extends JceStruct
{
  public String button;
  public String content;
  public String title;
  
  public Tips()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.title = "";
    this.button = "";
    this.content = "";
  }
  
  public Tips(String paramString1, String paramString2, String paramString3)
  {
    this.title = "";
    this.button = "";
    this.content = "";
    this.title = paramString1;
    this.button = paramString2;
    this.content = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, true);
    this.button = paramJceInputStream.readString(1, true);
    this.content = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.title, 0);
    paramJceOutputStream.write(this.button, 1);
    paramJceOutputStream.write(this.content, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MAAccessClient\Tips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */