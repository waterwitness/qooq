import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hsx
  implements Runnable
{
  public hsx(VideoUIController paramVideoUIController, ElasticHorScrView paramElasticHorScrView1, int paramInt1, ElasticHorScrView paramElasticHorScrView2, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */