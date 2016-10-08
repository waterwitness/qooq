import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.preload.DumpDialog;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class ihc
  extends BaseAdapter
{
  private ihc(DumpDialog paramDumpDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= this.a.a.size()) {
      return null;
    }
    return this.a.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ihe localihe;
    StringBuilder localStringBuilder;
    if (paramView == null)
    {
      paramView = new TextView(this.a.getContext());
      paramViewGroup = new ihd(this, null);
      paramViewGroup.a = ((TextView)paramView);
      paramView.setTag(paramViewGroup);
      localihe = (ihe)getItem(paramInt);
      if (localihe != null)
      {
        localStringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mPreloadMsg)) {
          break label254;
        }
        localStringBuilder.append(localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mPreloadMsg);
        label94:
        localStringBuilder.append("  |  ");
        switch (localihe.e)
        {
        default: 
          label136:
          localStringBuilder.append("  |  ");
          localStringBuilder.append("create time = " + StoryListUtils.a(localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime));
          localStringBuilder.append("\n");
          switch (localihe.e)
          {
          }
          break;
        }
      }
    }
    for (;;)
    {
      localStringBuilder.append("\n");
      paramViewGroup.a.setText(localStringBuilder);
      return paramView;
      paramViewGroup = (ihd)paramView.getTag();
      break;
      label254:
      if ((localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (!TextUtils.isEmpty(localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.nickName)))
      {
        localStringBuilder.append(localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.nickName);
        break label94;
      }
      if ((localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (!TextUtils.isEmpty(localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId())))
      {
        localStringBuilder.append("unionId = " + localihe.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId());
        break label94;
      }
      localStringBuilder.append("uin = " + localihe.jdField_a_of_type_Long);
      break label94;
      localStringBuilder.append("下载成功");
      break label136;
      localStringBuilder.append("已下载过");
      break label136;
      localStringBuilder.append("下载失败");
      break label136;
      localStringBuilder.append("暂停下载");
      break label136;
      localStringBuilder.append("file path = " + localihe.jdField_a_of_type_JavaLangString);
      continue;
      localStringBuilder.append("file path = " + localihe.jdField_a_of_type_JavaLangString);
      continue;
      localStringBuilder.append("error code = " + localihe.f);
      continue;
      localStringBuilder.append("download pause");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */