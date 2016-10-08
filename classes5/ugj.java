import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DataAdapter;
import com.tencent.mobileqq.richmedia.dc.DataCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ugj
  extends DataAdapter
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  private ugj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HashMap a(String paramString)
  {
    paramString = null;
    if ((this.jdField_a_of_type_Long == 0L) || (this.c == 0L)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      paramString = new StringBuilder();
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Boolean)
    {
      localHashMap.put("is_progressive", "progressive");
      localHashMap.put("view_count", "1");
      if (this.jdField_b_of_type_Boolean)
      {
        localHashMap.put("failure", "1");
        if (QLog.isColorLevel())
        {
          paramString.append("progressive:\n");
          paramString.append("refresh_dp:" + String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) + "\n");
          paramString.append("refresh_large:" + String.valueOf(this.c - this.jdField_a_of_type_Long));
          QLog.i(DataCollector.a_, 2, paramString.toString());
        }
      }
    }
    label391:
    for (;;)
    {
      return localHashMap;
      if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) {
        localHashMap.put("to_dp", String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      }
      if ((this.c <= this.jdField_a_of_type_Long) || (this.c <= this.jdField_b_of_type_Long)) {
        break;
      }
      localHashMap.put("to_large", String.valueOf(this.c - this.jdField_a_of_type_Long));
      break;
      localHashMap.put("is_progressive", "baseline");
      localHashMap.put("view_count", "1");
      if (this.jdField_b_of_type_Boolean) {
        localHashMap.put("failure", "1");
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label391;
        }
        paramString.append("baseline:\n");
        paramString.append("refresh_large:" + String.valueOf(this.c - this.jdField_a_of_type_Long));
        QLog.i(DataCollector.a_, 2, paramString.toString());
        break;
        if (this.c > this.jdField_a_of_type_Long) {
          localHashMap.put("to_large", String.valueOf(this.c - this.jdField_a_of_type_Long));
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */