import com.tencent.mobileqq.hotpatch.HotPatchManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svn
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  
  public svn(HotPatchManager paramHotPatchManager, int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public String toString()
  {
    return "patchName=" + this.jdField_a_of_type_JavaLangString + ", patchUrl=" + this.jdField_b_of_type_JavaLangString + ", startTime=" + this.jdField_a_of_type_Long + ", size=" + this.jdField_b_of_type_Long + ", tryTimes=" + this.jdField_a_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\svn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */