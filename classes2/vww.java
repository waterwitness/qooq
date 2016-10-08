import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

public class vww
  implements Runnable
{
  public vww(UnifiedDebugManager paramUnifiedDebugManager, long paramLong1, Context paramContext, String paramString1, int paramInt, long paramLong2, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (UnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager))
    {
      vwy localvwy = (vwy)UnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager).peek();
      if ((localvwy != null) && (vwy.a(localvwy) == this.jdField_a_of_type_Long))
      {
        UnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedDebugManager", 2, "start debug(retry): seq=" + this.jdField_a_of_type_Long);
        }
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */