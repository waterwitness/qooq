import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class htk
  implements Runnable
{
  htk(htj paramhtj, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Htj.a.f = false;
    String str = "播放错误";
    if (this.jdField_a_of_type_Int == 61) {
      str = "视频不存在";
    }
    this.jdField_a_of_type_Htj.a.a(str);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */