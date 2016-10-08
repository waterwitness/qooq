import com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class ihq
  implements Comparable
{
  public final long a;
  public final File a;
  
  public ihq(CapacityCleanStep paramCapacityCleanStep, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(ihq paramihq)
  {
    if (this.jdField_a_of_type_Long < paramihq.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramihq.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */