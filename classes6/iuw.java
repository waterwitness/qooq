import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class iuw
  extends FacePanelBaseAdapter
{
  private final List a;
  
  private iuw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public FacePackage a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (FacePackage)this.a.get(paramInt);
    }
    return null;
  }
  
  public FacePackage a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FacePackage localFacePackage = (FacePackage)localIterator.next();
      if (TextUtils.equals(paramString, localFacePackage.a)) {
        return localFacePackage;
      }
    }
    return null;
  }
  
  public void a(FacePackage paramFacePackage)
  {
    SLog.b("Q.qqstory.record.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramFacePackage);
    int i = this.a.indexOf(paramFacePackage);
    if (i >= 0)
    {
      this.a.set(i, paramFacePackage);
      a(i);
    }
  }
  
  public void a(Collection paramCollection)
  {
    SLog.b("Q.qqstory.record.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */