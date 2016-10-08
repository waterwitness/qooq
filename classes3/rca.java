import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class rca
  extends DefaultHandler
{
  public static final String a = "msg";
  public static final String b = "title";
  public static final String c = "summary";
  public static final String d = "source";
  public static final String e = "url";
  public static final String f = "name";
  public static final String g = "brief";
  MessageForTroopFee a;
  public String h;
  
  public rca()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new MessageForTroopFee();
    this.h = "";
  }
  
  public MessageForTroopFee a()
  {
    return this.a;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (this.h.equals("title")) {
      this.a.title = paramArrayOfChar;
    }
    while (!this.h.equals("summary")) {
      return;
    }
    this.a.summary = paramArrayOfChar;
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("msg"))
    {
      this.a.actionUrl = paramAttributes.getValue("url");
      this.a.brief = paramAttributes.getValue("brief");
    }
    do
    {
      return;
      if (paramString3.equals("title"))
      {
        this.h = "title";
        return;
      }
      if (paramString3.equals("summary"))
      {
        this.h = "summary";
        return;
      }
    } while (!paramString3.equals("source"));
    this.a.source = paramAttributes.getValue("name");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */