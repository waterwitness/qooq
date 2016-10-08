import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class pwy
  extends DefaultHandler
{
  private int jdField_a_of_type_Int;
  public String a;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  public HashMap a;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public pwy(HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.b = "0";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^([0-9]{1,5}|\\{([\\s\\S]*)\\})$");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  private boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches();
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuffer.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!a(this.jdField_a_of_type_JavaLangStringBuffer.toString()))
      {
        if (QLog.isColorLevel()) {
          QLog.e(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler format is error: " + paramString2 + "-" + this.jdField_a_of_type_JavaLangStringBuffer.toString());
        }
        return;
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) {
        break label232;
      }
      paramString1 = (pwz)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler parse to TEMPMAP update oldInfo: " + paramString2 + "-" + paramString1.toString());
      }
      if (paramString1.jdField_a_of_type_Int < this.jdField_a_of_type_Int)
      {
        paramString1.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        paramString1.b = this.jdField_a_of_type_JavaLangStringBuffer.toString();
        paramString1.c = this.b;
        paramString1.d = this.jdField_a_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler parse to TEMPMAP update newInfo: " + paramString2 + "-" + paramString1.toString());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      label232:
      paramString1 = new pwz();
      paramString1.jdField_a_of_type_JavaLangString = paramString2;
      paramString1.b = this.jdField_a_of_type_JavaLangStringBuffer.toString();
      paramString1.c = this.b;
      paramString1.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      paramString1.d = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler parse to TEMPMAP add: " + paramString2 + "-" + paramString1.toString());
      }
    }
  }
  
  public void startDocument()
  {
    super.startDocument();
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    int i = 0;
    if (paramString2.equals("features"))
    {
      if (i < paramAttributes.getLength())
      {
        if (paramAttributes.getLocalName(i).equals("weight")) {
          this.jdField_a_of_type_Int = Integer.parseInt(paramAttributes.getValue(i));
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramAttributes.getLocalName(i).equals("taskId")) {
            this.b = paramAttributes.getValue(i);
          } else if (paramAttributes.getLocalName(i).equals("testType")) {
            this.jdField_a_of_type_JavaLangString = paramAttributes.getValue(i);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.jdField_a_of_type_JavaLangStringBuffer.length());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */