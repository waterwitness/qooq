package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QZoneClickReport$ReportInfo
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  private Map a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  private boolean b;
  public int c;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "0";
  public String g = "";
  public String h = "";
  public String i = "2";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  
  public QZoneClickReport$ReportInfo()
  {
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = NetworkState.b();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public QZoneClickReport$ReportInfo(long paramLong, int paramInt, String paramString, Map paramMap)
  {
    this();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = true;
    if (paramMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
    }
  }
  
  public QZoneClickReport$ReportInfo(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, ArrayList paramArrayList)
  {
    this();
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_b_of_type_Int = paramInt;
    this.g = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public QZoneClickReport$ReportInfo(long paramLong, String paramString, Map paramMap)
  {
    this();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = true;
    if (paramMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
    }
  }
  
  public QZoneClickReport$ReportInfo(String paramString)
  {
    this();
    this.f = paramString;
    this.jdField_c_of_type_JavaLangString = "12";
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    if (!TextUtils.isEmpty(this.h)) {}
    Object localObject;
    for (JSONObject localJSONObject = new JSONObject(this.h);; localJSONObject = new JSONObject())
    {
      localJSONObject.put("touin", this.jdField_a_of_type_Long);
      localJSONObject.put("network_type", String.valueOf(this.jdField_a_of_type_Int));
      localJSONObject.put("tabletype", this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.isEmpty())) {
        break label345;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    localJSONObject.put("refer", this.jdField_b_of_type_JavaLangString);
    localJSONObject.put("actiontype", this.jdField_c_of_type_JavaLangString);
    localJSONObject.put("subactiontype", this.d);
    localJSONObject.put("tabletype", this.jdField_b_of_type_Int);
    localJSONObject.put("domain_type", this.i);
    localJSONObject.put("reserves", this.e);
    localJSONObject.put("source_type", this.k);
    localJSONObject.put("source_from", this.l);
    localJSONObject.put("source_to", this.m);
    localJSONObject.put("mergenum", this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      int n = 0;
      while (n < i1)
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(n);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localJSONObject.put("reserves" + (n + 2), localObject);
        }
        n += 1;
      }
    }
    label345:
    localJSONObject.put("read_source", this.f);
    localJSONObject.put("time", String.valueOf(this.jdField_b_of_type_Long));
    localJSONObject.put("info", this.g);
    localJSONObject.put("pushstatkey", this.j);
    return localJSONObject;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneClickReport$ReportInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */