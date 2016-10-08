import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class gxa
  implements Comparator
{
  public gxa(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(VideoController.GAudioFriends paramGAudioFriends1, VideoController.GAudioFriends paramGAudioFriends2)
  {
    if ((paramGAudioFriends2.b) && (paramGAudioFriends1.b)) {
      return paramGAudioFriends2.e - paramGAudioFriends1.e;
    }
    if ((!paramGAudioFriends2.b) && (!paramGAudioFriends1.b)) {
      return paramGAudioFriends2.e - paramGAudioFriends1.e;
    }
    if ((paramGAudioFriends2.b) && (!paramGAudioFriends1.b)) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */