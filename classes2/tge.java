import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;

public class tge
  extends BroadcastReceiver
{
  public tge(MusicGeneQQBrowserActivity paramMusicGeneQQBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      String str1;
      String str2;
      String str3;
      if ("BROAD_CAST_SHARE_MUSIC_GENE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("BUNDLE_KEY_TITLE");
        str1 = paramIntent.getStringExtra("BUNDLE_KEY_DESC");
        str2 = paramIntent.getStringExtra("BUDNLE_KEY_IMG_URL");
        str3 = paramIntent.getStringExtra("BUNDLE_KEY_SRC");
        paramIntent = paramIntent.getStringExtra("BUNDLE_KEY_ICON_URL");
        MusicGeneQQBrowserActivity.a(this.a, str2, str3, "", str1, paramContext, paramIntent, 1101244924L);
        return;
      }
      if ("BROAD_CAST_SHARE_SONG".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("BUNDLE_KEY_TITLE");
        str1 = paramIntent.getStringExtra("BUNDLE_KEY_DESC");
        str2 = paramIntent.getStringExtra("BUDNLE_KEY_IMG_URL");
        str3 = paramIntent.getStringExtra("BUNDLE_KEY_SRC");
        String str4 = paramIntent.getStringExtra("BUNDLE_KEY_AUDIO_URL");
        paramIntent = paramIntent.getStringExtra("BUNDLE_KEY_ICON_URL");
        MusicGeneQQBrowserActivity.a(this.a, str2, str3, str4, str1, paramContext, paramIntent, 1101244924L);
        return;
      }
    } while (!"BROAD_CAST_UPDATE_TITLE".equals(paramContext));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */