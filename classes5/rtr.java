import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class rtr
  implements Runnable
{
  public rtr(QfileLocalFileOtherTabView paramQfileLocalFileOtherTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = FMSettings.a().b();
    Object localObject1 = new HashMap();
    FileCategoryUtil.a((String)localObject2, "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4a|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject1, null);
    localObject2 = FMSettings.a().a();
    if (localObject2 != null) {
      FileCategoryUtil.a((String)localObject2, "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4a|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject1, null);
    }
    FileCategoryUtil.a((Map)localObject1);
    localObject2 = new LinkedHashMap();
    ((LinkedHashMap)localObject2).put("压缩文件", new ArrayList());
    ((LinkedHashMap)localObject2).put("电子书", new ArrayList());
    ((LinkedHashMap)localObject2).put("更多", new ArrayList());
    Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((List)((LinkedHashMap)localObject2).get(this.a.a(str))).addAll((Collection)((HashMap)localObject1).get(str));
    }
    localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)((LinkedHashMap)localObject2).get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    QfileLocalFileOtherTabView.a(this.a, new rts(this, (LinkedHashMap)localObject2));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */