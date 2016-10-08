import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class hgo
  implements QQPlayerService.QQPlayerCallback
{
  public hgo(QQMusicService paramQQMusicService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getToken()
  {
    return QQPlayerService.a(5, "" + this.a.a);
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicService", 2, "onPlaySongChanged:" + paramSongInfo.b);
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicService", 2, "onPlayStateChanged:" + paramInt);
    }
    Object localObject = QQPlayerService.a();
    localObject = QQMusicService.a(this.a, (SongInfo)localObject);
    if (localObject != null) {}
    try
    {
      ((JSONObject)localObject).put("state", paramInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("*.qq.com");
      EventApiPlugin.a("qbrowserMusicStateChange", (JSONObject)localObject, localArrayList, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMusicService", 2, "onPlayStateChanged:" + localJSONException.getStackTrace());
        }
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */