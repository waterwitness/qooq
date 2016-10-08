import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.view.ScanTorchViewFinder;

public class tsd
  implements Runnable
{
  public tsd(ScanTorchViewFinder paramScanTorchViewFinder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanTorchViewFinder.invalidate(this.jdField_a_of_type_Int, this.b, this.c, this.d);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */