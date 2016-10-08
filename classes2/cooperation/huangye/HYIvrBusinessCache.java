package cooperation.huangye;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class HYIvrBusinessCache
{
  public static final String b = "huangye_ivr_business_txt";
  public String a;
  private HashMap a;
  private String c;
  
  public HYIvrBusinessCache()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = HYIvrBusinessCache.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    boolean bool1;
    if (paramString == null)
    {
      bool1 = false;
      return bool1;
    }
    long l;
    try
    {
      l = System.currentTimeMillis();
      paramString = new JSONObject(paramString).getJSONObject("result").getJSONObject("result");
      if (paramString != null)
      {
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramString.getString(str1);
          this.jdField_a_of_type_JavaUtilHashMap.put(str2, str1);
          continue;
          paramString.printStackTrace();
        }
      }
    }
    catch (JSONException paramString)
    {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = true;
      bool1 = true;
      try
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "buildUinBizMap cost time " + (System.currentTimeMillis() - l) + "ms");
        return true;
      }
      catch (JSONException paramString)
      {
        bool1 = bool2;
      }
    }
  }
  
  public String a()
  {
    if (this.c != null) {
      return this.c;
    }
    this.c = HYSharedPref.a().a("huangye_ivr_business_txt", null);
    return this.c;
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.c != null)
    {
      if ((this.c.equals(paramString2)) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
        return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      }
      if (a(paramString2))
      {
        this.c = paramString2;
        return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      }
      this.c = null;
      return null;
    }
    if (a(paramString2))
    {
      this.c = paramString2;
      return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    }
    this.c = null;
    return null;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a(String paramString)
  {
    if ((this.c == null) || (!this.c.equals(paramString)))
    {
      if (HYSharedPref.a().a("huangye_ivr_business_txt", paramString)) {
        this.c = paramString;
      }
      a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.c != null) {
      if ((!this.c.equals(paramString)) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
        if (!b(paramString)) {
          break label43;
        }
      }
    }
    for (this.c = paramString;; this.c = paramString)
    {
      return true;
      label43:
      this.c = null;
      return false;
      if (!b(paramString)) {
        break;
      }
    }
    this.c = null;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYIvrBusinessCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */