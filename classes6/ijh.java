import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.Collections;

public class ijh
  extends LbsManager.OnLocationListener
{
  public ijh(DoodleEmojiManager paramDoodleEmojiManager, String paramString, WeakReference paramWeakReference, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.a(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = (DoodleEmojiManager.POIPostersRequestCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramSosoLbsInfo != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelDoodleEmojiManager.a(paramSosoLbsInfo);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryModelDoodleEmojiManager$POIPostersRequestCallback == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelDoodleEmojiManager$POIPostersRequestCallback.a(1, Collections.EMPTY_LIST);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */