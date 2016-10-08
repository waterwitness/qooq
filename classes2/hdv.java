import com.tencent.bitapp.BitAppViewGroup;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class hdv
  extends URLDrawableDownListener.Adapter
{
  long jdField_a_of_type_Long;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public hdv(BitAppViewGroup paramBitAppViewGroup, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBitAppViewGroup);
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */