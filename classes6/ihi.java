import com.tencent.biz.qqstory.base.preload.DumpDialog;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.List;

class ihi
  implements Runnable
{
  ihi(ihf paramihf, String paramString, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_JavaLangString);
    if (localStoryVideoItem != null)
    {
      ihe localihe = new ihe(this.jdField_a_of_type_Ihf.a, null);
      localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryVideoItem;
      localihe.e = 0;
      long l = localStoryVideoItem.mOwnerUid;
      localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).c(l);
      localihe.jdField_a_of_type_Long = l;
      localihe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      this.jdField_a_of_type_Ihf.a.jdField_a_of_type_JavaUtilList.add(localihe);
      this.jdField_a_of_type_Ihf.a.jdField_a_of_type_Ihc.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */