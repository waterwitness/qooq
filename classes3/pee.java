import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ConcurrentHashMap;

public class pee
  implements Comparable
{
  public int a;
  public long a;
  public int b;
  
  public pee(VideoFramesFetcher paramVideoFramesFetcher, long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesFetcher.a(paramVideoFramesFetcher));
    VideoFramesFetcher.a(paramVideoFramesFetcher).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(pee parampee)
  {
    return -(int)(this.jdField_a_of_type_Long - parampee.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */