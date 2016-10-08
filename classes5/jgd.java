import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jgd
  implements Runnable
{
  public jgd(RoundProgressBar paramRoundProgressBar, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar) < this.jdField_a_of_type_Int) {
      while (RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar) < this.jdField_a_of_type_Int)
      {
        RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar, 1);
        this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.postInvalidate();
        try
        {
          Thread.sleep(50L);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
        }
      }
    }
    while (this.jdField_a_of_type_Int < RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar))
    {
      RoundProgressBar.b(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar, 1);
      this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.postInvalidate();
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */