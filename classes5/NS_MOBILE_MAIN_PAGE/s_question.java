package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_question
  extends JceStruct
{
  public String qustion1;
  public String qustion2;
  public String qustion3;
  public String result1;
  public String result2;
  public String result3;
  
  public s_question()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.qustion1 = "";
    this.qustion2 = "";
    this.qustion3 = "";
    this.result1 = "";
    this.result2 = "";
    this.result3 = "";
  }
  
  public s_question(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.qustion1 = "";
    this.qustion2 = "";
    this.qustion3 = "";
    this.result1 = "";
    this.result2 = "";
    this.result3 = "";
    this.qustion1 = paramString1;
    this.qustion2 = paramString2;
    this.qustion3 = paramString3;
    this.result1 = paramString4;
    this.result2 = paramString5;
    this.result3 = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qustion1 = paramJceInputStream.readString(0, false);
    this.qustion2 = paramJceInputStream.readString(1, false);
    this.qustion3 = paramJceInputStream.readString(2, false);
    this.result1 = paramJceInputStream.readString(3, false);
    this.result2 = paramJceInputStream.readString(4, false);
    this.result3 = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.qustion1 != null) {
      paramJceOutputStream.write(this.qustion1, 0);
    }
    if (this.qustion2 != null) {
      paramJceOutputStream.write(this.qustion2, 1);
    }
    if (this.qustion3 != null) {
      paramJceOutputStream.write(this.qustion3, 2);
    }
    if (this.result1 != null) {
      paramJceOutputStream.write(this.result1, 3);
    }
    if (this.result2 != null) {
      paramJceOutputStream.write(this.result2, 4);
    }
    if (this.result3 != null) {
      paramJceOutputStream.write(this.result3, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_question.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */