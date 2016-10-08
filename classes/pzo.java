import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.LooperMonitorHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class pzo
  implements Printer
{
  public static final String a = ">>";
  public static final String b = "<<";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  
  public pzo(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith(">>>"))) {}
    int i;
    String str1;
    String str2;
    do
    {
      int k;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramString;
              i = paramString.indexOf('(');
            } while (i == -1);
            j = paramString.indexOf(')', i);
          } while (j == -1);
          str1 = paramString.substring(i + 1, j);
          k = paramString.indexOf("} ", j);
        } while (k == -1);
        int j = paramString.indexOf('@', k + 2);
        i = j;
        if (j != -1) {
          break;
        }
        j = paramString.indexOf(':', k + 2);
        i = j;
        if (j != -1) {
          break;
        }
        i = paramString.indexOf(' ', k + 2);
      } while (i == -1);
      str2 = paramString.substring(k + 2, i);
      i = paramString.indexOf(": ", i);
    } while (i == -1);
    return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    LooperMonitorHelper.jdField_a_of_type_Int = paramInt;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_c_of_type_JavaLangString = paramString;
      if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_b_of_type_Int)) {
        UnifiedMonitor.a().reportStackIfTimeout(this.jdField_b_of_type_Int);
      }
    }
    long l;
    do
    {
      do
      {
        return;
      } while ((this.jdField_c_of_type_Long == 0L) || (!paramString.startsWith("<<")));
      this.jdField_a_of_type_Long += 1L;
      l = SystemClock.uptimeMillis() - this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_b_of_type_Long += l;
      if (l <= LooperMonitorHelper.jdField_a_of_type_Int) {
        break;
      }
      if (!UnifiedMonitor.a().whetherReportThisTime(this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_Int = 0;
        return;
      }
      paramString = this.jdField_c_of_type_JavaLangString;
      Map localMap = UnifiedMonitor.a();
      UnifiedMonitor.a().addEvent(this.jdField_b_of_type_Int, paramString, (int)l, this.jdField_a_of_type_Int, localMap);
      this.jdField_a_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.d("AutoMonitor", 2, "MainLooper, cost=" + l + ", " + paramString);
    return;
    if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_b_of_type_Int)) {
      UnifiedMonitor.a().notifyNotTimeout(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public String toString()
  {
    return super.toString() + "(msgCount = " + this.jdField_a_of_type_Long + ", totalCost = " + this.jdField_b_of_type_Long + ")";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */