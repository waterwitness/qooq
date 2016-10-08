import android.os.Handler;
import android.os.Message;
import com.tencent.biz.now.CgiHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hkd
  implements Runnable
{
  public hkd(CgiHelper paramCgiHelper, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = "http://now.qq.com/cgi-bin/now/web/room/get_room_info_v2?room_id=" + this.jdField_a_of_type_Long;
    localObject = CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper, (String)localObject);
    CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper, (String)localObject);
    if (CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper) != null)
    {
      localObject = new Message();
      ((Message)localObject).what = 1001;
      CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper).sendMessage((Message)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */