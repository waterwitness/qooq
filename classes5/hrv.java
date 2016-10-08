import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hrv
  implements Runnable
{
  hrv(hru paramhru, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Hru.a.g = false;
    String str;
    if (this.jdField_a_of_type_Int == 123) {
      if (this.b == 103) {
        str = "网络异常：" + this.jdField_a_of_type_Int + "-" + this.b;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Hru.a.a(str);
      return;
      str = "视频加载失败，请稍后重试：" + this.jdField_a_of_type_Int + "-" + this.b;
      continue;
      if (this.jdField_a_of_type_Int == 122)
      {
        if (this.b == 204) {
          str = "网络异常：" + this.jdField_a_of_type_Int + "-" + this.b;
        } else if (this.b == 202) {
          str = "视频源已删除：" + this.jdField_a_of_type_Int + "-" + this.b;
        } else {
          str = "视频加载失败，请稍后重试：" + this.jdField_a_of_type_Int + "-" + this.b;
        }
      }
      else if (this.jdField_a_of_type_Int == 101)
      {
        if (this.b == 80) {
          str = "因版权限制、无法观看：" + this.jdField_a_of_type_Int + "-" + this.b;
        } else {
          str = "视频加载失败，请稍后重试：" + this.jdField_a_of_type_Int + "-" + this.b;
        }
      }
      else {
        str = "视频加载失败，请稍后重试：" + this.jdField_a_of_type_Int + "-" + this.b;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */