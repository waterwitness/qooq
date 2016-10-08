import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyHelper;

public class hxp
  implements Runnable
{
  public hxp(KandianMergeManager paramKandianMergeManager, long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager), 1).edit();
    localEditor.putLong("subscribe_push_msg_time", this.jdField_a_of_type_Long);
    localEditor.putString("subscribe_push_msg_uin", this.jdField_a_of_type_JavaLangString);
    localEditor.putInt("subscribe_push_msg_status", this.jdField_a_of_type_Int);
    localEditor.putString("subscribe_push_msg_xml", this.jdField_b_of_type_JavaLangString);
    localEditor.putInt("subscribe_push_msg_msgtype", this.jdField_b_of_type_Int);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */