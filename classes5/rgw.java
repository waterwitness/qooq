import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class rgw
  extends EmotionJsonDownloadListener
{
  public rgw(FavroamingManager paramFavroamingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.downMap.containsKey(paramEmoticonPackage.epId)) {}
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = (EmojiManager)this.a.mApp.getManager(42);
      if (paramInt != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", EmojiManager.e);
      paramBundle = new File(EmoticonUtils.n.replace("[epId]", paramEmoticonPackage.epId));
      localArrayList = new ArrayList();
      localObject2 = new ReqInfo();
      if (paramBundle.exists()) {}
      for (paramBundle = FileUtils.a(paramBundle);; paramBundle = null)
      {
        paramBundle = EmotionJsonUtils.a(this.a.mApp, paramEmoticonPackage, paramInt, paramBundle, localArrayList, (ReqInfo)localObject2);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        VasReportUtils.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      if ((!((ReqInfo)localObject2).jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
      {
        paramInt = 0;
        do
        {
          ((ReqInfo)localObject2).jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + paramInt);
          }
          ((EmojiManager)localObject1).a(paramEmoticonPackage.epId, localArrayList, (ReqInfo)localObject2);
          i = paramInt + 1;
          if (((ReqInfo)localObject2).jdField_a_of_type_Boolean) {
            break;
          }
          paramInt = i;
        } while (i < 3);
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i + " encryptKeysSuccess=" + ((ReqInfo)localObject2).jdField_a_of_type_Boolean);
        }
      }
      localArrayList = (ArrayList)this.a.downMap.get(paramEmoticonPackage.epId);
    } while (localArrayList == null);
    if (paramEmoticonPackage.jobType == 0)
    {
      paramInt = 0;
      label388:
      if (paramInt < localArrayList.size())
      {
        localObject2 = (CustomEmotionData)localArrayList.get(paramInt);
        if (localObject2 != null) {
          break label420;
        }
      }
      for (;;)
      {
        label413:
        paramInt += 1;
        break label388;
        break;
        label420:
        paramBundle = new Emoticon();
        if (this.a.mApp != null) {
          break label459;
        }
        QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|app null");
        this.a.onFileDone((CustomEmotionData)localObject2, false);
      }
      label459:
      EmoticonManager localEmoticonManager = (EmoticonManager)this.a.mApp.getManager(13);
      if (localEmoticonManager == null) {
        break label911;
      }
      paramBundle = localEmoticonManager.a(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
    }
    label911:
    for (;;)
    {
      if (paramBundle == null)
      {
        QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|cannot find emoticon: epId:" + paramEmoticonPackage.epId + "，eid=" + ((CustomEmotionData)localObject2).eId);
        ((CustomEmotionData)localObject2).RomaingType = "needDel";
        ((FavroamingDBManager)this.a.mApp.getManager(148)).b((CustomEmotionData)localObject2);
        this.a.onFileDone((CustomEmotionData)localArrayList.get(paramInt), false);
        break label413;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "downloadAIOEmoticon|taskvalue:" + 14 + "，epid:" + paramBundle.epId + "，eid=" + paramBundle.eId);
      }
      if (((EmojiManager)localObject1).b(paramBundle, 14))
      {
        this.a.onFileDone((CustomEmotionData)localArrayList.get(paramInt), true);
        break label413;
      }
      this.a.onFileDone((CustomEmotionData)localArrayList.get(paramInt), false);
      break label413;
      if ((paramEmoticonPackage.jobType != 3) && (paramEmoticonPackage.jobType != 5)) {
        break;
      }
      EmojiListenerManager.a().a(FavroamingManager.access$000(this.a));
      ((EmojiManager)localObject1).a(paramEmoticonPackage, false);
      return;
      paramBundle = (ArrayList)this.a.downMap.get(paramEmoticonPackage.epId);
      if (paramBundle != null)
      {
        i = 0;
        while (i < paramBundle.size())
        {
          localObject1 = (CustomEmotionData)paramBundle.get(i);
          if (localObject1 != null) {
            this.a.onFileDone((CustomEmotionData)localObject1, false);
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "downloadAIOEmoticon fail epId:" + paramEmoticonPackage.epId);
      }
      VasReportUtils.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", NetworkUtil.b(this.a.mApp.getApplication()) + "", paramInt + "", "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */