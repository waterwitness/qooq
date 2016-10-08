import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public class vwy
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private final long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString;
  
  public vwy(UnifiedDebugManager paramUnifiedDebugManager, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */