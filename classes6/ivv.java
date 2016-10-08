import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryPoiSearchViewPart;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ivv
  implements TextWatcher
{
  public ivv(NewStoryPoiSearchViewPart paramNewStoryPoiSearchViewPart)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.a.y) {}
    for (paramEditable = "2";; paramEditable = "1")
    {
      StoryReportor.a("video_edit", "search_poi", 0, 0, new String[] { paramEditable });
      this.a.a();
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */