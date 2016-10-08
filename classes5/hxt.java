import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyHelper;

public class hxt
  implements Runnable
{
  public hxt(KandianMergeManager paramKandianMergeManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.a), 1).edit();
    localEditor.remove("kandian_push_msg_xml").remove("kandian_push_msg_time");
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */