import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;

public final class tqb
  implements Runnable
{
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final tqc jdField_a_of_type_Tqc;
  private final boolean jdField_a_of_type_Boolean;
  
  public tqb(ItemLoader paramItemLoader, tqc paramtqc, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Tqc = paramtqc;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Tqc)) {}
    View localView;
    do
    {
      return;
      if (this.jdField_a_of_type_Tqc.c == null) {
        throw new IllegalStateException("Result should not be null when displaying an item part");
      }
      localView = (View)this.jdField_a_of_type_Tqc.b.get();
    } while (localView == null);
    Object localObject = this.jdField_a_of_type_Tqc.c.get();
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_Tqc.a.intValue(), this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */