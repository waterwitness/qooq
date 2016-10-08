import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ijp
  implements Parcelable.Creator
{
  public ijp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StoryVideoItem a(Parcel paramParcel)
  {
    return new StoryVideoItem(paramParcel);
  }
  
  public StoryVideoItem[] a(int paramInt)
  {
    return new StoryVideoItem[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */