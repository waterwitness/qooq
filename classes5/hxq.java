import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyHelper;

public class hxq
  implements Runnable
{
  public hxq(KandianMergeManager paramKandianMergeManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager), 1).edit();
    localEditor.putInt("subscribe_push_msg_status", this.jdField_a_of_type_Int);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */