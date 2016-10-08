import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.utils.LogTag;

public class uft
  implements Runnable
{
  public uft(CompoundProcessor paramCompoundProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RichmediaClient localRichmediaClient = RichmediaClient.a();
    String str = this.a.a(this.a.c);
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.a.jdField_b_of_type_JavaLangString);
    localBundle.putString("full_video_path", str);
    localBundle.putInt("video_slices_total_time_length", this.a.jdField_b_of_type_Int);
    localRichmediaClient.a(103, -1, localBundle);
    LogTag.a(this.a.jdField_b_of_type_JavaLangString, "clicompCompoundProcessor.compressSourceYUV", "path = " + str + ",totalTime = " + this.a.jdField_b_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */