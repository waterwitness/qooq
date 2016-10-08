import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class qgz
  implements Printer
{
  public static int a = 0;
  public static final String a = ">>";
  public static final String b = "<<";
  private static final String jdField_c_of_type_JavaLangString = "TM.global.LooperPrinter";
  private long a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private String d;
  private String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 200;
  }
  
  public qgz(int paramInt, String paramString)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.e = paramString;
  }
  
  private static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith(">>>"))) {
      return null;
    }
    int i = paramString.indexOf('(');
    if (i == -1) {
      return null;
    }
    int j = paramString.indexOf(')', i);
    if (j == -1) {
      return null;
    }
    String str1 = paramString.substring(i + 1, j);
    int k = paramString.indexOf("} ", j);
    if (k == -1) {
      return null;
    }
    j = paramString.indexOf('@', k + 2);
    i = j;
    if (j == -1)
    {
      j = paramString.indexOf(':', k + 2);
      i = j;
      if (j == -1)
      {
        i = paramString.indexOf(' ', k + 2);
        if (i == -1) {
          break label164;
        }
      }
    }
    String str2 = paramString.substring(k + 2, i);
    i = paramString.indexOf(": ", i);
    if (i == -1)
    {
      return null;
      label164:
      return null;
    }
    return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TM.global.LooperPrinter", 2, "setting threshold, threshold=" + paramInt);
    }
    jdField_a_of_type_Int = paramInt;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.d = paramString;
      if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_c_of_type_Int)) {
        UnifiedMonitor.a().reportStackIfTimeout(this.jdField_c_of_type_Int);
      }
    }
    while ((this.jdField_c_of_type_Long == 0L) || (!paramString.startsWith("<<"))) {
      return;
    }
    this.jdField_a_of_type_Long += 1L;
    long l = SystemClock.uptimeMillis() - this.jdField_c_of_type_Long;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long += l;
    paramString = null;
    Object localObject;
    if ((ThreadManager.b) || (ThreadManager.a))
    {
      localObject = a(this.d);
      paramString = (String)localObject;
      if (QLog.isDevelopLevel())
      {
        QLog.d("AutoMonitor", 4, this.e + ", cost=" + l + ", " + (String)localObject);
        paramString = (String)localObject;
      }
    }
    if (l > jdField_a_of_type_Int)
    {
      if (!UnifiedMonitor.a().whetherReportThisTime(this.jdField_c_of_type_Int))
      {
        this.jdField_b_of_type_Int = 0;
        return;
      }
      HashMap localHashMap;
      if (paramString == null)
      {
        paramString = a(this.d);
        localHashMap = new HashMap(8);
        localObject = BaseActivity.sTopActivity;
        if (localObject == null) {
          break label278;
        }
      }
      label278:
      for (localObject = localObject.getClass().getName();; localObject = "")
      {
        localHashMap.put("act", localObject);
        UnifiedMonitor.a().addEvent(this.jdField_c_of_type_Int, paramString, (int)l, this.jdField_b_of_type_Int, localHashMap);
        this.jdField_b_of_type_Int = 0;
        return;
        break;
      }
    }
    if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_c_of_type_Int)) {
      UnifiedMonitor.a().notifyNotTimeout(this.jdField_c_of_type_Int);
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  public String toString()
  {
    return super.toString() + "(msgCount = " + this.jdField_a_of_type_Long + ", totalCost = " + this.jdField_b_of_type_Long + ")";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */