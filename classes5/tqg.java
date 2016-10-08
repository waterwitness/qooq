import android.os.Handler;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;
import java.util.Map;

public final class tqg
  implements Runnable
{
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final tqc jdField_a_of_type_Tqc;
  
  public tqg(ItemLoader paramItemLoader, tqc paramtqc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Tqc = paramtqc;
  }
  
  public tqc a()
  {
    return this.jdField_a_of_type_Tqc;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_Tqc.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Tqc)) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Tqc.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Tqc.jdField_a_of_type_JavaLangInteger.intValue());
      this.jdField_a_of_type_Tqc.c = new SoftReference(localObject);
    } while ((this.jdField_a_of_type_Tqc.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Tqc)));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new tqb(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_Tqc, false));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */